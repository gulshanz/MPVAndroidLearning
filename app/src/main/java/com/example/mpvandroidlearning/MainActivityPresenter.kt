package com.example.mpvandroidlearning

class MainActivityPresenter : MainActivityContract.Presenter {
    var view: MainActivityContract.View

    constructor(view: MainActivityContract.View) {
        this.view = view
    }


    override fun doLogin(email: String, password: String) {
        val rEmail = "email@mail.com"
        val rPassword = "password"
        if (email == rEmail && rPassword == password) {
            view.onSuccess("Successful")
        } else {
            view.onError("Wrong email or password")
        }
    }
}