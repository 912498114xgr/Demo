package com.albert.xgrmvpdemo.Presenter;

/**
 * Created by Administrator on 2018/5/9/009.
 *
 */

public interface LoginPresenter {

    void validateCredentials(String username, String password);

    void onDestroy();


}
