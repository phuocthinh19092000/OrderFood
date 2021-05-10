package com.example.revision;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.revision.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;

    private int count = 0;
    private ArrayList<String> arrayList;
    private ArrayAdapter<String> arrayAdapter;
    private MyViewModel Model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View v  = binding.getRoot();
        setContentView(v);
        Model = new ViewModelProvider(this).get(MyViewModel.class);
        Model.countUp().observe(this, integer -> {
            binding.tv.setText(""+integer);
            count = integer;

        });

        Model.countUpList().observe(this, list -> {
            arrayList = list;
            arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
            binding.lv.setAdapter(arrayAdapter);
        });

        arrayList = new ArrayList<String>();
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        binding.lv.setAdapter(arrayAdapter);
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //binding.tv.setText(""+ ++count);
                Model.loadNumber();
               // arrayList.add(""+ count++);
                Model.loadList1(arrayList, count);

                arrayAdapter.notifyDataSetChanged();
            }
        });
        binding.lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                arrayList.remove(position);
                arrayAdapter.notifyDataSetChanged();
                return false;
            }
        });
        binding.lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("data", arrayList.get(position));
                startActivity(intent);
            }
        });

    }

}