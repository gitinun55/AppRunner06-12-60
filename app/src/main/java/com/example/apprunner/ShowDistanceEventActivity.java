package com.example.apprunner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TableLayout;

import java.util.ArrayList;
import java.util.List;

public class ShowDistanceEventActivity extends AppCompatActivity {

    RecyclerView recycler_View;
    DistanceAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_distance_event);

        recycler_View = findViewById(R.id.recycler_view);
        setRecyclerView();
    }

    private void setRecyclerView() {
        recycler_View.setHasFixedSize(true);
        recycler_View.setLayoutManager(new LinearLayoutManager(this));
        adapter = new DistanceAdapter(this,getList());
        recycler_View.setAdapter(adapter);
    }

    private List<DistanceDB> getList(){
        List<DistanceDB> distance_list = new ArrayList<>();
        distance_list.add(new DistanceDB("11/30/2020","11:42","11","140"));
        return distance_list;
    }
}