package kr.or.dgit.it.view_study;

import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class VibratorAlarmActivity extends AppCompatActivity {
    MediaPlayer playerme3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {setTitle(getIntent().getStringExtra("title"));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vibrator_alarm);
        setTitle(getIntent().getStringExtra("title"));
    }

    public void onclickAlarm(View view) {
        Vibrator vib = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        MediaPlayer player;


        if(view.getId()==R.id.btnv01){

            vib.vibrate(1000);
        }else if(view.getId()==R.id.btnv02){
            vib.vibrate(new long[]{500,1000,500,1000},-1);
        }else if(view.getId()==R.id.btns){
            Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            Ringtone ringtone = RingtoneManager.getRingtone(getApplicationContext(),notification);
            ringtone.play();
        }else if(view.getId()==R.id.btnc){
            player=MediaPlayer.create(this,R.raw.fallbackring);
            player.start();
        }else if(view.getId()==R.id.btnm){
            playerme3 = MediaPlayer.create(this,R.raw.always);
            playerme3.start();
        }else if(view.getId()==R.id.btnms){
            playerme3.stop();
        }
    }
}
