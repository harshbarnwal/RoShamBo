package com.example.android.roshambo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random randy;
    int i_randy;
    String s_randy, s_user;
    TextView t_display_text;
    TextView t_result_display;
    TextView t_wins;
    int i_wins = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t_display_text = (TextView)findViewById(R.id.display_text);
        t_result_display = (TextView)findViewById(R.id.result_display);
        t_wins = (TextView)findViewById(R.id.wins_count);
        t_display_text.setVisibility(View.GONE);
        t_result_display.setVisibility(View.GONE);

    }

    //creating a random number and selecting one out of 3 outcome
    public void randomselect() {

        //creating new random number
        randy = new Random();
        //assigning random number to integer
        i_randy = 1+randy.nextInt(3);

        //using that random number to select one outcome
        switch (i_randy) {

            case 1 :
                s_randy = "Rock";
                break;

            case 2 :
                s_randy = "Paper";
                break;

            case 3 :
                s_randy = "Scissor";
                break;

        }
    }

    public void imageclick(View view) {

        randomselect();

        //using switch to show output
        switch(view.getId()) {

            case R.id.rock :
                s_user = "Rock";
                //tricks
                if(s_randy.equals("Rock")) {
                    t_display_text.setText("Android has Chosen Rock");
                    t_result_display.setText("Result : It's a tie");
                }
                else if (s_randy.equals("Paper")){
                    t_display_text.setText("Android has Chosen Paper");
                    t_result_display.setText("Result : You lose");
                    i_wins--;
                }
                else if(s_randy.equals("Scissor")){
                    t_display_text.setText("Android has Chosen Scissor");
                    t_result_display.setText("Result : You Win");
                    i_wins++;
                }
                break;

            case R.id.paper :
                s_user = "Paper";
                //tricks
                if(s_randy.equals("Rock")) {
                    t_display_text.setText("Android has Chosen Rock");
                    t_result_display.setText("Result : You Win");
                    i_wins++;
                }
                else if (s_randy.equals("Paper")){
                    t_display_text.setText("Android has Chosen Paper");
                    t_result_display.setText("Result : It's a tie");
                }
                else if(s_randy.equals("Scissor")){
                    t_display_text.setText("Android has Chosen Scissor");
                    t_result_display.setText("Result : You lose");
                    i_wins--;
                }
                break;

            case R.id.scissor :
                s_user = "Scissor";
                //tricks
                if(s_randy.equals("Rock")) {
                    t_display_text.setText("Android has Chosen Rock");
                    t_result_display.setText("Result : You Lose");
                    i_wins--;
                }
                else if (s_randy.equals("Paper")){
                    t_display_text.setText("Android has Chosen Paper");
                    t_result_display.setText("Result : You Win");
                    i_wins++;
                }
                else if(s_randy.equals("Scissor")){
                    t_display_text.setText("Android has Chosen Scissor");
                    t_result_display.setText("Result : It's a tie");
                }
                break;
        }

        t_display_text.setVisibility(View.VISIBLE);
        t_result_display.setVisibility(View.VISIBLE);
        t_wins.setText(Integer.toString(i_wins));

    }

}
