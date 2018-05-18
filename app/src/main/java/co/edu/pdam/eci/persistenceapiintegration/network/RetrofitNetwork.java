package co.edu.pdam.eci.persistenceapiintegration.network;


import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import co.edu.pdam.eci.persistenceapiintegration.data.entity.NursingServices;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import co.edu.pdam.eci.persistenceapiintegration.services.*;


public class RetrofitNetwork implements Network {
    private static final String BASE_URL = "https://nyrs.herokuapp.com/";

    private NursingServicesService nursingServices;
    private UserService userService;

    private ExecutorService backgroundExecutor = Executors.newFixedThreadPool( 1 );

    public RetrofitNetwork() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl( BASE_URL ).addConverterFactory( GsonConverterFactory.create() ).build();
        nursingServices = retrofit.create( NursingServicesService.class );
        userService = retrofit.create( UserService.class );
    }

    @Override
    public void login( final LoginWrapper loginWrapper, final RequestCallback<Token> requestCallback )
    {


        backgroundExecutor.execute( new Runnable()
        {
            @Override
            public void run()
            {
                Call<Token> call = userService.login(loginWrapper);

                try
                {
                    Response<Token> execute = call.execute();
                    requestCallback.onSuccess( execute.body() );
                }
                catch ( IOException e )
                {
                    requestCallback.onFailed( new NetworkException( null, e ) );
                }
            }
        } );

    }

    @Override
    public void getNursingServices( RequestCallback<List<NursingServices>> requestCallback ){
        try {
            Call<List<NursingServices>> call = nursingServices.getNursingServicesList();
            Response<List<NursingServices>> execute = call.execute();
            requestCallback.onSuccess( execute.body() );
        }
        catch ( IOException e ) {
            requestCallback.onFailed( new NetworkException( null, e ) );
        }
    }



    public void addSecureTokenInterceptor( final String token )
    {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor( new Interceptor()
        {
            @Override
            public okhttp3.Response intercept( Chain chain )
                    throws IOException
            {
                Request original = chain.request();

                Request request = original.newBuilder().header( "Accept", "application/json" ).header( "Authorization",
                        "Bearer "
                                + token ).method(
                        original.method(), original.body() ).build();
                return chain.proceed( request );
            }
        } );
        Retrofit retrofit =
                new Retrofit.Builder().baseUrl( BASE_URL ).addConverterFactory( GsonConverterFactory.create() ).client(
                        httpClient.build() ).build();
        userService = retrofit.create( UserService.class );
    }
}
