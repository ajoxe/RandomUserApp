package com.example.android.randomuserapp.controller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.randomuserapp.R;
import com.example.android.randomuserapp.model.User;
import com.example.android.randomuserapp.view.UserViewHolder;

import java.util.List;

/**
 * Created by amirahoxendine on 1/24/18.
 */

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {
    List<User> userList;
    View.OnClickListener userDetailClick;
    Context context;

    public UserAdapter(List<User> userList, View.OnClickListener userDetailClick, Context context) {
        this.userList = userList;
        this.userDetailClick = userDetailClick;
        this.context = context;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_item_view, parent, false);

        return new UserViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        User user = userList.get(position);
        holder.onBind(user, context);
        holder.itemView.setTag(user.getEmail());
        holder.itemView.setOnClickListener(userDetailClick);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
