package com.gg.spora.core.firebase.model

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.gg.spora.MainActivity
import com.gg.spora.R
import javax.inject.Inject
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MessagingService @Inject constructor() : FirebaseMessagingService() {

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)

//        if (message.data.isNotEmpty()) {
//            val example1 = message.data
//            message.data.forEach { key, value ->
//                Log.i("titi", "Para la clave $key el valor es $value")
//            }
//        }
        
        Log.i("titi", "Notificacion ahre")

        message.notification?.let {
            val title = it.title.orEmpty()
            val body = it.body.orEmpty()
            createNotification(title, body)
        }

    }

    private fun createNotification(title: String, body: String) {
        val intent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        }

        val pendingIntent = PendingIntent.getActivity(this, 999, intent, PendingIntent.FLAG_IMMUTABLE)

        val sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
        val channelId = getString(R.string.default_channel)
        val notificationBuilder = NotificationCompat.Builder(this, "")
            .setSmallIcon(R.drawable.spora_face_splash)
            .setContentTitle(title)
            .setContentText(body)
            .setChannelId(channelId)
            .setAutoCancel(true)
            .setSound(sound)
            .setContentIntent(pendingIntent)

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        //COSAS DE CHANEL
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel(
                channelId,
                "General",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager.createNotificationChannel(channel)
        }

        notificationManager.notify(0, notificationBuilder.build())
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        sendRegistrationToken(token)
    }

    private fun sendRegistrationToken(token: String) {
        Log.i("Titi", token)
        //llamada al backend
    }
}