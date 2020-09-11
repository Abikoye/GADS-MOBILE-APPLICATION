package com.dev.gadsproject.repository;

import com.dev.gadsproject.model.HoursItem;
import com.dev.gadsproject.model.SkillIq;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GADSService {
    @GET("api/hours")
    Call<List<SkillIq>> fetchSkillIqList();

    @GET("api/hours")
    Call<List<HoursItem>> fetchHoursList();

//    @GET("questions/survey/{id}")
//    Call<QuestionResponse> fetchSurveyQuestionById(@Path("id") String id);
}
