package com.wuyz.mvpdemo.listener;

/**
 * Created by wuyz on 21/05/2017.
 */

public interface IUserBiz {
    void login(String name, String password, ILoginListener listener);
}
