package com.example.carbhejdo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FilterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
    }



    public void onFilterClick(View v){
        Intent ini = new Intent(this, BuyCarListActivity.class);
        startActivity(ini);
    }
}
