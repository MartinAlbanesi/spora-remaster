package com.gg.spora.login.ui

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.delay

class LoginViewModel : ViewModel() {

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

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()

    fun onLoginChanged(name: String, email: String, password: String) {
        _name.value = name
        _email.value = email
        _password.value = password
        _loginEnable.value = isValidEmail(email) && isValidPassword(password)
    }

    private fun isValidPassword(password: String): Boolean = password.length > 6
    public fun isValidEmail(email: String): Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()

    suspend fun onLoginSelected() {
        _isLoading.value = true
        try {
            registerWithEmail(email.value.orEmpty(), password.value.orEmpty(), name.value.orEmpty())
        } catch (e: Exception) {
            _errorMessage.value = "Error: ${e.localizedMessage}"
        } finally {
            _isLoading.value = false
        }
    }

    private fun registerWithEmail(email: String, password: String, name: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    saveUserToFirestore(name, email)
                } else {
                    if (task.exception is FirebaseAuthUserCollisionException) {
                        _errorMessage.value = "Usuario ya registrado"
                    } else {
                        _errorMessage.value = "Error: ${task.exception?.localizedMessage}"
                    }
                }
            }
    }

    private fun saveUserToFirestore(name: String, email: String) {
        val user = hashMapOf(
            "name" to name,
            "email" to email
        )
        firestore.collection("users")
            .add(user)
            .addOnSuccessListener {
                _loginSuccess.value = true
                _errorMessage.value = null
            }
            .addOnFailureListener {
                _errorMessage.value = "Error al guardar usuario: ${it.localizedMessage}"
            }
    }

}


