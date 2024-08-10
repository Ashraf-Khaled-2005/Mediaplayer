package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
ImageButton imagebtn;
MediaPlayer mediaPlayer;
private boolean ispaused=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imagebtn=findViewById(R.id.imageButton);
        mediaPlayer=MediaPlayer.create(this,R.raw.sound);


        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                imagebtn.setImageResource(R.drawable.play);
                ispaused = false;
                Toast.makeText(MainActivity.this, "Playback finished", Toast.LENGTH_SHORT).show();
                mediaPlayer.seekTo(0);
            }
        });
        imagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(ispaused){

                   imagebtn.setImageResource(R.drawable.play);
                   Toast.makeText(MainActivity.this, "playing", Toast.LENGTH_SHORT).show();
                   mediaPlayer.pause();
                   ispaused=!ispaused;
               }else{

                   imagebtn.setImageResource(R.drawable.pause);
                   Toast.makeText(MainActivity.this, "pauses", Toast.LENGTH_SHORT).show();
                        mediaPlayer.start();
                   ispaused=!ispaused;


               }
            }
        });
    }
}