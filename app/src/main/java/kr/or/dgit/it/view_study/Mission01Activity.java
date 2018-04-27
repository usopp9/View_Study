package kr.or.dgit.it.view_study;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Mission01Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission01);
        setTitle(getIntent().getStringExtra("title"));
    }

    public void misstion01Click(View view) {
        Toast.makeText(this,"ok button click~",Toast.LENGTH_SHORT).show();
    }


}
