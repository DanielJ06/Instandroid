package com.danieljrodrigues.instagramclone.login.presentation;

public interface LoginView {

    void onFailureForm(String emailError, String passwordError);

    void onUserLogged();

}
