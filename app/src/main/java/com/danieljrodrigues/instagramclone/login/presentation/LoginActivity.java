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
import com.danieljrodrigues.instagramclone.common.view.LoadingButton;
import com.danieljrodrigues.instagramclone.databinding.ActivityLoginBinding;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.loginEditTextEmail.addTextChangedListener(watcher);
        binding.loginEditTextPassword.addTextChangedListener(watcher);
        binding.loadingButton.setOnClickListener(v -> {
            binding.loadingButton.showProgress(true);

            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                binding.loadingButton.showProgress(false);

                binding.loginEditTextEmailInput.setError("Erro email inválido");
                binding.loginEditTextEmail.setBackground(ContextCompat.getDrawable(
                    LoginActivity.this,R.drawable.edit_text_error_bg)
                );

                binding.loginEditTextPasswordInput.setError("Erro senha inválido");
                binding.loginEditTextPassword.setBackground(ContextCompat.getDrawable(
                    LoginActivity .this,R.drawable.edit_text_error_bg)
                );
            }, 3000);

        });
    }

    private TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (!s.toString().isEmpty()) {
                binding.loadingButton.setEnabled(true);
            } else {
                binding.loadingButton.setEnabled(false);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}