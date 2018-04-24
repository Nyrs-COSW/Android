package co.edu.pdam.eci.persistenceapiintegration.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import co.edu.pdam.eci.persistenceapiintegration.R;
import co.edu.pdam.eci.persistenceapiintegration.data.entity.NursingServices;


public class NursingServicesAdapter extends RecyclerView.Adapter<NursingServicesAdapter.ViewHolder>{

    private final List<NursingServices> nursingServicesList;
    private Context context;

    public NursingServicesAdapter(List<NursingServices> response) {
        this.nursingServicesList = response;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.team_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NursingServices nursingServices = nursingServicesList.get(position);
        holder.name.setText(nursingServices.getName());
        holder.description.setText(nursingServices.getDescription());
    }

    @Override
    public int getItemCount() {
        return nursingServicesList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, description;

        public ViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            description = (TextView) view.findViewById(R.id.description);
        }
    }
}
