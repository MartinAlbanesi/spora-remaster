package com.gg.spora.welcome.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gg.spora.ui.theme.SporaTheme

@Composable
fun SporaTextField(
    modifier: Modifier = Modifier,
    guestName: String,
    onValueChange: (String) -> Unit = {},
    filterNames: (String) -> String,
    isAllowedName: (Boolean) -> Unit,
) {
    val placeholder = "Escribi tu nombre"
    val shape = RoundedCornerShape(20.dp)
    val usernamePattern = "^[a-zA-Z]{3,15}$"
    var showError by remember {
        mutableStateOf(
            !guestName.matches(
                usernamePattern.toRegex()
            )
        )
    }
    var isBannedWord by remember { mutableStateOf(false) }


    Column(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(
                color = if (showError || isBannedWord)
                    MaterialTheme.colorScheme.errorContainer else Color.Transparent,
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TextField(
            value = guestName,
            onValueChange = {
                val filteredText = filterNames(it)
                onValueChange(filteredText)
                isBannedWord = filteredText.contains("*")
                showError = !filteredText.matches(usernamePattern.toRegex())
                isAllowedName(isBannedWord || showError)
            },
            placeholder = {
                Text(
                    text = placeholder,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    style = MaterialTheme.typography.labelLarge,
                )
            },
            singleLine = true,
            isError = showError,
            modifier = modifier
                .width(350.dp)
                .height(50.dp),
            shape = if (showError) RoundedCornerShape(0.dp) else shape,
            textStyle = MaterialTheme.typography.labelLarge,
            colors = TextFieldDefaults.colors(
                unfocusedTextColor = MaterialTheme.colorScheme.onSurface,
                focusedTextColor = MaterialTheme.colorScheme.onSurface,
                focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = MaterialTheme.colorScheme.primary,
                unfocusedLabelColor = MaterialTheme.colorScheme.onSurface,
                errorContainerColor = MaterialTheme.colorScheme.primaryContainer,
            )
        )

        Spacer(Modifier.height(4.dp))

        AnimatedVisibility(visible = showError) {
            Text(
                text = if (!isBannedWord) "Ingresá un nombre de 3 a 15 caracteres" else "No se permiten malas palabras",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.Black
            )
        }

        Spacer(Modifier.height(4.dp))

    }

}

@Preview(showBackground = true)
@Composable
fun SporaLabelPrimaryPreview() {
    SporaTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            SporaTextField(
                guestName = "Jo",
                modifier = Modifier.align(Alignment.Center),
                filterNames = { "" },
                isAllowedName = { }
            )
        }
    }
}

