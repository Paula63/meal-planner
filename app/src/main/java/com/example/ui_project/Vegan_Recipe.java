package com.example.ui_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class Vegan_Recipe extends AppCompatActivity implements View.OnClickListener {
    private CardView curry, squash, cauliflower, tomato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_vegan__recipe);

        curry = (CardView) findViewById(R.id.coconut_curry);
        squash = (CardView) findViewById(R.id.baked_squash);
        cauliflower = (CardView) findViewById(R.id.cauliflower_stew);
        tomato = (CardView) findViewById(R.id.tomato_soup);

        curry.setOnClickListener(this);
        squash.setOnClickListener(this);
        cauliflower.setOnClickListener(this);
        tomato.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()){
            case R.id.coconut_curry : i = new Intent(this, Curry.class);startActivity(i); break;
            case R.id.baked_squash : i = new Intent(this, Squash.class);startActivity(i); break;
            case R.id.cauliflower_stew : i = new Intent(this, Cauliflower.class);startActivity(i); break;
            case R.id.tomato_soup : i = new Intent(this, Tomato_Soup.class);startActivity(i); break;
        }
    }
}