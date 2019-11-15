package com.example.carbhejdo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class BuyCarListActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private RecyclerView recyclerView;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToogle;
    NavigationView navigationview;
    Button logo ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_buy_car_list);
        mDrawerLayout = findViewById(R.id.draw);

        mToogle = new ActionBarDrawerToggle(this,mDrawerLayout, R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToogle);
        mToogle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);

        List<ModelClass> modelClassList = new ArrayList<>();
        modelClassList.add(new ModelClass(R.drawable.altima, "Altima 800", "Price: $5000","Miles Driven: 11000"));
        modelClassList.add(new ModelClass(R.drawable.kia, "Kia", "Price: $72000","Miles Driven: 11000" ));
        modelClassList.add(new ModelClass(R.drawable.altima, "Altima 800", "Price: $1300","Miles Driven: 11000"));
        modelClassList.add(new ModelClass(R.drawable.kia, "Kia", "Price: $5000","Miles Driven: 11000"));
        modelClassList.add(new ModelClass(R.drawable.altima, "Altima 800", "Price: $5000","Miles Driven: 11000"));
        modelClassList.add(new ModelClass(R.drawable.kia, "Kia", "Price: $5000","Miles Driven: 11000"));
        modelClassList.add(new ModelClass(R.drawable.altima, "Altima 800", "Price: $5000","Miles Driven: 11000"));
        modelClassList.add(new ModelClass(R.drawable.kia, "Kia", "Price: $5000","Miles Driven: 11000"));
        modelClassList.add(new ModelClass(R.drawable.altima, "Altima 800", "Price: $5000","Miles Driven: 11000"));
        modelClassList.add(new ModelClass(R.drawable.kia, "Kia", "Price: $5000","Miles Driven: 11000"));

        Adapter adapter = new Adapter(modelClassList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        setNavigationViewListener();
    }

private void setNavigationViewListener(){


NavigationView nav = (NavigationView)findViewById(R.id.nav_view);
nav.setNavigationItemSelectedListener(this);

}

    public void onCarClick(View v){
        Intent carini = new Intent(this,Singlecar_Activity.class);
        startActivity(carini);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        if(mToogle.onOptionsItemSelected(item)){


            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.profile) {
            // Handle the camera action
            Intent toOtherint=new Intent(this,BuyCarListActivity.class);
            startActivity(toOtherint);
           Toast.makeText(this,"This is home",Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.buycar) {
            Toast.makeText(this,"This is buy car",Toast.LENGTH_SHORT).show();
            // Handle the camera action
            //startActivity(new Intent(getApplicationContext(), BuyCarListActivity.class));
        }
        if (id == R.id.sellcar) {
            // Handle the camera action
            Toast.makeText(this,"This is sell",Toast.LENGTH_SHORT).show();
        }
//            mDrawerLayout.closeDrawer(GravityCompat.START);
//            return true;
        return false;
    }
}
//        switch (id){
//            case R.id.profile:
//                Intent p = new Intent(BuyCarListActivity.this,sellerprof.class);
//                startActivity(p);
//                break;
//            case R.id.buycar:
//                Intent b = new Intent(BuyCarListActivity.this,BuyCarListActivity.class);
//                startActivity(b);
//                break;
//            case R.id.sellcar:
//                Intent s = new Intent(BuyCarListActivity.this,Singlecar_Activity.class);
//                startActivity(s);
//                break;
//            case R.id.logout:
//                Intent l = new Intent(BuyCarListActivity.this,SIgninSignupActivity.class);
//                startActivity(l);
//                break;
//        }
//        DrawerLayout draw = findViewById(R.id.draw);
//        draw.closeDrawer(GravityCompat.START);
//        return true;
//    }
//}


