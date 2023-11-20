package com.example.teatroapp.ApiS;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiTeatro {

    public static final String BASE_URL =
            "http://localhost:8080/untitled/";

    private static Retrofit retrofit = null;
    //Creamos un interceptor  y le indicamos el log level a usar
    // HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
    // logging.

    //Asociamos el interceptor a las peticiones
    // OkHttpClient.Builder httpClient= new OkHttpClient.Builder();
    // httpClient.addInterceptor(logging);

    //Instanciamos un objeto Retrofit, que es el que hace posible las peticiones
    //Se define la ruta base de la API
    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
