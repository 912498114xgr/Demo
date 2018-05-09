package com.albert.xgrmvpdemo.Model;

import android.os.Handler;
import android.text.TextUtils;

import com.albert.xgrmvpdemo.Listener.OnLoginFinishedListener;

/**
 * Created by Administrator on 2018/5/9/009.
 * model层实现相对应的接口 接口里面定义所要做的方法或逻辑
 *
 */

public class LoginModelImpl implements LoginModel {

    @Override
    public void login(final String username, final String password, final OnLoginFinishedListener listener) {

        new Handler().postDelayed(new Runnable() {

            @Override public void run() {
                boolean error = false;
                if (TextUtils.isEmpty(username)){
                    listener.onUsernameError();//model层里面回调listener
                    error = true;
                }
                if (TextUtils.isEmpty(password)){
                    listener.onPasswordError();
                    error = true;
                }
                if (!error){
                    listener.onSuccess();
                }
            }
        }, 2000);
    }
}
