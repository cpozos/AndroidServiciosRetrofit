package com.example.consumoservicios.interfaces;

import com.example.consumoservicios.modelos.ClienteModel;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface IMyService
{
    @GET("posts")
    Call<List<ClienteModel>> getClienteGet();

}
