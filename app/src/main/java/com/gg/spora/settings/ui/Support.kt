package com.gg.spora.settings.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gg.spora.R
import com.gg.spora.core.ui.components.SporaPrimaryButton
import com.gg.spora.core.ui.components.TopBarWithTitleExitAndIcon


@Composable
fun SupportScreen(
    onBackClick: () -> Unit,
    onSendClick: () -> Unit
) {
    var description by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.settings_fondo),
            contentDescription = "Settings Background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            TopBarWithTitleExitAndIcon(
                title = "Soporte",
                onBackClick = onBackClick,
                showIcon = false,
                showSettingsIcon = false
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Enviar una solicitud",
                fontSize = 24.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .wrapContentWidth(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(200.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(colorResource(id = R.color.surface))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(colorResource(id = R.color.primary))
                            .padding(16.dp)
                    ) {
                        Text(
                            text = "Asunto",
                            fontSize = 22.sp,
                            color = Color.Black
                        )
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState())
                            .padding(16.dp)
                    ) {
                        ClickableRow("Opción 1") { /* Acción al hacer clic */ }
                        Divider(color = Color.Black, thickness = 1.dp)
                        ClickableRow("Opción 2") { /* Acción al hacer clic */ }
                        Divider(color = Color.Black, thickness = 1.dp)
                        ClickableRow("Opción 3") { /* Acción al hacer clic */ }
                        Divider(color = Color.Black, thickness = 1.dp)
                        ClickableRow("Opción 4") { /* Acción al hacer clic */ }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(colorResource(id = R.color.surface))
                    .padding(16.dp)
            ) {
                BasicTextField(
                    value = description,
                    onValueChange = { description = it },
                    textStyle = TextStyle(fontSize = 18.sp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp),
                    decorationBox = { innerTextField ->
                        if (description.isEmpty()) {
                            Text(
                                text = "Descripción",
                                style = TextStyle(color = Color.Gray, fontSize = 20.sp)
                            )
                        }
                        innerTextField()
                    }
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            SporaPrimaryButton(
                text = "Enviar",
                onClick = onSendClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
    }
}


@Composable
fun ClickableRow(text: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            fontSize = 18.sp,
            modifier = Modifier.weight(1f),
            color = Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SupportScreenPreview() {
    SupportScreen(
        onBackClick = {},
        onSendClick = {},
    )
}
