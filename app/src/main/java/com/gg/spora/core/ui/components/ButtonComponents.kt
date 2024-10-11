package com.gg.spora.core.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gg.spora.ui.theme.SporaTheme

@Composable
fun SporaPrimaryButton(
    modifier: Modifier = Modifier,
    text: String,
    textSize: Int = 26,
    onClick: () -> Unit
) {

    Button(
        onClick = { onClick() },
        modifier = modifier,
        //colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFF69C2C) // modificar para usar material
        ),
        shape = ButtonDefaults.elevatedShape
    ) {
        Text(text = text, fontSize = textSize.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun SporaPrimaryInverseButton(
    modifier: Modifier = Modifier,
    text: String,
    textSize: Int = 26,
    onClick: () -> Unit
) {

    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.background),
        shape = ButtonDefaults.elevatedShape,
        border = BorderStroke(2.dp, MaterialTheme.colorScheme.primary)
    ) {
        Text(
            text = text,
            fontSize = textSize.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
fun SporaSecondaryButton(
    modifier: Modifier = Modifier,
    text: String,
    textSize: Int = 26,
    onClick: () -> Unit
) {

    Button(
        onClick = onClick,
        modifier = modifier.size(width = 350.dp, height = 50.dp),
        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondary),
        elevation = ButtonDefaults.buttonElevation(5.dp),
        shape = ButtonDefaults.elevatedShape
    ) {
        Text(
            text = text,
            fontSize = textSize.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSecondary
        )
    }
}


@Preview(showBackground = true)
@Composable
fun SporaPrimaryButtonPreview() {

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        SporaTheme {

            SporaPrimaryButton(
                modifier = Modifier.align(Alignment.Center),
                text = "Continuar",
                onClick = {},
                textSize = 26
            )

            Spacer(modifier = Modifier.height(20.dp))

            SporaPrimaryInverseButton(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .offset(y = 50.dp),
                text = "Continuar",
                onClick = {})

            Spacer(modifier = Modifier.height(20.dp))

            SporaSecondaryButton(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .offset(y = (-50).dp),
                text = "Continuar",
                onClick = {})

            Spacer(modifier = Modifier.height(20.dp))

            SporaInverseSecondaryButton(
                modifier = Modifier
                    .align(Alignment.Center)
                    .offset(y = 100.dp),
                text = "Continuar",
                onClick = {})
        }
    }
}

@Composable
fun SporaInverseSecondaryButton(
    modifier: Modifier,
    text: String = "Continuar",
    textSize: Int = 26,
    onClick: () -> Unit
) {

    Button(
        onClick = onClick,
        modifier = modifier.size(width = 350.dp, height = 50.dp),
        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.background),
        elevation = ButtonDefaults.buttonElevation(5.dp),
        shape = ButtonDefaults.elevatedShape,
        border = BorderStroke(2.dp, MaterialTheme.colorScheme.secondary)
    ) {

        Text(
            text = text,
            fontSize = textSize.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}