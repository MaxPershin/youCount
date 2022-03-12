package com.example.youcount;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class GameField extends AppCompatActivity {

    TextView levelValue, scoreValue, timerValue, taskValue, answerValue;
    Button key1, key2, key3, key4, key5, key6, key7, key8, key9, key0, keyCLS, keyMinus, keyStart, keySend;
    View.OnClickListener onClickListener, actionOnClickListener;
    ProgressBar healthBar;
    GameManager gameManager;



    private void initializeGUI(){

        actionOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button tempButton = (Button) view;
                actionButtonsHandler(tempButton.getText().toString());
            }
        };

        onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b = (Button) view;
                userInputHandler(b.getText().toString());

            }
        };

        healthBar = findViewById(R.id.healthBar);
        levelValue = findViewById(R.id.levelValue);
        scoreValue = findViewById(R.id.scoreValue);
        timerValue = findViewById(R.id.timerValue);
        taskValue = findViewById(R.id.taskWindow);
        answerValue = findViewById(R.id.answerValue);

        key1 = findViewById(R.id.key1);
        key2 = findViewById(R.id.key2);
        key3 = findViewById(R.id.key3);
        key4 = findViewById(R.id.key4);
        key5 = findViewById(R.id.key5);
        key6 = findViewById(R.id.key6);
        key7 = findViewById(R.id.key7);
        key8 = findViewById(R.id.key8);
        key9 = findViewById(R.id.key9);
        key0 = findViewById(R.id.key0);
        keyCLS = findViewById(R.id.keyCLS);
        keyMinus = findViewById(R.id.keyMinus);
        keyStart = findViewById(R.id.keyStart);
        keySend = findViewById(R.id.keySendAnswer);

        key0.setOnClickListener(onClickListener);
        key1.setOnClickListener(onClickListener);
        key2.setOnClickListener(onClickListener);
        key3.setOnClickListener(onClickListener);
        key4.setOnClickListener(onClickListener);
        key5.setOnClickListener(onClickListener);
        key6.setOnClickListener(onClickListener);
        key7.setOnClickListener(onClickListener);
        key8.setOnClickListener(onClickListener);
        key9.setOnClickListener(onClickListener);
        keyCLS.setOnClickListener(onClickListener);
        keyMinus.setOnClickListener(onClickListener);
        keyStart.setOnClickListener(actionOnClickListener);
        keySend.setOnClickListener(actionOnClickListener);

    }

    private void userInputHandler(String input){

        if (input.equals("CLS")) {answerValue.setText(""); return;}

        if (input.equals("-")){
            if(answerValue.getText().toString().length() > 0){
                if(answerValue.getText().toString().substring(0, 1).equals("-")){
                    answerValue.setText(answerValue.getText().toString().substring(1));
                } else {
                    answerValue.setText("-" + answerValue.getText().toString());
                }
                return;
            }}
        if(answerValue.getText().toString().length() > 6) {return;}

        answerValue.setText(answerValue.getText() + input);

    }

    private void actionButtonsHandler(String input) {

        //ObjectAnimator animation = ObjectAnimator.ofFloat(keyAction, "translationX", 1000f);
        //animation.setDuration(1000);
       // animation.start();

        if (input.equals("READY")){


            gameManager = new GameManager(this);
            gameManager.start();

        } else if (input.equals("SEND")){

            gameManager.answerInput(answerValue.getText().toString());

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_field);

        initializeGUI();


    }

}