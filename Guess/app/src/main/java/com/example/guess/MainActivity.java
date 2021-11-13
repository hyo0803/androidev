package com.example.guess;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    TextView guessInf;
    EditText guessTxt;
    Button guessBtn;
    Button LevelHard;
    Button LevelEasy;

    int guess;
    boolean finishCheck;
    boolean lvlCheck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        guessInf = (TextView) findViewById(R.id.guessMessage);
        guessTxt = (EditText) findViewById(R.id.guessInput);
        guessBtn = (Button) findViewById(R.id.guessButton);

        guess = (int) (Math.random()*100);
        finishCheck = false;
        lvlCheck = false;

        guessTxt.setTransformationMethod(null);
    }

    public void LvlHrd_Click(View v){
        guess = (int) (Math.random()*100);
        guessInf.setText(getResources().getString(R.string.try_to_guess_100));
        lvlCheck=false;
    }

    public void LvlEasy_Click(View v){
        guess = (int) (Math.random()*10);
        guessInf.setText(getResources().getString(R.string.try_to_guess_10));
        lvlCheck=true;
    }

    public void OnClick(View v){
        if (!finishCheck) {
            if (guessTxt.getText().toString().trim().isEmpty()){
                guessTxt.setError(getResources().getString(R.string.error));
            } else {
                int inp = Integer.parseInt(guessTxt.getText().toString());
                if (inp > guess& !lvlCheck){
                    if (inp>100)
                        guessInf.setText(getResources().getString(R.string.ahead_error_100));
                    else
                        guessInf.setText(getResources().getString(R.string.ahead));
                }
                if (inp > guess& lvlCheck){
                    if (inp>10)
                        guessInf.setText(getResources().getString(R.string.ahead_error_10));
                    else
                        guessInf.setText(getResources().getString(R.string.ahead));
                }
                if (inp < guess) {
                    guessInf.setText(getResources().getString(R.string.behind));
                }
                if (inp == guess) {
                    guessInf.setText(getResources().getString(R.string.hit));
                    guessBtn.setText(getResources().getString(R.string.play_more));
                    finishCheck = false;
                    LevelEasy.setText(getResources().getString(R.string.lvlEasy));
                    LevelHard.setText(getResources().getString(R.string.lvlHrd));
                }
            }
        }
        else{
            guess = (int)(Math.random()*100);
            guessBtn.setText(getResources().getString(R.string.input_value));
            guessInf.setText(getResources().getString(R.string.try_to_guess_100));
            finishCheck = false;
        }
        guessTxt.setText("");
    }
    public void Exit_Click(View v){
        finish();
        System.exit(0);
    }
}