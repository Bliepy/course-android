package bliepy.com.android_level_4;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import bliepy.com.android_level_4.database.GameBacklogModel;

public class OverviewActivity extends AppCompatActivity {

    private List<GameBacklogModel> gameBacklogList = new ArrayList<>();
    private RecyclerView recyclerView;
    private OverviewAdapter triviaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        GameBacklogModel model = new GameBacklogModel();
        model.setTitle("test");
        model.setPlatform("test");
        model.setStatus("test");
        model.setDate("test");
        gameBacklogList.add(model);
        gameBacklogList.add(model);
        gameBacklogList.add(model);

        final OverviewAdapter adapter = new OverviewAdapter(gameBacklogList);
        recyclerView = findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layout = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layout);

        ItemTouchHelper.SimpleCallback swipDelete = new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                int position = viewHolder.getAdapterPosition();
                gameBacklogList.remove(position);
                adapter.notifyDataSetChanged();
            }


        };


        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(swipDelete);
        itemTouchHelper.attachToRecyclerView(recyclerView);
        recyclerView.setAdapter(adapter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddActivity.class);
                startActivity(intent);
                adapter.notifyDataSetChanged();
            }
        });
    }

    class OverviewAdapter extends RecyclerView.Adapter<OverviewAdapter.ViewHolder> {

        public List<GameBacklogModel> list;

        public OverviewAdapter(List<GameBacklogModel> list) {
            this.list = list;
        }

        @NonNull
        @Override
        public OverviewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            View view = inflater.inflate(R.layout.content_overview, viewGroup, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull OverviewAdapter.ViewHolder viewHolder, int i) {
            GameBacklogModel model = list.get(i);
            viewHolder.title.setText(model.getTitle());
            viewHolder.note.setText(model.getNotes());
            viewHolder.status.setText(model.getStatus());
            viewHolder.date.setText(model.getDate());
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

            public TextView title, note, status, date;

            public ViewHolder(@NonNull View view) {
                super(view);
                title = view.findViewById(R.id.overviewTitle);
                note = view.findViewById(R.id.textView1);
                status = view.findViewById(R.id.textView2);
                date = view.findViewById(R.id.textView3);
            }

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddActivity.class);
                startActivity(intent);
            }
        }
    }
}