package kr.or.dgit.it.view_study;

import android.app.Activity;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void mOnClick(View view) {
        Intent intent = new Intent();
        if(view.getId()==R.id.btnMain01){
            intent.setClass(this, ViewBasicActivity.class);
            intent.putExtra("title",((Button)view).getText());
        }
        if(view.getId()==R.id.btnMain02){
            intent.setClass(this, TextViewExActivity.class);
            intent.putExtra("title",((Button)view).getText());
        }
        if(view.getId()==R.id.btmMain03){
            intent.setClass(this, LinearLayoutExActivity.class);
            intent.putExtra("title",((Button)view).getText());
        }
        if(view.getId()==R.id.btmMain04){
            intent.setClass(this, RelativeLayoutExActivity.class);
            intent.putExtra("title",((Button)view).getText());
        }
        if(view.getId()==R.id.btmMain05){
            intent.setClass(this, FrameLayoutExActivity.class);
            intent.putExtra("title",((Button)view).getText());
        }
        if(view.getId()==R.id.btmMain06){
            intent.setClass(this, TabHostExActivity.class);
            intent.putExtra("title",((Button)view).getText());
        }
        if(view.getId()==R.id.btmMain07){
            intent.setClass(this, TGridLayoutExActivity.class);
            intent.putExtra("title",((Button)view).getText());
        }
        if(view.getId()==R.id.btmMain08){
            intent.setClass(this, VibratorAlarmActivity.class);
            intent.putExtra("title",((Button)view).getText());
        }
        if(view.getId()==R.id.btmMain09){
            intent.setClass(this, DialogExActivity.class);
            intent.putExtra("title",((Button)view).getText());
        }
        if(view.getId()==R.id.btmMain10){
            intent.setClass(this, WorkExActivity.class);
            intent.putExtra("title",((Button)view).getText());
        }
        if(view.getId()==R.id.btmMain11){
            intent.setClass(this, CustomEventExActivity.class);
            intent.putExtra("title",((Button)view).getText());
        }
        if(view.getId()==R.id.btmMain12){
            intent.setClass(this, ResourcesActivity.class);
            intent.putExtra("title",((Button)view).getText());
        }
        if(view.getId()==R.id.btmMain13){
            intent.setClass(this, ResourcesLanguageActivity.class);
            intent.putExtra("title",((Button)view).getText());
        }
        if(view.getId()==R.id.btmMain14){
            intent.setClass(this, Mission01Activity.class);
            intent.putExtra("title",((Button)view).getText());
        }
        if(view.getId()==R.id.btmMain15){
            intent.setClass(this, Mission02Activity.class);
            intent.putExtra("title",((Button)view).getText());
        }
        if(view.getId()==R.id.btmMain16){
            intent.setClass(this, Mission03Activity.class);
            intent.putExtra("title",((Button)view).getText());
        }
        startActivity(intent);
    }
}