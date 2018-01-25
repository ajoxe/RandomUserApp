package com.example.android.randomuserapp.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.randomuserapp.R;
import com.example.android.randomuserapp.RetrofitService;
import com.example.android.randomuserapp.controller.UserAdapter;
import com.example.android.randomuserapp.model.User;
import com.example.android.randomuserapp.model.UserResults;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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

    String baseURL = "https://randomuser.me";
    Map<String, String> queries = new HashMap<>();

    public UserListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_user_list, container, false);
        context = getActivity();
        setRecyclerView();

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
        fetchResults();
    }

    public void setDetailClickListener(){
        detailClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserDetailFragment userDetailFragment = new UserDetailFragment();


            }
        };
    }

    public void fetchResults(){
        queries.put("results", String.valueOf(20));
        queries.put("inc", "name,location,cell,email,picture");
        queries.put("nat", "us");
        connectWithRetrofit(queries);

    }

    public void connectWithRetrofit(Map<String, String> queries){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitService service = retrofit.create(RetrofitService.class);
        Call<UserResults> call = service.getResults(queries);
        call.enqueue(new retrofit2.Callback<UserResults>() {
            @Override
            public void onResponse(Call<UserResults> call, retrofit2.Response<UserResults> response) {
                UserResults results = response.body();
                userList.addAll(Arrays.asList(results.getResults()));
                Log.d("retrofit: ", "onResponse: " + userList.size());
               userAdapter.notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<UserResults> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }



}
