package edu.ktu.dotsandboxes;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivityOnline extends AppCompatActivity {

    Context context;

    Toast toast;

    private int blueScore = 0;
    private int redScore = 0;
    private int player = 1;

    private Drawable bluedrawable;
    private Drawable reddrawable;
    private Drawable dotteddrawable;

    private TextView txt_blueScore;
    private TextView txt_redScore;

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

    public String BluePlayer;
    public String RedPlayer;

    public static myString checkUser;
    public static myString playerMove;
    public static myString playerLastMove;

    private String userid;
    private String connectedid;

    public int thatplayer;
    public int otherplayer;

    int connectedLastMove;

    boolean otherPlayerMoving = false;
    boolean otherPlayerMovingAction = false;
    public void OtherUserTurn(){
        if(connectedLastMove == 1) w1_box1.performClick();
        else if(connectedLastMove == 2) w2_box1_w4_box2.performClick();
        else if(connectedLastMove == 3) w1_box4_w3_box1 .performClick();
        else if(connectedLastMove == 4) w4_box1.performClick();
        else if(connectedLastMove == 5) w1_box2.performClick();
        else if(connectedLastMove == 6) w2_box2_w4_box3.performClick();
        else if(connectedLastMove == 7) w1_box5_w3_box2.performClick();
        else if(connectedLastMove == 8) w1_box3.performClick();
        else if(connectedLastMove == 9) w2_box3.performClick();
        else if(connectedLastMove == 10) w1_box6_w3_box3.performClick();
        else if(connectedLastMove == 11) w2_box4_w4_box5.performClick();
        else if(connectedLastMove == 12) w1_box7_w3_box4.performClick();
        else if(connectedLastMove == 13) w4_box4.performClick();
        else if(connectedLastMove == 14) w2_box5_w4_box6.performClick();
        else if(connectedLastMove == 15) w1_box8_w3_box5.performClick();
        else if(connectedLastMove == 16) w2_box6.performClick();
        else if(connectedLastMove == 17) w1_box9_w3_box6.performClick();
        else if(connectedLastMove == 18) w2_box7_w4_box8.performClick();
        else if(connectedLastMove == 19) w3_box7.performClick();
        else if(connectedLastMove == 20) w4_box7.performClick();
        else if(connectedLastMove == 21) w2_box8_w4_box9.performClick();
        else if(connectedLastMove == 22) w3_box8.performClick();
        else if(connectedLastMove == 23) w2_box9.performClick();
        else if(connectedLastMove == 24) w3_box9.performClick();
    }

    myString.ChangeListener fetchedCheckUser = new myString.ChangeListener() {
        @Override
        public void onChange() {
            try{
                JSONArray JA = new JSONArray(checkUser.isBoo());
                JSONObject JO = (JSONObject) JA.get(0);
                if(BluePlayer == null){
                    BluePlayer = JO.getString("username");
                    txt_blueScore.setText(BluePlayer +": 0");
                }else{
                    RedPlayer = JO.getString("username");
                    txt_redScore.setText(RedPlayer +": 0");
                }
                new Timer().schedule(new TimerTask(){
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable(){
                            @Override
                            public void run() {
                                if(otherPlayerMoving == true) {
                                    fetchOtherPlayerMove process = new fetchOtherPlayerMove();
                                    process.setRequestURL("http://10.0.2.2:8888/dotsandboxes/public/api/checkMove");
                                    process.setParamNames(new String[]{"userid"});
                                    process.setParamValues(new String[]{String.valueOf(GetOnlineActivity.connectedid)});
                                    process.execute();
                                }
                            };
                        });
                    }
                }, 0, 1000);
                new Timer().schedule(new TimerTask(){
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable(){
                            @Override
                            public void run() {
                                if(userid == "0") {
                                    Intent myIntent = new Intent(MainActivityOnline.this, MenuActivity.class);
                                    startActivity(myIntent);
                                }
                            };
                        });
                    }
                }, 0, 10);
            }catch(JSONException e){
                e.printStackTrace();
            }
        }
    };

    myString.ChangeListener fetchedUserMove= new myString.ChangeListener() {
        @Override
        public void onChange() {
            try{
                JSONArray JA = new JSONArray(playerMove.isBoo());
                JSONObject JO = (JSONObject) JA.get(0);
                if(connectedLastMove != JO.getInt("lastmove")) {
                    connectedLastMove = JO.getInt("lastmove");
                    otherPlayerMovingAction=true;
                    OtherUserTurn();
                }
            }catch(JSONException e){
                e.printStackTrace();
            }
        }
    };

    myString.ChangeListener fetchedAddLastMove= new myString.ChangeListener() {
        @Override
        public void onChange() {
            try{
                JSONArray JA = new JSONArray(playerMove.isBoo());
            }catch(JSONException e){
                e.printStackTrace();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_online);

        context = this;

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

        checkUser = new myString();
        checkUser.setListener(fetchedCheckUser);

        playerMove = new myString();
        playerMove.setListener(fetchedUserMove);

        playerLastMove = new myString();
        playerLastMove.setListener(fetchedAddLastMove);

        if(GetOnlineActivity.userid<GetOnlineActivity.connectedid) {
            thatplayer = 1;
            otherplayer = 2;

            fetchPlayers process = new fetchPlayers();
            process.setRequestURL("http://10.0.2.2:8888/dotsandboxes/public/api/getPlayer");
            process.setParamNames(new String[]{"userid"});
            process.setParamValues(new String[]{String.valueOf(GetOnlineActivity.userid)});
            process.execute();

            fetchPlayers process1 = new fetchPlayers();
            process1.setRequestURL("http://10.0.2.2:8888/dotsandboxes/public/api/getPlayer");
            process1.setParamNames(new String[]{"userid"});
            process1.setParamValues(new String[]{String.valueOf(GetOnlineActivity.connectedid)});
            process1.execute();
        }else{

            thatplayer = 2;
            otherplayer = 1;
            otherPlayerMoving = true;

            fetchPlayers process = new fetchPlayers();
            process.setRequestURL("http://10.0.2.2:8888/dotsandboxes/public/api/getPlayer");
            process.setParamNames(new String[]{"userid"});
            process.setParamValues(new String[]{String.valueOf(GetOnlineActivity.connectedid)});
            process.execute();

            fetchPlayers process1 = new fetchPlayers();
            process1.setRequestURL("http://10.0.2.2:8888/dotsandboxes/public/api/getPlayer");
            process1.setParamNames(new String[]{"userid"});
            process1.setParamValues(new String[]{String.valueOf(GetOnlineActivity.userid)});
            process1.execute();
        }


        LinearLayout rlayout = (LinearLayout) findViewById(R.id.mymainlayout);
        rlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(redScore + blueScore == 9){
                    toast.cancel();
                    Intent myIntent = new Intent(MainActivityOnline.this, MenuActivity.class);
                    startActivity(myIntent);
                }
            }

        });

        w1_box1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((player != thatplayer && otherPlayerMovingAction == true) || (player == thatplayer && otherPlayerMovingAction == false)) {
                    int nextPlayerValue = box1.setWall1(player);
                    int blocked = box1.getwhowin();

                    if (player == 1) {
                        w1_box1.setBackground(bluedrawable);
                    } else {
                        w1_box1.setBackground(reddrawable);
                    }

                    w1_box1.setEnabled(false);
                    if (blocked != 0) {
                        if (blocked == 1) {
                            box1btn.setBackgroundColor(getResources().getColor(R.color.myred));
                            setBlueScore();
                        } else {
                            box1btn.setBackgroundColor(getResources().getColor(R.color.myred));
                            setRedScore();
                        }
                    }
                    if(player == thatplayer){
                        fetchPlayerMove process = new fetchPlayerMove();
                        process.setRequestURL("http://10.0.2.2:8888/dotsandboxes/public/api/makeMove");
                        process.setParamNames(new String[]{"userid","lastmove"});
                        process.setParamValues(new String[]{String.valueOf(GetOnlineActivity.userid),"1"});
                        process.execute();
                    }
                    nextPlayer(nextPlayerValue);
                    // Do something in response to button click
                }
            }
        });

        w1_box2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((player != thatplayer && otherPlayerMovingAction == true) || (player == thatplayer && otherPlayerMovingAction == false)) {
                    int nextPlayerValue = box2.setWall1(player);

                    int blocked = box2.getwhowin();

                    if (player == 1) {
                        w1_box2.setBackground(bluedrawable);
                    } else {
                        w1_box2.setBackground(reddrawable);
                    }

                    w1_box2.setEnabled(false);
                    if (blocked != 0) {
                        if (blocked == 1) {
                            box2btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                            setBlueScore();
                        } else {
                            box2btn.setBackgroundColor(getResources().getColor(R.color.myred));
                            setRedScore();
                        }
                    }

                    if (player == thatplayer) {
                        fetchPlayerMove process = new fetchPlayerMove();
                        process.setRequestURL("http://10.0.2.2:8888/dotsandboxes/public/api/makeMove");
                        process.setParamNames(new String[]{"userid", "lastmove"});
                        process.setParamValues(new String[]{String.valueOf(GetOnlineActivity.userid), "5"});
                        process.execute();
                    }

                    nextPlayer(nextPlayerValue);
                    // Do something in response to button click
                }
            }
        });

        w1_box3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((player != thatplayer && otherPlayerMovingAction == true) || (player == thatplayer && otherPlayerMovingAction == false)) {
                    int nextPlayerValue = box3.setWall1(player);
                    int blocked = box3.getwhowin();

                    if (player == 1) {
                        w1_box3.setBackground(bluedrawable);
                    } else {
                        w1_box3.setBackground(reddrawable);
                    }

                    w1_box3.setEnabled(false);
                    if (blocked != 0) {
                        if (blocked == 1) {
                            box3btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                            setBlueScore();
                        } else {
                            box3btn.setBackgroundColor(getResources().getColor(R.color.myred));
                            setRedScore();
                        }
                    }

                    if (player == thatplayer) {
                        fetchPlayerMove process = new fetchPlayerMove();
                        process.setRequestURL("http://10.0.2.2:8888/dotsandboxes/public/api/makeMove");
                        process.setParamNames(new String[]{"userid", "lastmove"});
                        process.setParamValues(new String[]{String.valueOf(GetOnlineActivity.userid), "8"});
                        process.execute();
                    }

                    nextPlayer(nextPlayerValue);
                    // Do something in response to button click

                }
            }
        });

        w4_box1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((player != thatplayer && otherPlayerMovingAction == true) || (player == thatplayer && otherPlayerMovingAction == false)) {
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
                    if (player == thatplayer) {
                        fetchPlayerMove process = new fetchPlayerMove();
                        process.setRequestURL("http://10.0.2.2:8888/dotsandboxes/public/api/makeMove");
                        process.setParamNames(new String[]{"userid", "lastmove"});
                        process.setParamValues(new String[]{String.valueOf(GetOnlineActivity.userid), "4"});
                        process.execute();
                    }
                nextPlayer(nextPlayerValue);
                // Do something in response to button click

            }
            }
        });

        w4_box4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((player != thatplayer && otherPlayerMovingAction == true) || (player == thatplayer && otherPlayerMovingAction == false)) {
                    int nextPlayerValue = box4.setWall4(player);
                    int blocked = box4.getwhowin();

                    if (player == 1) {
                        w4_box4.setBackground(bluedrawable);
                    } else {
                        w4_box4.setBackground(reddrawable);
                    }

                    w4_box4.setEnabled(false);
                    if (blocked != 0) {
                        if (blocked == 1) {
                            box4btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                            setBlueScore();
                        } else {
                            box4btn.setBackgroundColor(getResources().getColor(R.color.myred));
                            setRedScore();
                        }
                    }

                    if (player == thatplayer) {
                        fetchPlayerMove process = new fetchPlayerMove();
                        process.setRequestURL("http://10.0.2.2:8888/dotsandboxes/public/api/makeMove");
                        process.setParamNames(new String[]{"userid", "lastmove"});
                        process.setParamValues(new String[]{String.valueOf(GetOnlineActivity.userid), "13"});
                        process.execute();
                    }

                    nextPlayer(nextPlayerValue);
                    // Do something in response to button click
                }
            }
        });



        w2_box1_w4_box2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((player != thatplayer && otherPlayerMovingAction == true) || (player == thatplayer && otherPlayerMovingAction == false)) {
                    int temp = player;

                    int nextPlayerValue1 = box1.setWall2(player);
                    int nextPlayerValue2 = box2.setWall4(player);

                    int nextPlayerValue = 0;
                    if (temp == nextPlayerValue1) {
                        nextPlayerValue = nextPlayerValue1;
                    } else if (temp == nextPlayerValue2) {
                        nextPlayerValue = nextPlayerValue2;
                    } else {
                        if (temp == 1) nextPlayerValue = 2;
                        else nextPlayerValue = 1;
                    }

                    w2_box1_w4_box2.setEnabled(false);
                    if (player == 1) {
                        w2_box1_w4_box2.setBackground(bluedrawable);
                    } else {
                        w2_box1_w4_box2.setBackground(reddrawable);
                    }

                    int blocked = box1.getwhowin();

                    if (blocked != 0) {
                        if (blocked == 1) {
                            box1btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                            setBlueScore();
                        } else {
                            box1btn.setBackgroundColor(getResources().getColor(R.color.myred));
                            setRedScore();
                        }
                    }

                    blocked = box2.getwhowin();

                    if (blocked != 0) {
                        if (blocked == 1) {
                            box2btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                            setBlueScore();
                        } else {
                            box2btn.setBackgroundColor(getResources().getColor(R.color.myred));
                            setRedScore();
                        }
                    }
                    if (player == thatplayer) {
                        fetchPlayerMove process = new fetchPlayerMove();
                        process.setRequestURL("http://10.0.2.2:8888/dotsandboxes/public/api/makeMove");
                        process.setParamNames(new String[]{"userid", "lastmove"});
                        process.setParamValues(new String[]{String.valueOf(GetOnlineActivity.userid), "2"});
                        process.execute();
                    }
                    nextPlayer(nextPlayerValue);
                    // Do something in response to button click

                }
            }
        });
        w2_box2_w4_box3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                if ((player != thatplayer && otherPlayerMovingAction == true) || (player == thatplayer && otherPlayerMovingAction == false)) {
                    int temp = player;

                    int nextPlayerValue1 = box2.setWall2(player);
                    int nextPlayerValue2 = box3.setWall4(player);

                    int nextPlayerValue = 0;
                    if (temp == nextPlayerValue1) {
                        nextPlayerValue = nextPlayerValue1;
                    } else if (temp == nextPlayerValue2) {
                        nextPlayerValue = nextPlayerValue2;
                    } else {
                        if (temp == 1) nextPlayerValue = 2;
                        else nextPlayerValue = 1;
                    }

                    w2_box2_w4_box3.setEnabled(false);
                    if (player == 1) {
                        w2_box2_w4_box3.setBackground(bluedrawable);
                    } else {
                        w2_box2_w4_box3.setBackground(reddrawable);
                    }

                    int blocked = box2.getwhowin();

                    if (blocked != 0) {
                        if (blocked == 1) {
                            box2btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                            setBlueScore();
                        } else {
                            box2btn.setBackgroundColor(getResources().getColor(R.color.myred));
                            setRedScore();
                        }
                    }

                    blocked = box3.getwhowin();

                    if (blocked != 0) {
                        if (blocked == 1) {
                            box3btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                            setBlueScore();
                        } else {
                            box3btn.setBackgroundColor(getResources().getColor(R.color.myred));
                            setRedScore();
                        }
                    }

                    if (player == thatplayer) {
                        fetchPlayerMove process = new fetchPlayerMove();
                        process.setRequestURL("http://10.0.2.2:8888/dotsandboxes/public/api/makeMove");
                        process.setParamNames(new String[]{"userid", "lastmove"});
                        process.setParamValues(new String[]{String.valueOf(GetOnlineActivity.userid), "6"});
                        process.execute();
                    }

                    nextPlayer(nextPlayerValue);
                    // Do something in response to button click
                }
            }
        });
        w2_box3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((player != thatplayer && otherPlayerMovingAction == true) || (player == thatplayer && otherPlayerMovingAction == false)) {
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

                    if (player == thatplayer) {
                        fetchPlayerMove process = new fetchPlayerMove();
                        process.setRequestURL("http://10.0.2.2:8888/dotsandboxes/public/api/makeMove");
                        process.setParamNames(new String[]{"userid", "lastmove"});
                        process.setParamValues(new String[]{String.valueOf(GetOnlineActivity.userid), "9"});
                        process.execute();
                    }

                nextPlayer(nextPlayerValue);
                // Do something in response to button click

            }}
        });

        w1_box4_w3_box1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((player != thatplayer && otherPlayerMovingAction == true) || (player == thatplayer && otherPlayerMovingAction == false)) {
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

                if(player == thatplayer){
                    fetchPlayerMove process = new fetchPlayerMove();
                    process.setRequestURL("http://10.0.2.2:8888/dotsandboxes/public/api/makeMove");
                    process.setParamNames(new String[]{"userid","lastmove"});
                    process.setParamValues(new String[]{String.valueOf(GetOnlineActivity.userid),"3"});
                    process.execute();
                }

                nextPlayer(nextPlayerValue);
                // Do something in response to button click

            }}
        });

        w1_box5_w3_box2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((player != thatplayer && otherPlayerMovingAction == true) || (player == thatplayer && otherPlayerMovingAction == false)) {
                    int temp = player;

                    int nextPlayerValue1 = box5.setWall1(player);
                    int nextPlayerValue2 = box2.setWall3(player);

                    int nextPlayerValue = 0;
                    if (temp == nextPlayerValue1) {
                        nextPlayerValue = nextPlayerValue1;
                    } else if (temp == nextPlayerValue2) {
                        nextPlayerValue = nextPlayerValue2;
                    } else {
                        if (temp == 1) nextPlayerValue = 2;
                        else nextPlayerValue = 1;
                    }

                    w1_box5_w3_box2.setEnabled(false);
                    if (player == 1) {
                        w1_box5_w3_box2.setBackground(bluedrawable);
                    } else {
                        w1_box5_w3_box2.setBackground(reddrawable);
                    }

                    int blocked = box5.getwhowin();

                    if (blocked != 0) {
                        if (blocked == 1) {
                            box5btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                            setBlueScore();
                        } else {
                            box5btn.setBackgroundColor(getResources().getColor(R.color.myred));
                            setRedScore();
                        }
                    }

                    blocked = box2.getwhowin();

                    if (blocked != 0) {
                        if (blocked == 1) {
                            box2btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                            setBlueScore();
                        } else {
                            box2btn.setBackgroundColor(getResources().getColor(R.color.myred));
                            setRedScore();
                        }
                    }

                    if (player == thatplayer) {
                        fetchPlayerMove process = new fetchPlayerMove();
                        process.setRequestURL("http://10.0.2.2:8888/dotsandboxes/public/api/makeMove");
                        process.setParamNames(new String[]{"userid", "lastmove"});
                        process.setParamValues(new String[]{String.valueOf(GetOnlineActivity.userid), "7"});
                        process.execute();
                    }

                    nextPlayer(nextPlayerValue);
                    // Do something in response to button click
                }
            }

        });
        w1_box6_w3_box3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((player != thatplayer && otherPlayerMovingAction == true) || (player == thatplayer && otherPlayerMovingAction == false)) {
                    int temp = player;

                    int nextPlayerValue1 = box6.setWall1(player);
                    int nextPlayerValue2 = box3.setWall3(player);

                    int nextPlayerValue = 0;
                    if (temp == nextPlayerValue1) {
                        nextPlayerValue = nextPlayerValue1;
                    } else if (temp == nextPlayerValue2) {
                        nextPlayerValue = nextPlayerValue2;
                    } else {
                        if (temp == 1) nextPlayerValue = 2;
                        else nextPlayerValue = 1;
                    }

                    w1_box6_w3_box3.setEnabled(false);
                    if (player == 1) {
                        w1_box6_w3_box3.setBackground(bluedrawable);
                    } else {
                        w1_box6_w3_box3.setBackground(reddrawable);
                    }

                    int blocked = box6.getwhowin();

                    if (blocked != 0) {
                        if (blocked == 1) {
                            box6btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                            setBlueScore();
                        } else {
                            box6btn.setBackgroundColor(getResources().getColor(R.color.myred));
                            setRedScore();
                        }
                    }

                    blocked = box3.getwhowin();

                    if (blocked != 0) {
                        if (blocked == 1) {
                            box3btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                            setBlueScore();
                        } else {
                            box3btn.setBackgroundColor(getResources().getColor(R.color.myred));
                            setRedScore();
                        }
                    }

                    if (player == thatplayer) {
                        fetchPlayerMove process = new fetchPlayerMove();
                        process.setRequestURL("http://10.0.2.2:8888/dotsandboxes/public/api/makeMove");
                        process.setParamNames(new String[]{"userid", "lastmove"});
                        process.setParamValues(new String[]{String.valueOf(GetOnlineActivity.userid), "10"});
                        process.execute();
                    }

                    nextPlayer(nextPlayerValue);
                    // Do something in response to button click
                }

            }
        });

        w2_box4_w4_box5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((player != thatplayer && otherPlayerMovingAction == true) || (player == thatplayer && otherPlayerMovingAction == false)) {
                    int temp = player;

                    int nextPlayerValue1 = box4.setWall2(player);
                    int nextPlayerValue2 = box5.setWall4(player);

                    int nextPlayerValue = 0;
                    if (temp == nextPlayerValue1) {
                        nextPlayerValue = nextPlayerValue1;
                    } else if (temp == nextPlayerValue2) {
                        nextPlayerValue = nextPlayerValue2;
                    } else {
                        if (temp == 1) nextPlayerValue = 2;
                        else nextPlayerValue = 1;
                    }

                    w2_box4_w4_box5.setEnabled(false);
                    if (player == 1) {
                        w2_box4_w4_box5.setBackground(bluedrawable);
                    } else {
                        w2_box4_w4_box5.setBackground(reddrawable);
                    }

                    int blocked = box4.getwhowin();

                    if (blocked != 0) {
                        if (blocked == 1) {
                            box4btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                            setBlueScore();
                        } else {
                            box4btn.setBackgroundColor(getResources().getColor(R.color.myred));
                            setRedScore();
                        }
                    }

                    blocked = box5.getwhowin();

                    if (blocked != 0) {
                        if (blocked == 1) {
                            box5btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                            setBlueScore();
                        } else {
                            box5btn.setBackgroundColor(getResources().getColor(R.color.myred));
                            setRedScore();
                        }
                    }

                    if (player == thatplayer) {
                        fetchPlayerMove process = new fetchPlayerMove();
                        process.setRequestURL("http://10.0.2.2:8888/dotsandboxes/public/api/makeMove");
                        process.setParamNames(new String[]{"userid", "lastmove"});
                        process.setParamValues(new String[]{String.valueOf(GetOnlineActivity.userid), "11"});
                        process.execute();
                    }

                    nextPlayer(nextPlayerValue);
                    // Do something in response to button click
                }
            }
        });
        w2_box5_w4_box6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((player != thatplayer && otherPlayerMovingAction == true) || (player == thatplayer && otherPlayerMovingAction == false)) {
                    int temp = player;

                    int nextPlayerValue1 = box6.setWall4(player);
                    int nextPlayerValue2 = box5.setWall2(player);

                    int nextPlayerValue = 0;
                    if (temp == nextPlayerValue1) {
                        nextPlayerValue = nextPlayerValue1;
                    } else if (temp == nextPlayerValue2) {
                        nextPlayerValue = nextPlayerValue2;
                    } else {
                        if (temp == 1) nextPlayerValue = 2;
                        else nextPlayerValue = 1;
                    }

                    w2_box5_w4_box6.setEnabled(false);

                    if (player == 1) {
                        w2_box5_w4_box6.setBackground(bluedrawable);
                    } else {
                        w2_box5_w4_box6.setBackground(reddrawable);
                    }


                    int blocked = box5.getwhowin();

                    if (blocked != 0) {
                        if (blocked == 1) {
                            box5btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                            setBlueScore();
                        } else {
                            box5btn.setBackgroundColor(getResources().getColor(R.color.myred));
                            setRedScore();
                        }
                    }

                    blocked = box6.getwhowin();

                    if (blocked != 0) {
                        if (blocked == 1) {
                            box6btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                            setBlueScore();
                        } else {
                            box6btn.setBackgroundColor(getResources().getColor(R.color.myred));
                            setRedScore();
                        }
                    }

                    if (player == thatplayer) {
                        fetchPlayerMove process = new fetchPlayerMove();
                        process.setRequestURL("http://10.0.2.2:8888/dotsandboxes/public/api/makeMove");
                        process.setParamNames(new String[]{"userid", "lastmove"});
                        process.setParamValues(new String[]{String.valueOf(GetOnlineActivity.userid), "14"});
                        process.execute();
                    }

                    nextPlayer(nextPlayerValue);
                    // Do something in response to button click
                }
            }
        });

        w2_box6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((player != thatplayer && otherPlayerMovingAction == true) || (player == thatplayer && otherPlayerMovingAction == false)) {
                    int nextPlayerValue = box6.setWall2(player);


                    w2_box6.setEnabled(false);
                    if (player == 1) {
                        w2_box6.setBackground(bluedrawable);
                    } else {
                        w2_box6.setBackground(reddrawable);
                    }

                    int blocked = box6.getwhowin();


                    if (blocked != 0) {
                        if (blocked == 1) {
                            box6btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                            setBlueScore();
                        } else {
                            box6btn.setBackgroundColor(getResources().getColor(R.color.myred));
                            setRedScore();
                        }
                    }

                    if (player == thatplayer) {
                        fetchPlayerMove process = new fetchPlayerMove();
                        process.setRequestURL("http://10.0.2.2:8888/dotsandboxes/public/api/makeMove");
                        process.setParamNames(new String[]{"userid", "lastmove"});
                        process.setParamValues(new String[]{String.valueOf(GetOnlineActivity.userid), "16"});
                        process.execute();
                    }

                    nextPlayer(nextPlayerValue);
                    // Do something in response to button click

                }
            }
        });

        w1_box7_w3_box4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((player != thatplayer && otherPlayerMovingAction == true) || (player == thatplayer && otherPlayerMovingAction == false)) {
                    int temp = player;
                    int nextPlayerValue1 = box7.setWall1(player);
                    int nextPlayerValue2 = box4.setWall3(player);

                    int nextPlayerValue = 0;
                    if (temp == nextPlayerValue1) {
                        nextPlayerValue = nextPlayerValue1;
                    } else if (temp == nextPlayerValue2) {
                        nextPlayerValue = nextPlayerValue2;
                    } else {
                        if (temp == 1) nextPlayerValue = 2;
                        else nextPlayerValue = 1;
                    }

                    w1_box7_w3_box4.setEnabled(false);
                    if (player == 1) {
                        w1_box7_w3_box4.setBackground(bluedrawable);
                    } else {
                        w1_box7_w3_box4.setBackground(reddrawable);
                    }

                    int blocked = box7.getwhowin();

                    if (blocked != 0) {
                        if (blocked == 1) {
                            box7btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                            setBlueScore();
                        } else {
                            box7btn.setBackgroundColor(getResources().getColor(R.color.myred));
                            setRedScore();
                        }
                    }

                    blocked = box4.getwhowin();

                    if (blocked != 0) {
                        if (blocked == 1) {
                            box4btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                            setBlueScore();
                        } else {
                            box4btn.setBackgroundColor(getResources().getColor(R.color.myred));
                            setRedScore();
                        }
                    }

                    if (player == thatplayer) {
                        fetchPlayerMove process = new fetchPlayerMove();
                        process.setRequestURL("http://10.0.2.2:8888/dotsandboxes/public/api/makeMove");
                        process.setParamNames(new String[]{"userid", "lastmove"});
                        process.setParamValues(new String[]{String.valueOf(GetOnlineActivity.userid), "12"});
                        process.execute();
                    }

                    nextPlayer(nextPlayerValue);
                    // Do something in response to button click

                }
            }
        });
        w1_box8_w3_box5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((player != thatplayer && otherPlayerMovingAction == true) || (player == thatplayer && otherPlayerMovingAction == false)) {
                    int temp = player;

                    int nextPlayerValue1 = box8.setWall1(player);
                    int nextPlayerValue2 = box5.setWall3(player);

                    int nextPlayerValue = 0;
                    if (temp == nextPlayerValue1) {
                        nextPlayerValue = nextPlayerValue1;
                    } else if (temp == nextPlayerValue2) {
                        nextPlayerValue = nextPlayerValue2;
                    } else {
                        if (temp == 1) nextPlayerValue = 2;
                        else nextPlayerValue = 1;
                    }

                    w1_box8_w3_box5.setEnabled(false);
                    if (player == 1) {
                        w1_box8_w3_box5.setBackground(bluedrawable);
                    } else {
                        w1_box8_w3_box5.setBackground(reddrawable);
                    }

                    int blocked = box8.getwhowin();

                    if (blocked != 0) {
                        if (blocked == 1) {
                            box8btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                            setBlueScore();
                        } else {
                            box8btn.setBackgroundColor(getResources().getColor(R.color.myred));
                            setRedScore();
                        }
                    }

                    blocked = box5.getwhowin();

                    if (blocked != 0) {
                        if (blocked == 1) {
                            box5btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                            setBlueScore();
                        } else {
                            box5btn.setBackgroundColor(getResources().getColor(R.color.myred));
                            setRedScore();
                        }
                    }

                    if (player == thatplayer) {
                        fetchPlayerMove process = new fetchPlayerMove();
                        process.setRequestURL("http://10.0.2.2:8888/dotsandboxes/public/api/makeMove");
                        process.setParamNames(new String[]{"userid", "lastmove"});
                        process.setParamValues(new String[]{String.valueOf(GetOnlineActivity.userid), "15"});
                        process.execute();
                    }

                    nextPlayer(nextPlayerValue);
                    // Do something in response to button click
                }
            }
        });
        w1_box9_w3_box6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((player != thatplayer && otherPlayerMovingAction == true) || (player == thatplayer && otherPlayerMovingAction == false)) {
                    int temp = player;

                    int nextPlayerValue1 = box9.setWall1(player);
                    int nextPlayerValue2 = box6.setWall3(player);

                    int nextPlayerValue = 0;
                    if (temp == nextPlayerValue1) {
                        nextPlayerValue = nextPlayerValue1;
                    } else if (temp == nextPlayerValue2) {
                        nextPlayerValue = nextPlayerValue2;
                    } else {
                        if (temp == 1) nextPlayerValue = 2;
                        else nextPlayerValue = 1;
                    }

                    w1_box9_w3_box6.setEnabled(false);
                    if (player == 1) {
                        w1_box9_w3_box6.setBackground(bluedrawable);
                    } else {
                        w1_box9_w3_box6.setBackground(reddrawable);
                    }

                    int blocked = box9.getwhowin();

                    if (blocked != 0) {
                        if (blocked == 1) {
                            box9btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                            setBlueScore();
                        } else {
                            box9btn.setBackgroundColor(getResources().getColor(R.color.myred));
                            setRedScore();
                        }
                    }

                    blocked = box6.getwhowin();

                    if (blocked != 0) {
                        if (blocked == 1) {
                            box6btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                            setBlueScore();
                        } else {
                            box6btn.setBackgroundColor(getResources().getColor(R.color.myred));
                            setRedScore();
                        }
                    }

                    if (player == thatplayer) {
                        fetchPlayerMove process = new fetchPlayerMove();
                        process.setRequestURL("http://10.0.2.2:8888/dotsandboxes/public/api/makeMove");
                        process.setParamNames(new String[]{"userid", "lastmove"});
                        process.setParamValues(new String[]{String.valueOf(GetOnlineActivity.userid), "17"});
                        process.execute();
                    }

                    nextPlayer(nextPlayerValue);
                    // Do something in response to button click
                }
            }
        });
        w4_box7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((player != thatplayer && otherPlayerMovingAction == true) || (player == thatplayer && otherPlayerMovingAction == false)) {
                    int nextPlayerValue = box7.setWall4(player);

                    w4_box7.setEnabled(false);
                    if (player == 1) {
                        w4_box7.setBackground(bluedrawable);
                    } else {
                        w4_box7.setBackground(reddrawable);
                    }

                    int blocked = box7.getwhowin();


                    if (blocked != 0) {
                        if (blocked == 1) {
                            box7btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                            setBlueScore();
                        } else {
                            box7btn.setBackgroundColor(getResources().getColor(R.color.myred));
                            setRedScore();
                        }
                    }

                    if (player == thatplayer) {
                        fetchPlayerMove process = new fetchPlayerMove();
                        process.setRequestURL("http://10.0.2.2:8888/dotsandboxes/public/api/makeMove");
                        process.setParamNames(new String[]{"userid", "lastmove"});
                        process.setParamValues(new String[]{String.valueOf(GetOnlineActivity.userid), "20"});
                        process.execute();
                    }

                    nextPlayer(nextPlayerValue);
                    // Do something in response to button click

                }
            }
        });

        w2_box7_w4_box8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((player != thatplayer && otherPlayerMovingAction == true) || (player == thatplayer && otherPlayerMovingAction == false)) {
                    int temp = player;

                    int nextPlayerValue1 = box8.setWall4(player);
                    int nextPlayerValue2 = box7.setWall2(player);

                    int nextPlayerValue = 0;
                    if (temp == nextPlayerValue1) {
                        nextPlayerValue = nextPlayerValue1;
                    } else if (temp == nextPlayerValue2) {
                        nextPlayerValue = nextPlayerValue2;
                    } else {
                        if (temp == 1) nextPlayerValue = 2;
                        else nextPlayerValue = 1;
                    }

                    w2_box7_w4_box8.setEnabled(false);
                    if (player == 1) {
                        w2_box7_w4_box8.setBackground(bluedrawable);
                    } else {
                        w2_box7_w4_box8.setBackground(reddrawable);
                    }

                    int blocked = box7.getwhowin();

                    if (blocked != 0) {
                        if (blocked == 1) {
                            box7btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                            setBlueScore();
                        } else {
                            box7btn.setBackgroundColor(getResources().getColor(R.color.myred));
                            setRedScore();
                        }
                    }

                    blocked = box8.getwhowin();

                    if (blocked != 0) {
                        if (blocked == 1) {
                            box8btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                            setBlueScore();
                        } else {
                            box8btn.setBackgroundColor(getResources().getColor(R.color.myred));
                            setRedScore();
                        }
                    }

                    if (player == thatplayer) {
                        fetchPlayerMove process = new fetchPlayerMove();
                        process.setRequestURL("http://10.0.2.2:8888/dotsandboxes/public/api/makeMove");
                        process.setParamNames(new String[]{"userid", "lastmove"});
                        process.setParamValues(new String[]{String.valueOf(GetOnlineActivity.userid), "18"});
                        process.execute();
                    }

                    nextPlayer(nextPlayerValue);
                    // Do something in response to button click
                }
            }
        });

        w2_box8_w4_box9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((player != thatplayer && otherPlayerMovingAction == true) || (player == thatplayer && otherPlayerMovingAction == false)) {
                    int temp = player;

                    int nextPlayerValue1 = box8.setWall2(player);
                    int nextPlayerValue2 = box9.setWall4(player);

                    int nextPlayerValue = 0;
                    if (temp == nextPlayerValue1) {
                        nextPlayerValue = nextPlayerValue1;
                    } else if (temp == nextPlayerValue2) {
                        nextPlayerValue = nextPlayerValue2;
                    } else {
                        if (temp == 1) nextPlayerValue = 2;
                        else nextPlayerValue = 1;
                    }

                    w2_box8_w4_box9.setEnabled(false);
                    if (player == 1) {
                        w2_box8_w4_box9.setBackground(bluedrawable);
                    } else {
                        w2_box8_w4_box9.setBackground(reddrawable);
                    }

                    int blocked = box8.getwhowin();

                    if (blocked != 0) {
                        if (blocked == 1) {
                            box8btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                            setBlueScore();
                        } else {
                            box8btn.setBackgroundColor(getResources().getColor(R.color.myred));
                            setRedScore();
                        }
                    }

                    blocked = box9.getwhowin();

                    if (blocked != 0) {
                        if (blocked == 1) {
                            box9btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                            setBlueScore();
                        } else {
                            box9btn.setBackgroundColor(getResources().getColor(R.color.myred));
                            setRedScore();
                        }
                    }

                    if (player == thatplayer) {
                        fetchPlayerMove process = new fetchPlayerMove();
                        process.setRequestURL("http://10.0.2.2:8888/dotsandboxes/public/api/makeMove");
                        process.setParamNames(new String[]{"userid", "lastmove"});
                        process.setParamValues(new String[]{String.valueOf(GetOnlineActivity.userid), "21"});
                        process.execute();
                    }

                    nextPlayer(nextPlayerValue);

                }
            }
        });
        w2_box9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((player != thatplayer && otherPlayerMovingAction == true) || (player == thatplayer && otherPlayerMovingAction == false)) {
                    int nextPlayerValue = box9.setWall2(player);
                    w2_box9.setEnabled(false);

                    if (player == 1) {
                        w2_box9.setBackground(bluedrawable);
                    } else {
                        w2_box9.setBackground(reddrawable);
                    }


                    int blocked = box9.getwhowin();

                    if (blocked != 0) {
                        if (blocked == 1) {
                            box9btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                            setBlueScore();
                        } else {
                            box9btn.setBackgroundColor(getResources().getColor(R.color.myred));
                            setRedScore();
                        }
                    }

                    if (player == thatplayer) {
                        fetchPlayerMove process = new fetchPlayerMove();
                        process.setRequestURL("http://10.0.2.2:8888/dotsandboxes/public/api/makeMove");
                        process.setParamNames(new String[]{"userid", "lastmove"});
                        process.setParamValues(new String[]{String.valueOf(GetOnlineActivity.userid), "23"});
                        process.execute();
                    }

                    nextPlayer(nextPlayerValue);
                    // Do something in response to button click
                }
            }
        });
        w3_box7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((player != thatplayer && otherPlayerMovingAction == true) || (player == thatplayer && otherPlayerMovingAction == false)) {
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

                    if (player == thatplayer) {
                        fetchPlayerMove process = new fetchPlayerMove();
                        process.setRequestURL("http://10.0.2.2:8888/dotsandboxes/public/api/makeMove");
                        process.setParamNames(new String[]{"userid", "lastmove"});
                        process.setParamValues(new String[]{String.valueOf(GetOnlineActivity.userid), "19"});
                        process.execute();
                    }

                nextPlayer(nextPlayerValue);
                // Do something in response to button click

            }
            }
        });
        w3_box8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((player != thatplayer && otherPlayerMovingAction == true) || (player == thatplayer && otherPlayerMovingAction == false)) {
                    int nextPlayerValue = box8.setWall3(player);


                    w3_box8.setEnabled(false);
                    if (player == 1) {
                        w3_box8.setBackground(bluedrawable);
                    } else {
                        w3_box8.setBackground(reddrawable);
                    }

                    int blocked = box8.getwhowin();


                    if (blocked != 0) {
                        if (blocked == 1) {
                            box8btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                            setBlueScore();
                        } else {
                            box8btn.setBackgroundColor(getResources().getColor(R.color.myred));
                            setRedScore();
                        }
                    }

                    if (player == thatplayer) {
                        fetchPlayerMove process = new fetchPlayerMove();
                        process.setRequestURL("http://10.0.2.2:8888/dotsandboxes/public/api/makeMove");
                        process.setParamNames(new String[]{"userid", "lastmove"});
                        process.setParamValues(new String[]{String.valueOf(GetOnlineActivity.userid), "22"});
                        process.execute();
                    }

                    nextPlayer(nextPlayerValue);
                    // Do something in response to button click
                }
            }
        });
        w3_box9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((player != thatplayer && otherPlayerMovingAction == true) || (player == thatplayer && otherPlayerMovingAction == false)) {
                    int nextPlayerValue = box9.setWall3(player);


                    w3_box9.setEnabled(false);
                    if (player == 1) {
                        w3_box9.setBackground(bluedrawable);
                    } else {
                        w3_box9.setBackground(reddrawable);
                    }


                    int blocked = box9.getwhowin();
                    if (blocked != 0) {
                        if (blocked == 1) {
                            box9btn.setBackgroundColor(getResources().getColor(R.color.myblue));
                            setBlueScore();
                        } else {
                            box9btn.setBackgroundColor(getResources().getColor(R.color.myred));
                            setRedScore();
                        }
                    }

                    if (player == thatplayer) {
                        fetchPlayerMove process = new fetchPlayerMove();
                        process.setRequestURL("http://10.0.2.2:8888/dotsandboxes/public/api/makeMove");
                        process.setParamNames(new String[]{"userid", "lastmove"});
                        process.setParamValues(new String[]{String.valueOf(GetOnlineActivity.userid), "24"});
                        process.execute();
                    }

                    nextPlayer(nextPlayerValue);
                    // Do something in response to button click
                }
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

        if(otherplayer == player)
        {
            otherPlayerMoving = true;
            otherPlayerMovingAction=false;

            toast = Toast.makeText(context
                    , "Wait for other player...",Toast.LENGTH_SHORT);
            toast.show();
            new CountDownTimer(1000, 10)
            {
                public void onTick(long millisUntilFinished) {toast.show();}
                public void onFinish() {toast.cancel();}
            }.start();
        }else {
            otherPlayerMoving = false;
            otherPlayerMovingAction=false;
        }
    }

    public void setBlueScore(){
        blueScore+=1;
        txt_blueScore.setText(BluePlayer +": "+ blueScore);

        if(redScore + blueScore == 9){
            ENDGAME();
        }
    }

    public void setRedScore(){
        redScore+=1;
        txt_redScore.setText(RedPlayer +": "+ redScore);

        if(redScore + blueScore == 9){
            ENDGAME();
        }
    }

    @Override
    public void onResume(){
        super.onResume();

        hideNavigationBar();

    }

    public void onFinish() {toast.cancel();}

    private void hideNavigationBar(){
        this.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN |
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
    }

    public void ENDGAME(){
        otherPlayerMoving = false;
        if(redScore > blueScore)
        {
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.red_won_toast,
                    (ViewGroup) findViewById(R.id.custom_toast_container));

            TextView text = (TextView) layout.findViewById(R.id.text);
            text.setText("RED Player Won !!!");
            toast.cancel();
            toast = new Toast(this);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setView(layout);
            toast.show();
        }else{
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.blue_won_toast,
                    (ViewGroup) findViewById(R.id.custom_toast_container));

            TextView text = (TextView) layout.findViewById(R.id.text);
            text.setText("BLUE Player Won !!!");

            toast.cancel();
            toast = new Toast(this);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setView(layout);
            toast.show();
            GetOnlineActivity.userid = 0;
            GetOnlineActivity.connectedid = 0;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        try{
            GetOnlineActivity.userid = 0;
            GetOnlineActivity.connectedid = 0;
            fetchData process = new fetchData();
            process.setRequestURL("http://10.0.2.2:8888/dotsandboxes/public/api/delPlayers");
            process.setParamNames(new String[] {"userid"});
            process.setParamValues(new String[] {String.valueOf(userid)});
            process.execute();
        }catch(Exception e){
            e.printStackTrace();
            Toast.makeText(context, "Game Finished", Toast.LENGTH_SHORT).show();
        }
    }
}