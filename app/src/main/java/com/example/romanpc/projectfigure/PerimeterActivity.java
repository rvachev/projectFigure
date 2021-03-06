package com.example.romanpc.projectfigure;

import android.animation.LayoutTransition;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.constraint.Guideline;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent;
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEventListener;

public class PerimeterActivity extends AppCompatActivity {

    BottomNavigationViewEx bottomNavigation;
    LinearLayout circle, ellipse, parallelogram, rectangle, squarefigure, trapeze, triangle;
    HorizontalScrollView scrollView;
    FragmentTransaction fragmentTransaction;
    Guideline guideline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perimeter);

        scrollView = (HorizontalScrollView)findViewById(R.id.figureContainer);

        scrollView.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        circle = (LinearLayout)findViewById(R.id.circle);
        ellipse = (LinearLayout)findViewById(R.id.ellipse);
        parallelogram = (LinearLayout)findViewById(R.id.parallelogram);
        rectangle = (LinearLayout)findViewById(R.id.rectangle);
        squarefigure = (LinearLayout)findViewById(R.id.squarefigure);
        trapeze = (LinearLayout)findViewById(R.id.trapeze);
        triangle = (LinearLayout)findViewById(R.id.triangle);

        circle.setBackgroundColor(Color.LTGRAY);
        guideline = (Guideline)findViewById(R.id.guideline);

        FrameLayout frameLayout = (FrameLayout)findViewById(R.id.mainContainer);
        frameLayout.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.mainContainer, new CircleFragment());
        fragmentTransaction.commit();

        bottomNavigation = (BottomNavigationViewEx)findViewById(R.id.bottomMenuPerimeter);

        bottomNavigation.setCurrentItem(2);

        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.area:
                        startActivity(new Intent(PerimeterActivity.this, SquareActivity.class));
                        break;
                    case R.id.volume:
                        startActivity(new Intent(PerimeterActivity.this, MainActivity.class));
                        break;
                    case R.id.info:
                        startActivity(new Intent(PerimeterActivity.this, InfoActivity.class));
                }
                return false;
            }
        });

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
        circle.setBackgroundColor(Color.WHITE);
        ellipse.setBackgroundColor(Color.WHITE);
        parallelogram.setBackgroundColor(Color.WHITE);
        rectangle.setBackgroundColor(Color.WHITE);
        squarefigure.setBackgroundColor(Color.WHITE);
        trapeze.setBackgroundColor(Color.WHITE);
        triangle.setBackgroundColor(Color.WHITE);

        Fragment fragment = null;
        switch (view.getId()){
            case R.id.circle:
                fragment = new CircleFragment();
                view.setBackgroundColor(Color.LTGRAY);
                break;
            case R.id.ellipse:
                fragment = new EllipseFragment();
                view.setBackgroundColor(Color.LTGRAY);
                break;
            case R.id.parallelogram:
                fragment = new ParallelogramFragment();
                view.setBackgroundColor(Color.LTGRAY);
                break;
            case R.id.rectangle:
                fragment = new RectangleFragment();
                view.setBackgroundColor(Color.LTGRAY);
                break;
            case R.id.squarefigure:
                fragment = new SquareFigureFragment();
                view.setBackgroundColor(Color.LTGRAY);
                break;
            case R.id.trapeze:
                fragment = new TrapezeFragment();
                view.setBackgroundColor(Color.LTGRAY);
                break;
            case R.id.triangle:
                fragment = new TriangleFragment();
                view.setBackgroundColor(Color.LTGRAY);
                break;
        }

        if(fragment != null) {
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.mainContainer, fragment);
            fragmentTransaction.commit();
        }
    }
}
