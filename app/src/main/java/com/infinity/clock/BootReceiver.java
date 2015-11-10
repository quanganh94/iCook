package com.infinity.clock;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.Calendar;

/**
 * Created by Administrator on 11/8/2015.
 */
public class BootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            // Set the alarm here.
            AlarmManager alarmMgr = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            Intent tmp = new Intent(context, HourlyService.class);
            PendingIntent alarmIntent = PendingIntent.getService(context, 0, tmp, 0);


            Calendar calendar = Calendar.getInstance();
<<<<<<< HEAD
            calendar.set(Calendar.HOUR_OF_DAY, 22);
            calendar.set(Calendar.MINUTE, 00);
=======
            if (calendar.get(Calendar.HOUR_OF_DAY) >= 10 && calendar.get(Calendar.MINUTE) >= 57) {
                calendar.add(Calendar.DAY_OF_YEAR, 1); // add, not set!
            }
            calendar.set(Calendar.HOUR_OF_DAY, 10);
            calendar.set(Calendar.MINUTE, 57);
>>>>>>> origin/android
            calendar.set(Calendar.SECOND, 00);

            alarmMgr.setInexactRepeating(AlarmManager.RTC, calendar.getTimeInMillis(),
                    AlarmManager.INTERVAL_DAY, alarmIntent);
        }
    }
}
