package com.e.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

public class CalenderActivity extends AppCompatActivity {
    RelativeLayout createNewTask;
    DrawerLayout drawerLayout;
    ImageView nav_menu;
   Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

        createNewTask = (RelativeLayout) findViewById(R.id.newtaskrelay);
        nav_menu = (ImageView) findViewById(R.id.nav_menu);
        toolbar =(Toolbar) findViewById(R.id.toolbar);

        createNewTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newtaskIntent = new Intent(CalenderActivity.this, New_Task_activity.class);
                startActivity(newtaskIntent);
            }
        });

       /* setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        */

        nav_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
