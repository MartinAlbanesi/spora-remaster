package com.gg.spora.registeredLogin.iu

import android.content.Context
import android.widget.Toast
import androidx.compose.ui.semantics.password
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gg.spora.registeredLogin.data.User

class RegisteredLoginViewModel : ViewModel() {

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _isAccountValid = MutableLiveData<Boolean>()
    val isAccountValid: LiveData<Boolean> = _isAccountValid

    private val _isPasswordCorrect = MutableLiveData<Boolean>()
    val isPasswordCorrect: LiveData<Boolean> = _isPasswordCorrect

    private val mockUsers = listOf(
        User("champy@example.com", "Spora1"),
        User("mushy@example.com", "Spora2")
    )

    fun onEmailChanged(newEmail: String) {
        _email.value = newEmail
        _isAccountValid.value = mockUsers.any { it.email == newEmail }
    }

    fun onPasswordChanged(newPassword: String) {
        _password.value = newPassword
    }

    fun onLoginClick(context: Context) {
        val user = mockUsers.find { it.email == email.value }
        _isPasswordCorrect.value = user != null && user.password == password.value

        if (_isPasswordCorrect.value == true) {
            Toast.makeText(context, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
        }
    }

    /*fun onLoginClick() {
        val user = mockUsers.find { it.email == email.value }
        _isPasswordCorrect.value = user != null && user.password == password.value

        // Si las credenciales son válidas, puedes navegar a la siguiente pantalla o realizar otras acciones
        // Por ejemplo:
        // if (_isPasswordCorrect.value == true) {
        //     // Navegar a la pantalla principal
        // } else {
        //     // Mostrar un mensaje de error
        // }
    }*/
}