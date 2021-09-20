package com.e.simpletodo;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SignUpActivity extends AppCompatActivity implements My_Sex_Dialogue.myExampleDialogueListener {
    Button create_account;
    ImageView birthdayImage,  my_sex_imageview;
    EditText myBirthdayEditext;
    EditText my_sex_editext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        create_account = (Button) findViewById(R.id.create_account2);
        birthdayImage = findViewById(R.id.birthdayImage);
        my_sex_editext = (EditText) findViewById(R.id.mySexEditText);
        my_sex_imageview = (ImageView) findViewById(R.id.mySexImageView);

        create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(SignUpActivity.this, WelcomeBack_Activity.class);
                startActivity(myIntent);
            }
        });

        ////////////////////////////////////////////////THIS IS FOR DATE DROPDOWN//////////////////////////////////////////////////////////////
        final Calendar myCalendar = Calendar.getInstance();

        myBirthdayEditext= (EditText) findViewById(R.id.myEditText4);
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();///////////////put the method updateLabel here
            }

            private void updateLabel() {
                String myFormat = "dd/MM/yyyy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                myBirthdayEditext.setText(sdf.format(myCalendar.getTime()));
            }
        };
        myBirthdayEditext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(SignUpActivity.this, date, myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                Toast.makeText(getApplicationContext(), "Set your birthday here", Toast.LENGTH_LONG).show();

            }
        });
        birthdayImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(SignUpActivity.this, date, myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        //////////////// THIS METHOD IS USED TO OPEN DIALOGUE AND SET THE DIALOGUE TO MALE OR FEMALE/////////////////
        my_sex_editext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                My_Sex_Dialogue my_sex_dialogue = new My_Sex_Dialogue();
                my_sex_dialogue.show(getSupportFragmentManager(), "laterOn");
            }
        });
    }
    /////////////////THIS METHOD IS USED WITH MY_SEX_DIALOGUE TO SET THE TEXT TO MALE OR FEMALE/////////////////////////
    @Override
    public void applyTexts(String username, String password) {
        my_sex_editext.setText(username);
    }
}