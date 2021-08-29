package com.example.harest.service;

import androidx.lifecycle.MutableLiveData;

import com.example.harest.model.StateModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StatesRepository {

    private static StatesRepository statesRepository;

    public static StatesRepository getInstance() {
        if(statesRepository == null){
            statesRepository = new StatesRepository();
        }
        return statesRepository;
    }

    private ApiInterface apiInterface;

    public StatesRepository(){
        apiInterface = RetrofitInstance.getService();
    }

    public MutableLiveData<List<StateModel>> getStatesList(){
        MutableLiveData<List<StateModel>> statesList = new MutableLiveData<>();

        apiInterface.getStates().enqueue(new Callback<List<StateModel>>() {
            @Override
            public void onResponse(Call<List<StateModel>> call, Response<List<StateModel>> response) {
                statesList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<StateModel>> call, Throwable t) {

            }
        });

        return statesList;
    }
}
