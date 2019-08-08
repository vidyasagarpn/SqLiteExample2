package com.sqliteexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sqliteexample.Notes.Note;
import com.sqliteexample.databasehelper.DataBaseHelper;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText;
    Button btn_save, btn_read;
    DataBaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_save = findViewById(R.id.btn_save);
        btn_read = findViewById(R.id.btn_read);
        editText = findViewById(R.id.edtInput);

        db = new DataBaseHelper(getApplicationContext());

        btn_save.setOnClickListener(this);
        btn_read.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btn_save:
                callSaveData();
                break;

            case R.id.btn_read:
                callReadData();
                break;
        }
    }

    private void callReadData() {

        List<Note> data = db.readData();

        for (int i=0;i<data.size();i++)
        {
            Log.d("Id : ",String.valueOf(data.get(i).getId()));
            Log.d("Name : ",data.get(i).getData());
            Log.d("TimeStamp : ",data.get(i).getTimestamp());
        }

    }

    private void callSaveData() {

        // Note note=new Note();

        db.saveData(editText.getText().toString());
    }
}
