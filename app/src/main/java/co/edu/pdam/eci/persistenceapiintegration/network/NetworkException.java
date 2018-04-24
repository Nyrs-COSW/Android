package co.edu.pdam.eci.persistenceapiintegration.network;

public class NetworkException extends Exception {

    public NetworkException(int i, Object o, Exception e){
        e.printStackTrace();
    }
}
