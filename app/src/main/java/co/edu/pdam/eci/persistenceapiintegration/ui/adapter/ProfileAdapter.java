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
import co.edu.pdam.eci.persistenceapiintegration.ui.activity.ProfileUserActivity;

/**
 * Created by 2101751 on 5/21/18.
 */

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ViewHolder> {

    private User user;
    private Context context;

    public ProfileAdapter(User response) {
        this.user = response;
    }

    @Override
    public ProfileAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.profile_user_view, parent, false);
        return new ProfileAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.profileName.setText(user.getFirstname()+" "+user.getLastname());
    }

    @Override
    public int getItemCount() {
        return 1;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView profileName;

        public ViewHolder(View view) {
            super(view);
            profileName = view.findViewById(R.id.profileName);

        }
    }


}
