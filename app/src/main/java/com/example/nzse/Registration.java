package com.example.nzse;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class Registration extends Fragment {
    Profil profil = Profil.get();
    Button saveBtn;
    EditText name, lastname;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registration, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        name = getView().findViewById(R.id.etName);
        lastname = getView().findViewById(R.id.etLastname);
        saveBtn = getView().findViewById(R.id.SaveProfile);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profil.setName(name.getText().toString());
                profil.setLastName(lastname.getText().toString());
                profil.setIsReg(true);
                String msg = getString(R.string.FeedbackMessage1);
                Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });
    }
}