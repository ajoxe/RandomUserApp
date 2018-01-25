package com.example.android.randomuserapp;

import com.example.android.randomuserapp.model.UserResults;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by amirahoxendine on 1/24/18.
 */

public interface RetrofitService {
    @GET("/api/")
    Call<UserResults> getResults(@QueryMap Map<String, String> queries);

}
