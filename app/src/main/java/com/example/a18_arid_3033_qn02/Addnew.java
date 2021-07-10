package com.example.a18_arid_3033_qn02;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Addnew extends AppCompatActivity {
    EditText Cust_Name;
    EditText Number;
    EditText M_Number;
    EditText Amount;
    EditText Last_Unit;
    EditText Curr_Unit;
    Button Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newbill);

        Cust_Name = (EditText) findViewById(R.id.name);
        Number = (EditText) findViewById(R.id.number);
        M_Number = (EditText) findViewById(R.id.mnumber);
        Amount =(EditText) findViewById(R.id.amount);
        Last_Unit = (EditText) findViewById(R.id.lcount);
        Curr_Unit = (EditText) findViewById(R.id.CCount);
        Intent intent = getIntent();

        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mydatabase md = new Mydatabase(Addnew.this);
                md.addbill(Cust_Name.getText().toString().trim(),
                        Integer.parseInt(Number.getText().toString().trim()),
                        Integer.parseInt(M_Number.getText().toString().trim()),
                        Integer.parseInt(Amount.getText().toString().trim()),
                        Integer.parseInt(Last_Unit.getText().toString().trim()),
                        Integer.parseInt(Curr_Unit.getText().toString().trim()));
            }
        });

    }

}
;