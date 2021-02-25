package com.example.instatest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.MyViewHolder> {

    private List<Friend> friends = new ArrayList<>();

    public void setFriends(List<Friend> friends){
        this.friends = friends;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = (LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.friend_item, parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.setItem(friends.get(position));
    }

    @Override
    public int getItemCount() {
        return friends.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tvUsername;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUsername = itemView.findViewById(R.id.tv_friend_name);
        }
        public void setItem(Friend friend){
            tvUsername.setText(friend.getUsername());
        }
    }
}
