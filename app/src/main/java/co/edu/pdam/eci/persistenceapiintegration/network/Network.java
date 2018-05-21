package co.edu.pdam.eci.persistenceapiintegration.network;

import java.util.List;

import co.edu.pdam.eci.persistenceapiintegration.data.entity.NursingServices;
import co.edu.pdam.eci.persistenceapiintegration.data.entity.User;

/**
 * Created by 2101751 on 5/18/18.
 */

public interface Network {

    //for user service
    void login( LoginWrapper loginWrapper, RequestCallback<Token> requestCallback );

    void getNursingServices(RequestCallback<List<NursingServices>> requestCallback);

    void getNursesByService(String service, RequestCallback<List<User>> requestCallback);





    //M

    interface RequestCallback<T>
    {

        void onSuccess( T response );

        void onFailed( NetworkException e );

    }

}
