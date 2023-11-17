package h.alberto.svalero.com.plantillamvpretrofitcines.lst_films;



import java.util.ArrayList;

import h.alberto.svalero.com.plantillamvpretrofitcines.beans.Film;


public class LstFilmsPresenter implements LstFilmsContract.Presenter{
    /*Presenter, tiene que poder hablar con el Modelo, y desencadenar
    acciones en la Vista*/
    private LstFilmsContract.View vista;
    private LstFilmsModel modelo;

    public LstFilmsPresenter(LstFilmsContract.View vista) {
        this.vista = vista;
        this.modelo = new LstFilmsModel();
    }

    @Override
    public void getFilms() {
        this.modelo.getFilmsService(new LstFilmsContract.Model.OnLstFilmsListener() {
            public void onFinished(ArrayList<Film> lstFilms)
            {
                vista.sucessListFilms(lstFilms);
            }

            @Override
            public void onFailure(String error) {
                vista.failureListFilms("Error al listar películas");
            }
        });
    }




}
