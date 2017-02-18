package com.handsome.didi.Activity.Mine;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.handsome.didi.Base.BaseActivity;
import com.handsome.didi.Controller.UserController;
import com.handsome.didi.R;
import com.handsome.didi.Utils.ToastUtils;

public class RegisterActivity extends BaseActivity {

    private UserController userController;
    //界面
    private EditText et_password, et_username, et_password_again;
    private Button bt_register;

    @Override
    public void initViews() {
        setContentView(R.layout.activity_register);
        et_password = (EditText) findViewById(R.id.et_password);
        et_username = (EditText) findViewById(R.id.et_username);
        et_password_again = (EditText) findViewById(R.id.et_password_again);
        bt_register = (Button) findViewById(R.id.bt_register);
    }

    @Override
    public void initListener() {
        bt_register.setOnClickListener(this);
    }

    @Override
    public void initData() {
        userController = new UserController(this);
        userController.setTitle(this, "免费注册");
    }

    @Override
    public void processClick(View v) {
        switch (v.getId()) {
            case R.id.bt_register:
                String username = et_username.getText().toString().trim();
                String password = et_password.getText().toString().trim();
                String password_again = et_password_again.getText().toString().trim();
                register(username, password, password_again);
                break;
        }
    }

    /**
     * 用户注册
     *
     * @param username
     * @param password
     * @param password_again
     */
    private void register(String username, String password, String password_again) {
        userController.register(username, password, password_again, new UserController.OnRegisterListener() {
            @Override
            public void onRegister(boolean isRegister) {
                if (isRegister) {

                }
            }
        });
    }

}
