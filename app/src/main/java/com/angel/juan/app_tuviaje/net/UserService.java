package com.angel.juan.app_tuviaje.net;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import com.angel.juan.app_tuviaje.models.SimpleResponse;
import com.angel.juan.app_tuviaje.models.User;

public interface UserService {

    @POST("users/login")
    Call<SimpleResponse> login(@Body User user);

    @POST("users/registro")
    Call<SimpleResponse> registro(@Body User user);
}
