package kr.or.dgit.it.view_study;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewBasicActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mTextView;

    Button trueBtn;
    Button falseBtn;
    TextView mTextView02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*Intent intent = getIntent();
        int titleId = intent.getIntExtra("title", 0 );*/

        setTitle(getIntent().getStringExtra("title"));

        setContentView(R.layout.activity_view_basic);

        mTextView = findViewById(R.id.tv);
        trueBtn = findViewById(R.id.trueBtn);
        falseBtn = findViewById(R.id.falseBtn);
        mTextView02 = findViewById(R.id.tv02);

        trueBtn.setOnClickListener(this);
        falseBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v == trueBtn) {
            mTextView02.setVisibility(View.VISIBLE);
        } else {
            mTextView02.setVisibility(View.GONE);
        }
    }

    public void trueBtn01Click(View view) {
        if (!mTextView.isShown()) {
            mTextView.setVisibility(View.VISIBLE);
        }
    }

    public void falseBtn02Click(View view) {
        if (mTextView.isShown()) {
            mTextView.setVisibility(View.INVISIBLE);
        }
    }
}
