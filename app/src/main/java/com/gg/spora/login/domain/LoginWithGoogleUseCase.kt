package com.gg.spora.login.domain

import com.gg.spora.user.domain.SetNewUserUseCase
import com.gg.spora.user.domain.UpdateUserLocalDataFromNetworkUseCase
import com.gg.spora.user.domain.repository.IUserRepositoryNetwork
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import javax.inject.Inject

class LoginWithGoogleUseCase @Inject constructor(
    private val completeRegisterWithCredentialUseCase: CompleteRegisterWithCredentialUseCase,
    private val setNewUserUseCase: SetNewUserUseCase,
    private val userRepositoryNetwork: IUserRepositoryNetwork,
    private val updateUserLocalDataFromNetworkUseCase: UpdateUserLocalDataFromNetworkUseCase
) {
    suspend operator fun invoke(idToken: String): FirebaseUser? {
        val credential = GoogleAuthProvider.getCredential(idToken, null)

        val userAuth = completeRegisterWithCredentialUseCase(credential)

        val currentNetworkUser = userRepositoryNetwork.getUserByEmail(userAuth?.email ?: "")

        currentNetworkUser?.let {
            updateUserLocalDataFromNetworkUseCase(currentNetworkUser.email)
            return userAuth
        }

        userAuth?.let {
            setNewUserUseCase(email = userAuth.email, userName = userAuth.displayName ?: "Usuario")
        }

        return userAuth
    }
}