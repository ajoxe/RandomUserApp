package com.example.android.randomuserapp;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.randomuserapp.fragments.UserDetailFragment;
import com.example.android.randomuserapp.fragments.UserListFragment;

public class MainActivity extends AppCompatActivity {
    UserListFragment userListFragment;
    UserDetailFragment userDetailFragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userDetailFragment = new UserDetailFragment();
        userListFragment = new UserListFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_fragment_container, userListFragment);
        fragmentTransaction.addToBackStack("next");
        fragmentTransaction.commit();
    }
}
