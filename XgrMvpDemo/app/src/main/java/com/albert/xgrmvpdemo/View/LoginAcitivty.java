package com.albert.xgrmvpdemo.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.albert.xgrmvpdemo.Presenter.LoginPresenter;
import com.albert.xgrmvpdemo.Presenter.LoginPresenterImpl;
import com.albert.xgrmvpdemo.R;

public class LoginAcitivty extends AppCompatActivity implements LoginView, View.OnClickListener {

    private ProgressBar progressBar;
    private EditText username;
    private EditText password;
    //mvp的关系模型可知 view层需要获得一个p层接口的引用
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progress);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        findViewById(R.id.button).setOnClickListener(this);

        //view层得到presenter的实例
        presenter = new LoginPresenterImpl(this);

    }
    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {
        username.setError("用户名有误");
    }

    @Override
    public void setPasswordError() {
        password.setError("密码有误");
    }

    @Override
    public void navigateToHome() {
        Toast.makeText(this,"login success",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        presenter.validateCredentials(username.getText().toString(), password.getText().toString());

    }


    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }
}
