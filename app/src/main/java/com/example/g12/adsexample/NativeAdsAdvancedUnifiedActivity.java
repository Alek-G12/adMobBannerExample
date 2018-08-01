package com.example.g12.adsexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;

public class NativeAdsAdvancedUnifiedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_native_ads_advanced_unified);

        final AdLoader adLoader = new AdLoader.Builder(this, "ca-app-pub-3940256099942544/2247696110")
                .forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
                    @Override
                    public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
                        //show the ad
                        FrameLayout frameLayout = findViewById(R.id.adFrameLayout);
                        UnifiedNativeAdView adView = (UnifiedNativeAdView) getLayoutInflater().inflate(R.layout.unified_ad, null);
                        TextView headline = adView.findViewById(R.id.adHeadline);
                        headline.setText(unifiedNativeAd.getHeadline());

                        MediaView mediaView = adView.findViewById(R.id.ad_media);
                        adView.setMediaView(mediaView);

                        TextView description = adView.findViewById(R.id.adDescription);
                        description.setText(unifiedNativeAd.getBody());
                        adView.setNativeAd(unifiedNativeAd);
                        frameLayout.addView(adView);

                    }
                })
                .withAdListener(new AdListener(){
                    @Override
                    public void onAdFailedToLoad(int i) {
                        //Handle failure
                        super.onAdFailedToLoad(i);
                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder().build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());
    }
}
