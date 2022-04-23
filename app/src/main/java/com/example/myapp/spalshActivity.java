package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;

public class spalshActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh);

        getSupportActionBar().hide();
        Thread thread = new Thread(){

            public void run() {
                try{
                    sleep(3000);
                }
                catch(Exception exception){
                    exception.printStackTrace();
                }
                finally{
                    Intent intent = new Intent(spalshActivity.this, login.class);
                    startActivity(intent);
                    finish();
                }
            }
        };thread.start();
    }


}