package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.myapp.databinding.ActivityRegisFormBinding;
import com.example.myapp.databinding.ActivityRegisteredcoursesBinding;

import java.util.ArrayList;

public class registeredcourses extends AppCompatActivity {
   ActivityRegisteredcoursesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityRegisteredcoursesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DBHelper helper=new DBHelper(this);
        ArrayList<registeredcoursesmodel> list = helper.getCourses();



        registeredcoursesadapter registeredcoursesadapter = new registeredcoursesadapter(list,this);
        binding.registeredcoursesrecyclerview.setAdapter(registeredcoursesadapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.registeredcoursesrecyclerview.setLayoutManager(layoutManager);
    }
}