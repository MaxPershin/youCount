package com.example.youcount;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GameField extends AppCompatActivity {

    TextView levelValue, scoreValue, timerValue, taskValue, answerValue;
    Button key1, key2, key3, key4, key5, key6, key7, key8, key9, key0, keyCLS, keyMinus, keyAction;
    View.OnClickListener onClickListener;


    private void initializeGUI(){

        onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b = (Button) view;
                userInputHandler(b.getText().toString());

            }
        };

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
        keyAction = findViewById(R.id.keyAction);

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
        keyAction.setOnClickListener(onClickListener);

    }

    private void userInputHandler(String input){

        String answer = answerValue.getText().toString();

        if (input.equals("CLS")){
            answerValue.setText("");
        } else if (input.equals("-")){

            if(answerValue.getText().toString().length() > 0){
            if(answerValue.getText().toString().substring(0, 1).equals("-")){
                answerValue.setText(answerValue.getText().toString().substring(1));
            } else {
                answerValue.setText("-" + answerValue.getText().toString());
            }}
        } else {
        answerValue.setText(answerValue.getText() + input);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_field);

        initializeGUI();

    }

}