package com.example.youtubeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.youtubeapp.fragment.FragmentPlayVideo;
import com.example.youtubeapp.interfacee.InterfaceDefaultValue;

public class ActivityPlayV extends AppCompatActivity implements InterfaceDefaultValue {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_v);
        Intent intentGetID = getIntent();
        String id = intentGetID.getStringExtra(ID);
        Toast.makeText(this, id+"", Toast.LENGTH_SHORT).show();
        FragmentPlayVideo fragmentPlayVideo = new FragmentPlayVideo();
        Bundle bundle = new Bundle();
        bundle.putString(ID_VIDEO, id);
        fragmentPlayVideo.setArguments(bundle);

    }
}