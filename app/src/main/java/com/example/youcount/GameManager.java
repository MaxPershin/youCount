package com.example.youcount;

import android.os.SystemClock;
import android.view.View;
import android.widget.TextView;

public class GameManager {

    CountingTaskEngine taskEngine;
    Integer timer;
    GameField gameField;
    Boolean inGame;




    public GameManager(GameField sentGameField) {

        gameField = sentGameField;
        timer = Integer.parseInt(gameField.timerValue.getText().toString());
        inGame = false;
        taskEngine = new CountingTaskEngine(0);

    }

    public void startClock(){

        if (inGame) {return;}

        inGame = true;

        Thread clockThread = new Thread(new Runnable(){

            public void run(){
                while(timer > 0){
                    gameField.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            gameField.timerValue.setText(timer.toString());
                        }
                    });

                    timer -= 1;
                    SystemClock.sleep(1000);
                }
            }
        });

        clockThread.start();


    }


    public void getFirstTask(){
        taskEngine.getTask();
        gameField.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                gameField.taskValue.setText(taskEngine.task);
            }
        });

    }

    public void start(){

        startClock();
        getFirstTask();

    }

    public void answerInput(String playerAnswer){

        if(taskEngine.compareTaskToAnswer(playerAnswer)){

            taskEngine.getTask();
            gameField.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    gameField.taskValue.setText(taskEngine.task);
                    gameField.answerValue.setText("");
                }
            });

        };

    }



    public void startGame(){



    }



}
