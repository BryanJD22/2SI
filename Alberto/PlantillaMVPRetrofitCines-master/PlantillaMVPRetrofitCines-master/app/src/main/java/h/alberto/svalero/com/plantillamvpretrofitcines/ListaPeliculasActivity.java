package h.alberto.svalero.com.plantillamvpretrofitcines;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import h.alberto.svalero.com.plantillamvpretrofitcines.adapter.AdapterFilms;
import h.alberto.svalero.com.plantillamvpretrofitcines.beans.Film;
import h.alberto.svalero.com.plantillamvpretrofitcines.login_user.LoginContract;
import h.alberto.svalero.com.plantillamvpretrofitcines.lst_films.LstFilmsContract;
import h.alberto.svalero.com.plantillamvpretrofitcines.lst_films.LstFilmsPresenter;


//

/**
 * Activity llamada desde el login que contiene una lista de películas.
 * Llamará al Activity FichaDescriptiva, cuando se pulse un item.
 */
public class ListaPeliculasActivity
        extends AppCompatActivity implements LstFilmsContract.View
{


    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    private LstFilmsPresenter lstFilmsPresenter;


    private ArrayList<Film> lista;//Variable necesaria cuando se pulse un item de la lista


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_peliculas);

        /*Instanciar al Presenter*/
        lstFilmsPresenter = new LstFilmsPresenter(this);



          lstFilmsPresenter.getFilms();

        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.idReciclador);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);


    }

    @Override
    public void sucessListFilms(ArrayList<Film> lstFilms) {
        // Crear un nuevo adaptador
        adapter = new AdapterFilms(lstFilms);
        lista=lstFilms;
        recycler.setAdapter(adapter);
    }

    @Override
    public void failureListFilms(String message) {
        Toast toast1 =
                Toast.makeText(getApplicationContext(),
                        message, Toast.LENGTH_SHORT);
        toast1.show();

    }







}
