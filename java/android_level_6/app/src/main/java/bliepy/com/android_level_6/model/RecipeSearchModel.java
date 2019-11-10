package bliepy.com.android_level_6.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RecipeSearchModel {
    @SerializedName("recipe_id")
    @Expose
    private String recipe_id;

    public String getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(String recipe_id) {
        this.recipe_id = recipe_id;
    }
}
