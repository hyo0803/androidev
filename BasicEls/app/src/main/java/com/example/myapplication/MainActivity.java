package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    TextView mainTextView;
    Button mainBtn;
    EditText mainEdit;
    ListView mainListView;
    ArrayAdapter<String> mArrayAdapter;
    ArrayList<String> mNameList = new ArrayList<>();
    Button ok_btn, cancel_btn;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainTextView = findViewById(R.id.textId);
        mainTextView.setText("set in Java");
        mainBtn = findViewById(R.id.mainButton);
        mainBtn.setOnClickListener(this);
        mainEdit = findViewById(R.id.main_editTxt);
        mainListView = findViewById(R.id.main_listview);
        mArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mNameList);
        mainListView.setAdapter(mArrayAdapter);
        mainListView.setOnItemClickListener(this);
        ok_btn = findViewById(R.id.okBtn);
        cancel_btn = findViewById(R.id.cancelBtn);
        ok_btn.setOnClickListener(oclBtn);
        cancel_btn.setOnClickListener(oclBtn);
        mainListView.setOnItemLongClickListener(Lng);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        mainTextView.setText(mainEdit.getText().toString()
                + " is learning Android development!");
        mNameList.add(mainEdit.getText().toString());
        Collections.sort(mNameList);
        Set<String> set = new HashSet<>(mNameList);
        mNameList.clear();
        mNameList.addAll(set);
        mArrayAdapter.notifyDataSetChanged();


    }


    View.OnClickListener oclBtn = new View.OnClickListener(){
        @SuppressLint("NonConstantResourceId")
        @Override
        public void onClick(View v){
            switch (v.getId()){
                case R.id.okBtn:
                    Toast.makeText(getApplicationContext(), "Ok pressed", Toast.LENGTH_LONG).show();
                    break;
                case R.id.cancelBtn:
                    Toast.makeText(getApplicationContext(), "Cancel pressed", Toast.LENGTH_LONG).show();
                    break;
            }
        }
    };

    AdapterView.OnItemLongClickListener Lng = new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            String value = mNameList.get(position);
            Log.d("omg android", position + ": " + value);
            mNameList.remove(position);
            Toast.makeText(getApplicationContext(), "Удалено: " + value, Toast.LENGTH_LONG).show();
            mArrayAdapter.notifyDataSetChanged();
            return true;
        }
    };


    @SuppressLint("SetTextI18n")
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d("omg android", position + ": " + mNameList.get(position));
        mainTextView.setText(mNameList.get(position).toString()
                + " is learning Android development!");

    }
}

