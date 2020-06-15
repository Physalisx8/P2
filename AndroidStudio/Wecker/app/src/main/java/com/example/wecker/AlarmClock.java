package com.example.wecker;

import android.util.Log;

import java.io.Serializable;
import java.util.Arrays;

public class AlarmClock implements Serializable {
    public boolean alarmOn;
    public int minute;
    public int hour;
    public boolean days[]= new boolean[7];
  //  public void DaysPrevious (String args[]) {
    //    for (int i = 0; i < 8; i++) {
      //      days[i] = false;
     //   }
  //  }




    //Constructor minus day
    public AlarmClock(int hour, int minute, boolean alarmOn) {
        super();
        this.minute = minute;
        this.hour = hour;
        this.alarmOn = alarmOn;
    }

    public boolean isAlarmOn() {
        return alarmOn;
    }

    public void setAlarmOn(boolean alarmOn) {
        this.alarmOn = alarmOn;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public boolean[] getDays() {
        return days;
    }

    public void setDays(boolean[] days) {
        this.days = days;
    }

    @Override
    public String toString(){
        return "AlarmClock{" +
                "alarmHour=" + hour +
                ", alarmMinute=" + minute +
                ", alarmDay=" + Arrays.toString(days) +
                ", alarmOn=" + alarmOn +
                '}';


    }

    public void toggleDay(int id) {
        days[id] = !days[id];
        Log.i("Toggle", "you've been toogled" + days[id]);
    }

    public boolean getDays( int id){
        return days[id];
    }
}
