package com.example.youcount;

import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

public class GameManager {

    CountingTaskEngine taskEngine;
    Integer timer;
    GameField gameField;
    Boolean inGame, clock;
    Player player;
    Thread clockThread;




    public GameManager(GameField sentGameField) {

        gameField = sentGameField;
        timer = Integer.parseInt(gameField.timerValue.getText().toString());
        inGame = false;
        clock = false;
        taskEngine = new CountingTaskEngine(0);

    }

    public void endgame(){

        clockThread.interrupt();


        Intent intent = new Intent(gameField, GameOverScreen.class);
        gameField.startActivity(intent);

    }



    public void timerIsOutPunish(){

        System.out.println("PUNISHED ON CLOCK!!!!!!!!!");

        player.health -= 25;
        gameField.healthBar.setProgress(player.health, true);

        if (player.health<=0) {
            endgame();
            return;
        }

        timer = 25;

        clockThread.interrupt();
        startClock();

    }

    public void wrongAnswerPunish(){

        System.out.println("PUNISHED ON WRONG ASWSER!!!!!!!!!1");

        player.health -= 5;
        gameField.healthBar.setProgress(player.health, true);

        if (player.health<=0) {
            endgame();
        }
    }

    public void startClock(){


        clockThread = new Thread(new Runnable(){


            public void run(){

                while(timer > 0){

                    System.out.println("CLOCK IS ............ TICKING"+timer);

                    gameField.runOnUiThread(new Runnable() {
                        @Override
                        public void run() { gameField.timerValue.setText(timer.toString());}
                    });

                    timer -= 1;
                    SystemClock.sleep(1000);
                }

                timerIsOutPunish();

            }
        });


        System.out.println("TIMER STARTEEEEEEEEEEEEEEEEEEED!!!!");
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

        player = new Player();
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

        } else {

            wrongAnswerPunish();

        }

    }



    public void startGame(){

    }



}
