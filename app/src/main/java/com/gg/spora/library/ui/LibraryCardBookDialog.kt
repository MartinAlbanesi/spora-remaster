package com.gg.spora.library.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.gg.spora.core.ui.components.TopBarWithLeadingAndTrailingIcon
import com.gg.spora.core.utils.enums.StageType
import com.gg.spora.library.data.local.entity.InfoCardEntity
import com.gg.spora.library.data.repository.FakeRepositoryInfoCard
import com.gg.spora.library.domain.mappers.toInfoCard
import com.gg.spora.ui.theme.SporaTheme

@Composable
fun LibraryCardBookDialog(
    modifier: Modifier = Modifier,
    showDialog: Boolean,
    cardList: List<InfoCardEntity>,
    onDismissRequest: () -> Unit
) {
    if(showDialog){
        Dialog(
            onDismissRequest = onDismissRequest,
            properties = DialogProperties(
                usePlatformDefaultWidth = false,
            )
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
            ){
                TopBarWithLeadingAndTrailingIcon(
                    leadingIcon = Icons.Default.Close,
                    title = cardList.first().category.label,
                    onClickLeadingIcon = onDismissRequest,
                    modifier = Modifier.align(Alignment.TopCenter)
                )
                LibraryCarouselInfoCard(
                    modifier = modifier,
                    cardList = cardList.map { it.toInfoCard() }
                )
            }
        }
    }

}

//@PreviewLightDark
@Preview
//@PreviewFontScale
//@PreviewScreenSizes
@Composable
private fun LibraryCardBookDialogPreview() {
    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            LibraryCardBookDialog(
                modifier = Modifier,
                showDialog = true,
                cardList = FakeRepositoryInfoCard().getAllInfoCards(),
                onDismissRequest = {}
            )
        }
    }
}