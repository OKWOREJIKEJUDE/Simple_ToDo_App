package com.e.simpletodo;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class My_Sex_Dialogue extends AppCompatDialogFragment {
    RadioButton male, female;
    private myExampleDialogueListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.my_sex_dialogue, null);
        builder.setView(view);

        male = (RadioButton) view.findViewById(R.id.male);
        female = (RadioButton) view.findViewById(R.id.female);

        builder.setView(view);
        builder.setTitle("Sex");
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String userName = male.getText().toString();
                String password = female.getText().toString();
                listener.applyTexts(userName, password);
            }
        });



       return builder.create();
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (myExampleDialogueListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "Must Implement myExampleDialogueListener");
        }
    }

    public interface  myExampleDialogueListener {
        void  applyTexts(String username, String password);
    }
}

