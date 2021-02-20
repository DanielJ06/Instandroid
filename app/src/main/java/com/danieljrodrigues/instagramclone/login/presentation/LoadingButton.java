package com.danieljrodrigues.instagramclone.login.presentation;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

import com.danieljrodrigues.instagramclone.R;

public class LoadingButton extends FrameLayout {
    private AppCompatButton button;
    private ProgressBar progressBar;
    private String textContent;

    public LoadingButton(@NonNull Context context) {
        super(context);
        setup(context, null);
    }

    public LoadingButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setup(context, attrs);
    }

    public LoadingButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup(context, attrs);
    }

    private void setup(Context context, AttributeSet attrs) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.button_loading, this, true);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.LoadingButton, 0, 0);
        textContent = typedArray.getString(R.styleable.LoadingButton_text);

        typedArray.recycle();

        button = (AppCompatButton) getChildAt(0);
        button.setText(textContent);
        button.setEnabled(false);

        progressBar = (ProgressBar) getChildAt(1);

        PorterDuffColorFilter colorFilter = new PorterDuffColorFilter(
            ContextCompat.getColor(context, android.R.color.white),
            PorterDuff.Mode.SRC_IN
        );

        progressBar.getIndeterminateDrawable().setColorFilter(colorFilter);
    }

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        button.setOnClickListener(l);
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        button.setEnabled(enabled);
    }

    public void showProgress(boolean enabled) {
        progressBar.setVisibility(enabled ? VISIBLE : GONE);
        button.setText(enabled ? "" : textContent);
    }
}
