package com.example.myclock;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;
import java.util.Date;
public class alarm extends AppCompatActivity {
 TimePicker timePicker;
 Button b1;
 TextView textView;
 int mHour,mMin;
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.alarm);
 timePicker=findViewById(R.id.tp1);
 b1=findViewById(R.id.btn1);
 textView=findViewById(R.id.textView1);
 setTitle("ALARM");
 timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
 @Override
 public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
 mHour=hourOfDay;
 mMin=minute;
 textView.setText(mHour+":"+mMin);
 }
 });
 }
 public void setTimer(View v){
 AlarmManager
alarmManager=(AlarmManager)getSystemService(Context.ALARM_SERVICE);
 Date date=new Date();
 Calendar cal_alarm=Calendar.getInstance();
 Calendar cal_now=Calendar.getInstance();
 cal_now.setTime(date);
 cal_alarm.setTime(date);
 cal_alarm.set(Calendar.HOUR_OF_DAY,mHour);
 cal_alarm.set(Calendar.MINUTE,mMin);
 cal_alarm.set(Calendar.SECOND,0);
 if(cal_alarm.before(cal_now))
 {
 cal_alarm.add(Calendar.DATE,1);
 }
 Intent i=new Intent(alarm.this,MyBroadcastReceiver.class);
 PendingIntent pendingIntent=PendingIntent.getBroadcast(alarm.this,24444,i,0);

alarmManager.set(AlarmManager.RTC_WAKEUP,cal_alarm.getTimeInMillis(),pendingInten
t);
 Toast.makeText(getApplicationContext(),"Alarm set at
"+mHour+":"+mMin,Toast.LENGTH_LONG).show();
 }
}
