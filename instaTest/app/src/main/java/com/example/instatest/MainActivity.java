package com.example.instatest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";

    private RecyclerView rvFriendsList;
    private RecyclerView rvPostList;
    private List<Friend> friends;
    private List<Post> posts;
    private FriendAdapter friendAdapter;
    private PostApater postApater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        init();
        download();
        setting();
    }

    private void init(){
        rvFriendsList = findViewById(R.id.rv_friends_list);
        rvPostList = findViewById(R.id.rv_post_list);

        friends = new ArrayList<>();
        posts = new ArrayList<>();
        friendAdapter = new FriendAdapter();
        postApater = new PostApater();

    }
    private void download(){
        for(int i = 1; i < 10; i++){
            friends.add(new Friend("username" + i));
            posts.add(new Post("postUsername" + i));
        }
    }
    private void setting(){
        LinearLayoutManager managerHor = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        rvFriendsList.setLayoutManager(managerHor);
        friendAdapter.setFriends(friends);
        rvFriendsList.setAdapter(friendAdapter);
        LinearLayoutManager managerVer = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rvPostList.setLayoutManager(managerVer);
        postApater.setPosts(posts);
        rvPostList.setAdapter(postApater);
    }
}