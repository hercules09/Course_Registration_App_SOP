package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;

public class login extends AppCompatActivity {
    EditText UsernameEt,PasswordEt;
    GoogleSignInClient mGoogleSignInClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        UsernameEt=(EditText)findViewById(R.id.editTextTextPersonName);
        PasswordEt=(EditText)findViewById(R.id.editTextTextPassword);

        getSupportActionBar().hide();


        Button loginButton = findViewById(R.id.loginbtn);
        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent viewClassesIntent = new Intent(login.this, MainActivity.class);
                startActivity(viewClassesIntent);
            }
        });
}
public void OnLogin(View view){
        String username=UsernameEt.getText().toString();
        String password=PasswordEt.getText().toString();
        String type="login";

        BackgroundWorker backgroundWorker= new BackgroundWorker(this);
        backgroundWorker.execute(type,username,password);
}


}