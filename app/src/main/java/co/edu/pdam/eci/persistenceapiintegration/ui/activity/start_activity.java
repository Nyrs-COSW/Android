package co.edu.pdam.eci.persistenceapiintegration.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import co.edu.pdam.eci.persistenceapiintegration.R;
import co.edu.pdam.eci.persistenceapiintegration.data.OrmModel;
import co.edu.pdam.eci.persistenceapiintegration.data.entity.NursingServices;
import co.edu.pdam.eci.persistenceapiintegration.network.Network;
import co.edu.pdam.eci.persistenceapiintegration.network.NetworkException;
import co.edu.pdam.eci.persistenceapiintegration.network.RetrofitNetwork;
import co.edu.pdam.eci.persistenceapiintegration.ui.adapter.NursingServicesAdapter;

public class start_activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private OrmModel ormModel;


    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.start_activity_view);
        recyclerView = findViewById( R.id.recyclerView );
        configureRecyclerView();
        ConectToApiNetwork ca = new ConectToApiNetwork();
    }


    private void configureRecyclerView() {
        recyclerView = findViewById( R.id.recyclerView );
        recyclerView.setHasFixedSize( true );
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager( this );
        recyclerView.setLayoutManager( layoutManager );

    }


    private class ConectToApiNetwork{
        RetrofitNetwork rfN;
        ExecutorService executorService;
        private List<NursingServices> nursingServicesList;

        public ConectToApiNetwork() {
            rfN = new RetrofitNetwork();
            executorService = Executors.newFixedThreadPool(1);
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    rfN.getNursingServices(new Network.RequestCallback<List<NursingServices>>() {
                        @Override
                        public void onSuccess(List<NursingServices> response) {
                            nursingServicesList = response;
                        }

                        @Override
                        public void onFailed(NetworkException e) {
                            e.printStackTrace();
                        }
                    });
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            recyclerView.setAdapter(new NursingServicesAdapter(nursingServicesList));
                        }
                    });
                }
            });
        }
    }
    public void ListNurse(){
        Button lista;
        lista = findViewById(R.id.name);
        lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lista = new Intent(start_activity.this, ListNurse.class);
                startActivity(lista);
            }
        });

    }


}
