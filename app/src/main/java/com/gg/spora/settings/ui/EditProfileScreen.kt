package com.gg.spora.settings.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.gg.spora.R
import com.gg.spora.core.ui.components.SporaPrimaryButton
import com.gg.spora.core.ui.components.TopAppBarOnlyBackArrow
import com.gg.spora.ui.theme.SporaTheme
import com.gg.spora.user.domain.models.User

@Composable
fun EditProfileScreen(
    currentUser: User?,
    selectedImage: String,
    username: String,
    userImages: List<String>,
    onBackClick: () -> Unit,
    showPopup: Boolean = false,
    onUpdatePopup: (Boolean) -> Unit,
    onUpdateUsername: (String) -> Unit,
    onUpdateUserProfile : (String, String) -> Unit,
    showSnackbar: Boolean = false,
    onUpdateShowSnackbar: (Boolean) -> Unit
) {


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
            modifier = Modifier
                .fillMaxSize()
        ) {
            TopAppBarOnlyBackArrow(
                title = "Editar Perfil",
                onBackClick = onBackClick
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Spacer(modifier = Modifier.weight(1f))

                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(selectedImage)
                            .placeholder(R.drawable.user_image)
                            .build(),
                        contentDescription = "User Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(200.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .clickable { onUpdatePopup(true) }
                    )
                }

                TextField(
                    value = username,
                    onValueChange = { onUpdateUsername(it) },
                    label = { Text("Usuario Nuevo") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                        .clip(RoundedCornerShape(16.dp))
                )

                /*
                TextField(
                    value = username,
                    onValueChange = { username = it },
                    label = { Text("Contraseña nueva") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                        .clip(RoundedCornerShape(16.dp))
                )

                TextField(
                    value = username,
                    onValueChange = { username = it },
                    label = { Text("Confirmar contraseña nueva") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                        .clip(RoundedCornerShape(16.dp))
                )*/

                Spacer(modifier = Modifier.weight(1f))

                SporaPrimaryButton(
                    text = "Actualizar datos",
                    onClick = { onUpdateUserProfile(selectedImage, username) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 24.dp)
                )
            }
        }

        if (showSnackbar) {
            Snackbar(
                action = {
                    TextButton(onClick = { onUpdateShowSnackbar(false)}) {
                        Text("Continuar")
                    }
                },
                modifier = Modifier.padding(8.dp)
            ) {
                Text("Datos actualizados")
            }
        }

        if (showPopup) {
            ImagePopup(
                availableImages = userImages,
                onImageSelected = { onUpdateUserProfile(it, username) },
                onDismiss = { onUpdatePopup(false) }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImagePopup(
    availableImages: List<String>,
    onImageSelected: (String) -> Unit,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false),
        content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .background(colorResource(id = R.color.surface))
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
                    .clip(RoundedCornerShape(16.dp))
            ) {
                Text("Selecciona una imagen", fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 16.dp))
                for (i in availableImages.indices step 3) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        for (j in 0 until 3) {
                            if (i + j < availableImages.size) {
                                val imageRes = availableImages[i + j]
                                Box(
                                    modifier = Modifier
                                        .size(100.dp)
                                        .background(Color.Gray)
                                        .clickable {
                                            onImageSelected(imageRes)
                                            onDismiss()
                                        }
                                ) {
                                    AsyncImage(
                                        model = ImageRequest.Builder(LocalContext.current)
                                            .data(imageRes)
                                            .placeholder(R.drawable.user_image)
                                            .build(),
                                        contentDescription = null,
                                        contentScale = ContentScale.Fit,
                                        modifier = Modifier
                                            .size(100.dp)
                                            .clip(RoundedCornerShape(8.dp))
                                    )
                                }
                            }
                        }
                    }
                }
                Button(
                    onClick = onDismiss,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text("Close")
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun EditProfileScreenPreview() {
    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            EditProfileScreen(
                onBackClick = {},
                currentUser = null,
                selectedImage = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/avatars%2FChampy_sonriente_idle.png?alt=media&token=40474e6d-7365-491c-b8ea-424bd73fdc6f",
                username = "Champy",
                userImages = listOf(),
                onUpdatePopup = {},
                onUpdateUsername = {},
                onUpdateUserProfile = { _, _ -> },
                showSnackbar = false,
                onUpdateShowSnackbar = {}
            )
        }
    }
}