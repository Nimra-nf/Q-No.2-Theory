package com.example.a18_arid_3033_qn02;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ViewAll extends AppCompatActivity {
    Mydatabase db;
    ArrayList<String> Id, Name, number, m_number, amount, last_count, curr_count;

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.viewall);

        db = new Mydatabase(this);
        Id = new ArrayList<>();
        Name = new ArrayList<>();
        number = new ArrayList<>();
        m_number = new ArrayList<>();
        amount = new ArrayList<>();
        last_count = new ArrayList<>();
        curr_count = new ArrayList<>();
    }

    public void displaydata(){
        Cursor cursor = db.readData();
        if(cursor.getCount()==0){
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
        else{
            while(cursor.moveToNext()){
                Id.add(cursor.getString(0));
                Name.add(cursor.getString(1));
                number.add(cursor.getString(2));
                m_number.add(cursor.getString(3));
                amount.add(cursor.getString(4));
                last_count.add(cursor.getString(5));
                curr_count.add(cursor.getString(6));
            }
        }
    }
}
