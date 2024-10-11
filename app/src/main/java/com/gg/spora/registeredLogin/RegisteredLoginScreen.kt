package com.gg.spora.registeredLogin

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
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gg.spora.R
import com.gg.spora.core.ui.components.SporaPrimaryButton
import com.gg.spora.login.component.LoginTextField
import com.gg.spora.login.ui.LoginScreen

@Composable
fun RegisteredLoginScreen(
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
                .align(Alignment.BottomCenter) // Posiciona el texto en la parte inferior central
                .padding(16.dp)
                .clickable { onRegisterClick() }
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun RegisteredLoginScreenPreview() {
    RegisteredLoginScreen(
        onBackClick = { /*TODO*/ },
        onLoginClick = { /*TODO*/ },
        onGoogleLoginClick = { /*TODO*/ },
        onRegisterClick = { /*TODO*/ }
    )
}