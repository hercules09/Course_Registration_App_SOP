package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myapp.databinding.ActivityRegisFormBinding;

public class regisForm extends AppCompatActivity {
    ActivityRegisFormBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis_form);
        binding = ActivityRegisFormBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        final DBHelper helper =new DBHelper(this);
        if(getIntent().getIntExtra("type",0)==1){

        final String name =getIntent().getStringExtra("name");
        final String id= getIntent().getStringExtra("ID");
        final String instructor = getIntent().getStringExtra("instructor");

        binding.regiscoursename.setText(name);
        binding.regiscoursenumber.setText(id);
        binding.regiscourseinstruc.setText(instructor);


        binding.addcoursebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted = helper.insertCourses(binding.editTextTextPersonName2.getText().toString(),
                binding.editTextTextPersonName3.getText().toString(),
                        name,
                        id,
                        instructor);
                if(isInserted)
                    Toast.makeText(regisForm.this,"Course Added",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(regisForm.this,"Error",Toast.LENGTH_SHORT).show();
            }
        });
    } else{
            int id=getIntent().getIntExtra("id",0);
            Cursor cursor =helper.getRegCourseById(id);
            binding.regiscoursename.setText(cursor.getString(1));
            binding.regiscoursenumber.setText(cursor.getString(2));
            binding.regiscourseinstruc.setText(cursor.getString(3));
            binding.addcoursebtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean isupdated=helper.updateCourses(
                            binding.regiscoursename.getText().toString(),
                            binding.editTextTextPersonName3.getText().toString(),
                            binding.editTextTextPersonName2.getText().toString(),
                            binding.regiscoursenumber.getText().toString(),
                            binding.regiscourseinstruc.getText().toString()

                    );
                    if(isupdated)
                        Toast.makeText(regisForm.this,"Updated",Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(regisForm.this,"Failed",Toast.LENGTH_SHORT).show();
                }
            });

        }
}}