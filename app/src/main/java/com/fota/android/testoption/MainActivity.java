package com.fota.android.testoption;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.fota.option.OptionManager;
import com.fota.option.OptionSdkActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button fab = (Button) findViewById(R.id.enter_option);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        OptionManager.userId = "2509642342249006080";
//                        OptionManager.token = "uff95dv1jh";
//                        OptionManager.setBrokerId("7801250866987737088");
//                    }
//                }, 3000);


                Intent intent = new Intent(MainActivity.this, OptionSdkActivity.class);
                startActivity(intent);

            }
        });
    }


}
