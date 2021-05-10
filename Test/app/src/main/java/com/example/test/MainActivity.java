package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.test.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private ArrayList<String> arrCompute;
    private ArrayAdapter<String> adptCompute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        arrCompute = new ArrayList<>();
        adptCompute = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, arrCompute);

        binding.lvCompute.setAdapter(adptCompute);

    }
    public void onClickCompute(View v){
        try{
            float var1 = Float.parseFloat(binding.edt1.getText().toString());
            float var2 = Float.parseFloat(binding.edt2.getText().toString());
            String rs = var1 + " / " + var2 + " = ";
            binding.tvCompute.setText(rs+ (var1/var2));
            arrCompute.add(rs+(var1/var2));
            adptCompute.notifyDataSetChanged();
        }catch (Exception e){
            Toast toast = Toast.makeText(MainActivity.this,
                    "Input is incorrect ! ", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER,50, 0);
            toast.show();

        }
    }
}