package com.example.android.randomuserapp;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

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
        fragmentTransaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
        fragmentTransaction.addToBackStack("next");
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
     if (item.getItemId() ==R.id.refresh_menu_item) {
         userListFragment = new UserListFragment();
         userListFragment.fetchResults();
         fragmentManager.beginTransaction()
                 .replace(R.id.main_fragment_container, userListFragment)
                 .setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit)
                 .addToBackStack("next")
                 .commit();
     }
        return true;
    }

}
