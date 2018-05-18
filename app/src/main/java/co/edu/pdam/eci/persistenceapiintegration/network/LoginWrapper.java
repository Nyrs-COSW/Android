package co.edu.pdam.eci.persistenceapiintegration.network;

/**
 * Created by 2101751 on 5/18/18.
 */

public class LoginWrapper {

    private final String username;

    private final String password;

    public LoginWrapper( String username, String password )
    {
        this.username = username;
        this.password = password;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }


}
