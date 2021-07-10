package com.example.a18_arid_3033_qn02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button add;
    Button view;
    Intent inte = getIntent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = (Button) findViewById(R.id.newbtn);
        view = (Button) findViewById(R.id.viewbtn);

        add.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v){
                        OpenAddnew();
        }
                });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenViewAll();
            }
        });
    }

    public void OpenAddnew(){
        Intent intent = new Intent(this, Addnew.class);
        startActivity(intent);
    }

    public void OpenViewAll(){
        Intent intent = new Intent(this, ViewAll.class);
        startActivity(intent);
    }
}