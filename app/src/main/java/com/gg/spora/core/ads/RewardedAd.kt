package com.gg.spora.core.ads

import android.content.Context
import com.gg.spora.BuildConfig
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback

var mRewardedAd: RewardedAd? = null

fun loadRewarded(context: Context) {
    RewardedAd.load(
        context,
        BuildConfig.REWARDED_AD,
        AdRequest.Builder().build(),
        object : RewardedAdLoadCallback() {
            override fun onAdFailedToLoad(adError: LoadAdError) {
                mRewardedAd = null
            }

            override fun onAdLoaded(rewardedAd: RewardedAd) {
                mRewardedAd = rewardedAd
            }
        }
    )
}

fun showRewardedAd(
    context: Context,
    onUserEarnedReward: (Byte) -> Unit
) {
    val activity = context.findActivity()

    if (mRewardedAd != null && activity != null) {
        mRewardedAd?.fullScreenContentCallback = object : FullScreenContentCallback() {
            override fun onAdFailedToShowFullScreenContent(e: com.google.android.gms.ads.AdError) {
                mRewardedAd = null
            }

            override fun onAdDismissedFullScreenContent() {
                mRewardedAd = null

                loadRewarded(context)
            }
        }
        mRewardedAd?.show(activity) {
            onUserEarnedReward(it.amount.toByte())
        }
    }
}

fun removeRewarded() {
    mRewardedAd?.fullScreenContentCallback = null
    mRewardedAd = null
}