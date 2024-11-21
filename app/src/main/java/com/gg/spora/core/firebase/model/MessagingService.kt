package com.gg.spora.core.firebase.model

import javax.inject.Inject
import com.google.firebase.messaging.FirebaseMessagingService

class MessagingService @Inject constructor(

) : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        super.onNewToken(token)
    }
}