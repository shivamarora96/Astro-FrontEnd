package com.saproductions.astro.Helper;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by shivam on 8/2/18.
 */

public interface ApiInterface {

    @GET("/")
    Call<Response> getAll();
}
