package com.gg.spora.login.domain

import com.gg.spora.user.domain.SetNewUserUseCase
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import javax.inject.Inject

class LoginWithGoogleUseCase @Inject constructor(
    private val completeRegisterWithCredentialUseCase: CompleteRegisterWithCredentialUseCase,
    private val setNewUserUseCase: SetNewUserUseCase
) {
    suspend operator fun invoke(idToken: String): FirebaseUser? {
        val credential = GoogleAuthProvider.getCredential(idToken, null)

        val userAuth = completeRegisterWithCredentialUseCase(credential)

        userAuth?.let {
            setNewUserUseCase(email = userAuth.email, userName = userAuth.displayName ?: "Usuario")
        }

        return userAuth
    }
}