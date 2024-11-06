package com.gg.spora.settings.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gg.spora.R
import com.gg.spora.core.ui.components.TopBarWithTitleExitAndIcon
import com.gg.spora.ui.theme.SporaTheme


@Composable
fun AboutUs(
    onDismiss: () -> Unit,
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {},
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp),
        text = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = colorResource(id = R.color.surface))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = colorResource(id = R.color.primary))
                        .padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(onClick = onDismiss) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                    Text(
                        text = "Nosotros",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.width(48.dp))
                }
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp)
                ) {
                    InfoRow(
                        imageRes = R.drawable.user_image,
                        name = "Gastón Toledo",
                        email = "gaston.toledo@example.com",
                        socialMedia = "@gaston"
                    )
                    Divider(color = Color.Black, thickness = 1.dp)
                    InfoRow(
                        imageRes = R.drawable.user_image,
                        name = "Gastón Toledo",
                        email = "gaston.toledo@example.com",
                        socialMedia = "@gaston"
                    )
                    Divider(color = Color.Black, thickness = 1.dp)
                    InfoRow(
                        imageRes = R.drawable.user_image,
                        name = "Gastón Toledo",
                        email = "gaston.toledo@example.com",
                        socialMedia = "@gaston"
                    )
                    Divider(color = Color.Black, thickness = 1.dp)
                    InfoRow(
                        imageRes = R.drawable.user_image,
                        name = "Gastón Toledo",
                        email = "gaston.toledo@example.com",
                        socialMedia = "@gaston"
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(30.dp)
                        .background(color = colorResource(id = R.color.primary)),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {

                }
            }
        }
    )
}

@Composable
fun InfoRow(
    imageRes: Int,
    name: String,
    email: String,
    socialMedia: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier.size(60.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(text = name, fontWeight = FontWeight.Bold)
            Text(text = email, style = MaterialTheme.typography.titleMedium)
            Text(text = socialMedia, style = MaterialTheme.typography.titleMedium)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AboutUsPreview() {
    SporaTheme {
        AboutUs(onDismiss = {})
    }
}