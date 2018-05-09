package com.albert.xgrmvpdemo.Model;

import com.albert.xgrmvpdemo.Listener.OnLoginFinishedListener;

/**
 * Created by Administrator on 2018/5/9/009.
 *
 * 数据模型层
 */

public interface LoginModel {

    void login(String username, String password, OnLoginFinishedListener listener);

}
