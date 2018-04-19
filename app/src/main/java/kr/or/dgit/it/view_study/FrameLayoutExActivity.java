package kr.or.dgit.it.view_study;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FrameLayoutExActivity extends AppCompatActivity {

    TextView tv01;
    TextView tv02;
    TextView tv03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout_ex);
        setTitle(getIntent().getStringExtra("title"));
        tv01 = findViewById(R.id.tv01);
        tv02 = findViewById(R.id.tv02);
        tv03 = findViewById(R.id.tv03);

    }

    public void mOnClickFrame(View view) {
        if(view.getId() == R.id.btnBlue){
            visibleTextView(View.INVISIBLE,View.INVISIBLE,View.VISIBLE);
        }
        if(view.getId() == R.id.btnGreen){
            visibleTextView(View.INVISIBLE,View.VISIBLE,View.INVISIBLE);
        }
        if(view.getId() == R.id.btnRed){
            visibleTextView(View.VISIBLE,View.INVISIBLE,View.INVISIBLE);
        }
        if(view.getId() == R.id.btnT){
            visibleTextView(View.VISIBLE,View.VISIBLE,View.VISIBLE);
        }
        if(view.getId() == R.id.btnF){
            Toast.makeText(this,"dddd",Toast.LENGTH_SHORT).show();
            visibleTextView(View.INVISIBLE,View.INVISIBLE,View.INVISIBLE);
        }
    }


    public void visibleTextView(int...isVisible){
        tv01.setVisibility(isVisible[0]);
        tv02.setVisibility(isVisible[1]);
        tv03.setVisibility(isVisible[2]);
    }
}
