package com.example.ui_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class Dinner_Recipe extends AppCompatActivity implements View.OnClickListener {
    private CardView noodle, salmon, bake, creamy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dinner__recipe);

        noodle = (CardView) findViewById(R.id.chicken_noodles);
        salmon = (CardView) findViewById(R.id.veg_salmon);
        bake = (CardView) findViewById(R.id.pasta_bake);
        creamy = (CardView) findViewById(R.id.creamy_chicken);

        noodle.setOnClickListener(this);
        salmon.setOnClickListener(this);
        bake.setOnClickListener(this);
        creamy.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()){
            case R.id.chicken_noodles : i = new Intent(this, Noodles.class);startActivity(i); break;
            case R.id.veg_salmon : i = new Intent(this, Salmon.class);startActivity(i); break;
            case R.id.pasta_bake : i = new Intent(this, Bake.class);startActivity(i); break;
            case R.id.creamy_chicken : i = new Intent(this, Creamy_Chicken.class);startActivity(i); break;
        }
    }
}