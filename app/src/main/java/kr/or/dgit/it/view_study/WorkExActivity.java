package kr.or.dgit.it.view_study;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class WorkExActivity extends AppCompatActivity {
    AlertDialog cusDialog;
    TextView tv ;
    String s = "";
    EditText et01;
    EditText et02;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_ex2);
        tv = findViewById(R.id.tv_test);
    }

    private void showToast(String message){
        Toast t= Toast.makeText(this,message,Toast.LENGTH_LONG);
        t.show();
    }
    DialogInterface.OnClickListener dialogListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if(which==DialogInterface.BUTTON_NEGATIVE){
                showToast("취소하였습니다.");
            }if(which==DialogInterface.BUTTON_POSITIVE){
                s+= et01.getText()+"\r\n"+et02.getText();
                tv.setText(s);
            }
        }
    };

    public void onClickWork(View view) {
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        View v =inflater.inflate(R.layout.work_layout,null);
        builder.setView(v);

        et01 = v.findViewById(R.id.textview01);
        et02 = v.findViewById(R.id.textview02);



        builder.setPositiveButton("확인",dialogListener);
        builder.setNegativeButton("취소",dialogListener);
        cusDialog = builder.create();
        cusDialog.show();

    }
}
