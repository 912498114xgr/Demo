package com.albert.xgrmvpdemo.Presenter;

import com.albert.xgrmvpdemo.Listener.OnLoginFinishedListener;
import com.albert.xgrmvpdemo.Model.LoginModel;
import com.albert.xgrmvpdemo.Model.LoginModelImpl;
import com.albert.xgrmvpdemo.View.LoginView;

/**
 * Created by Administrator on 2018/5/9/009.
 */

public class LoginPresenterImpl implements LoginPresenter, OnLoginFinishedListener {
    /**
     * p层实现类得到m v层接口的实例
     */

    private LoginView loginView;
    private LoginModel loginModel;

    /**
     * P层通过构造方法初始化View层传入的接口实例
     * @param loginView
     */
    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.loginModel = new LoginModelImpl();
    }
    @Override
    public void validateCredentials(String username, String password) {
        if (loginView != null) {
            loginView.showProgress();
        }

        loginModel.login(username, password, this);
    }

    @Override
    public void onDestroy() {
        loginView = null;
    }

    @Override
    public void onUsernameError() {
        if (loginView != null) {
            loginView.setUsernameError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onPasswordError() {
        if (loginView != null) {
            loginView.setPasswordError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onSuccess() {
        if (loginView != null) {
            loginView.navigateToHome();
        }
    }
}
