package co.edu.pdam.eci.persistenceapiintegration.data;

import android.content.Context;

import co.edu.pdam.eci.persistenceapiintegration.data.dao.NursingServicesDao;

/**
 * @author Santiago Carrillo
 */

public interface Model
{
    void init( Context context );


    NursingServicesDao getNursingServiceDao();
}
