package com.gg.spora.registeredLogin.iu

import android.content.Context
import android.util.Patterns
import android.widget.Toast
import androidx.activity.result.launch
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.semantics.password
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.gg.spora.core.graph.NavigationRoutes
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class RegisteredLoginViewModel : ViewModel() {

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

   fun onLoginClick(context: Context, navController: NavHostController) {
       _isLoading.value = true
       viewModelScope.launch {
           delay(1500)
           val email = email.value.toString().trim()
           val password = password.value.toString().trim()

           auth.signInWithEmailAndPassword(email, password)
               .addOnCompleteListener { task ->
                   if (task.isSuccessful) {
                       _isLoading.value = false
                       navController.navigate(NavigationRoutes.Home)
                   } else {
                       _isLoading.value = false
                       Toast.makeText(context, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
                   }
               }
       }
   }

}