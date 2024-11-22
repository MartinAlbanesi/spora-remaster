package com.gg.spora.settings.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gg.spora.R
import com.google.firebase.firestore.auth.User

class EditProfileViewModel : ViewModel() {
    var currentUser by mutableStateOf<User?>(null)
    var showSnackbar by mutableStateOf(false)
    var showPopup by mutableStateOf(false)
    var selectedImage by mutableStateOf(R.drawable.user_image)

    fun updateUserImage(imageRes: Int) {
        currentUser?.userImage = imageRes
        selectedImage = imageRes
    }
}