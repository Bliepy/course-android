package com.bliepy;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private SwipeAdapter mAdapterSwipe;

    private RecyclerView.LayoutManager mLayoutManager;

    private List<SwipeImage> mSwipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        mSwipe = SwipeImage.demoData();

        mRecyclerView = findViewById(R.id.recyclerView);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapterSwipe = new SwipeAdapter(mSwipe);
        mRecyclerView.setAdapter(mAdapterSwipe);


        ItemTouchHelper.SimpleCallback touch = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder

                    target) {

                return false;

            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                //Get the index corresponding to the selected position
                int position = (viewHolder.getAdapterPosition());
                SwipeImage image = mSwipe.get(position);

                if (image.isImageEurope()) {
                    if (direction == ItemTouchHelper.LEFT ) {
                        Toast.makeText(MainActivity.this, "GOOD", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "WRONG", Toast.LENGTH_SHORT).show();
                    }

                } else {

                    if (direction != ItemTouchHelper.RIGHT ) {
                        Toast.makeText(MainActivity.this, "GOOD", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "WRONG", Toast.LENGTH_SHORT).show();
                    }
                }

                mSwipe.remove(position);
                mAdapterSwipe.notifyItemRemoved(position);
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(touch);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);
        updateUI();
    }

    private void updateUI() {

        if (mAdapterSwipe == null) {
            mAdapterSwipe = new SwipeAdapter(mSwipe);
            mRecyclerView.setAdapter(mAdapterSwipe);

        } else {
            mAdapterSwipe.notifyDataSetChanged();
        }
    }
}
