package com.example.teatroapp.Obras;

import com.example.teatroapp.beans.Obra;

import java.util.ArrayList;

public interface ObraContract {

    public interface View{
        void sucessListObras(ArrayList<Obra> lstObras);
        void failureListFilms(String message);
    }
    public interface Presenter{
        void getObra();//la original

    }
    public interface Model{
        /*Programación Reactiva*/
        interface OnLstObrasListener{
            void onFinished(ArrayList<Obra> lstObras);
            void onFailure(String error);
        }
        void getObrasService(OnLstObrasListener onLstObrasListener);
    }
}