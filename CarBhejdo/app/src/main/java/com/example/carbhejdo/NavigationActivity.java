package com.example.carbhejdo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class NavigationActivity extends AppCompatActivity  {
   private DrawerLayout mDrawerLayout;
   private ActionBarDrawerToggle mToogle;
    NavigationView navigationview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        mDrawerLayout = findViewById(R.id.draw);
        mToogle = new ActionBarDrawerToggle(this,mDrawerLayout, R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToogle);
        mToogle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        navigationview = (NavigationView) findViewById(R.id.nav_view);
//        navigationview.setNavigationItemSelectedListener(this);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.drawermenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

//        if(mToogle.onOptionsItemSelected(item)){
            if(item.getItemId()==R.id.profile){
                Intent intent=new Intent(this,sellerprof.class);
                startActivity(intent);

            }



//        }
        return true;
    }

//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//
//            int id = item.getItemId();
//
//            if (id == R.id.profile) {
//                // Handle the camera action
//                startActivity(new Intent(getApplicationContext(), BuyCarListActivity.class));
//                Toast.makeText(this,"This is home",Toast.LENGTH_SHORT).show();
//            }
//            if (id == R.id.buycar) {
//                Toast.makeText(this,"This is buy car",Toast.LENGTH_SHORT).show();
//                // Handle the camera action
//                //startActivity(new Intent(getApplicationContext(), BuyCarListActivity.class));
//            }
//            if (id == R.id.sellcar) {
//                // Handle the camera action
//                Toast.makeText(this,"This is sell",Toast.LENGTH_SHORT).show();
//            }
////            mDrawerLayout.closeDrawer(GravityCompat.START);
////            return true;
//            return false;
//        }
}
