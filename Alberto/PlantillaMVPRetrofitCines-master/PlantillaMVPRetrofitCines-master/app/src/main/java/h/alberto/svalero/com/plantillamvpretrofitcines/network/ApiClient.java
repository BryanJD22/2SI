/**
 * @file ApiClient.java
 * @brief This class will have all constants related to the networking and retrofit instance
 * @author Shrikant
 * @date 15/04/2018
 */
package h.alberto.svalero.com.plantillamvpretrofitcines.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String BASE_URL =
            "http://172.17.133.97:42644/RakutenTV/webresources/";

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
