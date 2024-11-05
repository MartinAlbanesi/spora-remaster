package com.gg.spora.login.domain

import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class LogOutUseCase @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
//    private val logOutWithGoogleUseCase: LogOutWithGoogleUseCase
) {

    operator fun invoke() {
        firebaseAuth.signOut()
//        logOutWithGoogleUseCase()
    }
}