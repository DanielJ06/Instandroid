package com.danieljrodrigues.instagramclone.register.presentation;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.danieljrodrigues.instagramclone.R;
import com.danieljrodrigues.instagramclone.common.view.CustomDialog;
import com.danieljrodrigues.instagramclone.common.view.LoadingButton;

public class RegisterPhotoFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_register_photo, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LoadingButton addPhoto = view.findViewById(R.id.register_button_add_photo);
        addPhoto.setEnabled(true);

        addPhoto.setOnClickListener(l -> {
            CustomDialog customDialog = new CustomDialog.Builder(getContext())
                .setTitle(R.string.define_photo_profile)
                .addButton((v) -> {
                    switch (v.getId()) {
                        case R.string.take_picture:
                            Toast.makeText(getContext(), R.string.take_picture, Toast.LENGTH_LONG).show();
                            break;
                        case R.string.search_gallery:
                            Toast.makeText(getContext(), R.string.search_gallery, Toast.LENGTH_LONG).show();
                            break;
                    }
                }, R.string.take_picture, R.string.search_gallery)
                .build();
            customDialog.show();
        });

    }
}