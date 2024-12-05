package com.gg.spora.login.domain

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.suspendCancellableCoroutine
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class SignInWithEmailAndPasswordUseCase @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) {
    suspend operator fun invoke(email: String, password: String): FirebaseUser? {
        return suspendCancellableCoroutine { scc ->
            firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener {
                    scc.resume(it.user)
                }
                .addOnFailureListener {
                    scc.resumeWithException(it)
                }
        }
    }

}