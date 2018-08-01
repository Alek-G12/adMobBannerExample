package com.example.g12.adsexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class RewardedVideoActivity extends AppCompatActivity implements RewardedVideoAdListener {
    
    private RewardedVideoAd rewardedVideoAd;
    private Button showRewardedVideoButton;
    
    @Override
    protected void onDestroy() {
        rewardedVideoAd.destroy(this);
        super.onDestroy();
    }
    
    @Override
    protected void onPause() {
        rewardedVideoAd.pause(this);
        super.onPause();
    }
    
    @Override
    protected void onResume() {
        rewardedVideoAd.resume(this);
        super.onResume();
    }
    
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewarded_video);
        
        rewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        rewardedVideoAd.setRewardedVideoAdListener(this);
        
        showRewardedVideoButton = findViewById(R.id.showRewardedVideoButton);
        showRewardedVideoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rewardedVideoAd.isLoaded()) {
                    rewardedVideoAd.show();
                } else{
                    Toast.makeText(RewardedVideoActivity.this, "Ad not Loaded yet!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        loadRewardedVideoAd();
    }
    
    private void loadRewardedVideoAd() {
        rewardedVideoAd.loadAd("ca-app-pub-3940256099942544/5224354917", new AdRequest.Builder().build());
    }
    
    @Override
    public void onRewardedVideoAdLoaded() {
    
    }
    
    @Override
    public void onRewardedVideoAdOpened() {
    
    }
    
    @Override
    public void onRewardedVideoStarted() {
    
    }
    
    @Override
    public void onRewardedVideoAdClosed() {
        loadRewardedVideoAd();
    }
    
    @Override
    public void onRewarded(RewardItem rewardItem) {
        Toast.makeText(this, "onRewarded currency: " + rewardItem.getType() + " amoun: " + rewardItem.getAmount(), Toast.LENGTH_SHORT).show();
        //Reward the user
    }
    
    @Override
    public void onRewardedVideoAdLeftApplication() {
    
    }
    
    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {
    
    }
    
    @Override
    public void onRewardedVideoCompleted() {
    
    }
}
