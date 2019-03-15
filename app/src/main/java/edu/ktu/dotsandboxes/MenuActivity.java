package edu.ktu.dotsandboxes;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MenuActivity extends AppCompatActivity {

    private Button playwithcomputer;
    private Button playwithfriend;
    private Button playonline;

    private int responseCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        playwithcomputer = (Button) findViewById(R.id.btn_playwithcomputer);
        playwithfriend = (Button) findViewById(R.id.btn_playwithfriend);
        playonline = (Button) findViewById(R.id.btn_playonline);

        playwithcomputer.setOnClickListener(playWithComputer);
        playwithfriend.setOnClickListener(playWithFriend);
        playonline.setOnClickListener(playOnline);

    }

    private View.OnClickListener playWithComputer = new View.OnClickListener() {
        public void onClick(View v) {
            Intent myIntent = new Intent(MenuActivity.this, MainActivity.class);
            myIntent.putExtra("playerTYPE", "1");// 1 = withcomputer, 3 = online
            startActivity(myIntent);
        }
    };

    private View.OnClickListener playWithFriend = new View.OnClickListener() {
        public void onClick(View v) {
            Intent myIntent = new Intent(MenuActivity.this, MainActivity.class);
            myIntent.putExtra("playerTYPE", "2");// 1 = withcomputer, 3 = online
            startActivity(myIntent);
        }
    };

    private View.OnClickListener playOnline = new View.OnClickListener() {
        public void onClick(View v){
            Intent myIntent = new Intent(MenuActivity.this, GetOnlineActivity.class);
            startActivity(myIntent);
        }
    };


}