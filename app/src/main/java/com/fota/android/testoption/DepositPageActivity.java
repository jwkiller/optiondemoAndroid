package com.fota.android.testoption;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.fota.option.OptionSdkActivity;

public class DepositPageActivity extends BaseActivity {

    @Override
    int getPageName() {
        return R.string.deposit_page_name;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImageView imageView = new ImageView(this);
        //Glide.with(this).load("").into(imageView);
        //Glide.with(this).applyDefaultRequestOptions()
    }
}
