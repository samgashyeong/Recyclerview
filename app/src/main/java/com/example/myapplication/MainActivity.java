package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        PersonAdapter adapter = new PersonAdapter();

        for(int i=0;i<10;i++){
            adapter.addItem(new Person(i+"", i+1+""));
        }

        recyclerView.setAdapter(adapter);


        adapter.setOnItemClickListener(new OnPersonItemCilckListener() {
            @Override
            public void onItemClick(PersonAdapter.ViewHolder holder, View view, int polsition) {
                Person item = adapter.getItem(polsition);
                Toast.makeText(MainActivity.this, "아이템 선택점"+item.getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}