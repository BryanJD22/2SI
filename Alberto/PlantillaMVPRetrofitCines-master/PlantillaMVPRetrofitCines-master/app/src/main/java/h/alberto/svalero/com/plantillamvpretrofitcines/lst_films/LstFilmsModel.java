package h.alberto.svalero.com.plantillamvpretrofitcines.lst_films;

import java.util.ArrayList;

import h.alberto.svalero.com.plantillamvpretrofitcines.beans.Film;
import h.alberto.svalero.com.plantillamvpretrofitcines.network.ApiClient;
import h.alberto.svalero.com.plantillamvpretrofitcines.network.ApiInterfacePelicula;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LstFilmsModel
        implements LstFilmsContract.Model{

    private OnLstFilmsListener onLstFilmsListener;
    private ArrayList<Film> lstFilms;

    @Override
    public void getFilmsService(final OnLstFilmsListener onLstFilmsListener) {
        /*Ejecuto Webservice con retrofit*/
        ApiInterfacePelicula apiService = ApiClient.getClient().create(ApiInterfacePelicula.class);

        //petición asíncrona.
        Call<ArrayList<Film>> call = apiService.getPopularMovies();
        //ponemos nuestra petición en cola.
        //El Callback se invoca cuando el servidor nos haya respondido
        call.enqueue(new Callback<ArrayList<Film>>() {

            public void onResponse(Call<ArrayList<Film>> call,
                                   Response<ArrayList<Film>> response) {

                ArrayList<Film> lstPeliculas = response.body();// Aquí tengo el JSON
                if(lstPeliculas!=null){
                    //OnLoginListener.onFinished(user);
                    onLstFilmsListener.onFinished(lstPeliculas);
                }else{
                    //OnLoginListener.onFinished(null);
                    onLstFilmsListener.onFailure("Fallo: Listar Películas");
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Film>> call,
                                  Throwable t) {
                onLstFilmsListener.onFailure("Fallo: Listar Películas");
            }
        });
    }

}
