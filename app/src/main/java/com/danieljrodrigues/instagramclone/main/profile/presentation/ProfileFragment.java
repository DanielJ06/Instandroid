package com.danieljrodrigues.instagramclone.main.profile.presentation;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.danieljrodrigues.instagramclone.R;

public class ProfileFragment extends Fragment {
    public ProfileFragment() {}

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(
            R.layout.fragment_main_profile,
            container,
            false
        );

        RecyclerView rv = view.findViewById(R.id.profile_recycler_posts);
        rv.setLayoutManager(new GridLayoutManager(getContext(), 3));
        rv.setAdapter(new PostAdapter());

        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_profile, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    private class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {

        private int[] images = new int[] {
            R.drawable.ic_insta_add,
            R.drawable.ic_insta_add,
            R.drawable.ic_insta_add,
            R.drawable.ic_insta_add,
            R.drawable.ic_insta_add,
            R.drawable.ic_insta_add,
            R.drawable.ic_insta_add,
            R.drawable.ic_insta_add,
            R.drawable.ic_insta_add,
            R.drawable.ic_insta_add,
            R.drawable.ic_insta_add,
            R.drawable.ic_insta_add,
            R.drawable.ic_insta_add,
            R.drawable.ic_insta_add,
            R.drawable.ic_insta_add,
            R.drawable.ic_insta_add,
            R.drawable.ic_insta_add,
            R.drawable.ic_insta_add,
        };

        @NonNull
        @Override
        public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new PostViewHolder(
                getLayoutInflater().inflate(R.layout.item_profile_grid, parent, false)
            );
        }

        @Override
        public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
            holder.bind(images[position]);
        }

        @Override
        public int getItemCount() {
            return images.length;
        }
    }

    private static class PostViewHolder extends RecyclerView.ViewHolder {

        private ImageView imagePost;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            imagePost = itemView.findViewById(R.id.profile_image_grid);
        }

        public void bind(int image) {
            this.imagePost.setImageResource(image);
        }
    }
}