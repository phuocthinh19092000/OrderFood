package com.example.revision;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class MyViewModel extends ViewModel {


    private MutableLiveData<Integer> number;
    private MutableLiveData<ArrayList<String>> list;
    private MutableLiveData<String> etValue;
    public LiveData<Integer> countUp() {
        if (number == null) {
            number = new MutableLiveData<Integer>();
            number.setValue(0);
        }
        return number;
    }
    public LiveData<ArrayList<String>> countUpList(){
        if (list == null){
            list = new MutableLiveData<ArrayList<String>>();
        }
        return list;
    }
    public LiveData<String> etChange(){
        if (etValue == null){
            etValue = new MutableLiveData<String>();
        }
        return etValue;
    }
    public void loadNumber() {
        number.setValue(number.getValue()+1);
    }
    public void loadList(ArrayList<String> list1 ){
        //list1.add(count)
        list.setValue(list1);
    }
    public void loadList1(ArrayList<String> list1, int count){
        list1.add(""+ count++);
        list.setValue(list1);
    }
    public void loadString(){


    }

}
