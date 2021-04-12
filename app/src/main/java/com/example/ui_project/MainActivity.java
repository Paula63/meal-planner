package com.example.ui_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {
    private CardView breakfast_recipe, lunch_recipe, dinner_recipe, vegan_recipe, shopping_list;

    //drawer menu
    static final float END_SCALE = 0.7f;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menuIcon;
    LinearLayout contentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        // define cards -- hooks
        breakfast_recipe = (CardView) findViewById(R.id.breakfast);
        lunch_recipe = (CardView) findViewById(R.id.lunch);
        dinner_recipe = (CardView) findViewById(R.id.dinner);
        vegan_recipe = (CardView) findViewById(R.id.vegan);
        shopping_list = (CardView) findViewById(R.id.list);

        //menu hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        menuIcon = findViewById(R.id.menu_icon);
        contentView = findViewById(R.id.content);

        navigationDrawer();


        //add click events to cards
        breakfast_recipe.setOnClickListener(this);
        lunch_recipe.setOnClickListener(this);
        dinner_recipe.setOnClickListener(this);
        vegan_recipe.setOnClickListener(this);
        shopping_list.setOnClickListener(this);
    }

    //Navigation drawer functions
    private void navigationDrawer() {

        //navigation drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        animateNavigationDrawer();

    }

    private void animateNavigationDrawer() {

        drawerLayout.setScrimColor(getResources().getColor(R.color.colorPrimaryDark));

        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                // Scale the View based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                // Translate the View, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }
        });

    }


    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.nav_home:
                intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_shopping_list:
                intent = new Intent(getApplicationContext(), Shopping_List.class);
                startActivity(intent);
                break;
            case R.id.nav_login:
            case R.id.nav_register:
                intent = new Intent(getApplicationContext(), StartUpScreen.class);
                startActivity(intent);
                break;
            case R.id.nav_profile:
                intent = new Intent(getApplicationContext(), Profile.class);
                startActivity(intent);
                break;
        }

        return true;
    }


    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {
            case R.id.breakfast:
                i = new Intent(this, Breakfast_Recipe.class);
                startActivity(i);
                break;
            case R.id.lunch:
                i = new Intent(this, Lunch_Recipe.class);
                startActivity(i);
                break;
            case R.id.dinner:
                i = new Intent(this, Dinner_Recipe.class);
                startActivity(i);
                break;
            case R.id.vegan:
                i = new Intent(this, Vegan_Recipe.class);
                startActivity(i);
                break;
            case R.id.list:
                i = new Intent(this, Shopping_List.class);
                startActivity(i);
                break;
            default:
                break;
        }

    }

}