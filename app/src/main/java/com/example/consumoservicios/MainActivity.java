package com.example.consumoservicios;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import com.example.consumoservicios.interfaces.IPosts;
import com.example.consumoservicios.interfaces.IUsuarioService;
import com.example.consumoservicios.modelos.PostModel;
import com.example.consumoservicios.modelos.UsuarioModel;
import com.example.consumoservicios.servicio.Servicio;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private String baseUrl = "http://4923f6db.ngrok.io/Service1.svc/";
    ListView list;
    ArrayList<String> titles = new ArrayList<>();
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView)findViewById(R.id.list);
        arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,titles);

        list.setAdapter(arrayAdapter);
        //new Peticion().execute();

        //getDatos();
        get();
        //getGenerico();

    }

    public void getGenerico()
    {
        Servicio<UsuarioModel> myServicio = new Servicio<>(baseUrl);
        myServicio.setEndPoint("usuarios?/nombre=xcats&password=2018");
        myServicio.get(new Callback<List<UsuarioModel>>() {
            @Override
            public void onResponse(Call<List<UsuarioModel>> call, Response<List<UsuarioModel>> response) {
                // La llamada fue exitosa
                for(UsuarioModel post : response.body() ) {

                    titles.add(String.valueOf(post.getUsuId()));
                }
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<UsuarioModel>> call, Throwable t) {

            }
        });
    }

    public void  get()
    {

        // Crea el objeto Builder
        Retrofit.Builder builder = new Retrofit.Builder();

        // Le asigna la url
        builder.baseUrl(baseUrl);

        // Ejecuta la siguiente instrucción que permite serializar la respuesta de nuestra petición
        builder.addConverterFactory(GsonConverterFactory.create());

        // Construye el objeto retrofit
        Retrofit retrofit = builder.build();

        // Inicializa una instancia de la interface creada
        IUsuarioService postService = retrofit.create(IUsuarioService.class);

        // Se crea una llamada que recibirá una lista de objetos PostEjemplo.
        Call<List<UsuarioModel>> response = postService.get();

        // Método que realiza la llamada
        response.enqueue(new Callback<List<UsuarioModel>>() {
            @Override
            public void onResponse(Call<List<UsuarioModel>> call, Response<List<UsuarioModel>> response)
            {
                // La llamada fue exitosa
                for(UsuarioModel post : response.body() ) {

                    titles.add(String.valueOf(post.getUsuId()));
                }
                arrayAdapter.notifyDataSetChanged();


            }

            @Override
            public void onFailure(Call<List<UsuarioModel>> call, Throwable t)
            {
                // Hubo un error
                Log.e("ERROR","ERROR FATAL AL LLAMAR A LA API");

            }
        });



    }


    public void  getDatos()
    {
        // Establece la url de la API
        final String url="https://jsonplaceholder.typicode.com/";

        // Crea el objeto Builder
        Retrofit.Builder builder = new Retrofit.Builder();

        // Le asigna la url
        builder.baseUrl(url);

        // Ejecuta la siguiente instrucción que permite serializar la respuesta de nuestra petición
        builder.addConverterFactory(GsonConverterFactory.create());

        // Construye el objeto retrofit
        Retrofit retrofit = builder.build();

        // Inicializa una instancia de la interface creada
        IPosts postService = retrofit.create(IPosts.class);

        // Se crea una llamada que recibirá una lista de objetos PostEjemplo.
        Call<List<PostModel>> response = postService.getPostGet();

        // Método que realiza la llamada
        response.enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response)
            {
                // La llamada fue exitosa
                for(PostModel post : response.body() ) {
                    titles.add(post.getTitle());
                }
                arrayAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t)
            {
                // Hubo un error
                Log.e("ERROR","ERROR FATAL AL LLAMAR A LA API");

            }
        });

    }

    /*public static class Peticion extends AsyncTask<Void, Void, Void>
    {
        @Override
        protected Void doInBackground(Void... voids)
        {
            // Establece la url de la API
            final String url="https://jsonplaceholder.typicode.com/";

            // Crea el objeto Builder
            Retrofit.Builder builder = new Retrofit.Builder();

            // Le asigna la url
            builder.baseUrl(url);

            // Ejecuta la siguiente e¿instrucción que permite serializar la respuesta de nuestra petición
            builder.addConverterFactory(GsonConverterFactory.create());

            // Construye el objeto retrofit
            Retrofit retrofit = builder.build();

            // Inicializa una instancia de la interface creada
            IPosts postService = retrofit.create(IPosts.class);

            // Se crea una llamada que recibirá una lista de objetos PostEjemplo.
            Call<List<PostEjemplo>> response = postService.getPostGet();

            // Método que realiza la llamada
            response.enqueue(new Callback<List<PostEjemplo>>() {
                @Override
                public void onResponse(Call<List<PostEjemplo>> call, Response<List<PostEjemplo>> response)
                {
                    // La llamada fue exitosa
                    for(PostEjemplo post : response.body() ) {
                        MainActivity.this.titles.add(post.getTitle());
                    }

                }

                @Override
                public void onFailure(Call<List<PostEjemplo>> call, Throwable t)
                {
                    // Hubo un error
                    Log.e("ERROR","ERROR FATAL AL LLAMAR A LA API");

                }
            });

            *//*
            CÓDIGO QUE TAMBIÉN FUNCIONA

            try
            {

                List<PostEjemplo> posts = response.execute().body();
                for(PostEjemplo post : posts )
                    Log.e("Respuesta:", post.getId() + " " + post.getBody());


            }
            catch (Exception e)
            {
                String error = e.getMessage();
            }*//*

            return null;
        }
    }*/
}
