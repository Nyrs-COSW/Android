package co.edu.pdam.eci.persistenceapiintegration.services;

import java.util.List;

import co.edu.pdam.eci.persistenceapiintegration.data.entity.NursingServices;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by 2101751 on 4/24/18.
 */

public interface NursingServicesService {

    @GET( "api/nursingservices" )
    Call<List<NursingServices>> getNursingServicesList( );

}
