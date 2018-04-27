package kr.or.dgit.it.view_study;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ResourcesLanguageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources_language);
        setTitle(getIntent().getStringExtra("title"));
    }
}
