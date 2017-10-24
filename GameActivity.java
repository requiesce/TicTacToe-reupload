package com.example.x.tictactoe;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class GameActivity extends AppCompatActivity {
    char player = 'X'; // game initialises with player X
    Button button1, button2, button3, button4, button5, button6, button7, button8, button9;
    int currentArrayPosition1, currentArrayPosition2;
    char[][] gameArray= new char[][] {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
    };

    // 2-dimensional gameArray[][]
    //  { 00, 01, 02 }
    //  { 10, 11, 12 }
    //  { 20, 21, 22 }

    // button layout
    // 1 2 3
    // 4 5 6
    // 7 8 9

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_game);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentArrayPosition1 = 0;
                currentArrayPosition2 = 0;

                // disables button to prevent double input
                button1.setEnabled(false);

                // passes input to array, checks for win
                gameArray = setMark(player, button1, gameArray, currentArrayPosition1, currentArrayPosition2);

                // switches to other player for input
                player = changePlayer(player);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentArrayPosition1 = 0;
                currentArrayPosition2 = 1;
                button2.setEnabled(false);
                gameArray = setMark(player, button2, gameArray, currentArrayPosition1, currentArrayPosition2);
                player = changePlayer(player);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentArrayPosition1 = 0;
                currentArrayPosition2 = 2;
                button3.setEnabled(false);
                gameArray = setMark(player, button3, gameArray, currentArrayPosition1, currentArrayPosition2);
                player = changePlayer(player);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentArrayPosition1 = 1;
                currentArrayPosition2 = 0;
                button4.setEnabled(false);
                gameArray = setMark(player, button4, gameArray, currentArrayPosition1, currentArrayPosition2);
                player = changePlayer(player);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentArrayPosition1 = 1;
                currentArrayPosition2 = 1;
                button5.setEnabled(false);
                gameArray = setMark(player, button5, gameArray, currentArrayPosition1, currentArrayPosition2);
                player = changePlayer(player);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentArrayPosition1 = 1;
                currentArrayPosition2 = 2;
                button6.setEnabled(false);
                gameArray = setMark(player, button6, gameArray, currentArrayPosition1, currentArrayPosition2);
                player = changePlayer(player);
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentArrayPosition1 = 2;
                currentArrayPosition2 = 0;
                button7.setEnabled(false);
                gameArray = setMark(player, button7, gameArray, currentArrayPosition1, currentArrayPosition2);
                player = changePlayer(player);
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentArrayPosition1 = 2;
                currentArrayPosition2 = 1;
                button8.setEnabled(false);
                gameArray = setMark(player, button8, gameArray, currentArrayPosition1, currentArrayPosition2);
                player = changePlayer(player);
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentArrayPosition1 = 2;
                currentArrayPosition2 = 2;
                button9.setEnabled(false);
                gameArray = setMark(player, button9, gameArray, currentArrayPosition1, currentArrayPosition2);
                player = changePlayer(player);
            }
        });
    }

    // passes input to array
    private char[][] setMark(char player, Button button, char gameArray[][], int currentArrayPosition1, int currentArrayPosition2) {
        if (button.getText().toString().equals("")) {
            char setArray;
            if (player == 'X') {
                button.setText("X");
                setArray = 'X';
            } else /*if player =='O'*/ {
                button.setText("O");
                setArray = 'O';
            }
            gameArray[currentArrayPosition1][currentArrayPosition2] = setArray;

            // checks for win
            checkWin(gameArray);
        }
        return gameArray;
    }

    // checks for win
    private char[][] checkWin(char gameArray[][]) {
        if ((gameArray[0][0] == gameArray[0][1]) && (gameArray[0][1] == gameArray[0][2])) {
            //button1.setText(gameArray[0][0] + " wins"); // tests row 0
            button1.setTextColor(getResources().getColor(R.color.colorAccent));
            button2.setTextColor(getResources().getColor(R.color.colorAccent));
            button3.setTextColor(getResources().getColor(R.color.colorAccent));
            winSound();
            winMessage(player);
        }
        else if ((gameArray[1][0] == gameArray[1][1]) && (gameArray[1][1] == gameArray[1][2])) {
            //button1.setText(gameArray[1][0] + " wins"); // tests row 1
            button4.setTextColor(getResources().getColor(R.color.colorAccent));
            button5.setTextColor(getResources().getColor(R.color.colorAccent));
            button6.setTextColor(getResources().getColor(R.color.colorAccent));
            winSound();
            winMessage(player);
        }
        else if ((gameArray[2][0] == gameArray[2][1]) && (gameArray[2][1] == gameArray[2][2])) {
            //button1.setText(gameArray[2][0] + " wins"); // tests row 2
            button7.setTextColor(getResources().getColor(R.color.colorAccent));
            button8.setTextColor(getResources().getColor(R.color.colorAccent));
            button9.setTextColor(getResources().getColor(R.color.colorAccent));
            winSound();
            winMessage(player);
        }
        else if ((gameArray[0][0] == gameArray[1][0]) && (gameArray[1][0] == gameArray[2][0])) {
            //button1.setText(gameArray[0][0] + " wins"); // tests column 0
            button1.setTextColor(getResources().getColor(R.color.colorAccent));
            button4.setTextColor(getResources().getColor(R.color.colorAccent));
            button7.setTextColor(getResources().getColor(R.color.colorAccent));
            winSound();
            winMessage(player);
        }
        else if ((gameArray[0][1] == gameArray[1][1]) && (gameArray[1][1] == gameArray[2][1])) {
            //button1.setText(gameArray[0][1] + " wins"); // tests column 1
            button2.setTextColor(getResources().getColor(R.color.colorAccent));
            button5.setTextColor(getResources().getColor(R.color.colorAccent));
            button8.setTextColor(getResources().getColor(R.color.colorAccent));
            winSound();
            winMessage(player);
        }
        else if ((gameArray[0][2] == gameArray[1][2]) && (gameArray[1][2] == gameArray[2][2])) {
            //button1.setText(gameArray[0][2] + " wins"); // tests column 2
            button3.setTextColor(getResources().getColor(R.color.colorAccent));
            button6.setTextColor(getResources().getColor(R.color.colorAccent));
            button9.setTextColor(getResources().getColor(R.color.colorAccent));
            winSound();
            winMessage(player);
        }
        else if ((gameArray[0][0] == gameArray[1][1]) && (gameArray[1][1] == gameArray[2][2])) {
            //button1.setText(gameArray[0][0] + " wins"); // tests diagonal L->R
            button1.setTextColor(getResources().getColor(R.color.colorAccent));
            button5.setTextColor(getResources().getColor(R.color.colorAccent));
            button9.setTextColor(getResources().getColor(R.color.colorAccent));
            winSound();
            winMessage(player);
        }
        else if ((gameArray[0][2] == gameArray[1][1]) && (gameArray[1][1] == gameArray[2][0])) {
            //button1.setText(gameArray[0][2] + " wins"); // tests diagonal R->L
            button3.setTextColor(getResources().getColor(R.color.colorAccent));
            button5.setTextColor(getResources().getColor(R.color.colorAccent));
            button7.setTextColor(getResources().getColor(R.color.colorAccent));
            winSound();
            winMessage(player);
        }
        else if ((gameArray[0][0] != 1) && (gameArray[0][1] != 2) && (gameArray[0][2] != 3) &&
                (gameArray[1][0] != 4) && (gameArray[1][1] != 5) && (gameArray[1][2] != 6) &&
                (gameArray[2][0] != 7) && (gameArray[2][1] != 8) && (gameArray[2][2] != 9)) {
                                                          // tests for draw against initialised variables
            drawMessage();
        }
        return gameArray;
    }

    // plays sound on win
    private void winSound() {
        final MediaPlayer soundWin = MediaPlayer.create(this, R.raw.sound_win);
        soundWin.start();
    }

    // shows message on win
    private void winMessage(char winner) {
        /*AlertDialog.Builder winnerAlert = new AlertDialog.Builder(this);
        winnerAlert.setMessage("Player " + winner + " wins!");
        AlertDialog alert = winnerAlert.create();
        alert.show();*/

        /*Toast toast = Toast.makeText(this, "Player " + winner + " wins!", Toast.LENGTH_LONG);
        toast.show();
        disableButtons();*/

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Player " + winner + " wins!");
        builder.setCancelable(true);
        builder.setNegativeButton("End", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                dialogInterface.cancel();
                finish();   // closes activity
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();



        /* final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // delay following action by 5 seconds
                finish();
            }
        }, 5000); */


    }

    // shows message on draw
    private void drawMessage() {
        AlertDialog.Builder drawAlert = new AlertDialog.Builder(this);
        drawAlert.setMessage("Nobody wins!");
        AlertDialog alert = drawAlert.create();   // LENGTH_LONG toast
        alert.show();
        finish();
    }

    // disables all buttons after game is won
    private void disableButtons() {
        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);
        button4.setEnabled(false);
        button5.setEnabled(false);
        button6.setEnabled(false);
        button7.setEnabled(false);
        button8.setEnabled(false);
        button9.setEnabled(false);
    }

    // switches to other player for input
    private char changePlayer(char player) {
        if (player == 'X') {
            player = 'O';
        }
        else /*if (player == 'O')*/ {
            player = 'X';
        }
        return player;
    }
}


