package com.midterm.TranPhuocThinh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.midterm.TranPhuocThinh.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MyViewModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();
        setContentView(v);

        model = new ViewModelProvider(this).get(MyViewModel.class);
        model.tvRS().observe(this, s -> {
            binding.tvRs.setText(s);
        });


        binding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.edtInput.getText().toString().isEmpty() || binding.edtAction.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"Please input all of edit text ",Toast.LENGTH_SHORT).show();
                }
                else {
                    if (binding.edtAction.getText().toString().equals("count-letter-digit") ){
                        binding.tvRs.setText(countLetterDigit(binding.edtInput.getText().toString()));
                    }
                    if (binding.edtAction.getText().toString().equals("remove-even")){
                        binding.tvRs.setText(countOdd(binding.edtInput.getText().toString()));

                    }
                }
            }
        });
    }
    public String countLetterDigit(String s) {
        int charCount = 0;
        int digitCount = 0;
        char temp;
        for (int i = 0; i < s.length(); i++) {
            temp = s.charAt(i);

            if (Character.isLetter(temp)) {
                charCount++;
            } else if (Character.isDigit(temp)) {
                digitCount++;
            }

        }
        return "LETTER : " + charCount + "\n" + "DIGITS : " + digitCount;
    }

    public String countOdd(String s){
        String[] arr = s.split(",");
        String new_s = "";
        for (int i = 0 ; i < arr.length; i++)
        {
            int n = Integer.parseInt(arr[i]);
            if (n % 2 != 0 )
                new_s += n + ",";
        }
        return new_s.substring(0, new_s.length()-1);
    }
}