package edu.ktu.dotsandboxes;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int blueScore = 0;
    private int redScore = 0;
    private int player = 1;

    private TextView txt_blueScore;
    private TextView txt_redScore;

    private Button btn_reset;

    private Button w1_box1;
    private Button w1_box2;
    private Button w1_box3;
    private Button w4_box1;
    private Button w2_box1_w4_box2;
    private Button w2_box2_w4_box3;
    private Button w2_box3;
    private Button w1_box4_w3_box1;
    private Button w1_box5_w3_box2;
    private Button w1_box6_w3_box3;
    private Button w4_box2;
    private Button w2_box4_w4_box5;
    private Button w2_box5_w4_box6;
    private Button w2_box6;
    private Button w1_box7_w3_box4;
    private Button w1_box8_w3_box5;
    private Button w1_box9_w3_box6;
    private Button w4_box7;
    private Button w2_box7_w4_box8;
    private Button w2_box8_w4_box9;
    private Button w2_box9;
    private Button w3_box7;
    private Button w3_box8;
    private Button w3_box9;
    private Button w4_box4;

    private Button box1btn;
    private Button box2btn;
    private Button box3btn;
    private Button box4btn;
    private Button box5btn;
    private Button box6btn;
    private Button box7btn;
    private Button box8btn;
    private Button box9btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_blueScore = (TextView)findViewById(R.id.text_player_blue);
        txt_redScore = (TextView)findViewById(R.id.text_player_red);

        final box box1 = new box();
        final box box2 = new box();
        final box box3 = new box();
        final box box4 = new box();
        final box box5 = new box();
        final box box6 = new box();
        final box box7 = new box();
        final box box8 = new box();
        final box box9 = new box();

        btn_reset = (Button) findViewById(R.id.btn_reset) ;

        box1btn = (Button) findViewById(R.id.box_1) ;
        box2btn = (Button) findViewById(R.id.box_2) ;
        box3btn = (Button) findViewById(R.id.box_3) ;
        box4btn = (Button) findViewById(R.id.box_4) ;
        box5btn = (Button) findViewById(R.id.box_5) ;
        box6btn = (Button) findViewById(R.id.box_6) ;
        box7btn = (Button) findViewById(R.id.box_7) ;
        box8btn = (Button) findViewById(R.id.box_8) ;
        box9btn = (Button) findViewById(R.id.box_9) ;

        w1_box1 = (Button) findViewById(R.id.w1_box1) ;
        w1_box2 = (Button) findViewById(R.id.w1_box2) ;
        w1_box3 = (Button) findViewById(R.id.w1_box3) ;
        w4_box1 = (Button) findViewById(R.id.w4_box1) ;
        w2_box1_w4_box2 = (Button) findViewById(R.id.w2_box1_w4_box2) ;
        w2_box2_w4_box3 = (Button) findViewById(R.id.w2_box2_w4_box3) ;
        w2_box3 = (Button) findViewById(R.id.w2_box3) ;
        w1_box4_w3_box1 = (Button) findViewById(R.id.w1_box4_w3_box1) ;
        w1_box5_w3_box2 = (Button) findViewById(R.id.w1_box5_w3_box2) ;
        w1_box6_w3_box3 = (Button) findViewById(R.id.w1_box6_w3_box3) ;
        w2_box4_w4_box5 = (Button) findViewById(R.id.w2_box4_w4_box5) ;
        w2_box5_w4_box6 = (Button) findViewById(R.id.w2_box5_w4_box6) ;
        w2_box6 = (Button) findViewById(R.id.w2_box6) ;
        w1_box7_w3_box4 = (Button) findViewById(R.id.w1_box7_w3_box4) ;
        w1_box8_w3_box5 = (Button) findViewById(R.id.w1_box8_w3_box5) ;
        w1_box9_w3_box6 = (Button) findViewById(R.id.w1_box9_w3_box6) ;
        w4_box7 = (Button) findViewById(R.id.w4_box7) ;
        w2_box7_w4_box8 = (Button) findViewById(R.id.w2_box7_w4_box8) ;
        w2_box8_w4_box9 = (Button) findViewById(R.id.w2_box8_w4_box9) ;
        w2_box9 = (Button) findViewById(R.id.w2_box9) ;
        w3_box7 = (Button) findViewById(R.id.w3_box7) ;
        w3_box8 = (Button) findViewById(R.id.w3_box8) ;
        w3_box9 = (Button) findViewById(R.id.w3_box9) ;
        w4_box4 = (Button) findViewById(R.id.w4_box4) ;

        btn_reset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                player = 1;

                txt_blueScore.setText("Blue Player: 0");
                txt_redScore.setText(" Red Player: 0");

                blueScore = 0;
                redScore = 0;

                w1_box1.setEnabled(true);
                w1_box2.setEnabled(true);
                w1_box3.setEnabled(true);
                w4_box1.setEnabled(true);
                w2_box1_w4_box2.setEnabled(true);
                w2_box2_w4_box3.setEnabled(true);
                w2_box3.setEnabled(true);
                w1_box4_w3_box1.setEnabled(true);
                w1_box5_w3_box2.setEnabled(true);
                w1_box6_w3_box3.setEnabled(true);
                w2_box4_w4_box5.setEnabled(true);
                w2_box5_w4_box6.setEnabled(true);
                w2_box6.setEnabled(true);
                w1_box7_w3_box4.setEnabled(true);
                w1_box8_w3_box5.setEnabled(true);
                w1_box9_w3_box6.setEnabled(true);
                w4_box7.setEnabled(true);
                w2_box7_w4_box8.setEnabled(true);
                w2_box8_w4_box9.setEnabled(true);
                w2_box9.setEnabled(true);
                w3_box7.setEnabled(true);
                w3_box8.setEnabled(true);
                w3_box9.setEnabled(true);
                w4_box4.setEnabled(true);

                w1_box1.setBackgroundColor(Color.GRAY);
                w1_box2.setBackgroundColor(Color.GRAY);
                w1_box3.setBackgroundColor(Color.GRAY);
                w4_box1.setBackgroundColor(Color.GRAY);
                w2_box1_w4_box2.setBackgroundColor(Color.GRAY);
                w2_box2_w4_box3.setBackgroundColor(Color.GRAY);
                w2_box3.setBackgroundColor(Color.GRAY);
                w1_box4_w3_box1.setBackgroundColor(Color.GRAY);
                w1_box5_w3_box2.setBackgroundColor(Color.GRAY);
                w1_box6_w3_box3.setBackgroundColor(Color.GRAY);
                w2_box4_w4_box5.setBackgroundColor(Color.GRAY);
                w2_box5_w4_box6.setBackgroundColor(Color.GRAY);
                w2_box6.setBackgroundColor(Color.GRAY);
                w1_box7_w3_box4.setBackgroundColor(Color.GRAY);
                w1_box8_w3_box5.setBackgroundColor(Color.GRAY);
                w1_box9_w3_box6.setBackgroundColor(Color.GRAY);
                w4_box7.setBackgroundColor(Color.GRAY);
                w2_box7_w4_box8.setBackgroundColor(Color.GRAY);
                w2_box8_w4_box9.setBackgroundColor(Color.GRAY);
                w2_box9.setBackgroundColor(Color.GRAY);
                w3_box7.setBackgroundColor(Color.GRAY);
                w3_box8.setBackgroundColor(Color.GRAY);
                w3_box9.setBackgroundColor(Color.GRAY);
                w4_box4.setBackgroundColor(Color.GRAY);

                box1.setReset();
                box2.setReset();
                box3.setReset();
                box4.setReset();
                box5.setReset();
                box6.setReset();
                box7.setReset();
                box8.setReset();
                box9.setReset();

                box1btn.setBackgroundColor(Color.WHITE);
                box2btn.setBackgroundColor(Color.WHITE);
                box3btn.setBackgroundColor(Color.WHITE);
                box4btn.setBackgroundColor(Color.WHITE);
                box5btn.setBackgroundColor(Color.WHITE);
                box6btn.setBackgroundColor(Color.WHITE);
                box7btn.setBackgroundColor(Color.WHITE);
                box8btn.setBackgroundColor(Color.WHITE);
                box9btn.setBackgroundColor(Color.WHITE);

            }
        });

        w1_box1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int nextPlayerValue = box1.setWall1(player);
                int blocked = box1.getwhowin();

                if(player == 1)
                {
                    w1_box1.setBackgroundColor(Color.BLUE);
                }else
                {
                    w1_box1.setBackgroundColor(Color.RED);
                }

                w1_box1.setEnabled(false);
                if(blocked!=0){
                    if(blocked == 1){
                        box1btn.setBackgroundColor(Color.BLUE);
                        setBlueScore();
                    }else {
                        box1btn.setBackgroundColor(Color.RED);
                        setRedScore();
                    }
                }

                nextPlayer(nextPlayerValue);
                // Do something in response to button click
            }
        });

        w1_box2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int nextPlayerValue = box2.setWall1(player);

                int blocked = box2.getwhowin();

                if(player == 1)
                {
                    w1_box2.setBackgroundColor(Color.BLUE);
                }else
                {
                    w1_box2.setBackgroundColor(Color.RED);
                }

                w1_box2.setEnabled(false);
                if(blocked!=0){
                    if(blocked == 1){
                        box2btn.setBackgroundColor(Color.BLUE);
                        setBlueScore();
                    }else {
                        box2btn.setBackgroundColor(Color.RED);
                        setRedScore();
                    }
                }

                nextPlayer(nextPlayerValue);
                // Do something in response to button click
            }
        });

        w1_box3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int nextPlayerValue = box3.setWall1(player);
                int blocked = box3.getwhowin();

                if(player == 1)
                {
                    w1_box3.setBackgroundColor(Color.BLUE);
                }else
                {
                    w1_box3.setBackgroundColor(Color.RED);
                }

                w1_box3.setEnabled(false);
                if(blocked!=0){
                    if(blocked == 1){
                        box3btn.setBackgroundColor(Color.BLUE);
                        setBlueScore();
                    }else {
                        box3btn.setBackgroundColor(Color.RED);
                        setRedScore();
                    }
                }
                nextPlayer(nextPlayerValue);
                // Do something in response to button click
            }
        });

        w4_box1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int nextPlayerValue = box1.setWall4(player);
                int blocked = box1.getwhowin();

                if(player == 1)
                {
                    w4_box1.setBackgroundColor(Color.BLUE);
                }else
                {
                    w4_box1.setBackgroundColor(Color.RED);
                }

                w4_box1.setEnabled(false);
                if(blocked!=0){
                    if(blocked == 1){
                        box1btn.setBackgroundColor(Color.BLUE);
                        setBlueScore();
                    }else {
                        box1btn.setBackgroundColor(Color.RED);
                        setRedScore();
                    }
                }

                nextPlayer(nextPlayerValue);
                // Do something in response to button click
            }
        });

        w4_box4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int nextPlayerValue = box4.setWall4(player);
                int blocked = box4.getwhowin();

                if(player == 1)
                {
                    w4_box4.setBackgroundColor(Color.BLUE);
                }else
                {
                    w4_box4.setBackgroundColor(Color.RED);
                }

                w4_box4.setEnabled(false);
                if(blocked!=0){
                    if(blocked == 1){
                        box4btn.setBackgroundColor(Color.BLUE);
                        setBlueScore();
                    }else {
                        box4btn.setBackgroundColor(Color.RED);
                        setRedScore();
                    }
                }

                nextPlayer(nextPlayerValue);
                // Do something in response to button click
            }
        });



        w2_box1_w4_box2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int temp = player;

                int nextPlayerValue1 = box1.setWall2(player);
                int nextPlayerValue2 = box2.setWall4(player);

                int nextPlayerValue = 0;
                if(temp == nextPlayerValue1){
                    nextPlayerValue = nextPlayerValue1;
                }else if(temp == nextPlayerValue2){
                    nextPlayerValue = nextPlayerValue2;
                }else
                {
                    if(temp == 1) nextPlayerValue = 2;
                    else nextPlayerValue = 1;
                }

                w2_box1_w4_box2.setEnabled(false);
                if(player == 1)
                {
                    w2_box1_w4_box2.setBackgroundColor(Color.BLUE);
                }else
                {
                    w2_box1_w4_box2.setBackgroundColor(Color.RED);
                }

                int blocked = box1.getwhowin();

                if(blocked!=0){
                    if(blocked == 1){
                        box1btn.setBackgroundColor(Color.BLUE);
                        setBlueScore();
                    }else {
                        box1btn.setBackgroundColor(Color.RED);
                        setRedScore();
                    }
                }

                blocked = box2.getwhowin();

                if(blocked!=0){
                    if(blocked == 1){
                        box2btn.setBackgroundColor(Color.BLUE);
                        setBlueScore();
                    }else {
                        box2btn.setBackgroundColor(Color.RED);
                        setRedScore();
                    }
                }

                nextPlayer(nextPlayerValue);
                // Do something in response to button click
            }
        });
        w2_box2_w4_box3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int temp = player;

                int nextPlayerValue1 = box2.setWall2(player);
                int nextPlayerValue2 = box3.setWall4(player);

                int nextPlayerValue = 0;
                if(temp == nextPlayerValue1){
                    nextPlayerValue = nextPlayerValue1;
                }else if(temp == nextPlayerValue2){
                    nextPlayerValue = nextPlayerValue2;
                }else
                {
                    if(temp == 1) nextPlayerValue = 2;
                    else nextPlayerValue = 1;
                }

                w2_box2_w4_box3.setEnabled(false);
                if(player == 1)
                {
                    w2_box2_w4_box3.setBackgroundColor(Color.BLUE);
                }else
                {
                    w2_box2_w4_box3.setBackgroundColor(Color.RED);
                }

                int blocked = box2.getwhowin();

                if(blocked!=0){
                    if(blocked == 1){
                        box2btn.setBackgroundColor(Color.BLUE);
                        setBlueScore();
                    }else {
                        box2btn.setBackgroundColor(Color.RED);
                        setRedScore();
                    }
                }

                blocked = box3.getwhowin();

                if(blocked!=0){
                    if(blocked == 1){
                        box3btn.setBackgroundColor(Color.BLUE);
                        setBlueScore();
                    }else {
                        box3btn.setBackgroundColor(Color.RED);
                        setRedScore();
                    }
                }

                nextPlayer(nextPlayerValue);
                // Do something in response to button click
            }
        });
        w2_box3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int nextPlayerValue = box3.setWall2(player);

                int blocked = box3.getwhowin();

                if(player == 1)
                {
                    w2_box3.setBackgroundColor(Color.BLUE);
                }else
                {
                    w2_box3.setBackgroundColor(Color.RED);
                }

                w2_box3.setEnabled(false);
                if(blocked!=0){
                    if(blocked == 1){
                        box3btn.setBackgroundColor(Color.BLUE);
                        setBlueScore();
                    }else {
                        box3btn.setBackgroundColor(Color.RED);
                        setRedScore();
                    }
                }
                nextPlayer(nextPlayerValue);
                // Do something in response to button click
            }
        });

        w1_box4_w3_box1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int temp = player;

                int nextPlayerValue1 = box4.setWall1(player);
                int nextPlayerValue2 = box1.setWall3(player);

                int nextPlayerValue = 0;
                if(temp == nextPlayerValue1){
                    nextPlayerValue = nextPlayerValue1;
                }else if(temp == nextPlayerValue2){
                    nextPlayerValue = nextPlayerValue2;
                }else
                {
                    if(temp == 1) nextPlayerValue = 2;
                    else nextPlayerValue = 1;
                }

                w1_box4_w3_box1.setEnabled(false);
                if(player == 1)
                {
                    w1_box4_w3_box1.setBackgroundColor(Color.BLUE);
                }else
                {
                    w1_box4_w3_box1.setBackgroundColor(Color.RED);
                }

                int blocked = box4.getwhowin();

                if(blocked!=0){
                    if(blocked == 1){
                        box4btn.setBackgroundColor(Color.BLUE);
                        setBlueScore();
                    }else {
                        box4btn.setBackgroundColor(Color.RED);
                        setRedScore();
                    }
                }

                blocked = box1.getwhowin();

                if(blocked!=0){
                    if(blocked == 1){
                        box1btn.setBackgroundColor(Color.BLUE);
                        setBlueScore();
                    }else {
                        box1btn.setBackgroundColor(Color.RED);
                        setRedScore();
                    }
                }
                nextPlayer(nextPlayerValue);
                // Do something in response to button click
            }
        });

        w1_box5_w3_box2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int temp = player;

                int nextPlayerValue1 = box5.setWall1(player);
                int nextPlayerValue2 = box2.setWall3(player);

                int nextPlayerValue = 0;
                if(temp == nextPlayerValue1){
                    nextPlayerValue = nextPlayerValue1;
                }else if(temp == nextPlayerValue2){
                    nextPlayerValue = nextPlayerValue2;
                }else
                {
                    if(temp == 1) nextPlayerValue = 2;
                    else nextPlayerValue = 1;
                }

                w1_box5_w3_box2.setEnabled(false);
                if(player == 1)
                {
                    w1_box5_w3_box2.setBackgroundColor(Color.BLUE);
                }else
                {
                    w1_box5_w3_box2.setBackgroundColor(Color.RED);
                }

                int blocked = box5.getwhowin();

                if(blocked!=0){
                    if(blocked == 1){
                        box5btn.setBackgroundColor(Color.BLUE);
                        setBlueScore();
                    }else {
                        box5btn.setBackgroundColor(Color.RED);
                        setRedScore();
                    }
                }

                blocked = box2.getwhowin();

                if(blocked!=0){
                    if(blocked == 1){
                        box2btn.setBackgroundColor(Color.BLUE);
                        setBlueScore();
                    }else {
                        box2btn.setBackgroundColor(Color.RED);
                        setRedScore();
                    }
                }
                nextPlayer(nextPlayerValue);
                // Do something in response to button click
            }
        });
        w1_box6_w3_box3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int temp = player;

                int nextPlayerValue1 = box6.setWall1(player);
                int nextPlayerValue2 = box3.setWall3(player);

                int nextPlayerValue = 0;
                if(temp == nextPlayerValue1){
                    nextPlayerValue = nextPlayerValue1;
                }else if(temp == nextPlayerValue2){
                    nextPlayerValue = nextPlayerValue2;
                }else
                {
                    if(temp == 1) nextPlayerValue = 2;
                    else nextPlayerValue = 1;
                }

                w1_box6_w3_box3.setEnabled(false);
                if(player == 1)
                {
                    w1_box6_w3_box3.setBackgroundColor(Color.BLUE);
                }else
                {
                    w1_box6_w3_box3.setBackgroundColor(Color.RED);
                }

                int blocked = box6.getwhowin();

                if(blocked!=0){
                    if(blocked == 1){
                        box6btn.setBackgroundColor(Color.BLUE);
                        setBlueScore();
                    }else {
                        box6btn.setBackgroundColor(Color.RED);
                        setRedScore();
                    }
                }

                blocked = box3.getwhowin();

                if(blocked!=0){
                    if(blocked == 1){
                        box3btn.setBackgroundColor(Color.BLUE);
                        setBlueScore();
                    }else {
                        box3btn.setBackgroundColor(Color.RED);
                        setRedScore();
                    }
                }
                nextPlayer(nextPlayerValue);
                // Do something in response to button click
            }
        });

        w2_box4_w4_box5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int temp = player;

                int nextPlayerValue1 = box4.setWall2(player);
                int nextPlayerValue2 = box5.setWall4(player);

                int nextPlayerValue = 0;
                if(temp == nextPlayerValue1){
                    nextPlayerValue = nextPlayerValue1;
                }else if(temp == nextPlayerValue2){
                    nextPlayerValue = nextPlayerValue2;
                }else
                {
                    if(temp == 1) nextPlayerValue = 2;
                    else nextPlayerValue = 1;
                }

                w2_box4_w4_box5.setEnabled(false);
                if(player == 1)
                {
                    w2_box4_w4_box5.setBackgroundColor(Color.BLUE);
                }else
                {
                    w2_box4_w4_box5.setBackgroundColor(Color.RED);
                }

                int blocked = box4.getwhowin();

                if(blocked!=0){
                    if(blocked == 1){
                        box4btn.setBackgroundColor(Color.BLUE);
                        setBlueScore();
                    }else {
                        box4btn.setBackgroundColor(Color.RED);
                        setRedScore();
                    }
                }

                blocked = box5.getwhowin();

                if(blocked!=0){
                    if(blocked == 1){
                        box5btn.setBackgroundColor(Color.BLUE);
                        setBlueScore();
                    }else {
                        box5btn.setBackgroundColor(Color.RED);
                        setRedScore();
                    }
                }
                nextPlayer(nextPlayerValue);
                // Do something in response to button click
            }
        });
        w2_box5_w4_box6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int temp = player;

                int nextPlayerValue1 = box6.setWall4(player);
                int nextPlayerValue2 = box5.setWall2(player);

                int nextPlayerValue = 0;
                if(temp == nextPlayerValue1){
                    nextPlayerValue = nextPlayerValue1;
                }else if(temp == nextPlayerValue2){
                    nextPlayerValue = nextPlayerValue2;
                }else
                {
                    if(temp == 1) nextPlayerValue = 2;
                    else nextPlayerValue = 1;
                }

                w2_box5_w4_box6.setEnabled(false);

                if(player == 1)
                {
                    w2_box5_w4_box6.setBackgroundColor(Color.BLUE);
                }else
                {
                    w2_box5_w4_box6.setBackgroundColor(Color.RED);
                }


                int blocked = box5.getwhowin();

                if(blocked!=0){
                    if(blocked == 1){
                        box5btn.setBackgroundColor(Color.BLUE);
                        setBlueScore();
                    }else {
                        box5btn.setBackgroundColor(Color.RED);
                        setRedScore();
                    }
                }

                blocked = box6.getwhowin();

                if(blocked!=0){
                    if(blocked == 1){
                        box6btn.setBackgroundColor(Color.BLUE);
                        setBlueScore();
                    }else {
                        box6btn.setBackgroundColor(Color.RED);
                        setRedScore();
                    }
                }
                nextPlayer(nextPlayerValue);
                // Do something in response to button click
            }
        });

        w2_box6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int nextPlayerValue = box6.setWall2(player);


                w2_box6.setEnabled(false);
                if(player == 1)
                {
                    w2_box6.setBackgroundColor(Color.BLUE);
                }else
                {
                    w2_box6.setBackgroundColor(Color.RED);
                }

                int blocked = box6.getwhowin();


                if(blocked!=0){
                    if(blocked == 1){
                        box6btn.setBackgroundColor(Color.BLUE);
                        setBlueScore();
                    }else {
                        box6btn.setBackgroundColor(Color.RED);
                        setRedScore();
                    }
                }
                nextPlayer(nextPlayerValue);
                // Do something in response to button click
            }
        });

        w1_box7_w3_box4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int temp = player;
                int nextPlayerValue1 = box7.setWall1(player);
                int nextPlayerValue2 = box4.setWall3(player);

                int nextPlayerValue = 0;
                if(temp == nextPlayerValue1){
                    nextPlayerValue = nextPlayerValue1;
                }else if(temp == nextPlayerValue2){
                    nextPlayerValue = nextPlayerValue2;
                }else
                {
                    if(temp == 1) nextPlayerValue = 2;
                    else nextPlayerValue = 1;
                }

                w1_box7_w3_box4.setEnabled(false);
                if(player == 1)
                {
                    w1_box7_w3_box4.setBackgroundColor(Color.BLUE);
                }else
                {
                    w1_box7_w3_box4.setBackgroundColor(Color.RED);
                }

                int blocked = box7.getwhowin();

                if(blocked!=0){
                    if(blocked == 1){
                        box7btn.setBackgroundColor(Color.BLUE);
                        setBlueScore();
                    }else {
                        box7btn.setBackgroundColor(Color.RED);
                        setRedScore();
                    }
                }

                blocked = box4.getwhowin();

                if(blocked!=0){
                    if(blocked == 1){
                        box4btn.setBackgroundColor(Color.BLUE);
                        setBlueScore();
                    }else {
                        box4btn.setBackgroundColor(Color.RED);
                        setRedScore();
                    }
                }
                nextPlayer(nextPlayerValue);
                // Do something in response to button click
            }
        });
        w1_box8_w3_box5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int temp = player;

                int nextPlayerValue1 =  box8.setWall1(player);
                int nextPlayerValue2= box5.setWall3(player);

                int nextPlayerValue = 0;
                if(temp == nextPlayerValue1){
                    nextPlayerValue = nextPlayerValue1;
                }else if(temp == nextPlayerValue2){
                    nextPlayerValue = nextPlayerValue2;
                }else
                {
                    if(temp == 1) nextPlayerValue = 2;
                    else nextPlayerValue = 1;
                }

                w1_box8_w3_box5.setEnabled(false);
                if(player == 1)
                {
                    w1_box8_w3_box5.setBackgroundColor(Color.BLUE);
                }else
                {
                    w1_box8_w3_box5.setBackgroundColor(Color.RED);
                }

                int blocked = box8.getwhowin();

                if(blocked!=0){
                    if(blocked == 1){
                        box8btn.setBackgroundColor(Color.BLUE);
                        setBlueScore();
                    }else {
                        box8btn.setBackgroundColor(Color.RED);
                        setRedScore();
                    }
                }

                blocked = box5.getwhowin();

                if(blocked!=0){
                    if(blocked == 1){
                        box5btn.setBackgroundColor(Color.BLUE);
                        setBlueScore();
                    }else {
                        box5btn.setBackgroundColor(Color.RED);
                        setRedScore();
                    }
                }
                nextPlayer(nextPlayerValue);
                // Do something in response to button click
            }
        });
        w1_box9_w3_box6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int temp = player;

                int nextPlayerValue1 = box9.setWall1(player);
                int nextPlayerValue2 = box6.setWall3(player);

                int nextPlayerValue = 0;
                if(temp == nextPlayerValue1){
                    nextPlayerValue = nextPlayerValue1;
                }else if(temp == nextPlayerValue2){
                    nextPlayerValue = nextPlayerValue2;
                }else
                {
                    if(temp == 1) nextPlayerValue = 2;
                    else nextPlayerValue = 1;
                }

                w1_box9_w3_box6.setEnabled(false);
                if(player == 1)
                {
                    w1_box9_w3_box6.setBackgroundColor(Color.BLUE);
                }else
                {
                    w1_box9_w3_box6.setBackgroundColor(Color.RED);
                }

                int blocked = box9.getwhowin();

                if(blocked!=0){
                    if(blocked == 1){
                        box9btn.setBackgroundColor(Color.BLUE);
                        setBlueScore();
                    }else {
                        box9btn.setBackgroundColor(Color.RED);
                        setRedScore();
                    }
                }

                blocked = box6.getwhowin();

                if(blocked!=0){
                    if(blocked == 1){
                        box6btn.setBackgroundColor(Color.BLUE);
                        setBlueScore();
                    }else {
                        box6btn.setBackgroundColor(Color.RED);
                        setRedScore();
                    }
                }

                nextPlayer(nextPlayerValue);
                // Do something in response to button click
            }
        });
        w4_box7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int nextPlayerValue = box7.setWall4(player);

                w4_box7.setEnabled(false);
                if(player == 1)
                {
                    w4_box7.setBackgroundColor(Color.BLUE);
                }else
                {
                    w4_box7.setBackgroundColor(Color.RED);
                }

                int blocked = box7.getwhowin();


                if(blocked!=0){
                    if(blocked == 1){
                        box7btn.setBackgroundColor(Color.BLUE);
                        setBlueScore();
                    }else {
                        box7btn.setBackgroundColor(Color.RED);
                        setRedScore();
                    }
                }

                nextPlayer(nextPlayerValue);
                // Do something in response to button click
            }
        });

        w2_box7_w4_box8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int temp = player;

                int nextPlayerValue1 = box8.setWall4(player);
                int nextPlayerValue2 = box7.setWall2(player);

                int nextPlayerValue = 0;
                if(temp == nextPlayerValue1){
                    nextPlayerValue = nextPlayerValue1;
                }else if(temp == nextPlayerValue2){
                    nextPlayerValue = nextPlayerValue2;
                }else
                {
                    if(temp == 1) nextPlayerValue = 2;
                    else nextPlayerValue = 1;
                }

                w2_box7_w4_box8.setEnabled(false);
                if(player == 1)
                {
                    w2_box7_w4_box8.setBackgroundColor(Color.BLUE);
                }else
                {
                    w2_box7_w4_box8.setBackgroundColor(Color.RED);
                }

                int blocked = box7.getwhowin();

                if(blocked!=0){
                    if(blocked == 1){
                        box7btn.setBackgroundColor(Color.BLUE);
                        setBlueScore();
                    }else {
                        box7btn.setBackgroundColor(Color.RED);
                        setRedScore();
                    }
                }

                blocked = box8.getwhowin();

                if(blocked!=0){
                    if(blocked == 1){
                        box8btn.setBackgroundColor(Color.BLUE);
                        setBlueScore();
                    }else {
                        box8btn.setBackgroundColor(Color.RED);
                        setRedScore();
                    }
                }
                nextPlayer(nextPlayerValue);
                // Do something in response to button click
            }
        });

        w2_box8_w4_box9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int temp = player;

                int nextPlayerValue1 = box8.setWall2(player);
                int nextPlayerValue2 = box9.setWall4(player);

                int nextPlayerValue = 0;
                if(temp == nextPlayerValue1){
                    nextPlayerValue = nextPlayerValue1;
                }else if(temp == nextPlayerValue2){
                    nextPlayerValue = nextPlayerValue2;
                }else
                {
                    if(temp == 1) nextPlayerValue = 2;
                    else nextPlayerValue = 1;
                }

                w2_box8_w4_box9.setEnabled(false);
                if(player == 1)
                {
                    w2_box8_w4_box9.setBackgroundColor(Color.BLUE);
                }else
                {
                    w2_box8_w4_box9.setBackgroundColor(Color.RED);
                }

                int blocked = box8.getwhowin();

                if(blocked!=0){
                    if(blocked == 1){
                        box8btn.setBackgroundColor(Color.BLUE);
                        setBlueScore();
                    }else {
                        box8btn.setBackgroundColor(Color.RED);
                        setRedScore();
                    }
                }

                blocked = box9.getwhowin();

                if(blocked!=0){
                    if(blocked == 1){
                        box9btn.setBackgroundColor(Color.BLUE);
                        setBlueScore();
                    }else {
                        box9btn.setBackgroundColor(Color.RED);
                        setRedScore();
                    }
                }
                nextPlayer(nextPlayerValue);
               
            }
        });
        w2_box9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int nextPlayerValue = box9.setWall2(player);
                w2_box9.setEnabled(false);

                if(player == 1)
                {
                    w2_box9.setBackgroundColor(Color.BLUE);
                }else
                {
                    w2_box9.setBackgroundColor(Color.RED);
                }


                int blocked = box9.getwhowin();

                if(blocked!=0){
                    if(blocked == 1){
                        box9btn.setBackgroundColor(Color.BLUE);
                        setBlueScore();
                    }else {
                        box9btn.setBackgroundColor(Color.RED);
                        setRedScore();
                    }
                }

                nextPlayer(nextPlayerValue);
                // Do something in response to button click
            }
        });
        w3_box7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int nextPlayerValue = box7.setWall3(player);


                w3_box7.setEnabled(false);
                if(player == 1)
                {
                    w3_box7.setBackgroundColor(Color.BLUE);
                }else
                {
                    w3_box7.setBackgroundColor(Color.RED);
                }

                int blocked = box7.getwhowin();


                if(blocked!=0){
                    if(blocked == 1){
                        box7btn.setBackgroundColor(Color.BLUE);
                        setBlueScore();
                    }else {
                        box7btn.setBackgroundColor(Color.RED);
                        setRedScore();
                    }
                }
                nextPlayer(nextPlayerValue);
                // Do something in response to button click
            }
        });
        w3_box8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int nextPlayerValue = box8.setWall3(player);


                w3_box8.setEnabled(false);
                if(player == 1)
                {
                    w3_box8.setBackgroundColor(Color.BLUE);
                }else
                {
                    w3_box8.setBackgroundColor(Color.RED);
                }

                int blocked = box8.getwhowin();


                if(blocked!=0){
                    if(blocked == 1){
                        box8btn.setBackgroundColor(Color.BLUE);
                        setBlueScore();
                    }else {
                        box8btn.setBackgroundColor(Color.RED);
                        setRedScore();
                    }
                }

                nextPlayer(nextPlayerValue);
                // Do something in response to button click
            }
        });
        w3_box9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int nextPlayerValue = box9.setWall3(player);


                w3_box9.setEnabled(false);
                if(player == 1)
                {
                    w3_box9.setBackgroundColor(Color.BLUE);
                }else
                {
                    w3_box9.setBackgroundColor(Color.RED);
                }


                int blocked = box9.getwhowin();
                if(blocked!=0){
                    if(blocked == 1){
                        box9btn.setBackgroundColor(Color.BLUE);
                        setBlueScore();
                    }else {
                        box9btn.setBackgroundColor(Color.RED);
                        setRedScore();
                    }
                }

                nextPlayer(nextPlayerValue);
                // Do something in response to button click
            }
        });

    }

    //player must be 1 or 2
    public void nextPlayer(int nextPlayerValue){
        player = nextPlayerValue;
    }

    public void setBlueScore(){
        blueScore+=1;
        txt_blueScore.setText("Blue Player: " + blueScore);
    }

    public void setRedScore(){
        redScore+=1;
        txt_redScore.setText(" Red Player: " + redScore);
    }


}
