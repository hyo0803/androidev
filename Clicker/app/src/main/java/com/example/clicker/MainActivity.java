package com.example.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    TextView mainText;
    Button mainBtn;

    private long score = 0;

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            score ++;
            String s = "Кликов: " + score;
            mainText.setText(s.toCharArray(),0, s.length());

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainText = (TextView) findViewById(R.id.mainTxt);
        mainBtn = (Button) findViewById(R.id.main_btn);
        mainBtn.setOnClickListener(clickListener);
    }
}