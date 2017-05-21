package com.wuyz.mvpdemo;

import android.os.Handler;

import com.wuyz.mvpdemo.entity.User;
import com.wuyz.mvpdemo.listener.ILoginListener;
import com.wuyz.mvpdemo.listener.IUserBiz;
import com.wuyz.mvpdemo.listener.IUserLoginView;

/**
 * Created by wuyz on 21/05/2017.
 */

public class UserLoginPresenter {
    private IUserBiz userBiz;
    private IUserLoginView loginView;
    private Handler uiHandler = new Handler();

    public UserLoginPresenter(IUserLoginView loginView) {
        this.loginView = loginView;
        userBiz = new UserBiz();
    }

    public void login() {
        loginView.showLoading();
        userBiz.login(loginView.getUserName(), loginView.getPassword(), new ILoginListener() {
            @Override
            public void onLoginSuccess(final User user) {
                uiHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.toMainActivity(user);
                        loginView.hideLoading();
                    }
                });
            }

            @Override
            public void onLoginFailed() {
                uiHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.hideLoading();
                        loginView.showFailError();
                    }
                });
            }
        });
    }

    public void clear() {
        loginView.clearPassword();
        loginView.clearUserName();
    }
}
