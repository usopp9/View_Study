package kr.or.dgit.it.view_study;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class CustomEventExActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    Switch switchOnof;
    CheckBox checkRepear;

    CheckBox checkVibrate;
    float intitX;
    long initTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_event_ex);
        setTitle(getIntent().getStringExtra("title"));

        switchOnof = findViewById(R.id.onOff);
        checkRepear = findViewById(R.id.repearCheck);

        checkVibrate = findViewById(R.id.vibrate);

        switchOnof.setOnCheckedChangeListener(this);
        checkRepear.setOnCheckedChangeListener(this);
        checkVibrate.setOnCheckedChangeListener(this);

    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void onBellClicked(View view) {
        Toast.makeText(this, "Bell text click event.....", Toast.LENGTH_SHORT).show();
}

    public void onLabelClick(View view) {
        Toast.makeText(this, "label text click event.....", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(buttonView==switchOnof){
            Toast.makeText(this, "switch is "+isChecked, Toast.LENGTH_SHORT).show();
        }
        if(buttonView==checkRepear){
            Toast.makeText(this, "repeat checkbox is  "+isChecked, Toast.LENGTH_SHORT).show();
        }
        if(buttonView==checkVibrate){
            Toast.makeText(this, "vibrate checkbox is  "+isChecked, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction()==MotionEvent.ACTION_DOWN){
            intitX =event.getRawX();
        }else if(event.getAction()==MotionEvent.ACTION_UP){
            float diffX= intitX - event.getRawX();
            if(diffX>30){
                Toast.makeText(this, "왼쪽으로 화면을 밀었습니다.", Toast.LENGTH_SHORT).show();
            }else if(diffX < -30){
                Toast.makeText(this, "오른쪽으로 화면을 밀었습니다.", Toast.LENGTH_SHORT).show();
            }
        }
        return true;
    }


    @Override
    public void onBackPressed() {
        if(System.currentTimeMillis() - initTime >3000){
            Toast.makeText(this, "종료할려면 한번 더 누르세요.", Toast.LENGTH_SHORT).show();
            initTime = System.currentTimeMillis();
        }else{
            finish();
        }
    }
}
