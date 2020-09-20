package com.example.quizapp.global;

import com.example.quizapp.model.ResponseData;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface RestApi {

    @GET(ApiClient.getQuestion)
    Call<ResponseData> getQuestionData(@QueryMap Map<String, String> queryMap);

}
