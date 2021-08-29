package com.example.harest.service;

import static com.example.harest.utils.Constants.LONG_LIVED_TOKEN;

import com.example.harest.model.StateModel;
import com.example.harest.model.StateResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    // this needs to be added to each call for successful login
    @Headers({
            "Authorization:Bearer " + LONG_LIVED_TOKEN,
            "content-type:application/json"
    })

    @GET("states")
    Call<List<StateModel>> getStates();

    // this needs to be added to each call for successful login
    @Headers({
            "Authorization:Bearer " + LONG_LIVED_TOKEN,
            "content-type:application/json"
    })

    @GET("states/{entity_id}")
    Call<StateModel> getEntityState(@Path("entity_id") String entity_id);
}
