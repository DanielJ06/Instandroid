package com.danieljrodrigues.instagramclone.login.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.widget.EditText;

import com.danieljrodrigues.instagramclone.R;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextInputLayout inputLayout = findViewById(R.id.login_edit_text_email_input);
        inputLayout.setError("Invalid email");

        EditText editText = findViewById(R.id.login_edit_text_email);
        editText.setBackground(ContextCompat.getDrawable(
            LoginActivity.this, R.drawable.edit_text_error_bg
        ));
    }
}