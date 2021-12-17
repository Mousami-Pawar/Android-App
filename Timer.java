package com.example.myclock;
import java.util.Locale;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class timer extends AppCompatActivity {
 Button btn,btn1;
 EditText et1;
 TextView tv2,tv1;
 CountDownTimer c1;
 long sec,min;
 String s1;
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.timer1);
 setTitle("TIMER");
 btn=(Button)findViewById(R.id.b1);
 et1=(EditText)findViewById(R.id.e1);
 tv2=(TextView)findViewById(R.id.t2);
 tv1=(TextView)findViewById(R.id.t1);
 btn1=(Button)findViewById(R.id.b2);
 btn1.setEnabled(false);
 btn.setOnClickListener(new View.OnClickListener() {
 @Override
 public void onClick(View v) {
 String str=et1.getText().toString();
 long time=Long.parseLong(str)*1000;
 c1=new CountDownTimer(time, 1000) {
 public void onTick(long millisUntilFinished) {
 min=(int) (millisUntilFinished / 1000) / 60;
 sec= (int) (millisUntilFinished / 1000) % 60;
 s1=String.format(Locale.getDefault(), "%02d:%02d", min, sec);
 tv2.setText(s1);
 et1.setVisibility(View.INVISIBLE);
 tv1.setVisibility(View.INVISIBLE);
 btn.setEnabled(false);
 btn1.setEnabled(true);
 }
 public void onFinish() {
 tv2.setText("Time's Up");
 }
 }.start();
 }
 });
 btn1.setOnClickListener(new View.OnClickListener() {
 @Override
 public void onClick(View v) {
 c1.cancel();
 et1.setText("");
 tv2.setText("");
 et1.setVisibility(View.VISIBLE);
 tv1.setVisibility(View.VISIBLE);
 btn.setEnabled(true);
 btn1.setEnabled(false);
 }
 });
 }
}
