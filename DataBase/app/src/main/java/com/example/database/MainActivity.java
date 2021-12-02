package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnAdd, btnDelete, btnRead;
    EditText etName;
    DBHelper dbHelper;
    final String LOG_TAG = "LOG_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.etName);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnRead = (Button) findViewById(R.id.btnRead);

        btnAdd.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnRead.setOnClickListener(this);

        dbHelper = new DBHelper(this);
    }

    @Override
    public void onClick(View v) {
        String name = etName.getText().toString();
        ContentValues cv = new ContentValues();
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        switch (v.getId()){
            case R.id.btnAdd:
                Log.d(LOG_TAG, "--- Insert in mytable: ---");

                cv.put("name", name);
                long rowID = db.insert("mytable", null, cv);

                Log.d(LOG_TAG, "row inserted, ID = " + rowID);
                break;
            case R.id.btnDelete:
                Log.d(LOG_TAG, "--- Clear mytable: ---");
                int clearCount = db.delete("mytable", null, null);
                Log.d(LOG_TAG, "deleted rows count = " + clearCount);
                break;
            case R.id.btnRead:
                Log.d(LOG_TAG, "--- Rows in mytable: ---");
                Cursor c = db.query("mytable", null,null,null,
                                                    null, null,null);
                if (c.moveToFirst()){
                    int idColIndex = c.getColumnIndex("id");
                    int nameColIndex = c.getColumnIndex("name");

                    do{
                        Log.d(LOG_TAG,
                                "ID = " + c.getInt(idColIndex) +
                                " , name = " + c.getString(nameColIndex));
                    } while (c.moveToNext());
                }else {
                    Log.d(LOG_TAG, "0 rows");
                }
                c.close();
                break;
            default:
                break;
        }
        dbHelper.close();
    }

    public class DBHelper extends SQLiteOpenHelper {
        public DBHelper(Context context) {
            super(context, "MyDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            //creating table
            db.execSQL("create table mytable ("
                    + "id integer primary key autoincrement,"
                    + "name text" + ")");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}