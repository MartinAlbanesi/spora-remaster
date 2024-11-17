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
import com.gg.spora.user.domain.UpdateUserLocalDataFromNetworkUseCase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@HiltViewModel
class RegisteredLoginViewModel @Inject constructor(
    private val updateUserLocalDataFromNetworkUseCase: UpdateUserLocalDataFromNetworkUseCase
): ViewModel() {

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
        val email = email.value.toString().trim()
        val password = password.value.toString().trim()

        viewModelScope.launch(Dispatchers.Main) {

            _isLoading.value = true

            val wea = auth.signInWithEmailAndPassword(email, password).await()

            if (wea.user != null) {
                updateUserLocalDataFromNetworkUseCase(email)
                navController.navigate(NavigationRoutes.Home)
                _isLoading.value = false
            } else {
                Toast.makeText(context, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
                _isLoading.value = false
            }
        }

//
//        auth.signInWithEmailAndPassword(email, password)
//            .addOnCompleteListener { task ->
//                if (task.isSuccessful) {
//                    //Toast.makeText(context, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
//                    updateUserLocalDataFromNetworkUseCase(email)
//                    navController.navigate(NavigationRoutes.Home)
//                } else {
//                    Toast.makeText(context, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
//                }
//            }
    }

}