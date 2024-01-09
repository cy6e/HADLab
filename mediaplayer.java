<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:orientation="vertical"
    android:background="#7712"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <TextView
        android:id="@+id/textView"
        android:layout_width="match_parent"
        android:layout_marginTop="100dp"
        android:textAlignment="center"
        android:layout_marginBottom="40dp"
        android:textSize="40sp"
        android:layout_height="wrap_content"
        android:text="@string/app_name"/>

    <Button
        android:id="@+id/play"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginLeft="70dp"
        android:layout_marginTop="30dp"
        android:layout_marginRight="70dp"
        android:onClick="play"
        android:padding="10dp"
        android:text="Play"
        android:textAlignment="center" />

    <Button
        android:id="@+id/pause"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginLeft="70dp"
        android:layout_marginTop="30dp"
        android:layout_marginRight="70dp"
        android:onClick="pause"
        android:padding="10dp"
        android:text="Pause"
        android:textAlignment="center" />



    <Button
        android:id="@+id/fwd"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginLeft="70dp"
        android:layout_marginTop="30dp"
        android:layout_marginRight="70dp"
        android:onClick="forward"
        android:padding="10dp"
        android:text="Forward"
        android:textAlignment="center" />

    <Button
        android:id="@+id/rewind"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginLeft="70dp"
        android:layout_marginTop="30dp"
        android:layout_marginRight="70dp"
        android:onClick="rewind"
        android:padding="10dp"
        android:text="Rewind"
        android:textAlignment="center" />

    <Button
        android:id="@+id/restart"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginLeft="70dp"
        android:layout_marginTop="30dp"
        android:layout_marginRight="70dp"
        android:onClick="restart"
        android:padding="10dp"
        android:text="Restart"
        android:textAlignment="center" />

</LinearLayout>





package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    MediaPlayer media;

    int starttime=0;
    int fwdrate=5000;
    int backwardrate=5000;

    public void play(View view){
        Toast.makeText(this, "Playing", Toast.LENGTH_SHORT).show();
        media.start();
    }
    public void pause(View view){
        Toast.makeText(this, "Pausing", Toast.LENGTH_SHORT).show();
        media.pause();
    }
    public void forward(View view){
        int dur=media.getDuration();
        int cur=media.getCurrentPosition();
        if(cur+fwdrate<=dur){
            media.seekTo(cur+fwdrate);
        }
        else{
            Toast.makeText(this, "Song is about to complete in 5 secs", Toast.LENGTH_SHORT).show();
        }
    }
    public void rewind(View view){
        int cur=media.getCurrentPosition();
        if(cur-backwardrate>=starttime){
            media.seekTo(cur-backwardrate);
        }
        else{
            Toast.makeText(this, "Wait for 5 secs", Toast.LENGTH_SHORT).show();
        }
    }
    public void restart(View view){
        if(media.isPlaying()){
            media.stop();
        }
        media.seekTo(starttime);
        media.start();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        media = MediaPlayer.create(this,R.raw.music1);
    }


}
