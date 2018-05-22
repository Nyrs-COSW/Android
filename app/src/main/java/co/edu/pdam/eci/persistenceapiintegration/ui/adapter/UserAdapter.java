package co.edu.pdam.eci.persistenceapiintegration.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import co.edu.pdam.eci.persistenceapiintegration.R;
import co.edu.pdam.eci.persistenceapiintegration.data.entity.NursingServices;
import co.edu.pdam.eci.persistenceapiintegration.data.entity.User;
import co.edu.pdam.eci.persistenceapiintegration.ui.activity.ProfileUserActivity;

/**
 * Created by 2101751 on 5/21/18.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private final List<User> userByServiceList;
    private Context context;
    private User userLocal;

    public UserAdapter(List<User> response) {
        this.userByServiceList = response;
    }

    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.nursebyservice_row, parent, false);
        return new UserAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        User users = userByServiceList.get(position);
        userLocal = users;
        List<NursingServices> nursingServicesLocal = userLocal.getServices();
        String ns="";
        for (int i = 0; i < nursingServicesLocal.size(); i++) {
            if(i == nursingServicesLocal.size()-1){
                ns = ns+nursingServicesLocal.get(i).getName()+".";
            }
            else{
                ns = ns+nursingServicesLocal.get(i).getName()+", ";
            }
        }

        holder.name.setText(users.getFirstname()+" "+users.getLastname());
        holder.servicesByUser.setText("Servicios: "+ns);
        holder.ageText.setText("Edad: "+String.format("%d",users.getAge()));
    }


    @Override
    public int getItemCount() {
        return userByServiceList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView servicesByUser;
        TextView ageText;
        Button name;

        public ViewHolder(View view) {
            super(view);
            ageText = view.findViewById(R.id.userAge);
            name = view.findViewById(R.id.nameUser);
            servicesByUser = view.findViewById(R.id.servicesUser);
            name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intentProfile = new Intent(view.getContext(), ProfileUserActivity.class);
                    intentProfile.putExtra("nameProfile", userLocal.getFirstname()+" "+userLocal.getLastname());
                    intentProfile.putExtra("emailProfile", userLocal.getEmail());
                    intentProfile.putExtra("ageProfile", userLocal.getAge());
                    intentProfile.putExtra("usernameProfile", userLocal.getUsername());
                    List<NursingServices> nurser = userLocal.getServices();
                    intentProfile.putExtra("sizeNursinServicesProfile", nurser.size());
                    for (int i = 0; i < nurser.size(); i++) {
                        intentProfile.putExtra("service"+i, nurser.get(i).getName());
                    }
                    context.startActivity(intentProfile);
                }
            });
        }
    }


}
