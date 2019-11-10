package com.bliepy.bucketlistapp;

import android.arch.lifecycle.Observer;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bliepy.bucketlistapp.store.BucketlistModel;
import com.bliepy.bucketlistapp.store.BucketlistView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton button;
    private View popupInputDialogView;

    private EditText infoInput;
    private EditText groupInput;
    private CheckBox doneInput;
    private Button buttonDialog;

    private AlertDialog alertDialog;
    private BucketlistView viewModel;
    private RecyclerView recyclerView;
    private BucketlistAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new BucketlistView(getApplicationContext());
        adapter = new BucketlistAdapter();

        recyclerView = findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layout = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layout);
        recyclerView.setAdapter(adapter);

        viewModel.list().observe(this, new Observer<List<BucketlistModel>>() {
            @Override
            public void onChanged(@Nullable List<BucketlistModel> model) {
                adapter.setList(model);
                adapter.notifyDataSetChanged();
            }
        });

        LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
        popupInputDialogView = layoutInflater.inflate(R.layout.bucket_list_popup_dialog, null);

        button = (FloatingActionButton) findViewById(R.id.fab);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);

                // Init popup dialog view and it's ui controls.
                groupInput = popupInputDialogView.findViewById(R.id.group);
                infoInput = popupInputDialogView.findViewById(R.id.info);
                doneInput = popupInputDialogView.findViewById(R.id.done);
                buttonDialog = popupInputDialogView.findViewById(R.id.button);

                // Set the inflated layout view object to the AlertDialog builder.
                if (popupInputDialogView.getParent() != null)
                    ((ViewGroup) popupInputDialogView.getParent()).removeView(popupInputDialogView);
                alertDialogBuilder.setView(popupInputDialogView);

                // Create AlertDialog and show.
                alertDialog = alertDialogBuilder.create();
                alertDialog.show();

                buttonDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String group = groupInput.getText().toString();
                        String info = infoInput.getText().toString();
                        boolean done = doneInput.isChecked();

                        BucketlistModel model = new BucketlistModel();
                        model.setBucketGroup(group);
                        model.setBucketItem(info);
                        model.setDone(done);

                        viewModel.insert(model);
                        alertDialog.cancel();
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }


    class BucketlistAdapter extends RecyclerView.Adapter<BucketlistAdapter.ViewHolder> {

        public List<BucketlistModel> list = new ArrayList<>();

        @NonNull
        @Override
        public BucketlistAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            View view = inflater.inflate(R.layout.bucket_list_item, viewGroup, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final BucketlistAdapter.ViewHolder viewHolder, int i) {
            final BucketlistModel model = list.get(i);

            boolean checked = viewHolder.done.isChecked();

            viewHolder.group.setText(model.getBucketGroup());
            viewHolder.info.setText(model.getBucketItem());
            viewHolder.done.setChecked(model.isDone());

            if (checked) {
                viewHolder.info.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                viewHolder.group.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            }

            viewHolder.remove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewModel.delete(model);
                }
            });


            viewHolder.done.setOnCheckedChangeListener(
                    new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (isChecked) {
                                viewHolder.info.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                                viewHolder.group.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                            } else {
                                viewHolder.info.setPaintFlags(viewHolder.info.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                                viewHolder.group.setPaintFlags(viewHolder.group.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                            }
                        }
                    }
            );
        }

        public void setList(List<BucketlistModel> models) {
            this.list = models;
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            public TextView info, group;
            public CardView card;
            public CheckBox done;
            public ImageButton remove;

            public ViewHolder(@NonNull View view) {
                super(view);
                info = view.findViewById(R.id.info);
                group = view.findViewById(R.id.group);
                done = view.findViewById(R.id.done);
                card = view.findViewById(R.id.card);
                remove = view.findViewById(R.id.remove);
            }
        }
    }
}
