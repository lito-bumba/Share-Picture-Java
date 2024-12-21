/*
 ******** Guidelines ********

 Click: Run > Build & Run
 Refer to README.md for additional information
 */
package com.hackerrank.android;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.hackerrank.android.databinding.ActivityMainBinding;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        Objects.requireNonNull(getSupportActionBar()).setHomeAsUpIndicator(R.drawable.ic_logo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding.btnShare.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareImage();
            }
        }));

    }

    public void updateButtonText() {
        //add code there
    }

    public void updateImage() {
        //add code there
    }

    public void shareImage() {
        //add code there
    }

    public Intent createShareIntent() {
        //add code there

        return new Intent();
    }

    public Intent createChooserIntent() {
        //add code there

        return new Intent();
    }

    public String getShareText() {
        //add code there

        return "";
    }

    public Uri getShareImageUri() {
        //add code there

        return Uri.EMPTY;
    }


}

