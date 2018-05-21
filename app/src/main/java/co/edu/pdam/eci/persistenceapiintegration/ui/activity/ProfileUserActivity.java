package co.edu.pdam.eci.persistenceapiintegration.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import co.edu.pdam.eci.persistenceapiintegration.R;
import co.edu.pdam.eci.persistenceapiintegration.data.entity.User;
import co.edu.pdam.eci.persistenceapiintegration.network.Network;
import co.edu.pdam.eci.persistenceapiintegration.network.NetworkException;
import co.edu.pdam.eci.persistenceapiintegration.network.RetrofitNetwork;
import co.edu.pdam.eci.persistenceapiintegration.ui.adapter.UserAdapter;

/**
 * Created by 2101751 on 5/21/18.
 */

public class ProfileUserActivity  extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_user_view);
        System.out.println("ENTRO A LISTnURSE");}}/*
        recyclerView = findViewById( R.id.recyclerViewProfile );
        configureRecyclerView();
        ConectToApiNetwork ca = new ConectToApiNetwork();
    }

    private void configureRecyclerView() {
        recyclerView = findViewById( R.id.recyclerViewUser );
        recyclerView.setHasFixedSize( true );
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager( this );
        recyclerView.setLayoutManager( layoutManager );
    }

    private class ConectToApiNetwork{
        RetrofitNetwork rfN;
        ExecutorService executorService;
        private List<User> nurseListByService;
        public ConectToApiNetwork() {
            System.out.println("ENTRO A CONTECT TO API");
            rfN = new RetrofitNetwork();
            executorService = Executors.newFixedThreadPool(1);
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    rfN.getNursesByService((String) getIntent().getSerializableExtra("servicio"), new Network.RequestCallback<List<User>>() {
                        @Override
                        public void onSuccess(List<User> response) {
                            System.out.println("ESTA MIRANDO LA LISTA");
                            System.out.println(response);
                            nurseListByService = response;
                        }

                        @Override
                        public void onFailed(NetworkException e) {
                            e.printStackTrace();
                        }
                    });
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            recyclerView.setAdapter(new UserAdapter(nurseListByService));
                        }
                    });
                }
            });
        }
    }



}*/
