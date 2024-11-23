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
    var selectedImage by mutableStateOf("https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/avatars%2Fchampy_smile.png?alt=media&token=332929a3-a86a-4a8c-834e-28bccc40fe36")
    var newUsername by mutableStateOf("")


    private val _userImages = MutableStateFlow(listOf(
        "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/avatars%2Fchampy_smile.png?alt=media&token=332929a3-a86a-4a8c-834e-28bccc40fe36",
        "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/avatars%2Fchampy_defeated.png?alt=media&token=f4677f5b-c6bc-4611-b180-b584b3035512",
        "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/avatars%2Fchampy_doubt.png?alt=media&token=e521f647-451e-4b52-ad12-dcff289a9d1a",
        "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/avatars%2Fchampy_happy.png?alt=media&token=e86e643f-0b3e-4abc-925d-f52341701d1c",
        "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/avatars%2Fchampy_sad.png?alt=media&token=f6a5d2b6-970c-4160-8d81-257d6776e839",
        "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/avatars%2Fchampy_serious.png?alt=media&token=3f9ffb71-2f81-4db1-9ba7-4a25e043891d",
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
                selectedImage = user?.userImage ?: "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/avatars%2Fchampy_smile.png?alt=media&token=332929a3-a86a-4a8c-834e-28bccc40fe36"
                newUsername = user?.userName ?: ""
            }
        }
    }

    fun updateUserProfile(imageRes: String, username: String) {
        viewModelScope.launch(Dispatchers.IO) {

            val user = User(
                id = _currentUser.value?.id ?: "",
                userName = username,
                email = _currentUser.value?.email ?: "",
                oxygen = _currentUser.value?.oxygen ?: 0,
                treesCount = _currentUser.value?.treesCount ?: 0,
                userImage = imageRes,
                levelsCompleted = _currentUser.value?.levelsCompleted ?: emptyList(),
                tutorialsCompleted = _currentUser.value?.tutorialsCompleted ?: emptyList(),
                weeklyOxygen = _currentUser.value?.weeklyOxygen ?: 0,
                forestTrees = _currentUser.value?.forestTrees ?: emptyList(),
                seedTrees = _currentUser.value?.seedTrees ?: emptyList(),
                objectsScanned = _currentUser.value?.objectsScanned ?: emptyList()
            )

            updateUserImageInFirebase(user.id, imageRes, username)
            updateUserNameUseCase(username)
            updateUserImageUseCase(imageRes)

//            _currentUser.value?.let { user ->
//                user.userImage = imageRes
//                user.userName = username
//                selectedImage = imageRes
//                updateUserImageInFirebase(user.id, imageRes, username)
//                updateUserNameUseCase(username)
//                updateUserImageUseCase(imageRes)
//            }

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