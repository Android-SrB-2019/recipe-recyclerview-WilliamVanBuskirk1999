package com.example.billy.assignment3;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder> {

    private LinkedList<Recipe> mRecipes;
    private Context mContext;

    public RecipeListAdapter(Context context, LinkedList<Recipe> recipeData){
        this.mRecipes = DataProvider.getRecipes();
        this.mContext = context;
    }


    @NonNull
    @Override
    public RecipeListAdapter.RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new RecipeViewHolder(LayoutInflater.from(mContext).inflate(R.layout.recipe_view,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeListAdapter.RecipeViewHolder recipeViewHolder, int position) {
        Recipe currentRecipe = mRecipes.get(position);
        recipeViewHolder.bindTo(currentRecipe);
    }

    @Override
    public int getItemCount() {
        return mRecipes.size();
    }

    class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mRecipeTitle;
        private TextView mRecipeBody;

        public RecipeViewHolder(View itemView){
            super(itemView);
            mRecipeTitle = itemView.findViewById(R.id.recipeTitle_textview);
            mRecipeBody = itemView.findViewById(R.id.recipeBody_textview);

            itemView.setOnClickListener(this);

        }

        public void bindTo(Recipe currentRecipe){
            mRecipeTitle.setText(currentRecipe.name);
            mRecipeBody.setText(currentRecipe.description);
        }
        @Override
        public void onClick(View view) {
            Recipe currentRecipe = mRecipes.get(getAdapterPosition());
            Intent recipeDetailIntent = new Intent(mContext,RecipeDetailActivity.class);
            recipeDetailIntent.putExtra("name", currentRecipe.name);
            recipeDetailIntent.putExtra("image",currentRecipe.image);
            recipeDetailIntent.putExtra("ingredients",currentRecipe.ingredients);
            recipeDetailIntent.putExtra("directions",currentRecipe.directions);
            mContext.startActivity(recipeDetailIntent);
        }
    }

}
