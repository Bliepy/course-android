package bliepy.com.android_level_4;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import bliepy.com.android_level_4.database.GameBacklogModel;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItem ();
                Intent intent = new Intent(getApplicationContext(), OverviewActivity.class);
                startActivity(intent);
            }
        });
    }


    public void addItem (){
        TextView titleView = findViewById(R.id.overviewTitle);
        TextView platformView = findViewById(R.id.textView1);
        TextView noteView = findViewById(R.id.textView2);
        TextView playView = findViewById(R.id.textView3);

        String title = titleView.getText().toString();
        String platform = platformView.getText().toString();
        String note = noteView.getText().toString();
        String play = playView.getText().toString();

        GameBacklogModel model = new GameBacklogModel();
        model.setTitle(title);
        model.setPlatform(platform);
        model.setNotes(note);
        model.setPlatform(play);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
