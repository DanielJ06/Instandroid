package com.danieljrodrigues.instagramclone.main.profile.presentation;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.danieljrodrigues.instagramclone.R;

public class ProfileFragment extends Fragment {
    public ProfileFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(
            R.layout.fragment_main_profile,
            container,
            false
        );
    }
}