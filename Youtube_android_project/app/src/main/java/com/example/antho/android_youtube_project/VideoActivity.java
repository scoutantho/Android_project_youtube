package com.example.antho.android_youtube_project;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class VideoActivity extends AppCompatActivity {
    private static final String CELL = "CELL";

    public static void start(Context context, String contractName) {
        Intent intent = new Intent(context, VideoActivity.class);
        intent.putExtra(CELL, contractName);
        context.startActivity(intent);
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
    }

    //see video information, and a player ?

}
