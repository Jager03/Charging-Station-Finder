package com.example.nzse;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class UserLog extends Fragment {

    Profil profil = Profil.get();
    TextView usrName;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // ....
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //CloseFAB = (FloatingActionButton) getView().findViewById(R.id.CloseFAB);
        //CloseFAB.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View view) {
                //getActivity().onBackPressed();
        //    }
        //});

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_log, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        usrName = getView().findViewById(R.id.greeting);
        String hello = getString(R.string.greeting_text);
        usrName.setText(hello + " " + profil.getName());
    }


}