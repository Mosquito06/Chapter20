package kr.or.dgit.bigdata.chapter20;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class DisplayScoreReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "동환 vs 재진 = ?", Toast.LENGTH_SHORT).show();
    }
}
