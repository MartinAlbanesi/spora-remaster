package com.gg.spora.core.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gg.spora.R

@Composable
fun OptionItemButton(
    modifier: Modifier = Modifier,
    textItem: String,
    isCorrect: Boolean?,
    enabled: Boolean,
    hasIcon: Boolean = true,
    onAnswerSelected: () -> Unit,
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

    Button(
        onClick = onAnswerSelected,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            contentColor = textColor,
            containerColor = backgroundColor,
            disabledContentColor = textColor,
            disabledContainerColor = backgroundColor,
        ),
        modifier = modifier
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = textItem,
                color = textColor,
            )
            if(hasIcon){
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    tint = textColor,
                    modifier = Modifier.size(40.dp),
                    contentDescription = Icons.Default.CheckCircle.name,
                )
            }

        }
    }
}

@Preview
@Composable
private fun OptionItemButtonPreview() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        OptionItemButton(
            modifier = Modifier.fillMaxWidth(),
            textItem = "Option 1",
            isCorrect = true,
            enabled = true
        ) {}
        OptionItemButton(
            modifier = Modifier.fillMaxWidth(),
            textItem = "Option 2",
            isCorrect = false,
            enabled = true
        ) {}
        OptionItemButton(
            modifier = Modifier.fillMaxWidth(),
            textItem = "Option 3",
            isCorrect = null,
            enabled = true
        ) {}
    }
}
