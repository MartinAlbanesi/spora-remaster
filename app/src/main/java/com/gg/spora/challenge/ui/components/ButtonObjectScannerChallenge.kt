package com.gg.spora.challenge.ui.components

import android.provider.SyncStateContract.Columns
import android.service.autofill.OnClickAction
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.autoSaver
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gg.spora.R
import com.gg.spora.ui.theme.Primary
import com.gg.spora.ui.theme.SporaTheme
import com.gg.spora.ui.theme.SurfaceButton

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
            .background(SurfaceButton)
            .width(100.dp)
            .padding(horizontal = 5.dp)
    ) {
            Image(
                painter = painterResource(R.drawable.clock_icon),
                contentDescription = null,
                modifier = Modifier.size(15.dp)
            )

        Column(
            modifier = Modifier.padding(5.dp, 0.dp)
        ){
            Text(
                text = text,
                fontSize = 11.sp
            )
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
                text = "hola"
            )
        }
    }
}