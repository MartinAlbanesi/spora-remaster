package com.gg.spora.registeredLogin.iu

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.gg.spora.core.graph.NavigationRoutes
import com.gg.spora.user.domain.UpdateUserLocalDataFromNetworkUseCase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import javax.inject.Inject


@HiltViewModel
class RegisteredLoginViewModel @Inject constructor(
    private val updateUserLocalDataFromNetworkUseCase: UpdateUserLocalDataFromNetworkUseCase
) : ViewModel() {

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _isAccountValid = MutableLiveData<Boolean>()
    val isAccountValid: LiveData<Boolean> = _isAccountValid

    private val _isPasswordCorrect = MutableLiveData<Boolean>()
    val isPasswordCorrect: LiveData<Boolean> = _isPasswordCorrect

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _showError = MutableLiveData<Boolean>()
    val showError: LiveData<Boolean> = _showError

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

    fun onLoginClick(navController: NavHostController) {
        val email = email.value.toString().trim()
        val password = password.value.toString().trim()

        viewModelScope.launch(Dispatchers.Main) {
            _isLoading.value = true

            try {
                val wea = auth.signInWithEmailAndPassword(email, password).await()

                if (wea.user != null) {
                    updateUserLocalDataFromNetworkUseCase(email)
                    navController.navigate(NavigationRoutes.Home)
                } else {
                    _showError.value = true // Mostrar Toast si la autenticación falla
                }
            } catch (e: FirebaseAuthInvalidUserException) {
                _showError.value = true // Usuario no registrado
                Log.e("RegisteredLogin", "Usuario no encontrado: ${e.message}", e)
            } catch (e: FirebaseAuthInvalidCredentialsException) {
                _showError.value = true // Credenciales inválidas
                Log.e("RegisteredLogin", "Credenciales inválidas: ${e.message}", e)
            } catch (e: Exception) {
                _showError.value = true // Error genérico
                Log.e("RegisteredLogin", "Error inesperado: ${e.message}", e)
            } finally {
                _isLoading.value = false
            }


            /*try {
                val wea = auth.signInWithEmailAndPassword(email, password).await()

                if (wea.user != null) {
                    updateUserLocalDataFromNetworkUseCase(email)
                    navController.navigate(NavigationRoutes.Home)
                } else {
                    _showError.value = true // Mostrar Toast si la autenticación falla
                }
            } catch (e: Exception) {
                _showError.value = true // Mostrar Toast si hay una excepción
            } finally {
                _isLoading.value = false
            }*/
        }
    }
    fun showErrorConsumed() {
        _showError.value = false
    }

}