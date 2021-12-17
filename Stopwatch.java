package com.example.myclock;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class stopwatch extends AppCompatActivity {
 TextView tv;
 Button btnStart,btnPause,btnReset;
 Handler handler;
 long tmilli,tstart,tbuff,tupdate=0L;
 int min=0,sec=0,msec=0;
 ListView listView ;
 String[] ListElements = new String[] { };
 List<String> ListElementsArrayList ;
 ArrayAdapter<String> adapter ;
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.stopwatch);
 setTitle("STOPWATCH");
 tv=(TextView) findViewById(R.id.tv1);
 btnStart=(Button)findViewById(R.id.button1);
 btnPause=(Button)findViewById(R.id.button2);
 btnReset=(Button)findViewById(R.id.button3);
 listView = (ListView)findViewById(R.id.ListView1);
 handler=new Handler();
 ListElementsArrayList = new ArrayList<String>(Arrays.asList(ListElements));
 adapter = new ArrayAdapter<String>(stopwatch.this,
 android.R.layout.simple_list_item_1,
 ListElementsArrayList
 );
 listView.setAdapter(adapter);
 btnStart.setOnClickListener(new View.OnClickListener() {
 @Override
 public void onClick(View v) {
 tstart= SystemClock.uptimeMillis();
 handler.postDelayed(runnable,0);
 btnReset.setEnabled(false);
 btnStart.setEnabled(false);
 btnPause.setEnabled(true);
 }
 });
 btnPause.setOnClickListener(new View.OnClickListener() {
 @Override
 public void onClick(View v) {
 tbuff += tmilli;
 handler.removeCallbacks(runnable);
 btnReset.setEnabled(true);
 btnStart.setEnabled(true);
 btnPause.setEnabled(false);
 ListElementsArrayList.add(tv.getText().toString());
 adapter.notifyDataSetChanged();
 }
 });
 btnReset.setOnClickListener(new View.OnClickListener() {
 @Override
 public void onClick(View v) {
 tmilli=0L;
 tbuff=0L;
 tstart=0L;
 tupdate=0L;
 sec=0;
 min=0;
 msec=0;
 tv.setText("00:00:00");
 btnPause.setEnabled(false);
 ListElementsArrayList.clear();
 adapter.notifyDataSetChanged();
 }
 });
 }
 public Runnable runnable = new Runnable() {
 @Override
 public void run() {
 tmilli= SystemClock.uptimeMillis()-tstart;
 tupdate=tbuff+tmilli;
 sec=(int)(tupdate/1000);
 min=sec/60;
 sec=sec%60;
 msec=(int)(tupdate%100);

tv.setText(String.format("%02d",min)+":"+String.format("%02d",sec)+":"+String.format("%
02d",msec));
 handler.postDelayed(this,60);
 }
 };
}
