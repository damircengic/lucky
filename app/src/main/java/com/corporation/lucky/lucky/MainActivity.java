package com.corporation.lucky.lucky;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private int luckyNumber;
    private int successStreak;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView randomText = (TextView) findViewById(R.id.random_nr);
        TextView streakText = (TextView) findViewById(R.id.random_nr);

        luckyNumber = getRandomNumber();
        successStreak = 0;
        randomText.setText(Integer.toString(luckyNumber));
    }

    private int getRandomNumber(){
        return new Random().nextInt(20)+1;
    }

    public void getLuckyNumber(View view){

        TextView resultText = (TextView) findViewById(R.id.resultText);

        int nextLuckyNumber = getRandomNumber();
        while(nextLuckyNumber == luckyNumber) {
            nextLuckyNumber = getRandomNumber();
        }

        boolean guessCorrect = false;
        TextView randomText = (TextView) findViewById(R.id.random_nr);
        TextView streakText = (TextView) findViewById(R.id.streak_txt);

        if(((Button)view).getText().equals("Bigger")){
            guessCorrect = nextLuckyNumber > luckyNumber;
        }
        else if(((Button)view).getText().equals("Smaller")) {
            guessCorrect = nextLuckyNumber < luckyNumber;
        }

        if(guessCorrect){
            successStreak++;
            resultText.setText("You got it right!");
        }
        else{
            successStreak = 0;
            resultText.setText("You suck! Better luck next time!");
        }

        streakText.setText(Integer.toString(successStreak));

        luckyNumber = nextLuckyNumber;
        randomText.setText(Integer.toString(luckyNumber));

    }
}
