package com.example.ui_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class Lunch_Recipe extends AppCompatActivity implements View.OnClickListener {
    private CardView wrap, salad, pesto, vegetables;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_lunch__recipe);

        wrap = (CardView) findViewById(R.id.chicken_wrap);
        salad = (CardView) findViewById(R.id.med_salad);
        pesto = (CardView) findViewById(R.id.pesto_pasta);
        vegetables = (CardView) findViewById(R.id.veg_soup);

        wrap.setOnClickListener(this);
        salad.setOnClickListener(this);
        pesto.setOnClickListener(this);
        vegetables.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()){
            case R.id.chicken_wrap : i = new Intent(this, Chicken_Wrap.class);startActivity(i); break;
            case R.id.med_salad : i = new Intent(this, Salad.class);startActivity(i); break;
            case R.id.pesto_pasta : i = new Intent(this, Pesto.class);startActivity(i); break;
            case R.id.veg_soup : i = new Intent(this, Vegetable_Soup.class);startActivity(i); break;
        }
    }
}