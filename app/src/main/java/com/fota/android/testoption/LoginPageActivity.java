package com.fota.android.testoption;

import android.os.Bundle;

import com.fota.option.OptionManager;

public class LoginPageActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    int getPageName() {
        return R.string.login_page_name;
    }
}
