package com.gg.spora.miniGames.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import com.gg.spora.R
import com.gg.spora.ui.theme.SporaTheme

@Composable
fun RelationItemSelected(
    modifier: Modifier = Modifier,
    answer: String,
    isCorrect: Boolean? = null,
    isSelected: Boolean,
    isEnabled: Boolean,
    onSelected: () -> Unit
) {

    val textColor by animateColorAsState(
        when (isCorrect) {
            true -> Color.White
            false -> Color.White
            null -> colorResource(R.color.primary_10)
        }, label = "textColor"
    )

    val backgroundColor by animateColorAsState(
        when (isCorrect) {
            true -> colorResource(R.color.secondary)
            false -> colorResource(R.color.error)
            null -> colorResource(R.color.cream)
        },
        label = "backgroundColor"
    )

    FilterChip(
        onClick = onSelected,
        enabled = isEnabled,
        label = {
            Text(
                text = answer,
            )
        },
        colors = FilterChipDefaults.filterChipColors(
            containerColor = backgroundColor,
            labelColor = textColor,
            selectedLabelColor = Color.Black,
            selectedContainerColor = colorResource(R.color.primary),
            selectedLeadingIconColor = Color.Black,
            disabledContainerColor = backgroundColor,
            disabledLabelColor = textColor
        ),
        selected = isSelected,
        shape = MaterialTheme.shapes.large,
        leadingIcon = {
            if (isSelected) {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Done icon",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        },
        modifier = modifier
    )
}

//@PreviewLightDark
@Preview
//@PreviewFontScale
//@PreviewScreenSizes
@Composable
private fun RelationItemSelectedPreview() {
    SporaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                RelationItemSelected(
                    modifier = Modifier
                        .width(180.dp)
                        .height(60.dp),
                    answer = "Enable",
                    isCorrect = null,
                    isSelected = false,
                    isEnabled = true,
                    onSelected = { }
                )

                RelationItemSelected(
                    modifier = Modifier
                        .width(180.dp)
                        .height(60.dp),
                    answer = "Disable",
                    isCorrect = null,
                    isSelected = false,
                    isEnabled = false,
                    onSelected = { }
                )
            }
        }
    }
}