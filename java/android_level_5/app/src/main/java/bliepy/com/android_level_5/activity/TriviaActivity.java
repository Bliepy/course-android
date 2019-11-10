package bliepy.com.android_level_5.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

//Web-service
import java.util.ArrayList;
import java.util.List;

import bliepy.com.android_level_5.R;
import bliepy.com.android_level_5.adapter.TriviaAdapter;
import bliepy.com.android_level_5.service.TriviaRestServiceImpl;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import bliepy.com.android_level_5.model.TriviaModel;

public class TriviaActivity extends AppCompatActivity {

    private ArrayList<TriviaModel> listTrivia = new ArrayList();
    private RecyclerView recyclerView;
    private TriviaAdapter triviaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivia);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.trivia_list_view);

        //set layout
        RecyclerView.LayoutManager layout = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layout);

        //set adapter
        triviaAdapter = new TriviaAdapter(listTrivia);
        recyclerView.setAdapter(triviaAdapter);

        FloatingActionButton refresh = findViewById(R.id.trivia_refresh);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestTriviaData();

            }
        });
    }

    private void requestTriviaData() {
        TriviaRestServiceImpl triviaService = new TriviaRestServiceImpl();
        triviaService.callTriviaService(this).enqueue(new Callback<TriviaModel>() {

            @Override
            public void onResponse(Call<TriviaModel> call, Response<TriviaModel> response) {

                if (response.isSuccessful()) {

                    TriviaModel triviaItem = response.body();
                        listTrivia.add(0,triviaItem);
                        triviaAdapter.notifyDataSetChanged();
                } else {
                    System.out.println("Unsuccesfull");
                }
            }

            @Override
            public void onFailure(Call<TriviaModel> call, Throwable t) {
                System.out.println("Call failed");
            }
        });
    }
}
