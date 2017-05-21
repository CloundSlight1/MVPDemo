package com.wuyz.mvpdemo;

import com.wuyz.mvpdemo.entity.User;
import com.wuyz.mvpdemo.listener.ILoginListener;
import com.wuyz.mvpdemo.listener.IUserBiz;

/**
 * Created by wuyz on 21/05/2017.
 */

public class UserBiz implements IUserBiz {
    @Override
    public void login(final String name, final String password, final ILoginListener listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ("wuyuz".equalsIgnoreCase(name) && "123456".equals(password)) {
                    User user = new User();
                    user.setName(name);
                    user.setPassword(password);
                    listener.onLoginSuccess(user);
                } else {
                    listener.onLoginFailed();
                }
            }
        }).start();
    }
}
