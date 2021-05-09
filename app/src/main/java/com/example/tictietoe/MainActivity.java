package com.example.tictietoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // 0 is x , 1 is O
    int activePlayer = 0;
    boolean gameActive = true;
    int[] gameState = {2,2,2,2,2,2,2,2,2};
    int[][] winningPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{0,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void appear (View view) {
        ImageView counter = (ImageView) view;
        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if (gameState[tappedCounter] == 2 && gameActive) {
            gameState[tappedCounter] = activePlayer;
            counter.setVisibility(View.VISIBLE);
            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.x);
                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.o);
                activePlayer = 0;
            }

            counter.setVisibility(View.VISIBLE);
            for (int[] winningPosition : winningPositions) {
                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[0]] != 2) {
                    String winner = " ";
                    gameActive = false;
                    if (activePlayer == 0) {
                        winner = "X ";
                    } else {
                        winner = "O ";
                    }
                    Button button = (Button) findViewById(R.id.button);
                    button.setVisibility(View.VISIBLE);
                    TextView winnerTextView = (TextView) findViewById(R.id.textView2);
                    winnerTextView.setVisibility(View.VISIBLE);
                    winnerTextView.setText(winner + "has won");
                }
            }
        }
    }
    public void playAgain (View view){
        activePlayer = 0;
        gameActive = true;
        Button button = (Button) findViewById(R.id.button);
        TextView winnerTextView = (TextView) findViewById(R.id.textView2);
        button.setVisibility(View.INVISIBLE);
        winnerTextView.setVisibility(View.INVISIBLE);
        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);
        for (int i = 0; i <= gridLayout.getChildCount(); i ++){
            ImageView counter = (ImageView) gridLayout.getChildAt(i);
            counter.setImageDrawable(null);}
        for (int j=0; j<gameState.length;j++){
            gameState[j] = 2;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
        }

