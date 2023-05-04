package com.example.nzse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.zip.Inflater;

public class CS_RecyclerViewAdapter extends RecyclerView.Adapter<CS_RecyclerViewAdapter.MyViewHolder> {
    Context context;
    //ArrayList<ChargingStation> ChargingStations;

    @NonNull
    @Override
    public CS_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);
        return new CS_RecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CS_RecyclerViewAdapter.MyViewHolder holder, int position) {
        //set data based on position of recyclerview
    }

    @Override
    public int getItemCount() {
        //return size of array of charging stations
        return 0;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
