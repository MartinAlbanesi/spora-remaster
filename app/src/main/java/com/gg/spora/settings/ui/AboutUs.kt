package com.gg.spora.settings.ui

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.gg.spora.R
import com.gg.spora.core.ui.components.TopBarWithTitleExitAndIcon
import com.gg.spora.ui.theme.SporaTheme


@Composable
fun InfoRow(
    imageRes: Int,
    name: String,
    email: String,
    linkedinUrl: String,
    githubUrl: String,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

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
            Text(text = email, style = MaterialTheme.typography.labelLarge)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Redes:", fontWeight = FontWeight.Bold)
            Row {
                ClickableText(
                    text = AnnotatedString("Linkedin"),
                    onClick = {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(linkedinUrl))
                        context.startActivity(intent)
                    },
                    style = MaterialTheme.typography.bodySmall.copy(color = colorResource(id = R.color.primary))
                )
                Spacer(modifier = Modifier.width(8.dp))
                ClickableText(
                    text = AnnotatedString("Github"),
                    onClick = {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(githubUrl))
                        context.startActivity(intent)
                    },
                    style = MaterialTheme.typography.bodySmall.copy(color = colorResource(id = R.color.primary))
                )
            }
        }
    }
}

@Composable
fun AboutUs(
    onDismiss: () -> Unit,
) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        )
    ) {
        Surface(
            shape = MaterialTheme.shapes.large,
            modifier = Modifier
                .fillMaxWidth()
                .height(450.dp)
                .padding(16.dp)
        ) {
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
                        .verticalScroll(rememberScrollState()) // Enable scrolling
                        .padding(horizontal = 16.dp)
                ) {
                    InfoRow(
                        imageRes = R.drawable.user_image,
                        name = "Martín Albanesi",
                        email = "martinalbanesi89@gmail.com",
                        linkedinUrl = "https://www.linkedin.com/in/martin-albanesi/",
                        githubUrl = "https://github.com/MartinAlbanesi"
                    )
                    Divider(color = Color.Black, thickness = 1.dp)
                    InfoRow(
                        imageRes = R.drawable.user_image,
                        name = "Gabriel Gomez",
                        email = "gabrielgomezgg1997@gmail.com",
                        linkedinUrl = "https://www.linkedin.com/in/gabrielgomezgg/",
                        githubUrl = "https://github.com/GabrielGomezGG"
                    )
                    Divider(color = Color.Black, thickness = 1.dp)
                    InfoRow(
                        imageRes = R.drawable.user_image,
                        name = "Elías Rueda Arévalo",
                        email = "eliasruedac@gmail.com",
                        linkedinUrl = "https://www.linkedin.com/in/gaston-toledo",
                        githubUrl = "https://github.com/eliaasgabriel"
                    )
                    Divider(color = Color.Black, thickness = 1.dp)
                    InfoRow(
                        imageRes = R.drawable.user_image,
                        name = "Gastón Toledo",
                        email = "mgaston648@gmail.com",
                        linkedinUrl = "https://www.linkedin.com/in/gastón-toledo-b921b6171/",
                        githubUrl = "https://github.com/gasToledo"
                    )
                    Divider(color = Color.Black, thickness = 1.dp)
                    InfoRow(
                        imageRes = R.drawable.user_image,
                        name = "Damian Llopar",
                        email = "damianllopar@gmail.com ",
                        linkedinUrl = "https://www.linkedin.com/in/damian-llopar",
                        githubUrl = "https://github.com/dllopar"
                    )
                    Divider(color = Color.Black, thickness = 1.dp)
                    InfoRow(
                        imageRes = R.drawable.user_image,
                        name = "Franco Mazaffra",
                        email = "francomazaffra98@gmail.com ",
                        linkedinUrl = "https://www.linkedin.com/in/francomazaffra/",
                        githubUrl = "https://github.com/FrancoMazaffra"
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
    }
}

@Preview(showBackground = true)
@Composable
fun AboutUsPreview() {
    SporaTheme {
        AboutUs(onDismiss = {})
    }
}