package com.gg.spora.core.data

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.gg.spora.core.utils.exceptions.NoInternetConnectionException
import javax.inject.Inject

class NetworkConnectivityChecker @Inject constructor(private val context: Context) :
    INetworkConnectivityChecker {


    @Throws(NoInternetConnectionException::class)
    override fun performNetworkConnectivityCheck() {
        if (!isInternetAvailable()) {
            throw NoInternetConnectionException()
        }
    }

    private fun isInternetAvailable(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork
        val capabilities = connectivityManager.getNetworkCapabilities(network)

        return capabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) == true
    }

}