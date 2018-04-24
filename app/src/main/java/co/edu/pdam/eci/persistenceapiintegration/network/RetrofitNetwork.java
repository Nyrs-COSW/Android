package co.edu.pdam.eci.persistenceapiintegration.network;


import java.io.IOException;
import java.util.List;

import co.edu.pdam.eci.persistenceapiintegration.data.entity.NursingServices;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import co.edu.pdam.eci.persistenceapiintegration.services.*;


public class RetrofitNetwork {
    private static final String BASE_URL = "https://nyrs.herokuapp.com/";

    private NursingServicesService nursingServices;

    public RetrofitNetwork() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl( BASE_URL ).addConverterFactory( GsonConverterFactory.create() ).build();
        nursingServices = retrofit.create( NursingServicesService.class );
    }



    public void getNursingServices( RequestCallback<List<NursingServices>> requestCallback ){
        try {
            Call<List<NursingServices>> call = nursingServices.getNursingServicesList();
            Response<List<NursingServices>> execute = call.execute();
            requestCallback.onSuccess( execute.body() );
        }
        catch ( IOException e ) {
            requestCallback.onFailed( new NetworkException( 0, null, e ) );
        }
    }
}
