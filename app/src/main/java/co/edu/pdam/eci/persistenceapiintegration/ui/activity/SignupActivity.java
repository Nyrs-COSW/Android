package co.edu.pdam.eci.persistenceapiintegration.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import co.edu.pdam.eci.persistenceapiintegration.R;
import co.edu.pdam.eci.persistenceapiintegration.data.entity.User;
import co.edu.pdam.eci.persistenceapiintegration.network.Network;
import co.edu.pdam.eci.persistenceapiintegration.network.NetworkException;
import co.edu.pdam.eci.persistenceapiintegration.network.RetrofitNetwork;


public class SignupActivity extends AppCompatActivity{

    private RecyclerView recyclerView;
    private Activity activity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);
        Log.i("SignupActivity", "Entro onCreate");

        Button signup = findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConectToApiNetwork ca = new ConectToApiNetwork();

            }
        });



    }




    private class ConectToApiNetwork{
        RetrofitNetwork rfN;
        ExecutorService executorService;
        private List<User> nurseListByService;
        public ConectToApiNetwork() {
            Log.i("SignupActivity", "Entro a la API");
            rfN = new RetrofitNetwork();
            executorService = Executors.newFixedThreadPool(1);
            executorService.execute(new Runnable() {
                @Override
                public void run() {

                    //prepare patient
                    EditText age = (EditText)findViewById(R.id.age);
                    EditText email = (EditText)findViewById(R.id.email);
                    EditText password = (EditText)findViewById(R.id.password);
                    EditText name = (EditText)findViewById(R.id.name);
                    EditText lastname = (EditText)findViewById(R.id.lastname);
                    EditText username = (EditText)findViewById(R.id.username);

                    //patient
                    User patient = new User(Integer.parseInt(age.getText().toString()), email.getText().toString(), password.getText().toString(), name.getText().toString(), lastname.getText().toString(), username.getText().toString());
                    //patient signUp
                    rfN.newPatient(patient, new Network.RequestCallback<User>() {
                        @Override
                        public void onSuccess(User response) {
                            Log.i("SignupActivity", "Registro exitoso");
                           // Intent intent = new Intent(activity , SigninActivity.class);
                            //startActivity(intent);


                        }

                        @Override
                        public void onFailed(NetworkException e) {
                            e.printStackTrace();
                        }
                    });

                }
            });
        }
    }



}

