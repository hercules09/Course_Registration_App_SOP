package com.example.myapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.Models.Face;
import com.example.myapp.R;
import com.example.myapp.ViewClassesActivity;

import java.util.ArrayList;

public class FaceAdapter extends RecyclerView.Adapter<FaceAdapter.viewHolder> {

    ArrayList <Face> list;
    Context context;

    public FaceAdapter(ArrayList<Face> list, Context context) {
        this.list = list;
        this.context = context;
    }

    // default
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_recycleview , parent , false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Face model = list.get(position);

        holder.imageView.setImageResource(model.getPic());
        holder.textView.setText(model.getText());

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, ViewClassesActivity.class);
               context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }
// till here
    public class viewHolder extends RecyclerView.ViewHolder {

            ImageView imageView;
            TextView textView;
            ConstraintLayout mainLayout;

            public viewHolder(@NonNull View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.imageView);
                textView = itemView.findViewById(R.id.textViewrecycler);
                mainLayout = itemView.findViewById(R.id.mainLayouta);

            }

}

}
