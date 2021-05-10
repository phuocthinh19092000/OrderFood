package com.midterm.TranPhuocThinh;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    MutableLiveData<String> str;

    public LiveData<String> tvRS(){
        if (str == null)
            str = new MutableLiveData<String>();
        return str;
    }
    public void Load(String s){
        str.setValue(s);
    }


}
