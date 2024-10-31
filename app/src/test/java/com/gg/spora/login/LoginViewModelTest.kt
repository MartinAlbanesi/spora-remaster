package com.gg.spora.login

import com.gg.spora.login.ui.LoginViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockkStatic
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE)
@ExperimentalCoroutinesApi
class LoginViewModelTest {

    @MockK
    private lateinit var auth: FirebaseAuth
    @MockK
    private lateinit var firestore: FirebaseFirestore
    private lateinit var viewModel: LoginViewModel


    @Before
    fun setup() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(StandardTestDispatcher())
        mockkStatic(FirebaseAuth::class)
        every { FirebaseAuth.getInstance() } returns auth
        mockkStatic(FirebaseFirestore::class)
        every { FirebaseFirestore.getInstance() } returns firestore
        viewModel = LoginViewModel() // Crea instancia sin argumentos

        // Inyecta dependencias mockeadas utilizando reflection
        val authField: java.lang.reflect.Field = viewModel.javaClass.getDeclaredField("auth")
        authField.isAccessible = true
        authField.set(viewModel, auth)

        val firestoreField: java.lang.reflect.Field = viewModel.javaClass.getDeclaredField("firestore")
        firestoreField.isAccessible = true
        firestoreField.set(viewModel, firestore)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun isValidPassword_validPassword_returnsTrue() {
        // Verifica que isValidPassword() retorne true para una contraseña válida.
        val password = "validPassword123"
        val isValidPasswordMethod = viewModel.javaClass.getDeclaredMethod("isValidPassword", String::class.java)
        isValidPasswordMethod.isAccessible = true
        val result = isValidPasswordMethod.invoke(viewModel, password) as Boolean
        assertTrue(result)
    }

    @Test
    fun isValidPassword_invalidPassword_returnsFalse() {
        // Verifica que isValidPassword() retorne false para una contraseña inválida.
        val password = "short"
        val isValidPasswordMethod = viewModel.javaClass.getDeclaredMethod("isValidPassword", String::class.java)
        isValidPasswordMethod.isAccessible = true
        val result = isValidPasswordMethod.invoke(viewModel, password) as Boolean
        assertFalse(result)
    }

    @Test
    fun isValidEmail_validEmail_returnsTrue() {
        val email = "test@example.com"
        val viewModel = LoginViewModel()
        val result = viewModel.isValidEmail(email)
        assertTrue(result)
    }

    @Test
    fun isValidEmail_invalidEmail_returnsFalse() {
        val email = "invalid-email"
        val result = viewModel.isValidEmail(email)
        assertFalse(result)
    }
}