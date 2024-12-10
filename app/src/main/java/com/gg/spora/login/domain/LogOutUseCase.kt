package com.gg.spora.login.domain

import com.gg.spora.missions.data.local.MissionRepositoryLocal
import com.gg.spora.missions.domain.repository.IMissionRepositoryLocal
import com.gg.spora.user.data.local.UserRepositoryLocal
import com.gg.spora.user.domain.repository.IUserRepositoryLocal
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class LogOutUseCase @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val userRepositoryLocal: IUserRepositoryLocal,
    private val missionRepositoryLocal: IMissionRepositoryLocal,
    private val googleSignInClient: GoogleSignInClient
) {

    suspend operator fun invoke() {
        firebaseAuth.signOut()
        userRepositoryLocal.deleteUser()
        userRepositoryLocal.deleteLevelsCompleted()
        missionRepositoryLocal.clearMissions()
        googleSignInClient.signOut()
    }
}