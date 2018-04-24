package co.edu.pdam.eci.persistenceapiintegration.data.dao;

import com.j256.ormlite.dao.Dao;

import co.edu.pdam.eci.persistenceapiintegration.data.entity.NursingServices;

/**
 * Created by 2101751 on 4/24/18.
 */

public class NursingServicesOrmLiteDao extends OrmLiteDao<NursingServices, String> implements NursingServicesDao {


    public NursingServicesOrmLiteDao(Dao<NursingServices, String> dao) {
        super(dao, NursingServices.class);
    }
}
