package com.wuyz.mvpdemo.listener;

import com.wuyz.mvpdemo.entity.User;

/**
 * Created by wuyz on 21/05/2017.
 */

public interface ILoginListener {
    void onLoginSuccess(User user);
    void onLoginFailed();
}
