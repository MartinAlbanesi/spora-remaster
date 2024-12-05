package com.gg.spora.login.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle


@Composable
fun LoadingIndicator() {
    Box(modifier = Modifier.fillMaxSize()) {
        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
    }
}

@Composable
fun InputField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    isPassword: Boolean = false
) {
    LoginTextField(
        placeholder = placeholder,
        value = value,
        onValueChange = onValueChange,
        isPassword = isPassword,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun SignUpText(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    mainText: String = "¿No tienes una cuenta? ",
    linkText: String = "Regístrate",
    mainTextColor: Color = Color.White,
    linkTextColor: Color = Color.Cyan
) {
    Text(
        text = buildAnnotatedString {
            withStyle(style = SpanStyle(color = mainTextColor)) {
                append(mainText)
            }
            withStyle(
                style = SpanStyle(
                    color = linkTextColor,
                    textDecoration = TextDecoration.Underline
                )
            ) {
                append(linkText)
            }
        },
        modifier = modifier.clickable(onClick = onClick)
    )
}
