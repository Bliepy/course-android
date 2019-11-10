package bliepy.com.android_level_6.activity;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import bliepy.com.android_level_6.R;
import bliepy.com.android_level_6.model.RecipeContentModel;
import bliepy.com.android_level_6.model.RecipeModel;
import bliepy.com.android_level_6.model.RecipeSearchResultModel;
import bliepy.com.android_level_6.service.RecipeRestServiceImpl;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SwipeActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    public static List<RecipeContentModel> recipes = new ArrayList();
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe);
        getSearch("chicken");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
    }

    public void getSearch(String search){
        RecipeRestServiceImpl service = new RecipeRestServiceImpl();
        service.callSearchRecipe(search).enqueue(new Callback<RecipeSearchResultModel>() {
            @Override
            public void onResponse(Call<RecipeSearchResultModel> call, Response<RecipeSearchResultModel> response) {
                RecipeSearchResultModel result =   response.body();
                getData(result.getRecipes().get(0).getRecipe_id());
                getData(result.getRecipes().get(1).getRecipe_id());
                getData(result.getRecipes().get(2).getRecipe_id());
            }

            @Override
            public void onFailure(Call<RecipeSearchResultModel> call, Throwable t) {

            }
        });
    }

    public void getData(String id){
        RecipeRestServiceImpl service = new RecipeRestServiceImpl();
        service.callRecipe(id).enqueue(new Callback<RecipeModel>() {
            @Override
            public void onResponse(Call<RecipeModel> call, Response<RecipeModel> response) {
                RecipeModel result =   response.body();
                recipes.add(result.getRecipe());
                mSectionsPagerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<RecipeModel> call, Throwable t) {
                System.out.println(t);
            }
        });
    }


    public static class PlaceholderFragment extends Fragment {

        public static PlaceholderFragment newInstance(int i) {
            RecipeContentModel recipe = recipes.get(i);
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putString("recipe_title", recipe.getTitle());
            args.putStringArray("recipe_ingredients", recipe.getIngredients());
            args.putString("recipe_image", recipe.getImageUrl());
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_swipe, container, false);
            TextView title = (TextView) rootView.findViewById(R.id.recipe_title);
            ListView ingredients = (ListView) rootView.findViewById(R.id.recipe_ingredients);
            ImageView imageView = (ImageView) rootView.findViewById(R.id.recipe_image);

            //Add title
            title.setText(getArguments().getString("recipe_title"));

            //Add String array
            String[] values =  getArguments().getStringArray("recipe_ingredients");
            ArrayAdapter<String> itemsAdapter =  new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1);
            itemsAdapter.addAll(values);
            ingredients.setAdapter(itemsAdapter);

            //Add image
            Glide.with(getActivity()).load(getArguments().getString("recipe_image")).into(imageView);

            return rootView;
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PlaceholderFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return recipes.size();
        }
    }

}
