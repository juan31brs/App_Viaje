package com.angel.juan.app_tuviaje.util;

import com.angel.juan.app_tuviaje.models.Destino;
import com.angel.juan.app_tuviaje.models.Viaje;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Data {

    public static List<Viaje> data=new ArrayList<>();


    public static List<Destino> datade=new ArrayList<>();

    public static Retrofit retrofit =  new Retrofit.Builder()
            .baseUrl("http://192.168.1.194:3001")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
