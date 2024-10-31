package com.gg.spora.user.domain

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import javax.inject.Inject

class GetCurrentUserUseCase @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) {
    operator fun invoke(): FirebaseUser? {
        Log.i("titi", "getCurrentUser: ${firebaseAuth.currentUser?.email}")
        return firebaseAuth.currentUser
    }
}