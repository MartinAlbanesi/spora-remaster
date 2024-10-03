package com.gg.spora.challenge.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gg.spora.R
import com.gg.spora.ui.theme.SporaTheme
import com.gg.spora.ui.theme.primaryContainerLight

/**
 * Composable element in the Challenge items
 */
@Composable
fun ButtonObjectScannerChallenge(
    text : String,
    modifier : Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(primaryContainerLight)
            .width(150.dp)
            .padding(horizontal = 8.dp)
    ) {
            Image(
                painter = painterResource(R.drawable.clock_icon),
                contentDescription = null,
                modifier = Modifier.size(15.dp)
            )

        Column(
            modifier = Modifier.padding(8.dp, 0.dp)
        ){
            Text(
                text = text,
                fontSize = 9.sp,
                modifier = Modifier.width(90.dp)
            )
        }
        Image(
            painter = painterResource(R.drawable.camera_icon),
            contentDescription = null,
            modifier = Modifier.size(15.dp)
        )

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
                text = "Botella de plastico"
            )
        }
    }
}