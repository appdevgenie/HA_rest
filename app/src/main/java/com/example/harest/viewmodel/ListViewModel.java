package com.example.harest.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.harest.model.StateModel;
import com.example.harest.service.StatesRepository;

import java.util.List;

public class ListViewModel extends ViewModel {

    private MutableLiveData<List<StateModel>>listMutableLiveData;
    private StatesRepository statesRepository;

    public void init(){
        if(listMutableLiveData != null) {
            return;
        }
        statesRepository = StatesRepository.getInstance();
        listMutableLiveData = statesRepository.getStatesList();
    }

    public LiveData<List<StateModel>> getStatesList(){
        return listMutableLiveData;
    }

}
