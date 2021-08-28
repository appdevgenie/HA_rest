package com.example.harest.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StatesListAdapter extends RecyclerView.Adapter<StatesListAdapter.StatesViewHolder> {


    @NonNull
    @Override
    public StatesListAdapter.StatesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull StatesListAdapter.StatesViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class StatesViewHolder extends RecyclerView.ViewHolder{


        public StatesViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
