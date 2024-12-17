package com.gg.spora.login.ui

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.gg.spora.R
import com.gg.spora.core.graph.NavigationRoutes
import com.gg.spora.core.ui.components.ShowCircularProgressIndicator
import com.gg.spora.core.ui.components.SporaPrimaryButton
import com.gg.spora.login.ui.component.IconButtonArrowLogin
import com.gg.spora.login.ui.component.InputField
import com.gg.spora.login.ui.component.LoginWithProvider
import com.gg.spora.login.ui.component.SignUpText
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.common.api.ApiException


@Composable
fun RegisteredLoginScreen(
//    onBackClick: () -> Unit,
//    onLoginClick: () -> Unit,
//    onGoogleLoginClick: () -> Unit,
//    onRegisterClick: () -> Unit,
//    navController: NavHostController
    onSignUpClick: () -> Unit,
    onNavigateToHome: () -> Unit
) {

    val registeredLoginViewModel = hiltViewModel<RegisteredLoginViewModel>()
    val email by registeredLoginViewModel.email.observeAsState("")
    val password by registeredLoginViewModel.password.observeAsState("")
    val isAccountValid by registeredLoginViewModel.isAccountValid.observeAsState(false)
    val isPasswordCorrect by registeredLoginViewModel.isPasswordCorrect.observeAsState(false)
    val isLoading by registeredLoginViewModel.isLoading.observeAsState(initial = false)

    val showError by registeredLoginViewModel.showError.collectAsState()

    val googleLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { retult ->
        val task = GoogleSignIn.getSignedInAccountFromIntent(retult.data)

        try {
            val account = task.getResult(ApiException::class.java)
            registeredLoginViewModel.signInWithGoogle(account.idToken!!) {
                onNavigateToHome()
            }
        } catch (e: ApiException) {
            registeredLoginViewModel.isShowError()
        }
    }

    if (showError.first) {
        AlertDialog(
            text = {
                Text(showError.second)
            },
            onDismissRequest = { registeredLoginViewModel.isShowError() },
            confirmButton = {
                TextButton(
                    onClick = {
                        registeredLoginViewModel.isShowError()
                    }
                ) {
                    Text("Aceptar")
                }
            }
        )
    }

    ShowCircularProgressIndicator(isLoading)

    Box(modifier = Modifier.fillMaxSize()) {
        // Background
        Image(
            painter = painterResource(id = R.drawable.welcome_background),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer { alpha = 1f },
            contentScale = androidx.compose.ui.layout.ContentScale.FillBounds,
            colorFilter = ColorFilter.tint(
                Color.Black.copy(alpha = 0.5f),
                BlendMode.Darken
            )
        )

        //
        //Main content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically)
        ) {
            // Texto
            Text(
                text = "Iniciar sesión",
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = Color.White,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            // Input fields
            InputField(
                value = email,
                onValueChange = registeredLoginViewModel::onEmailChanged,
                placeholder = "Correo"
            )
            InputField(
                value = password,
                onValueChange = registeredLoginViewModel::onPasswordChanged,
                placeholder = "Contraseña",
                isPassword = true
            )

            // Confirm button
            val context = LocalContext.current
            val isLoginEnabled = isAccountValid && password.length >= 7
            SporaPrimaryButton(
                text = "Confirmar",
                textSize = 24,
                onClick = {
                    registeredLoginViewModel.onSignInWithEmail {
                        onNavigateToHome()
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                isEnable = isLoginEnabled
            )

            // Separator
            Row(verticalAlignment = Alignment.CenterVertically) {
                Divider(modifier = Modifier.weight(1f))
                Text(
                    text = "o",
                    modifier = Modifier.padding(horizontal = 8.dp),
                    color = Color.White
                )
                Divider(modifier = Modifier.weight(1f))
            }

            // GoogleButton
            LoginWithProvider(
                provider = "Google",
                logo = R.drawable.google_icon,
                onClickProvider = {
                    registeredLoginViewModel.onGoogleLoginSelected {
                        googleLauncher.launch(it.signInIntent)
                    }
                }
            )

        }

        // Arrow at top left
        IconButtonArrowLogin()

        // Text of "Don't have an account?"
        SignUpText(
            onClick = onSignUpClick,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
        )
    }

}
