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

    @Override
    protected void onResume() {
        super.onResume();
        updateButtonText();
        updateImage();
    }

    public void updateButtonText() {
        binding.btnShare.setText(R.string.send_btn_text);
    }

    public void updateImage() {
        binding.imgScreen.setImageResource(R.drawable.share_image);
    }

    public void shareImage() {
        startActivity(createShareIntent());
    }

    public Intent createShareIntent() {
        Intent shareIntent = createChooserIntent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.setType("image/*");
        shareIntent.putExtra(Intent.EXTRA_TEXT, getShareText());
        shareIntent.putExtra(Intent.EXTRA_STREAM, getShareImageUri());
        return shareIntent;
    }

    public Intent createChooserIntent() {
        Intent chooserIntent = new Intent();
        chooserIntent.putExtra(Intent.EXTRA_TITLE, getResources().getString(R.string.title_chooser_text));
        chooserIntent.setAction(Intent.ACTION_CHOOSER);
        return chooserIntent;
    }

    public String getShareText() {
        String etInput = binding.etInput.getText().toString();

        if (etInput.isEmpty()) {
            return getString(R.string.share_empty_text);
        }

        return etInput;
    }

    public Uri getShareImageUri() {
        String srcImage = "android.resource://com.hackerrank.starter/drawable/share_image";
        return Uri.parse(srcImage);
    }
}

