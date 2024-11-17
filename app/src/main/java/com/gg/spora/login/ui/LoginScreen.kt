package com.gg.spora.login.ui

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.gg.spora.R
import com.gg.spora.login.component.EmailField
import com.gg.spora.login.component.IconButtonArrowLogin
import com.gg.spora.login.component.LoginButton
import com.gg.spora.login.component.LoginQuestionLink
import com.gg.spora.login.component.NameField
import com.gg.spora.login.component.PasswordField
import com.gg.spora.login.component.loginText

@Composable
fun LoginScreen(
    viewModel: LoginViewModel,
    //navController: NavHostController,
    onNavigationToHome: () -> Unit,
    onNavigateToRegisteredLogin: () -> Unit,
) {
    val isLoading by viewModel.isLoading.observeAsState(initial = false)

    if (isLoading) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    } else {
        Box(
            Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.welcome_background),
                contentDescription = "Background",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.5f))
            )
            IconButtonArrowLogin()

            Login(
                Modifier.align(Alignment.Center),
                viewModel
            )

            LoginQuestionLink(
//            navController = navController
                onNavigateToRegisteredLogin = onNavigateToRegisteredLogin
            )
        }
    }
}

@Composable
fun Login(
    modifier: Modifier,
    viewModel: LoginViewModel
) {
    val name: String by viewModel.name.observeAsState(initial = "")
    val email: String by viewModel.email.observeAsState(initial = "")
    val password: String by viewModel.password.observeAsState(initial = "")
    val loginEnable: Boolean by viewModel.loginEnable.observeAsState(initial = false)
    val isLoading: Boolean by viewModel.isLoading.observeAsState(initial = false)
    val loginSuccess: Boolean by viewModel.loginSuccess.observeAsState(initial = false)
    val errorMessage: String? by viewModel.errorMessage.observeAsState()

    val context = LocalContext.current

    if (isLoading) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    } else {
        Column(modifier = modifier.padding(16.dp)) {
            loginText(Modifier.align(Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.padding(16.dp))
            NameField(name = name) { viewModel.onLoginChanged(it, email, password) }
            Spacer(modifier = Modifier.padding(16.dp))
            EmailField(email) { viewModel.onLoginChanged(name, it, password) }
            Spacer(modifier = Modifier.padding(16.dp))
            PasswordField(password) { viewModel.onLoginChanged(name, email, it) }
            Spacer(modifier = Modifier.padding(16.dp))
            LoginButton(loginEnable) {
                viewModel.onLoginSelected {
                    viewModel.setLoading(true)
                }
            }
            //Spacer(modifier = Modifier.padding(8.dp))
            //separatorLogin()
            //Spacer(modifier = Modifier.padding(8.dp))
            //GoogleLoginButton()

            if (loginSuccess) {
                Toast.makeText(context, "Registro exitoso", Toast.LENGTH_SHORT).show()
            }

            errorMessage?.let {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
