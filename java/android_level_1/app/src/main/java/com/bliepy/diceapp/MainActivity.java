package com.bliepy.diceapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ArrayAdapter listAdapter;
    private ImageButton lowerButton ;
    private ImageButton higherButton;
    private ImageView dice ;
    private TextView score;
    private TextView highscore;


    private static int highScoreCount= 0;
    private static int scoreCount = 0;
    private static int previousDiceNumber = 1;
    private static int diceNumber = 0;
    private static ArrayList items = new ArrayList<>();

    final int[] diceImageNames =  new int[] {R.drawable.d1,R.drawable.d2,R.drawable.d3,R.drawable.d4,R.drawable.d5,R.drawable.d6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Higher - lower app");

        lowerButton = (ImageButton) findViewById(R.id.buttonLower);
        higherButton = (ImageButton) findViewById(R.id.buttonHigher);
        dice = (ImageView) findViewById(R.id.imageDice);
        score = (TextView) findViewById(R.id.textScore);
        highscore = (TextView) findViewById(R.id.textHighScore);
        ListView list = (ListView) findViewById(R.id.list);
        listAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, items);
        list.setAdapter(listAdapter);

        lowerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                diceNumber = rollDice();
                dice.setImageResource(diceImageNames[diceNumber-1]);

                if(diceNumber < previousDiceNumber){
                    scoreCount++;
                    score.setText(scoreCount+"");
                    highscore.setText(highScoreCount+"");
                    Toast toast = Toast.makeText(getApplicationContext(), "WINNER!" , Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();


                }else {
                    scoreCount = 0;
                    score.setText(scoreCount+"");
                    highscore.setText(highScoreCount+"");

                    Toast toast = Toast.makeText(getApplicationContext(), "LOSER!" , Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }


                if(scoreCount > highScoreCount) {
                    highScoreCount = scoreCount;
                    items.add("new Highscore: " + highScoreCount);

                    listAdapter.notifyDataSetChanged();


                    Toast toast = Toast.makeText(getApplicationContext(), "New HighScore!" , Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }

                previousDiceNumber = diceNumber;

            }
        });


        higherButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                diceNumber = rollDice();
                dice.setImageResource(diceImageNames[diceNumber-1]);

                if(diceNumber > previousDiceNumber){
                    scoreCount++;
                    score.setText(scoreCount+"");
                    highscore.setText(highScoreCount+"");

                    Toast toast = Toast.makeText(getApplicationContext(), "WINNER!" , Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();

                }else {
                    scoreCount = 0;
                    score.setText(scoreCount+"");
                    highscore.setText(highScoreCount+"");

                    Toast toast = Toast.makeText(getApplicationContext(), "LOSER!" , Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();                }


                if(scoreCount > highScoreCount) {
                    highScoreCount = scoreCount;
                    items.add("new Highscore: " + highScoreCount);

                    listAdapter.notifyDataSetChanged();

                    Toast toast = Toast.makeText(getApplicationContext(), "New HighScore!" , Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
                previousDiceNumber = diceNumber;
            }
        });

    }

    private int rollDice(){
        Random random = new  Random();
        int number = random.nextInt(6)+1;
        return number;
    }
}
