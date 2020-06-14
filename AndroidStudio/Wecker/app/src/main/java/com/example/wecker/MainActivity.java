package com.example.wecker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    AlarmClock alarmClock = new AlarmClock(05, 00, false);
    TextView timeView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton imageButton =  findViewById(R.id.plusButton);
        imageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(MainActivity.this, "Want to add a new entry",
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, EditAlarmActivity.class);
                startActivity(intent);
            }
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Want to add a new entry",
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,
                        EditAlarmActivity.class);
                startActivity(intent);
            }
        });

        Object obj = ReadService.readObject(MainActivity.this);
        if(obj != null){
            Log.i("Hallo", obj.toString() + "main");
            if(obj instanceof AlarmClock){
                alarmClock=(AlarmClock) obj;
                timeView.setText(alarmClock.getHour()+":"+alarmClock.getMinute());


            }
        }
    }
}
