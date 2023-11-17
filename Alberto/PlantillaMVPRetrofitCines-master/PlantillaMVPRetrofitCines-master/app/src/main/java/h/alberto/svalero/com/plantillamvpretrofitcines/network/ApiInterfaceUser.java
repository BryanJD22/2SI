package h.alberto.svalero.com.plantillamvpretrofitcines.network;

import java.util.ArrayList;

import h.alberto.svalero.com.plantillamvpretrofitcines.beans.Usuario;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterfaceUser {


    //http://192.168.1.242:9090/CinesAragonFeedback/webresources/UserWS/login

    @POST("usuarios/login")
    Call<ArrayList<Usuario>> login(@Body Usuario usuario);




}
