package com.gg.spora.core.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.viewinterop.AndroidView
import com.gg.spora.ui.theme.SporaTheme
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView

@Composable
fun BannerAdd(
    modifier: Modifier = Modifier,
    bannerId: String
) {
    AndroidView(
        modifier = modifier,
        factory = { context ->
            val adView = AdView(context)
            adView.setAdSize(AdSize.BANNER)
            adView.apply {
                adUnitId = bannerId
                loadAd(AdRequest.Builder().build())
            }
        },
    )
}