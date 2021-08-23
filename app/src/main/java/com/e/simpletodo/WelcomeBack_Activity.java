package com.e.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeBack_Activity extends AppCompatActivity {
    Button myFinalLogin;
    ImageView IMG;
    EditText myPassEditext;
    boolean isClicked = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_back_);

        myFinalLogin = (Button) findViewById(R.id.myfinalLogin);
        //IMG = findViewById(R.id.IMG);
       // myPassEditext = (EditText) findViewById(R.id.mypassEditText2);



        ////////////////////////////////THIS IS USED TO CHANGE TEXTS IN THE TEXTVIEW TO DOTS IF THE IMAGEVIEW IS CLICKED/////////////////
       /* IMG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClicked = true){
                    myPassEditext.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

                } else if(isClicked = false)
            {
                     myPassEditext.setInputType(InputType.TYPE_CLASS_TEXT);
                }
            }
        });

        */


        myFinalLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myFinalLoginIntent = new Intent(WelcomeBack_Activity.this, MainActivity.class);
                startActivity(myFinalLoginIntent);
            }
        });
    }
}
