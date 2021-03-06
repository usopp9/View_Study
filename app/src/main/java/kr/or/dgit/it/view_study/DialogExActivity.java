package kr.or.dgit.it.view_study;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v4.widget.CircularProgressDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class DialogExActivity extends AppCompatActivity implements View.OnClickListener{
    TextView tv;
    Button alertBtn;
    Button listBtn;
    Button progressBtn;
    Button dateBtn;
    Button timeBtn;
    Button customDialogBtn;

    AlertDialog customDialog;
    AlertDialog listDialog;
    AlertDialog alertDialog;
    String s = "";
    private String[] datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_ex);
        setTitle(getIntent().getStringExtra("title"));

        tv = findViewById(R.id.tv_result);


        alertBtn= findViewById(R.id.btn_alert);
        listBtn = findViewById(R.id.btn_list);
        progressBtn = findViewById(R.id.btn_progress);
        dateBtn = findViewById(R.id.btn_date);
        timeBtn=findViewById(R.id.btn_time);
        customDialogBtn=findViewById(R.id.btn_custom);

        alertBtn.setOnClickListener(this);
        listBtn.setOnClickListener(this);
        progressBtn.setOnClickListener(this);
        dateBtn.setOnClickListener(this);
        timeBtn.setOnClickListener(this);
        customDialogBtn.setOnClickListener(this);
        datas = getResources().getStringArray(R.array.dialog_array);

    }

    private void showToast(String message){
        Toast toast=Toast.makeText(this,message,Toast.LENGTH_SHORT);
        toast.show();

        s+= message+"\r\n";
        tv.setText(s);

    }
    DialogInterface.OnClickListener dialogListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if(dialog==customDialog && which ==DialogInterface.BUTTON_POSITIVE){

                showToast("확인");
            }else if(dialog==listDialog){

                showToast(datas[which]+"선택 하셨습니다.");
            }else if(dialog==alertDialog && which==DialogInterface.BUTTON_POSITIVE){
                showToast("확인");
            }
        }
    };

    @Override
    public void onClick(View v) {
        if(v==alertBtn){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setIcon(android.R.drawable.ic_dialog_alert);
            builder.setTitle("알림");
            builder.setMessage("정말 종료 하시겠습니까?");
            builder.setPositiveButton("OK",dialogListener);
            builder.setNegativeButton("NO",null);

            alertDialog=builder.create();
            alertDialog.show();
        }else if(v==listBtn){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("알람 벨소리");
            builder.setSingleChoiceItems(R.array.dialog_array,0,dialogListener);

            builder.setPositiveButton("확인",null);
            builder.setNegativeButton("취소",null);
            listDialog=builder.create();
            listDialog.show();
        }else if(v==progressBtn){
            ProgressDialog progressDialog= new ProgressDialog(this);
            progressDialog.setIcon(android.R.drawable.ic_dialog_alert);
            progressDialog.setTitle("Wait.....");
            progressDialog.setMessage("서버 연동중입니다. 잠시만 기다리세요.");

            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.setIndeterminate(true);

            progressDialog.show();
        }else if(v==dateBtn){
            Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month =c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dateDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    showToast(year+":"+(month+1)+":"+dayOfMonth);
                }
            },year,month,day);
            dateDialog.show();
        }else if(v==timeBtn){
            Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            TimePickerDialog timeDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    showToast(hourOfDay+":"+minute);
                }
            },hour,minute,false);
            timeDialog.show();
        }else if(v==customDialogBtn){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.dialog_layout,null);
            CheckBox cb = view.findViewById(R.id.chCheck);
            cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    showToast(isChecked?"디버깅 항상 허용":"허용하지 않음");
                }
            });


            builder.setView(view);

            builder.setPositiveButton("확인",dialogListener);
            builder.setNegativeButton("취소",null);

            customDialog=builder.create();
            customDialog.show();
        }
    }
}
