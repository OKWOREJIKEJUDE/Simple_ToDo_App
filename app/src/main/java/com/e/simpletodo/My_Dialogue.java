package com.e.simpletodo;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class My_Dialogue extends AppCompatDialogFragment {
    RelativeLayout confirm_relay, cancel_relay;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.my_dialogue, null);
        builder.setView(view);

        confirm_relay = (RelativeLayout) view.findViewById(R.id.confirm_relay);
        cancel_relay = (RelativeLayout) view.findViewById(R.id.cancel_relay);

        confirm_relay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(),"Your task have been added successfully", Toast.LENGTH_LONG).show();
                /*
                New_Task_activity new_task_activity = new New_Task_activity();
                Intent intent = new Intent(getActivity().getApplicationContext(), My_Calender_Fragment.class);
                intent.putExtra("TheText", new_task_activity.newTaskEditext5.getText().toString());
                startActivity(intent);

                 */
            }
        });

        cancel_relay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



       return builder.create();
    }

}

