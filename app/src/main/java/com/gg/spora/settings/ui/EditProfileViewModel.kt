package com.gg.spora.settings.ui

import android.annotation.SuppressLint
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gg.spora.R
import com.gg.spora.user.domain.GetUserLocalUseCase
import com.gg.spora.user.domain.models.User
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditProfileViewModel @Inject constructor(
    private val getUserLocalUseCase: GetUserLocalUseCase,
    private val firestore: FirebaseFirestore
) : ViewModel() {

    private val _currentUser = MutableStateFlow<User?>(null)
    @SuppressLint("RestrictedApi")
    val currentUser: StateFlow<User?> = _currentUser

    var showSnackbar by mutableStateOf(false)
    var showPopup by mutableStateOf(false)
    var selectedImage by mutableStateOf(R.drawable.user_image)

    init {
        getUserLocal()
    }

    private fun getUserLocal() {
        viewModelScope.launch {
            getUserLocalUseCase().collect { user ->
                _currentUser.value = user
                selectedImage = user?.userImage ?: R.drawable.user_image
            }
        }
    }

    fun updateUserImage(imageRes: Int) {
        _currentUser.value?.let { user ->
            user.userImage = imageRes
            selectedImage = imageRes
            updateUserImageInFirebase(user.id, imageRes)
        }
    }

    private fun updateUserImageInFirebase(userId: String, imageRes: Int) {
        val userRef = firestore.collection("users").document(userId)
        userRef.update("userImage", imageRes)
            .addOnSuccessListener {
                showSnackbar = true
            }
            .addOnFailureListener {
                // error message to be shown
            }
    }
}