package com.e.simpletodo;


import android.content.Intent;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class My_Calender_Fragment extends Fragment {
    RelativeLayout createNewTask;
    TextView myDisplaytext1;


    public My_Calender_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_my__calender_, container, false);

       /*
        myDisplaytext1 = (TextView) view.findViewById(R.id.myDisplayText2);
        myDisplaytext1.setText(getActivity().getIntent().getExtras().getString("TheText"));

        */


        createNewTask = (RelativeLayout) view.findViewById(R.id.newtaskrelay);
        createNewTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newtaskIntent = new Intent(getActivity(), New_Task_activity.class);
                startActivity(newtaskIntent);
                getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
               // getActivity().finishAffinity();   //Used to finish all the previous activities when createNewTask is clicked//
            }
        });
        return view;
    }

}
