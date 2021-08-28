package com.example.harest.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.harest.R;
import com.example.harest.adapter.StatesListAdapter;
import com.example.harest.model.StateModel;
import com.example.harest.service.RetrofitInstance;
import com.example.harest.service.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

 //   private List<StateModel> stateModelArrayList;
    private RecyclerView recyclerView;
    private StatesListAdapter statesListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        getHAStates();
    }

    private void getHAStates() {

        ApiInterface apiInterface = RetrofitInstance.getService();
        Call<List<StateModel>> call = apiInterface.getStates();
        call.enqueue(new Callback<List<StateModel>>() {
            @Override
            public void onResponse(Call<List<StateModel>> call, Response<List<StateModel>> response) {
                List<StateModel> stateList = response.body();

                statesListAdapter = new StatesListAdapter(getApplicationContext(), stateList);
                recyclerView.setAdapter(statesListAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

//                populateList();

//                Toast.makeText(getApplicationContext(), stateList.get(3).getEntity_id(), Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<List<StateModel>> call, Throwable t) {

                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

//    private void populateList() {
//
//
//    }
}