package com.gg.spora.login.ui

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gg.spora.login.domain.CreateAccountWithEmailUseCase
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuthEmailException
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val createAccountWithEmailUseCase: CreateAccountWithEmailUseCase,
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

    private val _showError = MutableStateFlow(Pair(false, ""))
    val showError = _showError

    private fun isValidPassword(password: String): Boolean = password.length > 6

    private fun isValidEmail(email: String): Boolean =
        Patterns.EMAIL_ADDRESS.matcher(email).matches()

    fun onLoginChanged(name: String, email: String, password: String) {
        _name.value = name
        _email.value = email
        _password.value = password
        _loginEnable.value = isValidEmail(email) && isValidPassword(password)
    }

    fun onCreateAccount(
        onNavigateToHome: () -> Unit
    ) {
        viewModelScope.launch(Dispatchers.Main) {
            _isLoading.value = true

            try {
                val result = createAccountWithEmailUseCase(
                    userName = name.value.orEmpty(),
                    email = email.value.orEmpty(),
                    password = password.value.orEmpty()
                )

                if (result != null) {
                    onNavigateToHome()

                } else {
                    _showError.value = Pair(true, "Error al registrar usuario")
                }
            } catch (e: FirebaseNetworkException) {
                _showError.value = Pair(true, "Hay problemas con la conexión a internet")
            } catch (e: FirebaseAuthUserCollisionException) {
                _showError.value = Pair(true, "El usuario ya está registrado")
            } catch (e: FirebaseAuthException) {
                _showError.value = Pair(true, "Error al registrar usuario")
            } catch (e: FirebaseAuthEmailException){
                _showError.value = Pair(true, "Email inválido")
            }

            _isLoading.value = false
        }
    }

    fun isShowError() {
        _showError.value = Pair(false, "")
    }

//    fun onLoginSelected(onNavigationToHome: () -> Unit) {
//        _isLoading.value = true
//        viewModelScope.launch {
//            try {
//                registerWithEmail(
//                    email.value.orEmpty(),
//                    password.value.orEmpty(),
//                    name.value.orEmpty(),
//                    onNavigationToHome
//                )
//            } catch (e: FirebaseAuthInvalidCredentialsException) {
//                _errorMessage.value = "Credenciales inválidas: ${e.localizedMessage}"
//            } catch (e: FirebaseAuthUserCollisionException) {
//                _errorMessage.value = "El usuario ya está registrado"
//            } catch (e: IllegalArgumentException) {
//                _errorMessage.value = "Parámetros inválidos: ${e.localizedMessage}"
//            } catch (e: Exception) {
//                Log.e("LoginViewModel", "Error inesperado: ${e.message}", e)
//                _errorMessage.value = "Error desconocido: ${e.localizedMessage}"
//                throw e // Opcional: re-lanza para no ocultar el error
//            } finally {
//                _isLoading.value = false
//            }
//        }
//    }


//    private fun registerWithEmail(
//        email: String,
//        password: String,
//        name: String,
//        onNavigationToHome: () -> Unit
//    ) {
//        auth.createUserWithEmailAndPassword(email, password)
//            .addOnCompleteListener { task ->
//                if (task.isSuccessful) {
//                    saveUserToFirestore(name, email, onNavigationToHome)
//                } else {
//                    if (task.exception is FirebaseAuthUserCollisionException) {
//                        _errorMessage.value = "Usuario ya registrado"
//                    } else {
//                        _errorMessage.value = "Error: ${task.exception?.localizedMessage}"
//                    }
//                }
//            }
//    }
//
//    private fun saveUserToFirestore(
//        name: String,
//        email: String,
//        onNavigationToHome: () -> Unit
//    ) {
//        viewModelScope.launch {
//            try {
//                setNewUserUseCase(email, name)
//                withContext(Dispatchers.Main) {
//                    delay(1500)
//                    onNavigationToHome()
//                }
//            } catch (e: IllegalStateException) {
//                _errorMessage.value = "Estado inesperado: ${e.localizedMessage}"
//            } catch (e: IllegalArgumentException) {
//                _errorMessage.value = "Datos inválidos: ${e.localizedMessage}"
//            } catch (e: Exception) {
//                Log.e("LoginViewModel", "Error al guardar usuario: ${e.message}", e)
//                _errorMessage.value = "Error al guardar usuario: ${e.localizedMessage}"
//                throw e // Opcional
//            }
//        }
//    }


    /*private fun saveUserToFirestore(
        name: String,
        email: String,
        onNavigationToHome: () -> Unit
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                setNewUserUseCase(email, name)
                withContext(Dispatchers.Main) {
                    delay(1500)
                    onNavigationToHome()
                }
            } catch (e: IllegalStateException) {
                _errorMessage.value = "Estado inesperado: ${e.localizedMessage}"
            } catch (e: Exception) {
                _errorMessage.value = "Error al guardar usuario: ${e.localizedMessage}"
            }
        }
    }*/

    fun setLoading(isLoading: Boolean) {
        _isLoading.value = isLoading
    }

}


