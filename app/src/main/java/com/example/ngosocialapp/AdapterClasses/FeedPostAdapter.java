package com.example.ngosocialapp.AdapterClasses;


import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.ngosocialapp.ModelClasses.FeedPostModal;
import com.example.ngosocialapp.Post;
import com.example.ngosocialapp.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class FeedPostAdapter extends RecyclerView.Adapter<FeedPostAdapter.viewHolder> {
    Context mContext;
    ArrayList<Post> list;

    public FeedPostAdapter(Context mContext, ArrayList<Post> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @NonNull
    @NotNull
    @Override
    public FeedPostAdapter.viewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.feed_post,parent,false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull FeedPostAdapter.viewHolder holder, int position) {
        Post post = list.get(position);
        Uri ur;
        ur=Uri.parse(post.getPostUrl());
        Glide.with(mContext).load(ur).into(holder.postMedia);
        holder.caption.setText(post.getCaption());
        holder.ngoName.setText(post.getNgoName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

   public static class viewHolder extends RecyclerView.ViewHolder {
            ImageView  postMedia;
            TextView caption,ngoName;

            public viewHolder(@NonNull View itemView){
                super(itemView);

                ngoName = itemView.findViewById(R.id.ngo_name_feed_post);
//                caption = itemView.findViewById(R.id.post_desc);
                caption=itemView.findViewById(R.id.feed_post_caption_comments);
                postMedia =itemView.findViewById(R.id.feed_post_pic);
            }
    }
}
