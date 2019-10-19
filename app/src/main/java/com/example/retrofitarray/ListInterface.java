package com.example.retrofitarray;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ListInterface {
    @Headers("Content-Type:application/json")
    @POST("api.php")
    Call<ListResponse> loadData(@Body JsonObject jsonObject);
}
