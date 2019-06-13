package com.example.romanpc.projectfigure;

import android.animation.LayoutTransition;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.constraint.Guideline;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent;
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEventListener;

public class MainActivity extends AppCompatActivity {

    static Fragment currentFragment = null;
    BottomNavigationViewEx bottomNavigation;
    FrameLayout frameLayout;
    double volume;
    HorizontalScrollView scrollView;
    LinearLayout shar, konus, cilin, tetr, pira, para, prisma, kub;
    FragmentTransaction fragmentTransaction;
    Guideline guideline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shar = (LinearLayout)findViewById(R.id.shar);
        shar.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        konus = (LinearLayout)findViewById(R.id.konus);
        konus.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        cilin = (LinearLayout)findViewById(R.id.cilin);
        tetr = (LinearLayout)findViewById(R.id.tetr);
        pira = (LinearLayout)findViewById(R.id.pira);
        para = (LinearLayout)findViewById(R.id.para);
        prisma = (LinearLayout)findViewById(R.id.prisma);
        kub = (LinearLayout)findViewById(R.id.kub);

        scrollView = (HorizontalScrollView)findViewById(R.id.figureContainer);
        guideline = (Guideline)findViewById(R.id.guideline);

        scrollView.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);



        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.mainContainer, new SharFragment());
        fragmentTransaction.commit();

        shar.setBackgroundColor(Color.LTGRAY);

        bottomNavigation = (BottomNavigationViewEx)findViewById(R.id.bottomMenu);

        bottomNavigation.setCurrentItem(0);

        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.area:
                        startActivity(new Intent(MainActivity.this, SquareActivity.class));
                        break;
                    case R.id.perimeter:
                        startActivity(new Intent(MainActivity.this, PerimeterActivity.class));
                        break;
                    case R.id.info:
                        startActivity(new Intent(MainActivity.this, InfoActivity.class));
                        break;
                }
                return false;
            }
        });

//        linearLayout = (LinearLayout)findViewById(R.id.mainContainer);
        frameLayout = (FrameLayout)findViewById(R.id.mainContainer);
        frameLayout.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        final Handler handler = new Handler();

        KeyboardVisibilityEvent.setEventListener(this, new KeyboardVisibilityEventListener() {
            @Override
            public void onVisibilityChanged(boolean isOpen) {
                if(isOpen){
                    bottomNavigation.setVisibility(View.GONE);
                    guideline.setGuidelinePercent(1f);
                }else{
                    bottomNavigation.setVisibility(View.VISIBLE);
                    guideline.setGuidelinePercent(0.87f);
                }
            }
        });
    }

    public void onClick(View view){
        shar.setBackgroundColor(Color.WHITE);
        konus.setBackgroundColor(Color.WHITE);
        cilin.setBackgroundColor(Color.WHITE);
        tetr.setBackgroundColor(Color.WHITE);
        pira.setBackgroundColor(Color.WHITE);
        para.setBackgroundColor(Color.WHITE);
        prisma.setBackgroundColor(Color.WHITE);
        kub.setBackgroundColor(Color.WHITE);

        Fragment fragment = null;

        switch (view.getId()){
            case R.id.shar:
                shar.setBackgroundColor(Color.LTGRAY);
                fragment = new SharFragment();
                break;
            case R.id.konus:
                konus.setBackgroundColor(Color.LTGRAY);
                fragment = new KonusFragment();
                break;
            case R.id.cilin:
                cilin.setBackgroundColor(Color.LTGRAY);
                fragment = new CilinFragment();
                break;
            case R.id.tetr:
                tetr.setBackgroundColor(Color.LTGRAY);
                fragment = new TetraFragment();
                break;
            case R.id.pira:
                pira.setBackgroundColor(Color.LTGRAY);
                fragment = new PiraFragment();
                break;
            case R.id.para:
                para.setBackgroundColor(Color.LTGRAY);
                fragment = new ParallelepipedFragment();
                break;
            case R.id.prisma:
                prisma.setBackgroundColor(Color.LTGRAY);
                fragment = new PrismFragment();
                break;
            case R.id.kub:
                kub.setBackgroundColor(Color.LTGRAY);
                fragment = new CubeFragment();
                break;
        }

        if(fragment != null) {
            currentFragment = fragment;
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.mainContainer, fragment);
            fragmentTransaction.commit();
        }
    }
}
