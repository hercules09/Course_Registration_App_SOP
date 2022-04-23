package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapp.Adapters.FaceAdapter;
import com.example.myapp.Adapters.topadapter;
import com.example.myapp.Models.Face;
import com.example.myapp.Models.top;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textView ;
//    ImageView imageView1 , imageView2 , imageView3;
    DbHandler DB;
    String nameDB;
    Bitmap imageDB;
    RecyclerView recyclerView ;
    RecyclerView  horizontalScrollView2 ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setTitle(getString(R.string.abc));

        textView = findViewById(R.id.textView);
//        imageView1 = findViewById(R.id.imageView1);
//        imageView2 = findViewById(R.id.imageView2);
//        imageView3 = findViewById(R.id.imageView3);
        DB = new DbHandler(MainActivity.this);
        recyclerView = findViewById(R.id.recycleView);
        horizontalScrollView2 = findViewById(R.id.horizontalScrollView2);
        registerForContextMenu(textView);

        ArrayList <Face> list = new ArrayList<>();
        ArrayList <top> listtop = new ArrayList<>();
        listtop.add(new top(R.drawable.cs,"CS"));
        listtop.add(new top(R.drawable.elec,"EEE"));
        listtop.add(new top(R.drawable.mech,"Mech"));
        list.add(new Face(R.drawable.y1 , "Year 1"));
        list.add(new Face(R.drawable.y2 , "Year 2"));
        list.add(new Face(R.drawable.y3 , "Year 3"));
        list.add(new Face(R.drawable.y4 , "Year 4"));
        list.add(new Face(R.drawable.y5 , "Year 5"));


        topadapter topadapter = new topadapter(listtop , this);
        horizontalScrollView2.setAdapter(topadapter);

        FaceAdapter adapter = new FaceAdapter(list , this);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this , LinearLayoutManager.HORIZONTAL , false );
        horizontalScrollView2.setLayoutManager(linearLayoutManager);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this , 2);
        recyclerView.setLayoutManager(gridLayoutManager);

//        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2 , StaggeredGridLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(staggeredGridLayoutManager);



    }

    @Override
   public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.context_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.MyCourses:
                startActivity(new Intent(MainActivity.this,registeredcourses.class));
        }
        return super.onOptionsItemSelected(item);
    }
    //    Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.one);
//    ByteArrayOutputStream bytearray = new ByteArrayOutputStream();
//    bitmap.compress(Bitmap.CompressFormat.PNG , 100 , bytearray);
//    byte[] image = bytearray.toByteArray();


//    public boolean onContextItemSelected(MenuItem item){
//        switch (item.getItemId()){
//            case R.id.addNew :
//                String name = "Room name";
//                Bitmap bitmap = BitmapFactory.decodeResource(
//                        getResources(),R.drawable.three
//                );
//                ByteArrayOutputStream bytearray = new ByteArrayOutputStream();
//                bitmap.compress(Bitmap.CompressFormat.PNG , 100 , bytearray);
//                byte[] image = bytearray.toByteArray();
//                boolean insertData = DB.insertData(name , image);
//
//                imageDB = DB.getImage(name);
//                nameDB = DB.getName(name);
//
////                imageView2.setImageBitmap(imageDB);
//                textView.setText(nameDB);
//
//                return true;
//            case R.id.Manage :
//                Toast.makeText(this,"Manage" , Toast.LENGTH_LONG);
//                return true;
//            case R.id.delete :
//                Toast.makeText(this , "Delete Selected" , Toast.LENGTH_SHORT );
//                return true;
//            default:
//                return super.onContextItemSelected(item);
//        }
//    }
}