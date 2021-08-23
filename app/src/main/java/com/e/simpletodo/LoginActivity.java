package com.e.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    Button create_account;
    TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        create_account = (Button) findViewById(R.id.create_account);
        login = (TextView) findViewById(R.id.login);


        create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myCreateIntent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(myCreateIntent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inn = new Intent(getApplicationContext(), WelcomeBack_Activity.class);
                startActivity(inn);
            }
        });
    }
}
