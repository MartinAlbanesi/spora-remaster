package com.gg.spora.user.domain

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import javax.inject.Inject

/**
 * Use case to get the authenticated user.
 * If there is no authenticated user, it returns null.
 * @return FirebaseUser?
 */
class GetUserAuthUseCase @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) {
    operator fun invoke(): FirebaseUser? {
        return firebaseAuth.currentUser
    }
}