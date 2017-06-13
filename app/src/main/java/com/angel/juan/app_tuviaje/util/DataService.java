package com.angel.juan.app_tuviaje.util;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class DataService {

    public static Retrofit retrofit =  new Retrofit.Builder()
            .baseUrl("http://192.168.1.194:3001")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
