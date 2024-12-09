package com.gg.spora.user.domain

import android.content.Context
import android.util.Log
import com.gg.spora.core.utils.functions.isNetworkAvailable
import com.gg.spora.user.domain.repository.IUserRepositoryLocal
import com.gg.spora.user.domain.repository.IUserRepositoryNetwork
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import javax.inject.Inject

class SyncUserNetworkDataUseCase @Inject constructor(
    private val userRepositoryLocal: IUserRepositoryLocal,
    private val userRepositoryNetwork: IUserRepositoryNetwork,
    private val context: Context
) {
    suspend operator fun invoke() {

        val isNetworkAvailable = isNetworkAvailable(context)

        if (!isNetworkAvailable) return

        val userLocal = userRepositoryLocal.getUser().first()

        userLocal?.let {
            userRepositoryNetwork.getUserByEmailFlow(userLocal.email)
                .catch {
                    Log.e("SyncUserNetworkDataUseCase", "Error: ${it.message}")
                }
                .collect {
                    val userNetwork = it

                    if (userLocal.oxygen > userNetwork.oxygen) {
                        userRepositoryNetwork.updateUserData(userLocal)
                        return@collect
                    }
                }
        }
    }
}