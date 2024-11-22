package com.gg.spora.settings.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gg.spora.R
import com.gg.spora.user.domain.GetUserLocalUseCase
import com.gg.spora.user.domain.UpdateUserImageUseCase
import com.gg.spora.user.domain.UpdateUserNameUseCase
import com.gg.spora.user.domain.models.User
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditProfileViewModel @Inject constructor(
    private val getUserLocalUseCase: GetUserLocalUseCase,
    private val firestore: FirebaseFirestore,
    private val updateUserNameUseCase: UpdateUserNameUseCase,
    private val updateUserImageUseCase: UpdateUserImageUseCase
) : ViewModel() {

    private val _currentUser = MutableStateFlow<User?>(null)
    val currentUser: StateFlow<User?> = _currentUser

    var showSnackbar by mutableStateOf(false)
    var showPopup by mutableStateOf(false)
    var selectedImage by mutableStateOf(R.drawable.user_image)
    var newUsername by mutableStateOf("")

    init {
        getUserLocal()
    }

    private fun getUserLocal() {
        viewModelScope.launch {
            getUserLocalUseCase().collect { user ->
                _currentUser.value = user
                selectedImage = user?.userImage ?: R.drawable.user_image
                newUsername = user?.userName ?: ""
            }
        }
    }

    fun updateUserProfile(imageRes: Int, username: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _currentUser.value?.let { user ->
                user.userImage = imageRes
                user.userName = username
                selectedImage = imageRes
                updateUserImageInFirebase(user.id, imageRes, username)
                updateUserNameUseCase(username)
                updateUserImageUseCase(imageRes)
            }

        }

    }

    private fun updateUserImageInFirebase(userId: String, imageRes: Int, username: String) {
        val userRef = firestore.collection("users").document(userId)
        userRef.update(mapOf("userImage" to imageRes, "userName" to username))
            .addOnSuccessListener {
                showSnackbar = true
            }
            .addOnFailureListener {
                // error message to be shown
            }
    }
}