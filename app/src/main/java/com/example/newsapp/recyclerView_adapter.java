package com.example.newsapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class recyclerView_adapter extends RecyclerView.Adapter<recyclerView_adapter.ViewHolder> {
    Context context;
    ArrayList<model_class> modelClassArrayList;

    public recyclerView_adapter(Context context, ArrayList<model_class> modelClassArrayList) {
        this.context = context;
        this.modelClassArrayList = modelClassArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.layout_item,null,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,webView.class);
                intent.putExtra("url",modelClassArrayList.get(position).getUrl());
                context.startActivity(intent);
            }
        });

        holder.mTime.setText("Published at:-"+modelClassArrayList.get(position).getPublishedAt());
        holder.mHeading.setText(modelClassArrayList.get(position).getTitle());
        holder.mAuthor.setText(modelClassArrayList.get(position).getAuthor());
        holder.mContent.setText(modelClassArrayList.get(position).getDescription());
        Log.e("content", "content : "+modelClassArrayList.get(position).getDescription());
//        Glide.with(context).load(modelClassArrayList.get(position).getUrlTOImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return modelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mAuthor,mHeading,mContent,mTime;
//        ImageView imageView;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mAuthor = itemView.findViewById(R.id.authorName);
            mContent = itemView.findViewById(R.id.content);
            mHeading = itemView.findViewById(R.id.mainHeadline);
            mTime = itemView.findViewById(R.id.publishDate);
//            imageView = itemView.findViewById(R.id.imageView);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
