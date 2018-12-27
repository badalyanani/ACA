package com.example.ani.todo;


import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;





public class MainActivity extends AppCompatActivity implements Fragment1.OnStateChangeListener{
    private Fragment1 fragment;
    private FloatingActionButton buttonAdd;
    private MyRecyclerViewAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        List<String> list = new ArrayList<>();
        for( int i = 0; i < 20; i++){
            list.add("user " + i);
        }
        adapter =  new MyRecyclerViewAdapter(this,list);
        RecyclerView dataRecyclerView = findViewById(R.id.data_recycler_view);
        dataRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        dataRecyclerView.setAdapter(adapter);

         buttonAdd = findViewById(R.id.btn_add);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment();

            }
        });
    }


    @Override
    public void onBackPressed() {
        if(fragment != null && fragment.isAdded()){
            getSupportFragmentManager().beginTransaction().remove(fragment).commit();
            buttonAdd.setVisibility(View.VISIBLE);
        }
        else {
            super.onBackPressed();
        }
    }

    public void openFragment() {
        buttonAdd.setVisibility(View.GONE);



        fragment = new Fragment1();
        fragment.setOnSaveListener(this);
        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame_maincontainer, fragment);
        ft.commit();

    }

    @Override
    public void onSave() {
        //todo
       onBackPressed();
    }
}
