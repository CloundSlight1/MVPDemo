package com.wuyz.mvpdemo.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.wuyz.mvpdemo.R;
import com.wuyz.mvpdemo.UserLoginPresenter;
import com.wuyz.mvpdemo.entity.User;
import com.wuyz.mvpdemo.listener.IUserLoginView;

/**
 * Created by wuyz on 21/05/2017.
 */

public class LoginActivity extends Activity implements IUserLoginView {

    private EditText nameEdit;
    private EditText passwordEdit;
    private Button loginButton;
    private Button clearButton;
    private ProgressBar loadingProgress;

    private UserLoginPresenter presenter = new UserLoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
       initViews();
    }

    private void initViews() {
        nameEdit = (EditText) findViewById(R.id.name_edit);
        passwordEdit = (EditText) findViewById(R.id.password_edit);
        loginButton = (Button) findViewById(R.id.submit_button);
        clearButton = (Button) findViewById(R.id.clear_button);
        loadingProgress = (ProgressBar) findViewById(R.id.loading_progress);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.login();
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.clear();
            }
        });
    }

    @Override
    public String getUserName() {
        return nameEdit.getText().toString();
    }

    @Override
    public String getPassword() {
        return passwordEdit.getText().toString();
    }

    @Override
    public void clearUserName() {
        nameEdit.getText().clear();
    }

    @Override
    public void clearPassword() {
        passwordEdit.getText().clear();
    }

    @Override
    public void showLoading() {
        loadingProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        loadingProgress.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity(User user) {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void showFailError() {
        Toast.makeText(this, "login error", Toast.LENGTH_SHORT).show();
    }
}
