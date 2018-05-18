package co.edu.pdam.eci.persistenceapiintegration.services;

import co.edu.pdam.eci.persistenceapiintegration.network.LoginWrapper;
import co.edu.pdam.eci.persistenceapiintegration.network.Token;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by 2101751 on 5/18/18.
 */

public interface UserService {

    @POST( "user/login" )
    Call<Token> login(@Body LoginWrapper user );

}
