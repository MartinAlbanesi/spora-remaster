package com.gg.spora.core.data

import com.gg.spora.core.utils.exceptions.NoInternetConnectionException

interface INetworkConnectivityChecker {
    @Throws(NoInternetConnectionException::class)
    fun performNetworkConnectivityCheck()
}