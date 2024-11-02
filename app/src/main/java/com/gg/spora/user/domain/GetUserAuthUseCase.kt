package com.gg.spora.user.domain

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import javax.inject.Inject

/**
 * Caso de uso para obtener el usuario autenticado.
 * Si no hay usuario autenticado devuelve null.
 */
class GetUserAuthUseCase @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) {
    operator fun invoke(): FirebaseUser? {
        Log.i("titi", "getCurrentUser: ${firebaseAuth.currentUser?.email}")
        return firebaseAuth.currentUser
    }
}