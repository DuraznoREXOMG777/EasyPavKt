package com.highflyers.commonresources;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public abstract class AppBaseViewModel extends ViewModel {


    private MutableLiveData<Boolean> sendingData = new MutableLiveData<>();
    public abstract void init();

    @Override
    protected void onCleared() {
        super.onCleared();
    }

    public void setLoadingData(Boolean loadingData){
        sendingData.setValue(loadingData);
    }

    public LiveData<Boolean> isLoadingData() {
        return sendingData;
    }

}

