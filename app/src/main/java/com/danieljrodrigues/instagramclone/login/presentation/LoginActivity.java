package com.danieljrodrigues.instagramclone.login.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import com.danieljrodrigues.instagramclone.R;
import com.danieljrodrigues.instagramclone.common.utils.DrawableHelper;
import com.danieljrodrigues.instagramclone.common.view.LoadingButton;
import com.danieljrodrigues.instagramclone.databinding.ActivityLoginBinding;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity implements LoginView {
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.loadingButton.setOnClickListener(v -> {
            binding.loadingButton.showProgress(true);

            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                binding.loadingButton.showProgress(false);
            }, 3000);

        });
    }

    @Override
    public void onFailureForm(String emailError, String passwordError) {
        if(emailError != null) {
            binding.loginEditTextEmailInput.setError(emailError);
            binding.loginEditTextPasswordInput.setError(emailError);
        }
    }

    @Override
    public void onUserLogged() {
        //TODO
    }
}