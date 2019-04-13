package com.example.consumoservicios.interfaces;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface IServicio<T>
{
    @GET
    Call<List<T>> get(@Url String endPoint);

}
