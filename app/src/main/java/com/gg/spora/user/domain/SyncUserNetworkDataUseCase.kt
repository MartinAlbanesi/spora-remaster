package com.gg.spora.user.domain

import android.content.Context
import com.gg.spora.core.utils.functions.isNetworkAvailable
import com.gg.spora.user.domain.repository.IUserRepositoryLocal
import com.gg.spora.user.domain.repository.IUserRepositoryNetwork
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class SyncUserNetworkDataUseCase @Inject constructor(
    private val userRepositoryLocal: IUserRepositoryLocal,
    private val userRepositoryNetwork: IUserRepositoryNetwork,
    private val context: Context
) {
    suspend operator fun invoke() {

        val isNetworkAvailable = isNetworkAvailable(context)

        if(!isNetworkAvailable) return

        val userLocal = userRepositoryLocal.getUser().first()!!
        val userNetwork = userRepositoryNetwork.getUserByEmailFlow(userLocal.email).first()

        if(userLocal.oxygen > userNetwork.oxygen){
            userRepositoryNetwork.updateUserData(userLocal)
        }
    }
}