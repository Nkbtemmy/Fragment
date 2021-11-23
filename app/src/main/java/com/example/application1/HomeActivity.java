package com.example.application1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;

import static com.example.application1.R.id.bottomNavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bnv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //getSupportActionBar().hide();
        //BottomNavigationItemView bottomNav = findViewById(R.id.bottomNavigation);

        //set home selected
        //bottomNavigation.setSelectedItemId(R.id.homeFragment);

        //paterne's code
        bnv = findViewById(R.id.bottomNavigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new home_page()).commit();
        bnv=(BottomNavigationView)findViewById(R.id.bottomNavigation);
//OnNavigationItemSelectedListener
        bnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                Fragment temp=null;

                switch (item.getItemId())
                {
                    case R.id.homeFragment : temp= home_page.newInstance("dd", "dd");
                        break;
                    case R.id.searchFragment : temp= search_page.newInstance("ddf", "df");
                        break;
                    case R.id.adduserFragment: temp= add_user_page.newInstance("dfd", "df");
                        break;
                    case R.id.profileFragment : temp= profile_page.newInstance("dsd", "ds");
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,temp).commit();

                return true;
            }
        });
    }

}