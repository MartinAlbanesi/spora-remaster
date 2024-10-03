package com.gg.spora.challenge.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gg.spora.R
import com.gg.spora.ui.theme.SporaTheme

/**
 * Composable element in the Challenge items
 */
@Composable
fun ButtonObjectScannerChallenge(
    textObject : String,
    modifier : Modifier,
    isValidate : Boolean?
) {

    val backgroundColor by remember {
        mutableStateOf(
            when (isValidate) {
                true -> Color(0xff538c21)
                false -> Color(0xFFffeacc)
                else -> Color(0xFFffeacc)
            }
        )
    }

    val textColor by remember {
        mutableStateOf(
            when (isValidate) {
                true -> Color.White
                false -> Color(0xff442801)
                else -> Color(0xff442801)
            }
        )
    }

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .background(backgroundColor)
            .padding(horizontal = 16.dp)
    ) {
        if(isValidate == true){
            Icon(
                imageVector = Icons.Default.CheckCircle,
                tint = textColor,
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )
        }
        else{
            Image(
                painter = painterResource(R.drawable.clock_icon),
                contentDescription = null,
                modifier = Modifier.size(35.dp)
            )
        }

        Column(
            modifier = Modifier.padding(20.dp, 0.dp)
        ){
            Text(
                text = textObject,
                color = textColor
            )
        }
        Column(
            modifier = Modifier.size(35.dp)
        )
        {

            if(isValidate != true){
                Image(
                    painter = painterResource(R.drawable.camera_icon),
                    contentDescription = null,
                    modifier = Modifier.size(35.dp)
                )
            }
        }

    }
}

@Preview
@Composable
fun IconWithTextPreview() {
    SporaTheme {
        Surface(
            color = Color.Transparent
        ) {
            ButtonObjectScannerChallenge(
                modifier = Modifier,
                textObject = "Botella de plastico",
                isValidate = false
            )
        }
    }
}