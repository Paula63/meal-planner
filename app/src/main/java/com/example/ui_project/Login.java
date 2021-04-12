package com.example.ui_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
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

public class Login extends AppCompatActivity{

    private FirebaseAuth mAuth;

    private TextInputEditText email_fld, pass_fld;

    Button submit, create_account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        email_fld = findViewById(R.id.l_email_edit_fld);
        pass_fld = findViewById(R.id.l_pass_edit_fld);
        submit = findViewById(R.id.submit_btn);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = email_fld.getText().toString();
                String password = pass_fld.getText().toString();
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Toast.makeText(getApplicationContext(), "User signed in: "+user.getEmail(), Toast.LENGTH_SHORT).show();
                                    //tvUser.setText(user.toString());
                                } else {
                                    Toast.makeText(getApplicationContext(), "Authentication failed.", Toast.LENGTH_SHORT).show();
                                    // tvUser.setText("Null as User Sign In failed");
                                }
                            }
                        });
            }
        });

    }

    public void callHomeScreen(View view){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void callCreateAccountScreen(View view){

        Intent intent = new Intent(this, Register.class);
        startActivity(intent);

    }

    public void callStart(View view){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

}