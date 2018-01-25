package com.example.android.randomuserapp.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.randomuserapp.R;
import com.example.android.randomuserapp.controller.UserAdapter;
import com.example.android.randomuserapp.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserListFragment extends Fragment {
    View rootView;
    RecyclerView recyclerView;
    UserAdapter userAdapter;
    Context context;
    List<User> userList = new ArrayList<>();
    View.OnClickListener detailClickListener;
    StaggeredGridLayoutManager layoutManager;

    public UserListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_user_list, container, false);
        context = getActivity();

        return rootView;
    }

    public void setRecyclerView(){
        recyclerView = (RecyclerView) rootView.findViewById(R.id.user_list_recycler_view);
        userAdapter = new UserAdapter(userList, detailClickListener, context);
        setDetailClickListener();
        recyclerView.setAdapter(userAdapter);
        layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        recyclerView.setLayoutManager(layoutManager);
    }

    public void setDetailClickListener(){
        detailClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserDetailFragment userDetailFragment = new UserDetailFragment();

            }
        };
    }



}
