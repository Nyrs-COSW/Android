package co.edu.pdam.eci.persistenceapiintegration.services;

import java.util.List;

import co.edu.pdam.eci.persistenceapiintegration.data.entity.User;
import co.edu.pdam.eci.persistenceapiintegration.network.LoginWrapper;
import co.edu.pdam.eci.persistenceapiintegration.network.Token;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by 2101751 on 5/18/18.
 */

public interface UserService {

    @POST( "user/login" )
    Call<Token> login(@Body LoginWrapper user );

    @GET( "user/personal/{service}" )
    Call<List<User>> getNurseByService(@Path("service") String service );

    @POST("user/patient")
    Call<User> newPatient(@Body User patient);

}
