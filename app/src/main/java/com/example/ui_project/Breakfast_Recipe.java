package com.example.ui_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class Breakfast_Recipe extends AppCompatActivity implements View.OnClickListener {
    private CardView egg, donuts, caramelApple, toastedGranola;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_breakfast__recipe);

        egg = (CardView) findViewById(R.id.egg_toast);
        donuts = (CardView) findViewById(R.id.blueberry_donuts);
        caramelApple = (CardView) findViewById(R.id.caramel);
        toastedGranola = (CardView) findViewById(R.id.granola);

        egg.setOnClickListener(this);
        donuts.setOnClickListener(this);
        caramelApple.setOnClickListener(this);
        toastedGranola.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()){
            case R.id.egg_toast : i = new Intent(this, Egg_Toast.class);startActivity(i); break;
            case R.id.blueberry_donuts : i = new Intent(this, Blueberry_Donuts.class);startActivity(i); break;
            case R.id.caramel : i = new Intent(this, Caramel_Apple.class);startActivity(i); break;
            case R.id.granola : i = new Intent(this, Granola.class);startActivity(i); break;
        }
    }
}