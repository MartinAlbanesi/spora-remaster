package com.gg.spora.login.ui

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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.gg.spora.R
import com.gg.spora.login.component.EmailField
import com.gg.spora.login.component.GoogleLoginButton
import com.gg.spora.login.component.IconButtonArrowLogin
import com.gg.spora.login.component.LoginButton
import com.gg.spora.login.component.LoginQuestionLink
import com.gg.spora.login.component.NameField
import com.gg.spora.login.component.PasswordField
import com.gg.spora.login.component.loginText
import com.gg.spora.login.component.separatorLogin
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(viewModel: LoginViewModel) {
    Box(
        Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.fondo_introduccion),
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

        Login(Modifier.align(Alignment.Center), viewModel)

        LoginQuestionLink()
    }
}

@Composable
fun Login(modifier: Modifier, viewModel: LoginViewModel) {

    val name: String by viewModel.name.observeAsState(initial = "")
    val email: String by viewModel.email.observeAsState(initial = "")
    val password: String by viewModel.password.observeAsState(initial = "")
    val loginEnable: Boolean by viewModel.loginEnable.observeAsState(initial = false)
    val isLoading: Boolean by viewModel.isLoading.observeAsState(initial = false)
    val coroutineScope = rememberCoroutineScope()

    if (isLoading) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }else{
        Column(modifier = modifier.padding(16.dp)) {
            loginText(Modifier.align(Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.padding(16.dp))
            NameField(name = name){viewModel.onLoginChanged(it, email, password)}
            Spacer(modifier = Modifier.padding(16.dp))
            EmailField(email, { viewModel.onLoginChanged(name, it, password) })
            Spacer(modifier = Modifier.padding(16.dp))
            PasswordField(password) { viewModel.onLoginChanged(name, email, it) }
            Spacer(modifier = Modifier.padding(16.dp))
            LoginButton(loginEnable) {
                coroutineScope.launch {
                    viewModel.onLoginSelected()
                }
            }
            Spacer(modifier = Modifier.padding(8.dp))
            separatorLogin()
            Spacer(modifier = Modifier.padding(8.dp))
            GoogleLoginButton()
        }
    }
}

/*
@Composable
fun LoginScreen(
    onBackClick: () -> Unit,
    onLoginClick: () -> Unit,
    onGoogleLoginClick: () -> Unit,
    onRegisterClick: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Imagen de fondo oscurecida
        Image(
            painter = painterResource(id = R.drawable.fondo_introduccion),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer { alpha = 0.5f },
            contentScale = androidx.compose.ui.layout.ContentScale.FillBounds
        )

        // Contenido principal centrado verticalmente
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically)
        ) {
            // Texto
            Text(
                text = "Creá tu perfil",
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = Color.White,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            // Campos de entrada
            LoginTextField(
                placeholder = "Nombre",
                value = "",
                onValueChange = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth()
            )

            LoginTextField(
                placeholder = "Correo",
                value = "",
                onValueChange = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth()
            )

            LoginTextField(
                placeholder = "Contraseña",
                value = "",
                onValueChange = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth()
            )

            // Botón de confirmar
            SporaPrimaryButton(
                text = "Confirmar",
                textSize = 20,
                onClick = onLoginClick,
                modifier = Modifier.fillMaxWidth()
            )

            // Separador
            Row(verticalAlignment = Alignment.CenterVertically) {
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
                onClick = onGoogleLoginClick,
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
            }
        }

        // Flecha en la parte superior izquierda
        IconButton(
            onClick = onBackClick,
            modifier = Modifier
                .align(Alignment.TopStart) // Posiciona la flecha en la esquina superior izquierda
                .padding(16.dp) // Espaciado desde el borde de la pantalla
        ) {
            Icon(
                imageVector = Icons.Filled.KeyboardArrowLeft,
                contentDescription = "Volver",
                tint = Color.White,
                modifier = Modifier.size(32.dp)
            )
        }

        // Texto de "¿No tienes una cuenta?" en la parte inferior centrado
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.White)) {
                    append("¿No tienes una cuenta? ")
                }
                withStyle(style = SpanStyle(color = Color.Cyan, textDecoration = TextDecoration.Underline)) {
                    append("Regístrate")
                }
            },
            modifier = Modifier
                .align(Alignment.BottomCenter) // Posiciona el texto en la parte inferior central
                .padding(16.dp)
                .clickable { onRegisterClick() }
        )
    }
}


@Preview(showBackground = true, backgroundColor = 0xFF000000, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(
        onBackClick = { /*TODO*/ },
        onLoginClick = { /*TODO*/ },
        onGoogleLoginClick = { /*TODO*/ },
        onRegisterClick = { /*TODO*/ }
    )
}*/