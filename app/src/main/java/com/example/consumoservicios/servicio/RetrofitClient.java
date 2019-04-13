package com.example.consumoservicios.servicio;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient
{
    public static Retrofit retrofit = null;

    private RetrofitClient()
    {
    }

    public static Retrofit getRetrofitClient(String urlBase)
    {
        if(retrofit==null)
        {
            retrofit = new Retrofit.Builder()
                               .baseUrl(urlBase)
                               .addConverterFactory(GsonConverterFactory.create())
                               .build();
        }

        return retrofit;
    }
}
