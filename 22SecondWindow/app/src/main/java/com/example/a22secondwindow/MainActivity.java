package com.example.a22secondwindow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button go;
    final String TAG = "States";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "MainActivity: onCreate()");
        go = (Button) findViewById(R.id.btnActTwo);
        go.setOnClickListener(this);
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG, "MainActivity: onStart()");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "MainActivity: onResume()");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "MainActivity: onPause()");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG, "MainActivity: onStop()");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "MainActivity: onDestroy()");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(TAG, "MainActivity: onRestart()");
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnActTwo:
                Intent intent = new Intent(this, MainActivity2PopUp.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }


}