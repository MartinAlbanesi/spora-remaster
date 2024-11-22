package com.gg.spora.settings.ui

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import com.gg.spora.user.domain.GetUserLocalUseCase
import com.google.firebase.firestore.auth.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject


@HiltViewModel
class SupportViewModel @Inject constructor(
    private val getUserLocalUseCase: GetUserLocalUseCase
) : ViewModel() {

    private val _currentUserEmail = MutableStateFlow<String>("")

    val currentUserEmail: StateFlow<String> = _currentUserEmail

    suspend fun getUserLocal() {
        getUserLocalUseCase().collect { user ->
            if (user != null) {
                _currentUserEmail.value = user.email
            }
        }
    }

}