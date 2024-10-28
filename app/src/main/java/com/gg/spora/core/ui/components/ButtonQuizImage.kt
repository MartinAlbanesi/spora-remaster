package com.gg.spora.core.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gg.spora.R

@Composable
fun ButtonQuizImage(text: String, onClick: () -> Unit) {
    Button(
        modifier = Modifier
            .height(50.dp)
            .width(165.dp)
            .shadow(
                elevation = 4.dp,
                shape = MaterialTheme.shapes.large,
            ),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.surface),
            contentColor = Color.Black
        )
    ) {
        Text(text)
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonQuizImagePreview() {
    ButtonQuizImage(text = "Ejemplo", onClick = { /* Acción del botón */ })
}