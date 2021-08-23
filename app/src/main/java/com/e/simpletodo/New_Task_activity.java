package com.e.simpletodo;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class New_Task_activity extends AppCompatActivity {
    EditText myEditext555;
    RelativeLayout descriptionRelay;
    EditText descriptionEditext;
    ImageView backIcon;
    Spinner spinner;
    EditText date_editext, time_editext, newTaskEditext5;
    Button add_text_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new__task_activity);

        //noteTitle = findViewById(R.id.myDescriptionEditText);
        descriptionRelay = (RelativeLayout) findViewById(R.id.descriptionRelay);
        descriptionEditext = (EditText) findViewById(R.id.myDescriptionEditText);
        backIcon = (ImageView) findViewById(R.id.back_Icon);
        spinner = (Spinner) findViewById(R.id.spinner);
        add_text_button = (Button) findViewById(R.id.add_Task_Button);
        //newTaskEditext5 = (EditText) findViewById(R.id.myEditText5);
        myEditext555 = (EditText) findViewById(R.id.myEditText555);



        ////////////////////////////THIS  CODE WAS USED TO USED TO SET SPINNER, A DROP DOWN MENU WHEN CATEGORY IS CLICKED///////////////////////////////
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(New_Task_activity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.names));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(myAdapter);


        descriptionRelay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                descriptionEditext.requestFocus();
                InputMethodManager IMM = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                IMM.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
            }
        });
        backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
        ////////////////////////////////////////////////THIS IS FOR DATE DROPDOWN//////////////////////////////////////////////////////////////
        final Calendar myCalendar = Calendar.getInstance();

        date_editext= (EditText) findViewById(R.id.date_editext);
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();///////////////put the method updateLabel here
            }

            private void updateLabel() {
                String myFormat = "MM/dd/yy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                date_editext.setText(sdf.format(myCalendar.getTime()));
            }
        };
        date_editext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(New_Task_activity.this, date, myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        /////////////////////////////////////////////////THIS IS FOR TIME DROPDOWN////////////////////////////////////////////////////////////////
        time_editext  = (EditText) findViewById(R.id.time_editext);
        time_editext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(New_Task_activity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        time_editext.setText( selectedHour + " : " + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();

            }
        });












        add_text_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialogueHereFoeMe();
            }
        });
    }
    public void openDialogueHereFoeMe() {
        My_Dialogue activity_botton = new My_Dialogue();
        activity_botton.show(getSupportFragmentManager(), "ExampleDialogue");
    }













        @Override
        public void onBackPressed () {
            super.onBackPressed();
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }
}
