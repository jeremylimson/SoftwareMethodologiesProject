package com.example.bmesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    RecyclerView eventViewer;

    String s1[], s2[];
    int images[] = {R.drawable.bmes1,R.drawable.bmes2,R.drawable.bmes3,R.drawable.bmes4,R.drawable.bmes5,R.drawable.bmes6,R.drawable.bmes7};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
    }

    public void openWindowmenu(View v) {

        setContentView(R.layout.windowmenu);
    }
    public void backtomenu(View v) {
        setContentView(R.layout.activity_main);
        eventViewer = findViewById(R.id.eventViewer);

        s1 = getResources().getStringArray(R.array.picture_names);
        s2 = getResources().getStringArray(R.array.description);

        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this, s1, s2, images);
        eventViewer.setAdapter(myAdapter);
        eventViewer.setLayoutManager(new LinearLayoutManager(this));
    }

}