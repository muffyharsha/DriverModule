package com.example.currentplacedetailsonmap;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.VideoView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LauncherActivity extends AppCompatActivity {
    private static final String DEBUG_TAG = "HttpExample";
    TextView g1,g2,g3;
    ListView listview;
    Button btnDownload,address1,address2,address3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
address1 = (Button)findViewById(R.id.add1);
        address2 = (Button)findViewById(R.id.add2);
        address3 = (Button)findViewById(R.id.add3);


        g1 = (TextView)findViewById(R.id.mgrade1);
        g2 = (TextView)findViewById(R.id.mgrade2);
        g3 = (TextView)findViewById(R.id.mgrade3);

final data obj = new data();
        address1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                obj.lat=10.884501;
                obj.lng = 76.910809;
                obj.address = "Store 1";
                startActivity(new Intent(LauncherActivity.this,MapsActivityCurrentPlace.class));
            }
        });


        address2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                obj.lat = 10.897684;
                obj.lng = 76.899962;
                obj.address = "Store 2";
                startActivity(new Intent(LauncherActivity.this,MapsActivityCurrentPlace.class));
            }
        });

        address3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                obj.lat = 10.900844;
                obj.lng = 76.901212;
                obj.address = "Store 3";
                startActivity(new Intent(LauncherActivity.this,MapsActivityCurrentPlace.class));
            }
        });


        new DownloadWebpageTask(new AsyncResult() {
            @Override
            public void onResult(JSONObject object) {
                processJson(object);
            }
        }).execute("https://spreadsheets.google.com/tq?key=19uDSbYSP256m3Uv6BGHzEmwn99ZghhZTedPVS-ReT5M");



    }


    private void processJson(JSONObject object) {

        try {
            JSONArray rows = object.getJSONArray("rows");
            JSONObject row = rows.getJSONObject(0);
            JSONArray columns = row.getJSONArray("c");


            String t1= columns.getJSONObject(0).getString("f");
            String h1 = columns.getJSONObject(1).getString("f");

            String t2= columns.getJSONObject(2).getString("f");
            String h2 = columns.getJSONObject(3).getString("f");

            String t3= columns.getJSONObject(4).getString("f");
            String h3 = columns.getJSONObject(5).getString("f");

            String module1 = grades(t1,h1);
            String module2 = grades(t2,h2);
            String module3 = grades(t3,h3);
            g1.setText(module1);
            g2.setText(module2);
            g3.setText(module3);







        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public String grades(String t, String h){
        Float t_f = Float.parseFloat(t);
        Float h_t = Float.parseFloat(h);
        if (t_f>= 56 && t_f<= 58){
            return "A";
        }else if(t_f>58 && t_f<=60 ){
            return "B";
        }else if(t_f>60 && t_f<=62){
            return "C";
        }else{
            return "D";
        }
    }

}
