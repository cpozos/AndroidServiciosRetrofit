package com.example.consumoservicios.servicio;

import com.example.consumoservicios.interfaces.IServicio;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

public class Servicio<T>
{
    Retrofit retrofit;
    IServicio<T> servicio;

    private String endPoint;

    public Servicio(String urlBase)
    {
        retrofit =  RetrofitClient.getRetrofitClient(urlBase);
        servicio = retrofit.create(IServicio.class);
    }

    public void get(Callback<List<T>> callback)
    {
        Call<List<T>> response  = servicio.get(endPoint);
        response.enqueue(callback);
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }
}
