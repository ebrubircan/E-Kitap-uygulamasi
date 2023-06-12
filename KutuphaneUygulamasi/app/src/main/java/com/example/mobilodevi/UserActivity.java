package com.example.mobilodevi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.mobilodevi.databinding.ActivityUserBinding;

public class UserActivity extends AppCompatActivity {


    ActivityUserBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();

        if(intent != null){

            String name = intent.getStringExtra("name");
            String author = intent.getStringExtra("author");
            String ozet = intent.getStringExtra("ozet");
            int imageid = intent.getIntExtra("imageid",R.drawable.cesuryenidunya);

            binding.kitapIsim.setText(name);
            binding.yazarIsim.setText(author);
            binding.kitapOzet.setText(ozet);
            binding.kitapResim.setImageResource(imageid);
        }


    }
}