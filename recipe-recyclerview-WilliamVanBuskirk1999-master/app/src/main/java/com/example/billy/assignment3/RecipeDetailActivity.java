package com.example.billy.assignment3;

/**
 * @date 2019-03-25
 * William Van Buskirk
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

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

        Picasso.get()
                .load(getIntent().getStringExtra("image"))
                .fit()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(recipeImage);

    }
}
