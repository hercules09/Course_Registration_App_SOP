package com.example.myapp;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class ViewClassesActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<ViewCourseModel> courseModelArrayList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_classes);
        recyclerView = findViewById(R.id.recycler_view);

        //create array
        courseModelArrayList = new ArrayList<>();
        courseModelArrayList.add(new ViewCourseModel("Object Oriented Programming", "101", "Anita Agarwal", 4));
        courseModelArrayList.add(new ViewCourseModel("Data Structures and Algorithms", "102", "Prof 2", 3));
        courseModelArrayList.add(new ViewCourseModel("Digital Design", "103", "Prof 3", 3));
        courseModelArrayList.add(new ViewCourseModel("Course 4", "104", "Prof 4", 3));
        courseModelArrayList.add(new ViewCourseModel("Course 5", "105", "Prof 5", 3));
        courseModelArrayList.add(new ViewCourseModel("Course 6", "106", "Prof 6", 3));
        courseModelArrayList.add(new ViewCourseModel("Course 7", "107", "Prof 7", 3));

        ViewCourseAdapter courseAdapter = new ViewCourseAdapter(this, courseModelArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false );
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(courseAdapter);

    }
}
