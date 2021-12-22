package com.example.savedata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etName;
    Button btnSave, btnLoad;

    String name = "";

    SharedPreferences sPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.etName);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnLoad = (Button) findViewById(R.id.btnLoad);

        btnSave.setOnClickListener(this);
        btnLoad.setOnClickListener(this);

        loadText();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSave:
                saveText();
                break;
            case R.id.btnLoad:
                loadText();
                break;
            default:
                break;
        }
    }

    void saveText(){
        sPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPreferences.edit();
        name = etName.getText().toString();
        ed.putString("name", name);
        ed.commit();
        Log.i("SPREF", name);
    }

    void loadText(){
        sPreferences = getPreferences(MODE_PRIVATE);
        name = sPreferences.getString("name", "");
        etName.setText(name);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        saveText();
    }
}