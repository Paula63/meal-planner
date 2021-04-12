package com.example.ui_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    private FirebaseAuth mAuth;

    //get data variables
    TextInputEditText fullName, username, email_fld, password_fld;

    Button confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_register);

        //hooks for getting data
        fullName = findViewById(R.id.full_name_edit_fld);
        username = findViewById(R.id.username_edit_fld);
        email_fld = findViewById(R.id.email_edit_fld);
        password_fld = findViewById(R.id.l_pass_edit_fld);
        confirm = findViewById(R.id.submit_details_btn);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        confirm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String email = email_fld.getText().toString();
                String password = password_fld.getText().toString();
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Toast.makeText(getApplicationContext(), "User created: " + user.getEmail(), Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(getApplicationContext(), "Authentication failed!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }

        });

    }

    public void callToLoginScreen(View view) {

        Intent intent = new Intent(getApplicationContext(), Login.class);
        startActivity(intent);

    }

    public void callCAHomeScreen(View view) {


        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void callStartScreen(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

}