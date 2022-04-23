package com.example.myapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class registeredcoursesadapter extends RecyclerView.Adapter<registeredcoursesadapter.viewHolder>{
    ArrayList<registeredcoursesmodel> list;
    Context context;

    public registeredcoursesadapter(ArrayList<registeredcoursesmodel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override

    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.regcoursesample,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
    final registeredcoursesmodel model = list.get(position);
    holder.regCourseName.setText(model.getName());
    holder.regCourseId.setText(model.getCourseId());
    holder.regCourseInstructor.setText(model.getCourseInstructor());

    holder.itemView.setOnClickListener(new View.OnClickListener(){

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context,regisForm.class);
            intent.putExtra("id",Integer.parseInt(model.getRegcoursenumber()));
            intent.putExtra("type",2);
            context.startActivity(intent);
        }
    });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
               new AlertDialog.Builder(context)
                       .setTitle("Drop Course")
                       .setMessage("Are you sure you want to drop the course?")
                       .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialogInterface, int i) {
                               DBHelper helper=new DBHelper(context);
                               if(helper.deleteRegcourses(model.getRegcoursenumber())>0){
                                   Toast.makeText(context,"Course Dropped", Toast.LENGTH_LONG).show();
                               } else{
                                   Toast.makeText(context,"Error",Toast.LENGTH_SHORT).show();
                              }
                          }
                       })
            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            }).show();

        return false;
    }
    });
}





    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        TextView regCourseName, regCourseId,regCourseInstructor;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            regCourseName= itemView.findViewById(R.id.regCourseName);
            regCourseId=itemView.findViewById(R.id.regCourseNum);
            regCourseInstructor=itemView.findViewById(R.id.reginstructor);
        }
    }
}
