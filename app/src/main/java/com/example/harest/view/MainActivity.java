package com.example.harest.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.harest.R;
import com.example.harest.adapter.StatesListAdapter;
import com.example.harest.model.StateModel;
import com.example.harest.model.StateResult;
import com.example.harest.service.RetrofitInstance;
import com.example.harest.service.ApiInterface;
import com.example.harest.viewmodel.ListViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<StateModel> stateModelArrayList;
    private RecyclerView recyclerView;
    private StatesListAdapter statesListAdapter;
    private TextView text_result;
    private ListViewModel listViewModel;
    private Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        statesListAdapter = new StatesListAdapter(this, new ArrayList<>());

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(statesListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        text_result = findViewById(R.id.text_result);

        listViewModel = ViewModelProviders.of(this).get(ListViewModel.class);
        listViewModel.init();
        listViewModel.getStatesList().observe(this, new Observer<List<StateModel>>() {
            @Override
            public void onChanged(List<StateModel> stateModels) {
                if(stateModels != null){
                    statesListAdapter.updateStates(stateModels);
                    Toast.makeText(getApplicationContext(), "changed", Toast.LENGTH_LONG).show();
                    //stateModelArrayList.addAll(stateModels);
                    //statesListAdapter.notifyDataSetChanged();
                }

            }
        });

        //setupRecyclerView();

        //getHAStates();
    }

//    private void setupRecyclerView() {
//        if(statesListAdapter == null){
//            statesListAdapter = new StatesListAdapter(this, stateModelArrayList);
//        }else{
//            statesListAdapter.notifyDataSetChanged();
//        }
//    }

//    private void getHAStates() {
//
//        ApiInterface apiInterface = RetrofitInstance.getService();
//
////        Call<StateModel> call = apiInterface.getEntityState("binary_sensor.aquarium_door");
////        //Log.d("main", call.toString());
////        call.enqueue(new Callback<StateModel>() {
////            @Override
////            public void onResponse(Call<StateModel> call, Response<StateModel> response) {
////                StateModel state = response.body();
////                if(state != null) {
////                    Log.d("main", state.getState());
////                    //Toast.makeText(getApplicationContext(), state.getState(), Toast.LENGTH_LONG).show();
////                    text_result.setText(state.getState());
////                }
////            }
////
////            @Override
////            public void onFailure(Call<StateModel> call, Throwable t) {
////                //Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
////            }
////        });
//
//
////        Call<List<StateModel>> call = apiInterface.getStates();
////        call.enqueue(new Callback<List<StateModel>>() {
////            @Override
////            public void onResponse(Call<List<StateModel>> call, Response<List<StateModel>> response) {
////                List<StateModel> stateList = response.body();
////
////                statesListAdapter = new StatesListAdapter(getApplicationContext(), stateList);
////                recyclerView.setAdapter(statesListAdapter);
////                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
////
////            }
////
////            @Override
////            public void onFailure(Call<List<StateModel>> call, Throwable t) {
////
////                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
////            }
////        });
////    }
//
//


//    //https://www.journaldev.com/23007/android-retrofit-call-every-x-seconds
//    @Override
//    protected void onResume() {
//        super.onResume();
//
//        if (disposable.isDisposed()) {
//            disposable = Observable.interval(1000, 1000,
//                    TimeUnit.MILLISECONDS)
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe(this::callStatesEndpoint, this::onError);
//        }
//    }
//
//    private void callStatesEndpoint(Long aLong) {
//
//        ApiInterface apiInterface = RetrofitInstance.getService();
//
//        Observable<StateModel> observable = apiInterface.getEntityState("binary_sensor.aquarium_door");
//        observable.subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .map(result -> result.value)
//                .subscribe(this::handleResults, this::handleError);
//    }
//
//    private void onError(Throwable throwable) {
//        Toast.makeText(this, "OnError in Observable Timer",
//                Toast.LENGTH_LONG).show();
//    }
//
//    private void handleResults(String joke) {
//
//        if (!TextUtils.isEmpty(joke)) {
//            text_result.setText(joke);
//
//
//        } else {
//            Toast.makeText(this, "NO RESULTS FOUND",
//                    Toast.LENGTH_LONG).show();
//        }
//    }
//
//    private void handleError(Throwable t) {
//
//        //Add your error here.
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//
//        disposable.dispose();
//    }
}