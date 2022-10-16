package com.example.tiktok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.tiktok.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

  ArrayList<Model> modelArrayList = new ArrayList<>();
  Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());

        //remove statusbar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(binding.getRoot());
        // hide tollbar
        getSupportActionBar().hide();

        //this.getTheme().applyStyle(R.style.FullScreen,false);

        modelArrayList.add(new Model("android.resource://" + getPackageName() + "/" + R.raw.v1,R.drawable.man,"Sohail Anwar"));
        modelArrayList.add(new Model("android.resource://" + getPackageName() + "/" + R.raw.v3,R.drawable.man,"Ali Raza"));
        modelArrayList.add(new Model("android.resource://" + getPackageName() + "/" + R.raw.v4,R.drawable.man,"Abid"));

        // initialize adapter
        adapter = new Adapter(MainActivity.this, modelArrayList);
        binding.vp2.setAdapter(adapter);

    }
}