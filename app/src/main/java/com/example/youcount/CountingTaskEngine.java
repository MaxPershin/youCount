package com.example.youcount;

import java.util.Random;

public class CountingTaskEngine {

    Integer level, taskAnswer, firstNumber, secondNumber;
    String[] operands = {"+", "-", "*"};
    String operand, task;

    public CountingTaskEngine(Integer level){
        this.level = level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getTask(){

        Random random = new Random();

        if(level == 0){

            firstNumber = random.nextInt(99 + 1 - (1)) + (1);
            secondNumber = random.nextInt(99 + 1 - (1)) + (1);
            operand = operands[random.nextInt(1+1 - 0 + 0)];

        } else if (level == 1){

            operand = operands[random.nextInt(2+1 - 0 + 0)];

            if (operand.equals("*")) {

                firstNumber = random.nextInt(10 + 1 - (1)) + (1);
                secondNumber = random.nextInt(99 + 1 - (1)) + (1);

            } else {

                firstNumber = random.nextInt(99 + 1 - (-99)) + (-99);
                secondNumber = random.nextInt(99 + 1 - (-99)) + (-99);
            }

        } else if (level == 2) {

            operand = operands[random.nextInt(2+1 - 0 + 0)];

            if (operand.equals("*")) {

                firstNumber = random.nextInt(99 + 1 - (-99)) + (-99);
                secondNumber = random.nextInt(99 + 1 - (-99)) + (-99);

            } else {

                firstNumber = random.nextInt(999 + 1 - (-999)) + (-999);
                secondNumber = random.nextInt(999 + 1 - (-999)) + (-999);
            }


        } else if (level == 3) {

            operand = "*";
            firstNumber = random.nextInt(99 + 1 - (-99)) + (-99);
            secondNumber = random.nextInt(99 + 1 - (-99)) + (-99);


        } else if (level == 4) {

            operand = "*";
            firstNumber = random.nextInt(999 + 1 - (-999)) + (-999);
            secondNumber = random.nextInt(999 + 1 - (-999)) + (-999);

        }

        switch (operand) {
            case ("+"):
                taskAnswer = firstNumber+secondNumber;
                task = ""+firstNumber+"+"+secondNumber;
                return task;
            case ("-"):
                taskAnswer = firstNumber-secondNumber;
                task = ""+firstNumber+"-"+secondNumber;
                return  task;
            case ("*"):
                taskAnswer = firstNumber*secondNumber;
                task = ""+firstNumber+"*"+secondNumber;
                return task;
            default:
                return "Error";
        }
    }

    public boolean checkAnswer(String userInput){

        System.out.println(taskAnswer.toString());
        System.out.println(userInput);

        return userInput.equals(taskAnswer.toString());

    }

}
