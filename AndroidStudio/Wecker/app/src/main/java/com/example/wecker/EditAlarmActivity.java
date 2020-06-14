package com.example.wecker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TimePicker;


public class EditAlarmActivity extends AppCompatActivity {

    AlarmClock alarmClock = new AlarmClock(05,00,false);
    TimePicker timepicker;
    //man muss allen Buttons eine extistenzberechtigung geben, vor der onCreate Method, damit man
    //in der onCreate Methode nochmal IDs festlegen.
    Button moB;
    Button diB;
    Button miB;
    Button doB;
    Button frB;
    Button saB;
    Button soB;
    Switch editSwitch;
    Button okayB;
    //wenn man das nicht macht, müssten die final sein und das ist rotz.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_alarm);

        moB= findViewById(R.id.moB);
        diB=findViewById(R.id.diB);
        miB=findViewById(R.id.miB);
        doB=findViewById(R.id.doB);
        frB=findViewById(R.id.frB);
        saB=findViewById(R.id.saB);
        soB=findViewById(R.id.soB);

        okayB=findViewById(R.id.okayB);
        editSwitch=findViewById(R.id.editSwitch);
        timepicker=findViewById(R.id.timePicker);
        alarmClock.setAlarmOn(false);


        setColor(moB,0);
        setColor(diB,1);
        setColor(miB,2);
        setColor(doB,3);
        setColor(frB,4);
        setColor(saB,5);
        setColor(soB,6);

        //reads data from timepicker
            okayB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    alarmClock.setHour(timepicker.getHour());
                    alarmClock.setMinute(timepicker.getMinute());
                }
            });

        public void setSwitch(Switch editSwitch) {
        editSwitch.setOnCheckedChangeListener((CompoundButton buttonView, boolean isChecked)->{
            if (alarmClock.isAlarmOn()) {
                alarmClock.setAlarmOn(false);
            }else{
                alarmClock.setAlarmOn(true);
            }
        });
        }}

    @SuppressLint("ResourceAsColor")
        public void setColor(Button button, int id){
            button.setOnClickListener(lambda ->{
                alarmClock.toggleDay(id);
                if (alarmClock.getDays(id)) {

                    button.setBackgroundColor(R.color.orange);
                }else{
                    button.setBackgroundColor(R.color.white);
                }
            });
        }

        public void androidData(Button button){
        button.setOnClickListener(v->{
            Log.i("Logbuch", alarmClock.toString());
            WriterService.writeObject(EditAlarmActivity.this, alarmClock);
            Intent intent = new Intent(EditAlarmActivity.this, MainActivity.class);
            startActivity(intent);
        });
        }
            }






