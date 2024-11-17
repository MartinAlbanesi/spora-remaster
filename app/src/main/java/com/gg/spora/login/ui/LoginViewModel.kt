package com.gg.spora.login.ui

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gg.spora.user.domain.SetNewUserUseCase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val auth: FirebaseAuth,
    private val setNewUserUseCase: SetNewUserUseCase
) : ViewModel() {

    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _loginEnable = MutableLiveData<Boolean>()
    val loginEnable: LiveData<Boolean> = _loginEnable

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _loginSuccess = MutableLiveData<Boolean>()
    val loginSuccess: LiveData<Boolean> = _loginSuccess

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    fun onLoginChanged(name: String, email: String, password: String) {
        _name.value = name
        _email.value = email
        _password.value = password
        _loginEnable.value = isValidEmail(email) && isValidPassword(password)
    }

    private fun isValidPassword(password: String): Boolean = password.length > 6
     fun isValidEmail(email: String): Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()


    fun onLoginSelected(onNavigationToHome: () -> Unit) {
        _isLoading.value = true // Show the CircularProgressIndicator
        viewModelScope.launch {
            try {
                registerWithEmail(
                    email.value.orEmpty(),
                    password.value.orEmpty(),
                    name.value.orEmpty(),
                    onNavigationToHome
                )
            } catch (e: Exception) {
                _errorMessage.value = "Error: ${e.localizedMessage}"
            } finally {
                _isLoading.value = false // Hide the CircularProgressIndicator
            }
        }
    }

    private fun registerWithEmail(
        email: String,
        password: String,
        name: String,
        onNavigationToHome: () -> Unit
    ) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    saveUserToFirestore(name, email,onNavigationToHome)
                } else {
                    if (task.exception is FirebaseAuthUserCollisionException) {
                        _errorMessage.value = "Usuario ya registrado"
                    } else {
                        _errorMessage.value = "Error: ${task.exception?.localizedMessage}"
                    }
                }
            }
    }

    private fun saveUserToFirestore(
        name: String,
        email: String,
        onNavigationToHome: () -> Unit
    ) {
        try {
            viewModelScope.launch(Dispatchers.IO) {
                setNewUserUseCase(email, name)
                withContext(Dispatchers.Main) {
                    delay(1500)
                    onNavigationToHome()
                }

            }
        }catch (e:Exception){
            _errorMessage.value = "Error al guardar usuario: ${e.localizedMessage}"
        }

    }
    fun setLoading(isLoading: Boolean) {
        _isLoading.value = isLoading
    }

}


