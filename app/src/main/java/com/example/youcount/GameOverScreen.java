package com.example.youcount;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameOverScreen extends AppCompatActivity {

    Button exitButton;

    public void setListeners(){

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(GameOverScreen.this, MainActivity.class);
                startActivity(intent);

            }
        });

    }

    public void initGUI(){

        exitButton = findViewById(R.id.exitButton);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over_screen);


        initGUI();
        setListeners();

    }
}