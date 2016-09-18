package com.tneciv.blueprint.module.login;

import com.tneciv.blueprint.retrofit.ApiServiceFactory;
import com.tneciv.blueprint.retrofit.LoginService;

/**
 * Created by Tneciv
 * on 2016-09-17 19:01 .
 */

public class LoginPresenter implements LoginContract.Presenter {
    private LoginContract.View mView;

    public LoginPresenter(LoginContract.View view) {
        this.mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void subscribe() {
        LoginService loginService = ApiServiceFactory.getInstance("https://dribbble.com/").create(LoginService.class);

    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void login() {

    }
}
