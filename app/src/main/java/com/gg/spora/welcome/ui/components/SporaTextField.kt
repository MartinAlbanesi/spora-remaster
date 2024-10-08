package com.gg.spora.welcome.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gg.spora.ui.theme.SporaTheme

@Composable
fun SporaTextField(
    modifier: Modifier = Modifier,
    guestName: String,
    onValueChange: (String) -> Unit = {},
) {
    val placeholder = "Escribi tu nombre"
    val shape = RoundedCornerShape(20.dp)

    TextField(
        value = guestName,
        onValueChange = {
            onValueChange (it)
        },
        placeholder = { Text(
            text = placeholder,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            style = MaterialTheme.typography.labelLarge,
        ) },
        singleLine = true,
        modifier = modifier
            .width(350.dp)
            .height(50.dp),
        shape = shape,
        textStyle = MaterialTheme.typography.labelLarge,
        colors = TextFieldDefaults.colors(
            unfocusedTextColor = MaterialTheme.colorScheme.onSurface,
            focusedTextColor = MaterialTheme.colorScheme.onSurface,
            focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
            unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = MaterialTheme.colorScheme.primary,
            unfocusedLabelColor = MaterialTheme.colorScheme.onSurface
        )
    )
}

@Preview(showBackground = true)
@Composable
fun SporaLabelPrimaryPreview() {
    SporaTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            SporaTextField(
                guestName = "",
                modifier = Modifier.align(Alignment.Center),
            )
        }
    }
}

