package com.example.revision;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.revision.databinding.ActivityDetailBinding;



public class DetailActivity extends AppCompatActivity {


    private ActivityDetailBinding binding;
    //private  TextView tv;
    private MyViewModel Model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);

        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        View v  = binding.getRoot();
        setContentView(v);

        //tv = findViewById(R.id.textView);

        Intent intent = getIntent();
        if (intent!=null) {
            String t1 = intent.getStringExtra("data");
            binding.setEtValue(t1);
            //binding.tv1.setText(t1);
        }
      // binding.setEtValue(binding.et1.getText().toString());






    }

}