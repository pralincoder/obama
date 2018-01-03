package com.example.dell.obama.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.dell.obama.R;

public class MyBio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bio);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
     finish();
    }
}
