package com.gg.spora.settings.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
    var selectedImage by mutableStateOf("https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/avatars%2FChampy_sonriente_idle.png?alt=media&token=40474e6d-7365-491c-b8ea-424bd73fdc6f")
    var newUsername by mutableStateOf("")


    private val _userImages = MutableStateFlow<List<String>>(listOf(
        "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/avatars%2FChampy_sonriente_idle.png?alt=media&token=40474e6d-7365-491c-b8ea-424bd73fdc6f",
        "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/avatars%2FChampy_curioso_idle.png?alt=media&token=63e957f7-1ec0-4895-b695-733604948485",
        "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/avatars%2FChampy_derrotado_idle.png?alt=media&token=ecd4eac4-6d52-49ac-b522-cb5fb2d941f9",
        "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/avatars%2FChampy_durmiendo_sentado.png?alt=media&token=87792ce7-a90f-4f8f-b61c-ac3fc6f3338a",
        "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/avatars%2FChampy_enojado_idle.png?alt=media&token=a485f6da-4f03-41c8-b5cd-a9c6542c3e13",
        "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/avatars%2FChampy_triste_idle.png?alt=media&token=b63b2227-a4b8-4cc3-a96f-0b3a5e89147d",
        "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/avatars%2Fchampy_celebrando_brazoslevantados_sinsombra.png?alt=media&token=5edbed36-6fb9-4b0a-81c3-fe5dec1659e1",
        "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/avatars%2Fmushy_sin_sombra.png?alt=media&token=ec9d88b1-57ee-4807-ad40-978d7acf83b6"
    ))

    val userImages: StateFlow<List<String>> = _userImages

    init {
        getUserLocal()
    }

    fun updateShowPopup(value: Boolean) {
        showPopup = value
    }

    fun updateUserName(username: String) {
        newUsername = username
    }

    fun updateSnackBar(value: Boolean) {
        showSnackbar = value
    }

    private fun getUserLocal() {
        viewModelScope.launch {
            getUserLocalUseCase().collect { user ->
                _currentUser.value = user
                selectedImage = user?.userImage ?: "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/avatars%2FChampy_sonriente_idle.png?alt=media&token=40474e6d-7365-491c-b8ea-424bd73fdc6f"
                newUsername = user?.userName ?: ""
            }
        }
    }

    fun updateUserProfile(imageRes: String, username: String) {
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

    private fun updateUserImageInFirebase(userId: String, imageRes: String, username: String) {
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