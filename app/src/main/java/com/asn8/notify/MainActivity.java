package com.asn8.notify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> heading,text_ish;
    DataBaseHelper dBHelper;
    RecyclerViewAdapter recyclerViewAdapter;
    FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dBHelper = new DataBaseHelper(this);
        heading = new ArrayList<>();
        text_ish = new ArrayList<>();
        floatingActionButton = findViewById(R.id.float_button);
        recyclerView = findViewById(R.id.recycler_id);
        recyclerViewAdapter = new RecyclerViewAdapter(this,heading,text_ish);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        try {
            displayData();

        }catch (Exception e){
            Toast.makeText(this, "Exception"+e, Toast.LENGTH_LONG).show();
        }

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,NotesEntery.class));
            }
        });


    }

    private void displayData() {
        Cursor cursor =dBHelper.getEveryone();
        if (cursor.getCount() == 0){
            Toast.makeText(MainActivity.this, "No Data Found", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            while (cursor.moveToNext()){
                heading.add(cursor.getString(1));
                text_ish.add(cursor.getString(2));
            }
        }
    }
}