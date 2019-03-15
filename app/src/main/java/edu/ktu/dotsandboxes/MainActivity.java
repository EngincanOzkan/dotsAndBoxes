package edu.ktu.dotsandboxes;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static myString fetchedData;

    private int responseCode;

    private int blueScore = 0;
    private int redScore = 0;
    private int player = 1;

    private Drawable bluedrawable;
    private Drawable reddrawable;
    private Drawable dotteddrawable;

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

    private ImageView player1arrow;
    private ImageView player2arrow;

    private String playerType;

    private box box1 = new box();
    private box box2 = new box();
    private box box3 = new box();
    private box box4 = new box();
    private box box5 = new box();
    private box box6 = new box();
    private box box7 = new box();
    private box box8 = new box();
    private box box9 = new box();

    public void ComputerTurn(){
        int[] totalBox = new int[9];
        //this are calculating how many wall changed from 0 to 1 and its summing filled walls
        totalBox[0] = (box1.getWall1() != 0 ? 1 : 0) + (box1.getWall2() != 0 ? 1 : 0) + (box1.getWall3() != 0 ? 1 : 0) + (box1.getWall4() != 0 ? 1 : 0);
        totalBox[1] = (box2.getWall1() != 0 ? 1 : 0) + (box2.getWall2() != 0 ? 1 : 0) + (box2.getWall3() != 0 ? 1 : 0) + (box2.getWall4() != 0 ? 1 : 0);
        totalBox[2] = (box3.getWall1() != 0 ? 1 : 0) + (box3.getWall2() != 0 ? 1 : 0) + (box3.getWall3() != 0 ? 1 : 0) + (box3.getWall4() != 0 ? 1 : 0);
        totalBox[3] = (box4.getWall1() != 0 ? 1 : 0) + (box4.getWall2() != 0 ? 1 : 0) + (box4.getWall3() != 0 ? 1 : 0) + (box4.getWall4() != 0 ? 1 : 0);
        totalBox[4] = (box5.getWall1() != 0 ? 1 : 0) + (box5.getWall2() != 0 ? 1 : 0) + (box5.getWall3() != 0 ? 1 : 0) + (box5.getWall4() != 0 ? 1 : 0);
        totalBox[5] = (box6.getWall1() != 0 ? 1 : 0) + (box6.getWall2() != 0 ? 1 : 0) + (box6.getWall3() != 0 ? 1 : 0) + (box6.getWall4() != 0 ? 1 : 0);
        totalBox[6] = (box7.getWall1() != 0 ? 1 : 0) + (box7.getWall2() != 0 ? 1 : 0) + (box7.getWall3() != 0 ? 1 : 0) + (box7.getWall4() != 0 ? 1 : 0);
        totalBox[7] = (box8.getWall1() != 0 ? 1 : 0) + (box8.getWall2() != 0 ? 1 : 0) + (box8.getWall3() != 0 ? 1 : 0) + (box8.getWall4() != 0 ? 1 : 0);
        totalBox[8] = (box9.getWall1() != 0 ? 1 : 0) + (box9.getWall2() != 0 ? 1 : 0) + (box9.getWall3() != 0 ? 1 : 0) + (box9.getWall4() != 0 ? 1 : 0);

        if(totalBox[0] != 4 ||
                totalBox[1] != 4 ||
                totalBox[2] != 4 ||
                totalBox[3] != 4 ||
                totalBox[4] != 4 ||
                totalBox[5] != 4 ||
                totalBox[6] != 4 ||
                totalBox[7] != 4 ||
                totalBox[8] != 4
                ) {
            int maxNearlyFinishedBox = 0;
            int nearlyFinishedBoxesCounter = 0;
            int[] nearlyFinishedBoxes = new int[9];
            for (int i = 0; i < 9; i++) {
                if (maxNearlyFinishedBox < totalBox[i] && totalBox[i] < 4) {
                    maxNearlyFinishedBox = totalBox[i];
                }
            }

            for (int i = 0; i < 9; i++) {
                if (maxNearlyFinishedBox == totalBox[i]) {
                    nearlyFinishedBoxes[nearlyFinishedBoxesCounter] = i + 1;
                    nearlyFinishedBoxesCounter++;
                }
            }

            Random rnd = new Random();
            int selectedBox = rnd.nextInt(nearlyFinishedBoxesCounter);
            int selectedWall = rnd.nextInt(4) + 1;
            switch (nearlyFinishedBoxes[selectedBox]) {
                case 1:
                    while (selectedWall > 0) {
                        if (box1.getWall1() == 0 && selectedWall == 1) {
                            selectedWall = 0;
                            w1_box1.performClick();
                            break;
                        } else if (box1.getWall2() == 0 && selectedWall == 2) {
                            selectedWall = 0;
                            w2_box1_w4_box2.performClick();
                            break;
                        } else if (box1.getWall3() == 0 && selectedWall == 3) {
                            selectedWall = 0;
                            w1_box4_w3_box1.performClick();
                            break;
                        } else if (box1.getWall4() == 0 && selectedWall == 4) {
                            selectedWall = 0;
                            w4_box1.performClick();
                            break;
                        } else {
                            selectedWall = rnd.nextInt(4) + 1;
                            Log.d("selectedbox", "box1");
                            Log.d("selectedWall", String.valueOf(selectedWall));
                            Log.d("Wall1", String.valueOf(box1.getWall1()));
                            Log.d("Wall2", String.valueOf(box1.getWall2()));
                            Log.d("Wall3", String.valueOf(box1.getWall3()));
                            Log.d("Wall4", String.valueOf(box1.getWall4()));
                        }
                    }
                    break;

                case 2:
                    while (selectedWall > 0) {
                        if (box2.getWall1() == 0 && selectedWall == 1) {
                            selectedWall = 0;
                            w1_box2.performClick();
                            break;
                        } else if (box2.getWall2() == 0 && selectedWall == 2) {
                            selectedWall = 0;
                            w2_box2_w4_box3.performClick();
                            break;
                        } else if (box2.getWall3() == 0 && selectedWall == 3) {
                            selectedWall = 0;
                            w1_box5_w3_box2.performClick();
                            break;
                        } else if (box2.getWall4() == 0 && selectedWall == 4) {
                            selectedWall = 0;
                            w2_box1_w4_box2.performClick();
                            break;
                        } else {
                            selectedWall = rnd.nextInt(4) + 1;
                            Log.d("selectedbox", "box2");
                            Log.d("selectedWall", String.valueOf(selectedWall));
                            Log.d("Wall1", String.valueOf(box2.getWall1()));
                            Log.d("Wall2", String.valueOf(box2.getWall2()));
                            Log.d("Wall3", String.valueOf(box2.getWall3()));
                            Log.d("Wall4", String.valueOf(box2.getWall4()));
                        }

                    }
                    break;

                case 3:
                    while (selectedWall > 0) {
                        if (box3.getWall1() == 0 && selectedWall == 1) {
                            selectedWall = 0;
                            w1_box3.performClick();
                            break;
                        } else if (box3.getWall2() == 0 && selectedWall == 2) {
                            selectedWall = 0;
                            w2_box3.performClick();
                            break;
                        } else if (box3.getWall3() == 0 && selectedWall == 3) {
                            selectedWall = 0;
                            w1_box6_w3_box3.performClick();
                            break;
                        } else if (box3.getWall4() == 0 && selectedWall == 4) {
                            selectedWall = 0;
                            w2_box2_w4_box3.performClick();
                            break;
                        } else {
                            selectedWall = rnd.nextInt(4) + 1;
                            Log.d("selectedbox", "box3");
                            Log.d("selectedWall", String.valueOf(selectedWall));
                            Log.d("Wall1", String.valueOf(box3.getWall1()));
                            Log.d("Wall2", String.valueOf(box3.getWall2()));
                            Log.d("Wall3", String.valueOf(box3.getWall3()));
                            Log.d("Wall4", String.valueOf(box3.getWall4()));
                        }

                    }
                    break;

                case 4:
                    while (selectedWall > 0) {
                        if (box4.getWall1() == 0 && selectedWall == 1) {
                            selectedWall = 0;
                            w1_box4_w3_box1.performClick();
                            break;
                        } else if (box4.getWall2() == 0 && selectedWall == 2) {
                            selectedWall = 0;
                            w2_box4_w4_box5.performClick();
                            break;
                        } else if (box4.getWall3() == 0 && selectedWall == 3) {
                            selectedWall = 0;
                            w1_box7_w3_box4.performClick();
                            break;
                        } else if (box4.getWall4() == 0 && selectedWall == 4) {
                            selectedWall = 0;
                            w4_box4.performClick();
                            break;
                        } else {
                            selectedWall = rnd.nextInt(4) + 1;
                            Log.d("selectedbox", "box4");
                            Log.d("selectedWall", String.valueOf(selectedWall));
                            Log.d("Wall1", String.valueOf(box4.getWall1()));
                            Log.d("Wall2", String.valueOf(box4.getWall2()));
                            Log.d("Wall3", String.valueOf(box4.getWall3()));
                            Log.d("Wall4", String.valueOf(box4.getWall4()));
                        }

                    }
                    break;

                case 5:
                    while (selectedWall > 0) {
                        if (box5.getWall1() == 0 && selectedWall == 1) {
                            selectedWall = 0;
                            w1_box5_w3_box2.performClick();
                            break;
                        } else if (box5.getWall2() == 0 && selectedWall == 2) {
                            selectedWall = 0;
                            w2_box5_w4_box6.performClick();
                            break;
                        } else if (box5.getWall3() == 0 && selectedWall == 3) {
                            selectedWall = 0;
                            w1_box8_w3_box5.performClick();
                            break;
                        } else if (box5.getWall4() == 0 && selectedWall == 4) {
                            selectedWall = 0;
                            w2_box4_w4_box5.performClick();
                            break;
                        } else {
                            selectedWall = rnd.nextInt(4) + 1;
                            Log.d("selectedbox", "box5");
                            Log.d("selectedWall", String.valueOf(selectedWall));
                            Log.d("Wall1", String.valueOf(box5.getWall1()));
                            Log.d("Wall2", String.valueOf(box5.getWall2()));
                            Log.d("Wall3", String.valueOf(box5.getWall3()));
                            Log.d("Wall4", String.valueOf(box5.getWall4()));
                        }

                    }
                    break;

                case 6:
                    while (selectedWall > 0) {
                        if (box6.getWall1() == 0 && selectedWall == 1) {
                            selectedWall = 0;
                            w1_box6_w3_box3.performClick();
                            break;
                        } else if (box6.getWall2() == 0 && selectedWall == 2) {
                            selectedWall = 0;
                            w2_box6.performClick();
                            break;
                        } else if (box6.getWall3() == 0 && selectedWall == 3) {
                            selectedWall = 0;
                            w1_box9_w3_box6.performClick();
                            break;
                        } else if (box6.getWall4() == 0 && selectedWall == 4) {
                            selectedWall = 0;
                            w2_box5_w4_box6.performClick();
                            break;
                        } else {
                            selectedWall = rnd.nextInt(4) + 1;
                            Log.d("selectedbox", "box6");
                            Log.d("selectedWall", String.valueOf(selectedWall));
                            Log.d("Wall1", String.valueOf(box6.getWall1()));
                            Log.d("Wall2", String.valueOf(box6.getWall2()));
                            Log.d("Wall3", String.valueOf(box6.getWall3()));
                            Log.d("Wall4", String.valueOf(box6.getWall4()));
                        }

                    }
                    break;

                case 7:
                    while (selectedWall > 0) {
                        if (box7.getWall1() == 0 && selectedWall == 1) {
                            selectedWall = 0;
                            w1_box7_w3_box4.performClick();
                            break;
                        } else if (box7.getWall2() == 0 && selectedWall == 2) {
                            selectedWall = 0;
                            w2_box7_w4_box8.performClick();
                            break;
                        } else if (box7.getWall3() == 0 && selectedWall == 3) {
                            selectedWall = 0;
                            w3_box7.performClick();
                            break;
                        } else if (box7.getWall4() == 0 && selectedWall == 4) {
                            selectedWall = 0;
                            w4_box7.performClick();
                            break;
                        } else {
                            selectedWall = rnd.nextInt(4) + 1;
                            Log.d("selectedbox", "box7");
                            Log.d("selectedWall", String.valueOf(selectedWall));
                            Log.d("Wall1", String.valueOf(box7.getWall1()));
                            Log.d("Wall2", String.valueOf(box7.getWall2()));
                            Log.d("Wall3", String.valueOf(box7.getWall3()));
                            Log.d("Wall4", String.valueOf(box7.getWall4()));
                        }

                    }
                    break;

                case 8:
                    while (selectedWall > 0) {
                        if (box8.getWall1() == 0 && selectedWall == 1) {
                            selectedWall = 0;
                            w1_box8_w3_box5.performClick();
                            break;
                        } else if (box8.getWall2() == 0 && selectedWall == 2) {
                            selectedWall = 0;
                            w2_box8_w4_box9.performClick();
                            break;
                        } else if (box8.getWall3() == 0 && selectedWall == 3) {
                            selectedWall = 0;
                            w3_box8.performClick();
                            break;
                        } else if (box8.getWall4() == 0 && selectedWall == 4) {
                            selectedWall = 0;
                            w2_box7_w4_box8.performClick();
                            break;
                        } else {
                            selectedWall = rnd.nextInt(4) + 1;
                            Log.d("selectedbox", "box8");
                            Log.d("selectedWall", String.valueOf(selectedWall));
                            Log.d("Wall1", String.valueOf(box8.getWall1()));
                            Log.d("Wall2", String.valueOf(box8.getWall2()));
                            Log.d("Wall3", String.valueOf(box8.getWall3()));
                            Log.d("Wall4", String.valueOf(box8.getWall4()));
                        }

                    }
                    break;

                case 9:
                    while (selectedWall > 0) {
                        if (box9.getWall1() == 0 && selectedWall == 1) {
                            selectedWall = 0;
                            w1_box9_w3_box6.performClick();
                            break;
                        } else if (box9.getWall2() == 0 && selectedWall == 2) {
                            selectedWall = 0;
                            w2_box9.performClick();
                            break;
                        } else if (box9.getWall3() == 0 && selectedWall == 3) {
                            selectedWall = 0;
                            w3_box9.performClick();
                            break;
                        } else if (box9.getWall4() == 0 && selectedWall == 4) {
                            selectedWall = 0;
                            w2_box8_w4_box9.performClick();
                            break;
                        } else {
                            selectedWall = rnd.nextInt(4) + 1;
                            Log.d("selectedbox", "box9");
                            Log.d("selectedWall", String.valueOf(selectedWall));
                            Log.d("Wall1", String.valueOf(box9.getWall1()));
                            Log.d("Wall2", String.valueOf(box9.getWall2()));
                            Log.d("Wall3", String.valueOf(box9.getWall3()));
                            Log.d("Wall4", String.valueOf(box9.getWall4()));
                        }

                    }
                    break;
            }
        }

    }

    myString.ChangeListener fetchedDataListener = new myString.ChangeListener() {
        @Override
        public void onChange() {
            //smt
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fetchedData = new myString();
        fetchedData.setListener(fetchedDataListener);

        hideNavigationBar();

        //Line Button drawables
        bluedrawable = getDrawable(R.drawable.bluebuttonhorizontal);
        reddrawable = getDrawable(R.drawable.redbuttonhorizontal);
        dotteddrawable = getDrawable(R.drawable.dottedbuttonhorizontal);

        //get player type
        Intent intent = getIntent();
        playerType = intent.getStringExtra("playerTYPE");

        txt_blueScore = (TextView)findViewById(R.id.text_player_blue);
        txt_redScore = (TextView)findViewById(R.id.text_player_red);

        player1arrow = (ImageView)findViewById(R.id.player1arrow);
        player2arrow = (ImageView)findViewById(R.id.player2arrow);

        player1arrow.setVisibility(View.VISIBLE);
        player2arrow.setVisibility(View.INVISIBLE);

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

                player1arrow.setVisibility(View.VISIBLE);
                player2arrow.setVisibility(View.INVISIBLE);

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

                w1_box1.setBackground(dotteddrawable);
                w1_box2.setBackground(dotteddrawable);
                w1_box3.setBackground(dotteddrawable);
                w4_box1.setBackground(dotteddrawable);
                w2_box1_w4_box2.setBackground(dotteddrawable);
                w2_box2_w4_box3.setBackground(dotteddrawable);
                w2_box3.setBackground(dotteddrawable);
                w1_box4_w3_box1.setBackground(dotteddrawable);
                w1_box5_w3_box2.setBackground(dotteddrawable);
                w1_box6_w3_box3.setBackground(dotteddrawable);
                w2_box4_w4_box5.setBackground(dotteddrawable);
                w2_box5_w4_box6.setBackground(dotteddrawable);
                w2_box6.setBackground(dotteddrawable);
                w1_box7_w3_box4.setBackground(dotteddrawable);
                w1_box8_w3_box5.setBackground(dotteddrawable);
                w1_box9_w3_box6.setBackground(dotteddrawable);
                w4_box7.setBackground(dotteddrawable);
                w2_box7_w4_box8.setBackground(dotteddrawable);
                w2_box8_w4_box9.setBackground(dotteddrawable);
                w2_box9.setBackground(dotteddrawable);
                w3_box7.setBackground(dotteddrawable);
                w3_box8.setBackground(dotteddrawable);
                w4_box4.setBackground(dotteddrawable);
                w3_box9.setBackground(dotteddrawable);


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
                    w1_box1.setBackground(bluedrawable);
                }else
                {
                    w1_box1.setBackground(reddrawable);
                }

                w1_box1.setEnabled(false);
                if(blocked!=0){
                    if(blocked == 1){
                        box1btn.setBackgroundColor(getResources().getColor(R.color.myred));
                        setBlueScore();
                    }else {
                        box1btn.setBackgroundColor(getResources().getColor(R.color.myred));
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
                    w1_box2.setBackground(bluedrawable);
                }else
                {
                    w1_box2.setBackground(reddrawable);
                }

                w1_box2.setEnabled(false);
                if(blocked!=0){
                    if(blocked == 1){
                        box2btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                        setBlueScore();
                    }else {
                        box2btn.setBackgroundColor(getResources().getColor(R.color.myred));
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
                    w1_box3.setBackground(bluedrawable);
                }else
                {
                    w1_box3.setBackground(reddrawable);
                }

                w1_box3.setEnabled(false);
                if(blocked!=0){
                    if(blocked == 1){
                        box3btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                        setBlueScore();
                    }else {
                        box3btn.setBackgroundColor(getResources().getColor(R.color.myred));
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
                    w4_box1.setBackground(bluedrawable);
                }else
                {
                    w4_box1.setBackground(reddrawable);
                }

                w4_box1.setEnabled(false);
                if(blocked!=0){
                    if(blocked == 1){
                        box1btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                        setBlueScore();
                    }else {
                        box1btn.setBackgroundColor(getResources().getColor(R.color.myred));
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
                    w4_box4.setBackground(bluedrawable);
                }else
                {
                    w4_box4.setBackground(reddrawable);
                }

                w4_box4.setEnabled(false);
                if(blocked!=0){
                    if(blocked == 1){
                        box4btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                        setBlueScore();
                    }else {
                        box4btn.setBackgroundColor(getResources().getColor(R.color.myred));
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
                    w2_box1_w4_box2.setBackground(bluedrawable);
                }else
                {
                    w2_box1_w4_box2.setBackground(reddrawable);
                }

                int blocked = box1.getwhowin();

                if(blocked!=0){
                    if(blocked == 1){
                        box1btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                        setBlueScore();
                    }else {
                        box1btn.setBackgroundColor(getResources().getColor(R.color.myred));
                        setRedScore();
                    }
                }

                blocked = box2.getwhowin();

                if(blocked!=0){
                    if(blocked == 1){
                        box2btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                        setBlueScore();
                    }else {
                        box2btn.setBackgroundColor(getResources().getColor(R.color.myred));
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
                    w2_box2_w4_box3.setBackground(bluedrawable);
                }else
                {
                    w2_box2_w4_box3.setBackground(reddrawable);
                }

                int blocked = box2.getwhowin();

                if(blocked!=0){
                    if(blocked == 1){
                        box2btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                        setBlueScore();
                    }else {
                        box2btn.setBackgroundColor(getResources().getColor(R.color.myred));
                        setRedScore();
                    }
                }

                blocked = box3.getwhowin();

                if(blocked!=0){
                    if(blocked == 1){
                        box3btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                        setBlueScore();
                    }else {
                        box3btn.setBackgroundColor(getResources().getColor(R.color.myred));
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
                    w2_box3.setBackground(bluedrawable);
                }else
                {
                    w2_box3.setBackground(reddrawable);
                }

                w2_box3.setEnabled(false);
                if(blocked!=0){
                    if(blocked == 1){
                        box3btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                        setBlueScore();
                    }else {
                        box3btn.setBackgroundColor(getResources().getColor(R.color.myred));
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
                    w1_box4_w3_box1.setBackground(bluedrawable);
                }else
                {
                    w1_box4_w3_box1.setBackground(reddrawable);
                }

                int blocked = box4.getwhowin();

                if(blocked!=0){
                    if(blocked == 1){
                        box4btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                        setBlueScore();
                    }else {
                        box4btn.setBackgroundColor(getResources().getColor(R.color.myred));
                        setRedScore();
                    }
                }

                blocked = box1.getwhowin();

                if(blocked!=0){
                    if(blocked == 1){
                        box1btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                        setBlueScore();
                    }else {
                        box1btn.setBackgroundColor(getResources().getColor(R.color.myred));
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
                    w1_box5_w3_box2.setBackground(bluedrawable);
                }else
                {
                    w1_box5_w3_box2.setBackground(reddrawable);
                }

                int blocked = box5.getwhowin();

                if(blocked!=0){
                    if(blocked == 1){
                        box5btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                        setBlueScore();
                    }else {
                        box5btn.setBackgroundColor(getResources().getColor(R.color.myred));
                        setRedScore();
                    }
                }

                blocked = box2.getwhowin();

                if(blocked!=0){
                    if(blocked == 1){
                        box2btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                        setBlueScore();
                    }else {
                        box2btn.setBackgroundColor(getResources().getColor(R.color.myred));
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
                    w1_box6_w3_box3.setBackground(bluedrawable);
                }else
                {
                    w1_box6_w3_box3.setBackground(reddrawable);
                }

                int blocked = box6.getwhowin();

                if(blocked!=0){
                    if(blocked == 1){
                        box6btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                        setBlueScore();
                    }else {
                        box6btn.setBackgroundColor(getResources().getColor(R.color.myred));
                        setRedScore();
                    }
                }

                blocked = box3.getwhowin();

                if(blocked!=0){
                    if(blocked == 1){
                        box3btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                        setBlueScore();
                    }else {
                        box3btn.setBackgroundColor(getResources().getColor(R.color.myred));
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
                    w2_box4_w4_box5.setBackground(bluedrawable);
                }else
                {
                    w2_box4_w4_box5.setBackground(reddrawable);
                }

                int blocked = box4.getwhowin();

                if(blocked!=0){
                    if(blocked == 1){
                        box4btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                        setBlueScore();
                    }else {
                        box4btn.setBackgroundColor(getResources().getColor(R.color.myred));
                        setRedScore();
                    }
                }

                blocked = box5.getwhowin();

                if(blocked!=0){
                    if(blocked == 1){
                        box5btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                        setBlueScore();
                    }else {
                        box5btn.setBackgroundColor(getResources().getColor(R.color.myred));
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
                    w2_box5_w4_box6.setBackground(bluedrawable);
                }else
                {
                    w2_box5_w4_box6.setBackground(reddrawable);
                }


                int blocked = box5.getwhowin();

                if(blocked!=0){
                    if(blocked == 1){
                        box5btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                        setBlueScore();
                    }else {
                        box5btn.setBackgroundColor(getResources().getColor(R.color.myred));
                        setRedScore();
                    }
                }

                blocked = box6.getwhowin();

                if(blocked!=0){
                    if(blocked == 1){
                        box6btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                        setBlueScore();
                    }else {
                        box6btn.setBackgroundColor(getResources().getColor(R.color.myred));
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
                    w2_box6.setBackground(bluedrawable);
                }else
                {
                    w2_box6.setBackground(reddrawable);
                }

                int blocked = box6.getwhowin();


                if(blocked!=0){
                    if(blocked == 1){
                        box6btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                        setBlueScore();
                    }else {
                        box6btn.setBackgroundColor(getResources().getColor(R.color.myred));
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
                    w1_box7_w3_box4.setBackground(bluedrawable);
                }else
                {
                    w1_box7_w3_box4.setBackground(reddrawable);
                }

                int blocked = box7.getwhowin();

                if(blocked!=0){
                    if(blocked == 1){
                        box7btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                        setBlueScore();
                    }else {
                        box7btn.setBackgroundColor(getResources().getColor(R.color.myred));
                        setRedScore();
                    }
                }

                blocked = box4.getwhowin();

                if(blocked!=0){
                    if(blocked == 1){
                        box4btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                        setBlueScore();
                    }else {
                        box4btn.setBackgroundColor(getResources().getColor(R.color.myred));
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
                    w1_box8_w3_box5.setBackground(bluedrawable);
                }else
                {
                    w1_box8_w3_box5.setBackground(reddrawable);
                }

                int blocked = box8.getwhowin();

                if(blocked!=0){
                    if(blocked == 1){
                        box8btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                        setBlueScore();
                    }else {
                        box8btn.setBackgroundColor(getResources().getColor(R.color.myred));
                        setRedScore();
                    }
                }

                blocked = box5.getwhowin();

                if(blocked!=0){
                    if(blocked == 1){
                        box5btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                        setBlueScore();
                    }else {
                        box5btn.setBackgroundColor(getResources().getColor(R.color.myred));
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
                    w1_box9_w3_box6.setBackground(bluedrawable);
                }else
                {
                    w1_box9_w3_box6.setBackground(reddrawable);
                }

                int blocked = box9.getwhowin();

                if(blocked!=0){
                    if(blocked == 1){
                        box9btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                        setBlueScore();
                    }else {
                        box9btn.setBackgroundColor(getResources().getColor(R.color.myred));
                        setRedScore();
                    }
                }

                blocked = box6.getwhowin();

                if(blocked!=0){
                    if(blocked == 1){
                        box6btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                        setBlueScore();
                    }else {
                        box6btn.setBackgroundColor(getResources().getColor(R.color.myred));
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
                    w4_box7.setBackground(bluedrawable);
                }else
                {
                    w4_box7.setBackground(reddrawable);
                }

                int blocked = box7.getwhowin();


                if(blocked!=0){
                    if(blocked == 1){
                        box7btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                        setBlueScore();
                    }else {
                        box7btn.setBackgroundColor(getResources().getColor(R.color.myred));
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
                    w2_box7_w4_box8.setBackground(bluedrawable);
                }else
                {
                    w2_box7_w4_box8.setBackground(reddrawable);
                }

                int blocked = box7.getwhowin();

                if(blocked!=0){
                    if(blocked == 1){
                        box7btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                        setBlueScore();
                    }else {
                        box7btn.setBackgroundColor(getResources().getColor(R.color.myred));
                        setRedScore();
                    }
                }

                blocked = box8.getwhowin();

                if(blocked!=0){
                    if(blocked == 1){
                        box8btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                        setBlueScore();
                    }else {
                        box8btn.setBackgroundColor(getResources().getColor(R.color.myred));
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
                    w2_box8_w4_box9.setBackground(bluedrawable);
                }else
                {
                    w2_box8_w4_box9.setBackground(reddrawable);
                }

                int blocked = box8.getwhowin();

                if(blocked!=0){
                    if(blocked == 1){
                        box8btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                        setBlueScore();
                    }else {
                        box8btn.setBackgroundColor(getResources().getColor(R.color.myred));
                        setRedScore();
                    }
                }

                blocked = box9.getwhowin();

                if(blocked!=0){
                    if(blocked == 1){
                        box9btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                        setBlueScore();
                    }else {
                        box9btn.setBackgroundColor(getResources().getColor(R.color.myred));
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
                    w2_box9.setBackground(bluedrawable);
                }else
                {
                    w2_box9.setBackground(reddrawable);
                }


                int blocked = box9.getwhowin();

                if(blocked!=0){
                    if(blocked == 1){
                        box9btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                        setBlueScore();
                    }else {
                        box9btn.setBackgroundColor(getResources().getColor(R.color.myred));
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
                    w3_box7.setBackground(bluedrawable);
                }else
                {
                    w3_box7.setBackground(reddrawable);
                }

                int blocked = box7.getwhowin();


                if(blocked!=0){
                    if(blocked == 1){
                        box7btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                        setBlueScore();
                    }else {
                        box7btn.setBackgroundColor(getResources().getColor(R.color.myred));
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
                    w3_box8.setBackground(bluedrawable);
                }else
                {
                    w3_box8.setBackground(reddrawable);
                }

                int blocked = box8.getwhowin();


                if(blocked!=0){
                    if(blocked == 1){
                        box8btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                        setBlueScore();
                    }else {
                        box8btn.setBackgroundColor(getResources().getColor(R.color.myred));
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
                    w3_box9.setBackground(bluedrawable);
                }else
                {
                    w3_box9.setBackground(reddrawable);
                }


                int blocked = box9.getwhowin();
                if(blocked!=0){
                    if(blocked == 1){
                        box9btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                        setBlueScore();
                    }else {
                        box9btn.setBackgroundColor(getResources().getColor(R.color.myred));
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
        if(player == 1) {
            player1arrow.setVisibility(View.VISIBLE);
            player2arrow.setVisibility(View.INVISIBLE);
           // txt_blueScore.setTextColor(Color.BLUE);
           // txt_redScore.setTextColor(Color.BLACK);
        }
        else {
            player1arrow.setVisibility(View.INVISIBLE);
            player2arrow.setVisibility(View.VISIBLE);
            //txt_redScore.setTextColor(Color.RED);
            //txt_blueScore.setTextColor(Color.BLACK);
        }

        if(playerType.equals("1") && player == 2){
            ComputerTurn();
        }else if(playerType.equals("3")){

        }
    }

    public void setBlueScore(){
        blueScore+=1;
        txt_blueScore.setText("Blue Player: " + blueScore);

    }

    public void setRedScore(){
        redScore+=1;
        txt_redScore.setText(" Red Player: " + redScore);
    }

    @Override
    public void onResume(){
        super.onResume();

        hideNavigationBar();
    }

    private void hideNavigationBar(){
        this.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN |
                                            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                                            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                                            View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                                            View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
    }
}