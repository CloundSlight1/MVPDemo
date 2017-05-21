package com.wuyz.mvpdemo.listener;

import com.wuyz.mvpdemo.entity.User;

/**
 * Created by wuyz on 21/05/2017.
 */

public interface IUserLoginView {
    String getUserName();
    String getPassword();
    void clearUserName();
    void clearPassword();
    void showLoading();
    void hideLoading();
    void toMainActivity(User user);
    void showFailError();
}
