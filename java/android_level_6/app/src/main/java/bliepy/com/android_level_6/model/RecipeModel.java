package bliepy.com.android_level_6.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RecipeModel {

    @SerializedName("recipe")
    @Expose
    private RecipeContentModel recipe;

    public RecipeContentModel getRecipe() {
        return recipe;
    }

    public void setRecipe(RecipeContentModel recipe) {
        this.recipe = recipe;
    }
}
