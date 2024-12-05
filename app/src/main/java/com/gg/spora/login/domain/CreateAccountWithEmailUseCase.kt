package com.gg.spora.login.domain

import com.gg.spora.user.domain.SetNewUserUseCase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.suspendCancellableCoroutine
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class CreateAccountWithEmailUseCase @Inject constructor(
    private val setNewUserUseCase: SetNewUserUseCase,
    private val firebaseAuth: FirebaseAuth,
) {
    suspend operator fun invoke(
        email: String,
        password: String,
        userName: String,
    ): FirebaseUser? {
        val userAuth = suspendCancellableCoroutine { scc ->
            firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener {
                    scc.resume(it.user)
                }
                .addOnFailureListener {
                    scc.resumeWithException(it)
                }
        }

        if (userAuth == null) return null

        setNewUserUseCase(
            email = email,
            userName = userName
        )
        return userAuth
    }
}