package kr.or.dgit.it.view_study;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Mission02Activity extends AppCompatActivity {
    AlertDialog alertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission02);
        setTitle(getIntent().getStringExtra("title"));
    }

    DialogInterface.OnClickListener dialogListener=new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            finish();
        }
    };

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("작성중인 내용을 저장하지 않고 나가시겠습니까?");
        builder.setNegativeButton("취소",null);
        builder.setPositiveButton("확인",dialogListener);


        alertDialog=builder.create();
        alertDialog.show();

    }
}
