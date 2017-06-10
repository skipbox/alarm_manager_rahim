package goals.dream.alarm_manager_rahim;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

//Make that method as static so you can call without creating the class object
//public static void Mymethod()
//{}
//and call like this way
//MainActivity.Mymethod();

public class AlertReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Alarm Triggered", Toast.LENGTH_LONG).show();
    }
}
