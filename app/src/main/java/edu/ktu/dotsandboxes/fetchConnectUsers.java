package edu.ktu.dotsandboxes;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class fetchConnectUsers extends AsyncTask<Void, Void, Void>{
    private String requestURL;
    private String[] paramNames;
    private String[] paramValues;
    String data;
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL(requestURL); //in the real code, there is an ip and a port
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            conn.setRequestProperty("Accept","application/json");
            conn.setDoOutput(true);
            conn.setDoInput(true);

            JSONObject jsonParam = new JSONObject();
            for(int i = 0; i < paramNames.length; i++)
                jsonParam.put(paramNames[i], paramValues[i]);

            Log.i("JSON", jsonParam.toString());
            DataOutputStream os = new DataOutputStream(conn.getOutputStream());
            //os.writeBytes(URLEncoder.encode(jsonParam.toString(), "UTF-8"));
            os.writeBytes(jsonParam.toString());

            os.flush();
            os.close();

            Log.i("STATUS", String.valueOf(conn.getResponseCode()));
            Log.i("MSG" , conn.getResponseMessage());

            InputStream inputStream = conn.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            data = "";
            while(line != null){
                line = bufferedReader.readLine();
                if(line != null)
                    data = data + line;
            }
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        GetOnlineActivity.connectUsers.setBoo(this.data);
    }

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void setParamNames(String[] paramNames) {
        this.paramNames = paramNames;
    }

    public void setParamValues(String[] paramValues) {
        this.paramValues = paramValues;
    }
}
