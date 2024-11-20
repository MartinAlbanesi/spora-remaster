package com.gg.spora.library.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.gg.spora.core.ui.components.TopAppBarOnlyBackArrow
import com.gg.spora.core.utils.enums.StageType
import com.gg.spora.library.data.repository.FakeRepositoryInfoCard
import com.gg.spora.library.domain.mappers.toInfoCard
import com.gg.spora.library.domain.model.InfoCard

@Composable
fun CardbookDialog(
    modifier: Modifier,
    cardList: List<InfoCard>,
    category: StageType,
    onDismiss: () -> Unit = {}
) {

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        )
    ) {
        TopAppBarOnlyBackArrow(
            modifier = Modifier,
            onBackClick = onDismiss,
            title = category.label
        )

        CardBook(modifier, cardList)
    }
}


@Composable
private fun CardBook(modifier: Modifier, cardList: List<InfoCard>) {

    LibraryCarouselInfoCard(cardList = cardList)
}


@Composable
@Preview(showBackground = true)
fun PreviewCardBook() {
    CardbookDialog(
        modifier = Modifier,
        cardList = FakeRepositoryInfoCard().getAllInfoCards().map { it.toInfoCard() },
        category = StageType.FOREST,
    )
}