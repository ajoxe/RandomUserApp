package com.example.android.randomuserapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.randomuserapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserListFragment extends Fragment {
    View rootView;
    RecyclerView recyclerView;

    public UserListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_user_list, container, false);

        return rootView;
    }

}
