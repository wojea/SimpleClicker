package com.example.simpleclicker.loginmvp

class LoginPresenter(_view: LoginContract.View) : LoginContract.Presenter {

    private var view: LoginContract.View = _view
    private var model: LoginContract.Model = LoginModel(view.getApp())

    init {
        view.initView()
    }

    override fun login(username: String, password: String): Boolean {
        return model.login(username, password)
    }

}