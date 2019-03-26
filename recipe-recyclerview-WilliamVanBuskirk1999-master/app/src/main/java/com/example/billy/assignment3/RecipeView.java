package com.example.billy.assignment3;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.LinkedList;

public class RecipeView extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private LinkedList<Recipe> mRecipeData;
    private RecipeListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_view);

        mRecyclerView = findViewById(R.id.recyclerView);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mRecipeData = new LinkedList<Recipe>();


        mAdapter = new RecipeListAdapter(this,mRecipeData);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initializeData() {

    }

}
