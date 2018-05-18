package co.edu.pdam.eci.persistenceapiintegration.network;

public class NetworkException extends Exception {

    public NetworkException(String  s, Throwable t) {
        super(s,t);
    }

    public NetworkException(String message){
        super(message);
    }

    public NetworkException (Exception e){
        super (e);
    }
}
