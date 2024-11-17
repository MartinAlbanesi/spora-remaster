package com.gg.spora.registeredLogin.iu

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.gg.spora.R
import com.gg.spora.core.graph.NavigationRoutes
import com.gg.spora.core.ui.components.SporaPrimaryButton
import com.gg.spora.login.component.LoginTextField


@Composable
fun RegisteredLoginScreen(
    onBackClick: () -> Unit,
//    onLoginClick: () -> Unit,
//    onGoogleLoginClick: () -> Unit,
//    onRegisterClick: () -> Unit,
    navController: NavHostController
) {

    val registeredLoginViewModel = hiltViewModel<RegisteredLoginViewModel>()
    val email by registeredLoginViewModel.email.observeAsState("")
    val password by registeredLoginViewModel.password.observeAsState("")
    val isAccountValid by registeredLoginViewModel.isAccountValid.observeAsState(false)
    val isPasswordCorrect by registeredLoginViewModel.isPasswordCorrect.observeAsState(false)
    val isLoading by registeredLoginViewModel.isLoading.observeAsState(initial = false)
    val showError by registeredLoginViewModel.showError.observeAsState(initial = false)
    val context = LocalContext.current

    if (isLoading) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    } else {
        Box(modifier = Modifier.fillMaxSize()) {
            // Imagen de fondo
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

            // Contenido principal
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

                // Campos de entrada
                LoginTextField(
                    placeholder = "Correo",
                    value = email,
                    onValueChange = registeredLoginViewModel::onEmailChanged,
                    modifier = Modifier.fillMaxWidth()
                )

                LoginTextField(
                    placeholder = "Contraseña",
                    isPassword = true,
                    value = password,
                    onValueChange = registeredLoginViewModel::onPasswordChanged,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = "¿Olvidaste tu contraseña?",
                    color = Color.Cyan,
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(bottom = 8.dp)
                        .clickable {
                            /*TODO*/
                        },
                    style = MaterialTheme.typography.bodySmall.copy(textDecoration = TextDecoration.Underline) // Subrayado
                )

                // Botón de confirmar
                val context = LocalContext.current
                val isLoginEnabled = isAccountValid && password.length >=7
                SporaPrimaryButton(
                    text = "Confirmar",
                    textSize = 24,
                    onClick = { registeredLoginViewModel.onLoginClick(context, navController) },
                    modifier = Modifier.fillMaxWidth(),
                    isEnable = isLoginEnabled
                )

                // Separador
                /* Row(verticalAlignment = Alignment.CenterVertically) {
                     Divider(modifier = Modifier.weight(1f))
                     Text(
                         text = "o",
                         modifier = Modifier.padding(horizontal = 8.dp),
                         color = Color.White
                     )
                     Divider(modifier = Modifier.weight(1f))
                 }

                 // Botón de login con Google
                 Button(
                     onClick = ( /*TODO*/ ),
                     modifier = Modifier.fillMaxWidth(),
                     colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                     contentPadding = PaddingValues(8.dp)
                 ) {
                     Box(
                         modifier = Modifier.fillMaxWidth(),
                         contentAlignment = Alignment.Center
                     ) {
                         Row(
                             modifier = Modifier.fillMaxWidth(),
                             verticalAlignment = Alignment.CenterVertically
                         ) {
                             Icon(
                                 painter = painterResource(id = R.drawable.google),
                                 contentDescription = "Google Login",
                                 tint = Color.Unspecified,
                                 modifier = Modifier.size(ButtonDefaults.IconSize)
                             )
                         }
                         Text(
                             text = "Continue with Google",
                             color = Color.Black,
                             fontSize = 18.sp,
                             modifier = Modifier.align(Alignment.Center)
                         )
                     }
                 }*/
            }

            // Flecha en la parte superior izquierda
            IconButton(
                onClick = onBackClick,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(16.dp)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = "Volver",
                    tint = Color.White,
                    modifier = Modifier.size(32.dp)
                )
            }

            // Texto de "¿No tienes una cuenta?"
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.White)) {
                        append("¿No tienes una cuenta? ")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = Color.Cyan,
                            textDecoration = TextDecoration.Underline
                        )
                    ) {
                        append("Regístrate")
                    }
                },
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(16.dp)
                    .clickable {
                        navController.navigate(NavigationRoutes.SignUp) // Navegar a LoginScreen
                    }
            )
        }
        if (showError) {
            LaunchedEffect(key1 = showError) {
                Toast.makeText(
                    context, "El mail o la contraseña son incorrectas", Toast.LENGTH_SHORT).show()
                registeredLoginViewModel.showErrorConsumed()
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun RegisteredLoginScreenPreview() {
    RegisteredLoginScreen(
        onBackClick = {  },
        navController = NavHostController(LocalContext.current)
    )
}