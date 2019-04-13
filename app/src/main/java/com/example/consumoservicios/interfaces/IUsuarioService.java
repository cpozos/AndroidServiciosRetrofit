package com.example.consumoservicios.interfaces;


import com.example.consumoservicios.modelos.UsuarioModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IUsuarioService
{
    String endPoint = "usuarios?/nombre=xcats&password=2018";
    @GET(endPoint)
    Call<List<UsuarioModel>> get();
}
