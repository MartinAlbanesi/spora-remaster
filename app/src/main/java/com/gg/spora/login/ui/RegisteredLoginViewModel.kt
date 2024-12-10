package com.gg.spora.login.ui

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gg.spora.login.domain.LoginWithGoogleUseCase
import com.gg.spora.login.domain.SignInWithEmailAndPasswordUseCase
import com.gg.spora.user.domain.UpdateUserLocalDataFromNetworkUseCase
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RegisteredLoginViewModel @Inject constructor(
    private val updateUserLocalDataFromNetworkUseCase: UpdateUserLocalDataFromNetworkUseCase,
    private val signInWithEmailAndPasswordUseCase: SignInWithEmailAndPasswordUseCase,
    private val loginWithGoogleUseCase: LoginWithGoogleUseCase,
    private val googleSignInClient: GoogleSignInClient
) : ViewModel() {

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _isAccountValid = MutableLiveData<Boolean>()
    val isAccountValid: LiveData<Boolean> = _isAccountValid

    private val _isPasswordCorrect = MutableLiveData<Boolean>()
    val isPasswordCorrect: LiveData<Boolean> = _isPasswordCorrect

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _showError = MutableStateFlow(Pair(false, ""))
    val showError = _showError

    fun onEmailChanged(newEmail: String) {
        _email.value = newEmail
        _isAccountValid.value = isValidEmail(newEmail)
    }

    private fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun onPasswordChanged(newPassword: String) {
        _password.value = newPassword
    }

    fun onSignInWithEmail(
        onNavigationToHome: () -> Unit
    ) {
        val email = email.value.toString().trim()
        val password = password.value.toString().trim()

        viewModelScope.launch(Dispatchers.Main) {
            _isLoading.value = true

            try {
                val user = signInWithEmailAndPasswordUseCase(email, password)

                if (user != null) {
                    async { updateUserLocalDataFromNetworkUseCase(email) }.await()
                    onNavigationToHome()
                } else {
                    _showError.value = Pair(true, "Error al iniciar sesión")
                }
            } catch (e: FirebaseAuthInvalidUserException) {
                _showError.value = Pair(true, "El usuario no existe o la cuenta fue deshabilitada.")
            } catch (e: FirebaseNetworkException) {
                _showError.value = Pair(true, "Hay problemas con la conexión a internet")
            } catch (e: FirebaseAuthException) {
                _showError.value = Pair(true, "Error al iniciar sesión")
            }

            _isLoading.value = false
        }
    }

    fun isShowError() {
        _showError.value = Pair(false, "")
    }

    fun onGoogleLoginSelected(googleLauncherLogin: (GoogleSignInClient) -> Unit) {
        googleLauncherLogin(googleSignInClient)
    }

    fun signInWithGoogle(idToken: String, onNavigateToHome: () -> Unit) {
        viewModelScope.launch {
            _isLoading.value = true
            val result = loginWithGoogleUseCase(idToken)

            if (result != null) {
//                _singInState.value = result
                onNavigateToHome()
            } else {
                _showError.value = Pair(true, "Error al iniciar sesión")
            }
            _isLoading.value = false
        }
    }

}