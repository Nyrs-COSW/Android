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
import co.edu.pdam.eci.persistenceapiintegration.data.entity.User;
import co.edu.pdam.eci.persistenceapiintegration.ui.activity.ListNurse;

/**
 * Created by 2101751 on 5/21/18.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private final List<User> userByServiceList;
    private Context context;

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
        holder.name.setText(users.getFirstname()+" "+users.getLastname());
        holder.emailText.setText(users.getEmail());
        holder.ageText.setText(String.format("%d",users.getAge()));
    }


    @Override
    public int getItemCount() {
        return userByServiceList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView emailText;
        TextView ageText;
        Button name;

        public ViewHolder(View view) {
            super(view);
            ageText = view.findViewById(R.id.userAge);
            name = view.findViewById(R.id.nameUser);
            emailText = view.findViewById(R.id.emailUser);
            name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent lista = new Intent(view.getContext(), ListNurse.class);
                    context.startActivity(lista);
                }
            });
        }
    }


}
