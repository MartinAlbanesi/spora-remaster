package com.gg.spora.core.ui.components

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun OptionItemButton(
    modifier: Modifier = Modifier,
    textItem: String,
    isCorrect: Boolean?,
    enabled: Boolean,
    onAnswerSelected: () -> Unit,
) {

    val textColor = when(isCorrect){
        true -> Color.White
        false -> Color.White
        null -> Color(0xff442801)
    }

    val backgroundColor = when(isCorrect){
        true -> Color(0xff538c21)
        false -> Color(0xffb3261e)
        null -> Color(0xFFffeacc)
    }
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
            Icon(
                imageVector = Icons.Default.CheckCircle,
                tint = textColor,
                modifier = Modifier.size(40.dp),
                contentDescription = Icons.Default.CheckCircle.name,
            )

        }
    }
//    Row(
//        horizontalArrangement = Arrangement.SpaceBetween,
//        verticalAlignment = Alignment.CenterVertically,
//        modifier = modifier
//            .background(backgroundColor)
//            .padding(horizontal = 16.dp)
//    ) {
//        Text(
//            text = textItem,
//            color = textColor,
//        )
//        Icon(
//            imageVector = Icons.Default.CheckCircle,
//            tint = textColor,
//            modifier = Modifier.size(40.dp),
//            contentDescription = Icons.Default.CheckCircle.name,
//        )
//
//    }
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
        ){}
        OptionItemButton(
            modifier = Modifier.fillMaxWidth(),
            textItem = "Option 2",
            isCorrect = false,
            enabled = true
        ){}
        OptionItemButton(
            modifier = Modifier.fillMaxWidth(),
            textItem = "Option 3",
            isCorrect = null,
            enabled = true
        ){}
    }
}