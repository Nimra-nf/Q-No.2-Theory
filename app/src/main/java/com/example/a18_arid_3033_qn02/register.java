package com.example.a18_arid_3033_qn02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class register extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        EditText username;
        EditText password;
        EditText email;
        Button reg;


        username = (EditText) findViewById(R.id.user_name);
        password = (EditText) findViewById(R.id.password);
        email = (EditText) findViewById(R.id.email);
        reg = (Button) findViewById(R.id.reg);

        String name = username.getText().toString();
        String pass = password.getText().toString();
        String mail = email.getText().toString();


        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mydatabase md = Mydatabase(register.this);
                md.AddUser(name, pass, mail);
            }
        });
    }
}
