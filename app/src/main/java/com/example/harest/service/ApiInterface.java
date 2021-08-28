package com.example.harest.service;

import static com.example.harest.utils.Constants.LONG_LIVED_TOKEN;

import com.example.harest.model.StateModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ApiInterface {

    @Headers({
            "Authorization:Bearer " + LONG_LIVED_TOKEN,
            "content-type:application/json"
            })

    @GET("api/states")
    Call<List<StateModel>> getStates();
}
