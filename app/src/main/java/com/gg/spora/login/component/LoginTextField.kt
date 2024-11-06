package com.gg.spora.login.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gg.spora.ui.theme.SporaTheme

@Composable
fun LoginTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit = {},
    placeholder: String,
    label: String? = null,
    isPassword: Boolean = false
) {
    val shape = RoundedCornerShape(16.dp)
    var passwordVisible by remember { mutableStateOf(false) } // State for password visibility

    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = placeholder,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                style = MaterialTheme.typography.labelLarge
            )
        },
        label = if (label != null) { { Text(label) } } else { null },
        singleLine = true,
        modifier = modifier
            .width(350.dp)
            .height(60.dp)
            .padding(bottom = 8.dp),
        shape = shape,
        textStyle = MaterialTheme.typography.labelLarge,
        visualTransformation = if (isPassword) { // Apply visual transformation only if isPassword is true
            if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        },
        colors = TextFieldDefaults.colors(
            unfocusedTextColor = MaterialTheme.colorScheme.onSurface,
            focusedTextColor = MaterialTheme.colorScheme.onSurface,
            focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
            unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = MaterialTheme.colorScheme.primary,
            unfocusedLabelColor = MaterialTheme.colorScheme.onSurface
        ),
        trailingIcon = {
            if (isPassword) { // Show trailing icon only if isPassword is true
                val image = if (passwordVisible)
                    Icons.Filled.Visibility
                else Icons.Filled.VisibilityOff
                // Please provide localized description for accessibility
                val description = if (passwordVisible) "Hide password" else "Show password"

                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(imageVector = image, contentDescription = description)
                }
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = if (isPassword) KeyboardType.Password else KeyboardType.Text) // Set keyboard type based on isPassword
    )
}

/*@Composable
fun LoginTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit = {},
    placeholder: String,
    label: String? = null, // Agregar parámetro para label
    isPassword: Boolean = false // Agregar parámetro para contraseña
) {
    val shape = RoundedCornerShape(20.dp)

    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = placeholder,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                style = MaterialTheme.typography.labelLarge
            )
        },
        label = if (label != null) { { Text(label) } } else { null }, // Mostrar label si se proporciona
        singleLine = true,
        modifier = modifier
            .width(350.dp)
            .height(50.dp),
        shape = shape,
        textStyle = MaterialTheme.typography.labelLarge,
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None, // Aplicar transformación para contraseña
        colors = TextFieldDefaults.colors(
            unfocusedTextColor = MaterialTheme.colorScheme.onSurface,
            focusedTextColor = MaterialTheme.colorScheme.onSurface,
            focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
            unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = MaterialTheme.colorScheme.primary,
            unfocusedLabelColor = MaterialTheme.colorScheme.onSurface
        ),
    )
}*/

@Preview(showBackground = true)
@Composable
fun SporaLabelPrimaryPreview() {
    SporaTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            LoginTextField(
                value = "",
                placeholder = "Escribi tu nombre", // Agregar placeholder
                //label = "", // Agregar label (opcional)
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}