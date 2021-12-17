package com.example.myclock;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {
 Button b1,b2,b3;
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_main);
 b1=(Button)findViewById(R.id.btn1);
 b2=(Button)findViewById(R.id.btn2);
 b3=(Button)findViewById(R.id.btn3);
 b1.setOnClickListener(new View.OnClickListener() {
 @Override
 public void onClick(View v) {
 Intent i=new Intent(getApplicationContext(),stopwatch.class);
 startActivity(i);
 }
 });
 b2.setOnClickListener(new View.OnClickListener() {
 @Override
 public void onClick(View v) {
 Intent i=new Intent(getApplicationContext(),alarm.class);
 startActivity(i);
 }
 });
 b3.setOnClickListener(new View.OnClickListener() {
 @Override
 public void onClick(View v) {
 Intent i=new Intent(getApplicationContext(),timer.class);
 startActivity(i);
 }
 });
 }
}
