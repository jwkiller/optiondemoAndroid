package com.fota.android.testoption;

import android.gesture.GestureLibraries;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);
        TextView name = (TextView) findViewById(R.id.activity_name);
        TextView title = (TextView) findViewById(R.id.activity_title);
        name.setText(getPageName());
        title.setText(getPageName());
        View back = findViewById(R.id.imb_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }

    abstract int getPageName();
}
