package com.example.sattimcom;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.net.CookieHandler;
import java.util.ArrayList;

public class FeedRecyclerAdapter extends RecyclerView.Adapter<FeedRecyclerAdapter.PostHolder> {



    private ArrayList<String> userEmailList;
    private ArrayList<String> userCommentList;
    private ArrayList<String> userImageList;




    public FeedRecyclerAdapter(ArrayList<String> userEmailList, ArrayList<String> userCommentList, ArrayList<String> userImageList) {
        this.userEmailList = userEmailList;
        this.userCommentList = userCommentList;
        this.userImageList = userImageList;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext()); //LayoutInflater sınıfı bunlara karşılık gelen Görüntüle nesneleri içine Düzen XML dosyalarının içeriğini oluşturmak için kullanılır
        View view = layoutInflater.inflate(R.layout.recycler_row,parent,false);
        return new PostHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {

        holder.userEmailText.setText(userEmailList.get(position));
        holder.commentText.setText(userCommentList.get(position));
        Picasso.get ().load(userImageList.get(position)).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return userEmailList.size();
    } //liste boyutunu döndürür.

    static class PostHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView userEmailText;
        TextView commentText;

        public PostHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.recyclerview_row_imageview);
            userEmailText = itemView.findViewById(R.id.recyclerview_row_useremail_text);
            commentText = itemView.findViewById(R.id.recyclerview_row_comment_text);


        }
    }

}
