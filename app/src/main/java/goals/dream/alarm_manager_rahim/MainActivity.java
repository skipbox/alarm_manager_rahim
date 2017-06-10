package goals.dream.alarm_manager_rahim;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.icu.util.GregorianCalendar;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import static android.R.attr.name;
import static android.R.attr.value;

public class MainActivity extends AppCompatActivity {

//http://www.newthinktank.com/2014/12/make-android-apps-19/
//when you add AlarmReciever class right click on the same folder as MainActivity

//<!-- Permission to use AlarmManager -->
//<uses-permission android:name="com.android.alarm.permission.SET_ALARM"/>
// need this - guess what you just saved about 22 minutes of googling
//if class is red its becasuse GIT hub is just warning you... but it still works
//right click make new class just use defaults
//</activity>
//important   !!!!! must make class named AlertReceiver for this to fucking work
//<receiver android:name=".AlertReceiver"/>
//</application>
//</manifest>

//2 parts you start the manager and basically SET the alarm
//then you set the receiver ... which listens for the alarm


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setVisibility(View.GONE);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

       //button clicks------------------------------------------------------------------
    public void buttonOnClick(View view) {
        int the_id = view.getId();
        if (the_id == R.id.b_1) {

            Toast.makeText(this, "Alarm Set", Toast.LENGTH_SHORT).show();
            // Define a time value of 5 seconds

            Long alertTime = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                //This is getting current time and adding 10 seconds to set alarm trigger time
                alertTime = new GregorianCalendar().getTimeInMillis()+10*1000;
            }

//How to get time left on alarm?
//AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
//        Long NexClockTime = alarmManager.getNextAlarmClock().getTriggerTime();
//        Long now = System.currentTimeMillis();
//        Long timeLeft = NexClockTime - now;


//getNextAlarmClock() was added in API 21 – Kirill Karmazin Mar 5 at 18:39

           // is it possible to think something works ... but it does not work ?


            // Define our intention of executing AlertReceiver
            Intent alertIntent = new Intent(this, AlertReceiver.class);

            // Allows you to schedule for your application to do something at a later date
            // even if it is in he background or isn't active
            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            // set() schedules an alarm to trigger
            // Trigger for alertIntent to fire in 5 seconds
            // FLAG_UPDATE_CURRENT : Update the Intent if active
            alarmManager.set(AlarmManager.RTC_WAKEUP, alertTime,
                    PendingIntent.getBroadcast(this, 1, alertIntent,
                            PendingIntent.FLAG_UPDATE_CURRENT));

        }
        if (the_id == R.id.b_2) {
            Toast.makeText(this, "but_2_works", Toast.LENGTH_SHORT).show();
            AlarmManager my_alarm_manager = (AlarmManager) getSystemService(ALARM_SERVICE);
            Long NexClockTime = my_alarm_manager.getNextAlarmClock().getTriggerTime();
            Long now = System.currentTimeMillis();
            Long timeLeft = NexClockTime - now;


            //Toast.makeText(this, "Time remaining = "+timeLeft, Toast.LENGTH_SHORT).show();
            Button b_1_x = (Button)findViewById(R.id.b_1);
            //b_1_x.setText("Time = "+timeLeft);
            b_1_x.setText("Time");
        }
        //if (the_id == R.id.b_3) {Toast.makeText(this, "but_3_works", Toast.LENGTH_SHORT).show();
       // }
        }
 //=============

}
