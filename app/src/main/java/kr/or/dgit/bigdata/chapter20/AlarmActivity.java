package kr.or.dgit.bigdata.chapter20;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Calendar;

public class AlarmActivity extends AppCompatActivity {
    private AlarmManager alarmMgr;
    private PendingIntent mSender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        alarmMgr = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

    }


    public void mOneTimeButtonClicked(View view) {
        Intent intent = new Intent(this, AlarmReceiver.class);
        PendingIntent sender = PendingIntent.getBroadcast(this, 0, intent, 0);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(Calendar.SECOND, 3);

        alarmMgr.set(AlarmManager.RTC, calendar.getTimeInMillis(), sender);


}

    public void mRepeatButtonClicked(View view) {
        Intent intent = new Intent(this, DisplayScoreReceiver.class);
        mSender = PendingIntent.getBroadcast(this, 0, intent, 0);
        alarmMgr.setRepeating(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime(), 3000, mSender);
    }

    public void mStopButtonClicked(View view) {
        alarmMgr.cancel(mSender);
    }
}
