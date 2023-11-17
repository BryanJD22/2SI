package h.alberto.svalero.com.plantillamvpretrofitcines.lst_films;


import java.util.ArrayList;

import h.alberto.svalero.com.plantillamvpretrofitcines.beans.Film;


public interface LstFilmsContract {

    public interface View{
        void sucessListFilms(ArrayList<Film> lstFilms);
        void failureListFilms(String message);
    }
    public interface Presenter{
        void getFilms();//la original

    }
    public interface Model{
        /*Programación Reactiva*/
        interface OnLstFilmsListener{
            void onFinished(ArrayList<Film> lstFilms);
            void onFailure(String error);
        }
        void getFilmsService(OnLstFilmsListener onLstFilmsListener);
    }

}
