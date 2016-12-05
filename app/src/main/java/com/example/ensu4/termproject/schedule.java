package com.example.ensu4.termproject;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class schedule extends AppCompatActivity {
    final private static String RECORDED_FILE = "recoded";
    DataBase helper;
    MediaRecorder recoder;

    final static String TAG="SQLITE";

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);
        Button save = (Button) findViewById(R.id.button1);
        Button can = (Button) findViewById(R.id.button2);
        Button aud = (Button) findViewById(R.id.button3);
        Button vid = (Button) findViewById(R.id.button3);
        Button img = (Button) findViewById(R.id.button3);
  
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = (EditText)findViewById(R.id.name);
                EditText day = (EditText)findViewById(R.id.day);
                EditText start = (EditText)findViewById(R.id.start);
                EditText end = (EditText)findViewById(R.id.end);
                EditText lot = (EditText)findViewById(R.id.lot);
                EditText memo = (EditText)findViewById(R.id.memo);

                try {
                    String sql = String.format (
                            "INSERT INTO schedule (_id, name, day,start,end,lot,memo)\n"+
                                    "VALUES (NULL, '%s', '%s')");
                    helper.getWritableDatabase().execSQL(sql);
                } catch (SQLException e) {
                    Log.e(TAG,"Error inserting into DB");
                }
            }
        });
        can.setOnClickListener(new View.OnClickListener() {
            final FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            @Override
            public void onClick(View v) {

                    //fragmentTransaction.replace(R.id.fragment, new MainActivity()).addToBackStack(null).commit();
            }
        });

        aud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(recoder!=null){
                    recoder.stop();
                    recoder.release();
                    recoder=null;
                }
                recoder = new MediaRecorder();

                recoder.setAudioSource(MediaRecorder.AudioSource.MIC);
                recoder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
                recoder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
                recoder.setOutputFile(RECORDED_FILE);

                try{
                    recoder.prepare();
                    recoder.start();
                }catch (Exception e){
                    Log.e("Sample","Exception",e);
                }

            }
        });
        vid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (recoder != null) {
                        recoder.stop();
                        recoder.release();
                        recoder = null;
                    }
                    recoder = new MediaRecorder();

                    recoder.setAudioSource(MediaRecorder.AudioSource.MIC);
                    recoder.setVideoSource(MediaRecorder.VideoSource.CAMERA);
                    recoder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
                    recoder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
                    recoder.setVideoEncoder(MediaRecorder.VideoEncoder.DEFAULT);

                } catch (Exception e) {
                    Log.e("Sample", "Exception", e);
                }
            }
        });

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
            }

        }

