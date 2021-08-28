package com.example.harest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.harest.R;
import com.example.harest.model.StateModel;

import java.util.ArrayList;
import java.util.List;

public class StatesListAdapter extends RecyclerView.Adapter<StatesListAdapter.StatesViewHolder> {

    private Context context;
    private List<StateModel> stateModelArrayList;

    public StatesListAdapter(Context context, List<StateModel> stateModelArrayList) {
        this.context = context;
        this.stateModelArrayList = stateModelArrayList;
    }

    @NonNull
    @Override
    public StatesListAdapter.StatesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_state, parent, false);
        return new StatesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StatesListAdapter.StatesViewHolder holder, int position) {

        holder.entity_id.setText(stateModelArrayList.get(position).getEntity_id());
        holder.last_changed.setText(stateModelArrayList.get(position).getLast_changed());
        holder.state.setText(stateModelArrayList.get(position).getState());
    }

    @Override
    public int getItemCount() {
        return stateModelArrayList.size();
    }

    public class StatesViewHolder extends RecyclerView.ViewHolder{

        private TextView entity_id;
        private TextView last_changed;
        private TextView state;

        public StatesViewHolder(@NonNull View itemView) {
            super(itemView);

            entity_id = itemView.findViewById(R.id.text_item_entity_id);
            last_changed = itemView.findViewById(R.id.text_item_last_changed);
            state = itemView.findViewById(R.id.text_item_state);
        }
    }
}
