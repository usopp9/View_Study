package kr.or.dgit.it.view_study;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class TextViewExActivity extends AppCompatActivity {

    CheckBox chb;
    RadioGroup radiogroup;
    EditText et;

    RadioButton rbt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view_ex);
        setTitle(getIntent().getStringExtra("title"));

        chb = findViewById(R.id.chbox);
        radiogroup = findViewById(R.id.radiogroup);
        et = findViewById(R.id.edtext);
    }

    public void mOnClickTextView(View view) {
        int rad = radiogroup.getCheckedRadioButtonId();
        rbt = findViewById(rad);

        Toast.makeText(this,et.getText()+":"+chb.getText()+":"+rbt.getText(),Toast.LENGTH_LONG ).show();
    }


    public void mChecked(View view) {
        if(chb.isChecked()==true){
            chb.setText("is Checked");
        }else{
            chb.setText("is unChecked");
        }
    }
}
