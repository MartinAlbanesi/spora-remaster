package com.gg.spora.core.ads

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.gg.spora.BuildConfig
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView

@Composable
fun BannerAd(
    modifier: Modifier = Modifier,
    bannerId: String = BuildConfig.BANNER_AD
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