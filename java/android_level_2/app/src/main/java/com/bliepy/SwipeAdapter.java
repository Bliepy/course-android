package com.bliepy;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SwipeAdapter extends RecyclerView.Adapter<SwipeAdapter.ViewHolder>        {

    private List<SwipeImage> mSwipeImage;

    public SwipeAdapter(List<SwipeImage> mSwipeImage) {
        this.mSwipeImage = mSwipeImage;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.content_item, null);
        SwipeAdapter.ViewHolder viewHolder = new SwipeAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        SwipeImage swipeItem =  mSwipeImage.get(i);
        viewHolder.image.setImageResource(swipeItem.getImageId());
    }

    @Override
    public int getItemCount() {
        return mSwipeImage.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView image;

        public ViewHolder(View itemView) {

            super(itemView);
            image = itemView.findViewById(R.id.imageListItem);

        }
    }
}
