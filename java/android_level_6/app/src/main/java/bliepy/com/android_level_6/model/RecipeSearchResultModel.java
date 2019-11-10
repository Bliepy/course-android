package bliepy.com.android_level_6.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RecipeSearchResultModel {

    @SerializedName("count")
    @Expose
    private Integer count;

    @SerializedName("recipes")
    @Expose
    private List<RecipeSearchModel> recipes;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<RecipeSearchModel> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<RecipeSearchModel> recipes) {
        this.recipes = recipes;
    }
}
