package com.example.frenchteacherapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button btnGreen,btnYellow,btnRed,btnPurple,btnBlack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        btnBlack = findViewById(R.id.btn_black);
        btnGreen = findViewById(R.id.btn_green);
        btnPurple = findViewById(R.id.btn_purple);
        btnYellow = findViewById(R.id.btn_yellow);
        btnRed = findViewById(R.id.btn_red);


        btnRed.setOnClickListener(this);
        btnGreen.setOnClickListener(this);
        btnPurple.setOnClickListener(this);
        btnBlack.setOnClickListener(this);
        btnYellow.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        int clickedBtnId = v.getId();

        if (clickedBtnId == R.id.btn_red){
         playSound(R.raw.red);
        } else if(clickedBtnId == R.id.btn_black){
            playSound(R.raw.black);
        }else if(clickedBtnId == R.id.btn_green){
            playSound(R.raw.green);
        } else if(clickedBtnId == R.id.btn_purple){
            playSound(R.raw.purple);
        }else {
            playSound(R.raw.yellow);
        }

    }

    public void playSound(int id){
        MediaPlayer mediaPlayer = MediaPlayer.create(this,id);
        mediaPlayer.start();
    }
}