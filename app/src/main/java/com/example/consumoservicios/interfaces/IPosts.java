package com.example.consumoservicios.interfaces;

import com.example.consumoservicios.modelos.PostModel;
import com.example.consumoservicios.modelos.UsuarioModel;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface IPosts {

    String API_ROUTE = "posts";

    @GET(API_ROUTE)
    Call<List<PostModel>> getPostGet();

}
