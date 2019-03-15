package edu.ktu.dotsandboxes;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.Timer;
import java.util.TimerTask;

public class GetOnlineActivity extends AppCompatActivity {

    Context context;

    Toast toast;

    String myUsername;
    private Button btnGetOnline;
    private EditText etxtUsername;

    private ProgressBar pbar;

    public static int userid = 0;
    public static int connectedid = 0;

    public static myString fetchedData;
    public static myString connectUsers;
    public static myString connectUserToPlayer1;
    public static myString connectUserToPlayer2;
    public static myString checkUser;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_online);

        context = this;

        userid = 0;
        connectedid = 0;

        btnGetOnline = (Button) findViewById(R.id.btn_playonline);
        btnGetOnline.setOnClickListener(enterUsernameAndSearchPlayer);

        etxtUsername = (EditText)findViewById(R.id.txt_name);

        pbar = (ProgressBar) findViewById(R.id.pbar);
        pbar.setVisibility(View.INVISIBLE);

        fetchedData = new myString();
        fetchedData.setListener(fetchedDataListener);

        connectUsers = new myString();
        connectUsers.setListener(fetchedConnectUsers);

        connectUserToPlayer1 = new myString();
        connectUserToPlayer1.setListener(fetchedConnectUsersToPlayer);

        connectUserToPlayer2 = new myString();
        connectUserToPlayer2.setListener(fetchedConnectUsersToPlayer2);

        checkUser = new myString();
        checkUser.setListener(fetchedCheckUser);
    }

    View.OnClickListener enterUsernameAndSearchPlayer = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(userid == 0) {
                myUsername = etxtUsername.getText().toString();
                fetchDataGetOnlineActivity process = new fetchDataGetOnlineActivity();
                process.setRequestURL("http://10.0.2.2:8888/dotsandboxes/public/api/addPlayer");
                process.setParamNames(new String[]{"username"});
                process.setParamValues(new String[]{myUsername});
                process.execute();
                toast = Toast.makeText(context, "Searching...", Toast.LENGTH_SHORT);
                toast.show();
                pbar.setVisibility(View.VISIBLE);
                btnGetOnline.setEnabled(false);
            }else {
                if(userid != 0 && connectedid == 0) {
                    fetchGetUserGetOnline process = new fetchGetUserGetOnline();
                    process.setRequestURL("http://10.0.2.2:8888/dotsandboxes/public/api/getPlayer");
                    process.setParamNames(new String[]{"userid"});
                    process.setParamValues(new String[]{String.valueOf(userid)});
                    process.execute();
                    pbar.setVisibility(View.VISIBLE);
                    btnGetOnline.setEnabled(false);
                }

                if(connectedid != 0)
                {
                    btnGetOnline.setText("JOIN");
                    Drawable btnSearch = getDrawable(R.drawable.resetbuttonview);
                    btnGetOnline.setBackground(btnSearch);
                    toast.cancel();
                    Intent myIntent = new Intent(GetOnlineActivity.this, MainActivityOnline.class);
                    myIntent.putExtra("playerTYPE", "3");// 1 = withcomputer, 3 = online
                    startActivity(myIntent);
                }
            }

        }
    };

    myString.ChangeListener fetchedDataListener = new myString.ChangeListener() {
        @Override
        public void onChange() {
            String singleParsed = "";
            try{
                String data = fetchedData.isBoo();
                if(data != null){
                    Log.i("fetchedDataListener D", data);
                    JSONObject reader = new JSONObject(data);
                    singleParsed = reader.getString("username");
                    userid = reader.getInt("id");
                    btnGetOnline.setText("SEARCH");
                    Drawable btnSearch = getDrawable(R.drawable.searchbuttonview);
                    btnGetOnline.setBackground(btnSearch);
                    pbar.setVisibility(View.VISIBLE);
                    btnGetOnline.setEnabled(false);
                }else{
                    fetchDataGetOnlineActivity process = new fetchDataGetOnlineActivity();
                    process.setRequestURL("http://10.0.2.2:8888/dotsandboxes/public/api/addPlayer");
                    process.setParamNames(new String[]{"username"});
                    process.setParamValues(new String[]{myUsername});
                    process.execute();
                    pbar.setVisibility(View.VISIBLE);
                    btnGetOnline.setEnabled(false);
                    return;
                }
            }catch(JSONException e){
                e.printStackTrace();
                toast.cancel();
                toast = Toast.makeText(context, "Game not ready to online", Toast.LENGTH_SHORT);
                toast.show();
                pbar.setVisibility(View.INVISIBLE);
                btnGetOnline.setEnabled(true);
            }

            if(userid != 0 && connectedid == 0) {
                fetchConnectUsers process = new fetchConnectUsers();
                process.setRequestURL("http://10.0.2.2:8888/dotsandboxes/public/api/ConnectPlayers");
                process.setParamNames(new String[] {"userid"});
                process.setParamValues(new String[] {String.valueOf(userid)});
                process.execute();
                pbar.setVisibility(View.VISIBLE);
                btnGetOnline.setEnabled(false);
            }
        }
    };

    myString.ChangeListener fetchedConnectUsers = new myString.ChangeListener() {
        @Override
        public void onChange() {
            String singleParsed = "";
            try{
                String data = connectUsers.isBoo();
                if(data != null) {
                    JSONArray JA = new JSONArray(data);
                    JSONObject JO = (JSONObject) JA.get(0);
                    singleParsed = JO.getString("id");
                    if (singleParsed == null || singleParsed == "") {
                        fetchConnectUsers process = new fetchConnectUsers();
                        process.setRequestURL("http://10.0.2.2:8888/dotsandboxes/public/api/ConnectPlayers");
                        process.execute();
                        pbar.setVisibility(View.VISIBLE);
                        btnGetOnline.setEnabled(false);
                        return;
                    }
                }else {
                    fetchConnectUsers process = new fetchConnectUsers();
                    process.setRequestURL("http://10.0.2.2:8888/dotsandboxes/public/api/ConnectPlayers");
                    process.setParamNames(new String[] {"userid"});
                    process.setParamValues(new String[] {String.valueOf(userid)});
                    process.execute();
                    pbar.setVisibility(View.VISIBLE);
                    btnGetOnline.setEnabled(false);
                }
            }catch(JSONException e){
                e.printStackTrace();

                toast.cancel();
                toast = Toast.makeText(context, "Not Match, search again", Toast.LENGTH_SHORT);
                toast.show();

                pbar.setVisibility(View.INVISIBLE);
                btnGetOnline.setEnabled(true);

            }
            if(singleParsed != "" && singleParsed != null){
                fetchConnectPlayerToPlayer1 process = new fetchConnectPlayerToPlayer1();
                process.setRequestURL("http://10.0.2.2:8888/dotsandboxes/public/api/ConnectPlayerToPlayer");
                process.setParamNames(new String[] {"userid","connectedid"});
                process.setParamValues(new String[] {String.valueOf(userid),singleParsed});
                connectedid = Integer.valueOf(singleParsed);
                process.execute();
                pbar.setVisibility(View.VISIBLE);
                btnGetOnline.setEnabled(false);
            }
        }
    };

    myString.ChangeListener fetchedConnectUsersToPlayer = new myString.ChangeListener() {
        @Override
        public void onChange() {
            String singleParsed = "";
            try{
                String data = connectUserToPlayer1.isBoo();
                if(data != null)
                    singleParsed = data;
                else{
                    fetchConnectPlayerToPlayer1 process = new fetchConnectPlayerToPlayer1();
                    process.setRequestURL("http://10.0.2.2:8888/dotsandboxes/public/api/ConnectPlayerToPlayer");
                    process.setParamNames(new String[] {"userid","connectedid"});
                    process.setParamValues(new String[] {String.valueOf(userid),singleParsed});
                    connectedid = Integer.valueOf(singleParsed);
                    process.execute();
                    pbar.setVisibility(View.VISIBLE);
                    btnGetOnline.setEnabled(false);
                    return;
                }
            }catch(Exception e){
                e.printStackTrace();
                toast.cancel();
                toast = Toast.makeText(context, "Game not ready to online", Toast.LENGTH_SHORT);
                toast.show();
                pbar.setVisibility(View.INVISIBLE);
                btnGetOnline.setEnabled(true);
            }

            if(!singleParsed.equals("0")){
                fetchConnectPlayerToPlayer2 process = new fetchConnectPlayerToPlayer2();
                process.setRequestURL( "http://10.0.2.2:8888/dotsandboxes/public/api/ConnectPlayerToPlayer");
                process.setParamNames(new String[] {"connectedid","userid"});
                process.setParamValues(new String[] {String.valueOf(userid),String.valueOf(connectedid)});
                process.execute();
                pbar.setVisibility(View.VISIBLE);
                btnGetOnline.setEnabled(false);
            }
        }
    };

    myString.ChangeListener fetchedConnectUsersToPlayer2 = new myString.ChangeListener() {
        @Override
        public void onChange() {
            String singleParsed = "";
            try{
                String data = connectUserToPlayer2.isBoo();
                if(data != null)
                    singleParsed = data;
                else{
                    fetchConnectPlayerToPlayer2 process = new fetchConnectPlayerToPlayer2();
                    process.setRequestURL( "http://10.0.2.2:8888/dotsandboxes/public/api/ConnectPlayerToPlayer");
                    process.setParamNames(new String[] {"connectedid","userid"});
                    process.setParamValues(new String[] {String.valueOf(userid),String.valueOf(connectedid)});
                    process.execute();
                    pbar.setVisibility(View.VISIBLE);
                    btnGetOnline.setEnabled(false);
                    return;
                }

                fetchGetUserGetOnline process = new fetchGetUserGetOnline();
                process.setRequestURL("http://10.0.2.2:8888/dotsandboxes/public/api/getPlayer");
                process.setParamNames(new String[]{"userid"});
                process.setParamValues(new String[]{String.valueOf(userid)});
                process.execute();
                pbar.setVisibility(View.VISIBLE);
                btnGetOnline.setEnabled(false);
            }catch(Exception e){
                e.printStackTrace();
                toast.cancel();
                toast = Toast.makeText(context, "Game not ready to online", Toast.LENGTH_SHORT);
                toast.show();

                pbar.setVisibility(View.INVISIBLE);
                btnGetOnline.setEnabled(true);
            }
        }
    };

    myString.ChangeListener fetchedCheckUser = new myString.ChangeListener() {
        @Override
        public void onChange() {
            String singleParsed = "";
            try{
                String data = checkUser.isBoo();
                Log.i("DATA fetchedCheckUser ", data);
                JSONArray JA = new JSONArray(data);
                JSONObject JO = (JSONObject) JA.get(0);
                singleParsed = JO.getString("connectedid");
                connectedid = Integer.valueOf(singleParsed);
                pbar.setVisibility(View.VISIBLE);
                btnGetOnline.setEnabled(false);

                if(connectedid != 0) {
                    toast.cancel();
                    toast = Toast.makeText(context, "User Found...", Toast.LENGTH_SHORT);
                    toast.show();

                    btnGetOnline.setText("PLAY");
                    Drawable btnSearch = getDrawable(R.drawable.playbuttonview);
                    btnGetOnline.setBackground(btnSearch);

                    pbar.setVisibility(View.INVISIBLE);
                    btnGetOnline.setEnabled(true);
                }else{
                    fetchConnectUsers process = new fetchConnectUsers();
                    process.setRequestURL("http://10.0.2.2:8888/dotsandboxes/public/api/ConnectPlayers");
                    process.setParamNames(new String[] {"userid"});
                    process.setParamValues(new String[] {String.valueOf(userid)});
                    process.execute();
                    pbar.setVisibility(View.VISIBLE);
                    btnGetOnline.setEnabled(false);
                }
            }catch(Exception e){
                e.printStackTrace();
                Toast.makeText(context, "Game not ready to online", Toast.LENGTH_SHORT).show();
                pbar.setVisibility(View.INVISIBLE);
                btnGetOnline.setEnabled(true);
            }
        }
    };

    public void onDestroy() {
        super.onDestroy();
        try{
            userid = 0;
            connectedid = 0;
            fetchData process = new fetchData();
            process.setRequestURL("http://10.0.2.2:8888/dotsandboxes/public/api/delPlayers");
            process.setParamNames(new String[] {"userid"});
            process.setParamValues(new String[] {String.valueOf(userid)});
            process.execute();
            pbar.setVisibility(View.VISIBLE);
            btnGetOnline.setEnabled(false);
        }catch(Exception e){
            e.printStackTrace();
            Toast.makeText(context, "Game Finished", Toast.LENGTH_SHORT).show();
            pbar.setVisibility(View.INVISIBLE);
            btnGetOnline.setEnabled(true);
        }
    }

}
