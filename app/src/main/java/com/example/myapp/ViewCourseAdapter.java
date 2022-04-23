package com.example.myapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class ViewCourseAdapter extends RecyclerView.Adapter<ViewCourseAdapter.ViewHolder>{
    private Context context;
    private ArrayList<ViewCourseModel> courseModelArrayList;

    public ViewCourseAdapter(Context context, ArrayList<ViewCourseModel> courseModelArrayList) {
        this.context = context;
        this.courseModelArrayList = courseModelArrayList;
    }

    @Override
    public ViewCourseAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewCourseAdapter.ViewHolder holder, int position) {
        ViewCourseModel courseModel = courseModelArrayList.get(position);
        holder.courseName.setText(courseModel.getCourse_name());
        holder.courseNumber.setText(courseModel.getCourse_number());
        holder.instructor.setText(courseModel.getCourse_instructor());
        holder.creditHour.setText(Integer.toString(courseModel.getCredit_hour()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(context,regisForm.class);
                intent.putExtra("name", courseModel.getCourse_name());
                intent.putExtra("ID",courseModel.getCourse_number());
                intent.putExtra("instructor",courseModel.getCourse_instructor());
                intent.putExtra("type",1);
                context.startActivity(intent);
            }
        });

//        holder.addbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Toast toast = Toast.makeText(context, "Course Added",Toast.LENGTH_LONG);
//                toast.show();
//
//            }
//        });
//
//        holder.dropbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Toast toast = Toast.makeText(context, "Course Dropped",Toast.LENGTH_LONG);
//                toast.show();
//
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return courseModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView courseimg;
        private TextView courseName;
        private TextView courseNumber;
        private TextView instructor;
        private TextView creditHour;
//        Button addbtn,dropbtn;

        public ViewHolder(View itemView){
            super(itemView);
            courseimg=itemView.findViewById(R.id.comp_logo);
            courseName = itemView.findViewById(R.id.course_name);
            courseNumber = itemView.findViewById(R.id.course_number);
            instructor = itemView.findViewById(R.id.instructor);
            creditHour = itemView.findViewById(R.id.credit_hour);
//            addbtn=itemView.findViewById(R.id.addbtn);
//            dropbtn=itemView.findViewById(R.id.dropbtn);
        }
    }

}
