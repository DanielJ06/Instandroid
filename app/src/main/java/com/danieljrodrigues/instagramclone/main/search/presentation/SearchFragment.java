package com.danieljrodrigues.instagramclone.main.search.presentation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.danieljrodrigues.instagramclone.R;

public class SearchFragment extends Fragment {
    public SearchFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(
            R.layout.fragment_main_search,
            container,
            false
        );

        RecyclerView rv = view.findViewById(R.id.search_recycler);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(new PostAdapter());

        return view;
    }

    private class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {

        private int[] images = new int[] {
            R.drawable.ic_insta_profile,
            R.drawable.ic_insta_profile,
            R.drawable.ic_insta_profile,
            R.drawable.ic_insta_profile,
            R.drawable.ic_insta_profile,
            R.drawable.ic_insta_profile,
            R.drawable.ic_insta_profile,
            R.drawable.ic_insta_profile,
            R.drawable.ic_insta_profile,
            R.drawable.ic_insta_profile,
            R.drawable.ic_insta_profile,
            R.drawable.ic_insta_profile,
            R.drawable.ic_insta_profile,
            R.drawable.ic_insta_profile,
            R.drawable.ic_insta_profile,
            R.drawable.ic_insta_profile,
            R.drawable.ic_insta_profile,
            R.drawable.ic_insta_profile,
        };

        @NonNull
        @Override
        public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new PostViewHolder(
                getLayoutInflater().inflate(R.layout.item_search_user, parent, false)
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
            imagePost = itemView.findViewById(R.id.search_item_profile_picture);
        }

        public void bind(int image) {
            this.imagePost.setImageResource(image);
        }
    }
}