package com.fota.android.testoption;

import android.os.Bundle;

import com.fota.option.OptionManager;

public class LoginPageActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OptionManager.userId = "2509642342249006080";
        OptionManager.token = "uff95dv1jh";
    }

    @Override
    int getPageName() {
        return R.string.login_page_name;
    }
}
