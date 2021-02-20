package com.danieljrodrigues.instagramclone.login.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import com.danieljrodrigues.instagramclone.R;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextPassword;
    private LoadingButton submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmail = findViewById(R.id.login_edit_text_email);
        editTextPassword = findViewById(R.id.login_edit_text_password);
        submitBtn = findViewById(R.id.login_button_submit);

        editTextEmail.addTextChangedListener(watcher);
        editTextPassword.addTextChangedListener(watcher);
        submitBtn.setOnClickListener(v -> {
            submitBtn.showProgress(true);

            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                submitBtn.showProgress(false);

                TextInputLayout emailInputLayout = findViewById(R.id.login_edit_text_email_input);
                emailInputLayout.setError("Erro email inválido");
                editTextEmail.setBackground(ContextCompat.getDrawable(
                    LoginActivity.this,R.drawable.edit_text_error_bg)
                );

                TextInputLayout passwdInputLayout = findViewById(R.id.login_edit_text_password_input);
                passwdInputLayout.setError("Erro senha inválido");
                editTextPassword.setBackground(ContextCompat.getDrawable(
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
                submitBtn.setEnabled(true);
            } else {
                submitBtn.setEnabled(false);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}