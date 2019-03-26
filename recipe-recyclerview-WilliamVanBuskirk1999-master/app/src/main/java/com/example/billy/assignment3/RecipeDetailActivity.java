package com.example.billy.assignment3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class RecipeDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.recipe_details);

        TextView recipeTitle = findViewById(R.id.recipeTitleDetail_textview);
        ImageView recipeImage = findViewById(R.id.recipeImage);
        TextView recipeDirections = findViewById(R.id.directionsList_textview);
        TextView recipeIngredients = findViewById(R.id.ingredientsList_textview);

        recipeTitle.setText(getIntent().getStringExtra("name"));
        recipeDirections.setText(getIntent().getStringExtra("directions"));
        recipeIngredients.setText(getIntent().getStringExtra("ingredients"));
        //glide not loading image
        Glide.with(this).load(getIntent().getStringExtra("image"))
                .into(recipeImage);


    }
}
