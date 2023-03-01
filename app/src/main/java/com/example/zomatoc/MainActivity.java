package com.example.zomatoc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.zomatoc.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        DeliveryFragment deliveryFragment = new DeliveryFragment();
        MoneyFragment moneyFragment = new MoneyFragment();
        DiningFragment diningFragment = new DiningFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.main_frag_container,deliveryFragment).commit();

        bottomNavigationView = findViewById(R.id.bottom_nav_view);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.delivery_bu:
                    fragmentManager.beginTransaction().replace(R.id.main_frag_container,deliveryFragment).commit();
                    return true;
                case R.id.dining_bu:
                    fragmentManager.beginTransaction().replace(R.id.main_frag_container,diningFragment).commit();
                    return true;
                case R.id.money_bu:
                    fragmentManager.beginTransaction().replace(R.id.main_frag_container,moneyFragment).commit();
                    return true;
                default:
                    return false;
            }
        });
    }
}