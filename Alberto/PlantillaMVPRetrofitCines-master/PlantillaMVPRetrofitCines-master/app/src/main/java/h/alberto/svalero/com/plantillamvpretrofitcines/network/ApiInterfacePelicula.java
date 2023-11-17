/**
 * @file ApiInterface.java
 * @brief This is the api interface class, it will contain all the Api call references
 * @author Shrikant
 * @date 14/04/2018
 */
package h.alberto.svalero.com.plantillamvpretrofitcines.network;


import java.util.ArrayList;

import h.alberto.svalero.com.plantillamvpretrofitcines.beans.Film;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterfacePelicula {
    @GET("peliculasws")
    Call<ArrayList<Film>> getPopularMovies();

}
