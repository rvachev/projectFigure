package com.example.romanpc.projectfigure;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class InfoActivity extends AppCompatActivity {

    private BottomNavigationViewEx bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        bottomNavigation = (BottomNavigationViewEx)findViewById(R.id.bottomMenu);

        bottomNavigation.setCurrentItem(3);

        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.area:
                        startActivity(new Intent(InfoActivity.this, SquareActivity.class));
                        break;
                    case R.id.perimeter:
                        startActivity(new Intent(InfoActivity.this, PerimeterActivity.class));
                        break;
                    case R.id.volume:
                        startActivity(new Intent(InfoActivity.this, MainActivity.class));
                        break;
                }
                return false;
            }
        });
    }
}
