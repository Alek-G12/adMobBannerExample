package com.example.g12.adsexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    private Button bannerButton;
    private Button intersitialButton;
    private Button unifiedNativeButton;
    private Button rewardedVideoButton;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bannerButton = findViewById(R.id.btnBanner);
        bannerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BannerAdActivity.class);
                startActivity(intent);
            }
        });

        intersitialButton = findViewById(R.id.btnIntersitial);
        intersitialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, IntersitialAdActivity.class);
                startActivity(intent);
            }
        });

        unifiedNativeButton = findViewById(R.id.unifiedNativeButton);
        unifiedNativeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NativeAdsAdvancedUnifiedActivity.class);
                startActivity(intent);
            }
        });
        
        rewardedVideoButton = findViewById(R.id.rewardedVideoButton);
        rewardedVideoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RewardedVideoActivity.class);
                startActivity(intent);
            }
        });

        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");
        
    }
}
