package com.kenyans.todo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;


public class DashBoard extends AppCompatActivity implements TodoListener {
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        initRecyclerView();
    }
    private ArrayList<String> initData() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("workout");
        arrayList.add("talk to baby");
        arrayList.add("read");
        arrayList.add("cook");
        arrayList.add("drive");
        return arrayList;

    }
    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Adapter(this,initData(),this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onTodoChange(ArrayList<String> arrayList) {

    }
}