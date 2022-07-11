package com.example.cmritplacementapp;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
public class JobRVAdapter extends RecyclerView.Adapter<JobRVAdapter.ViewHolder> {
        private ArrayList<DriveModel> DriveModelArrayList;
        private Context context;
        public JobRVAdapter(ArrayList<DriveModel> DriveModelArrayList, Context context) {
            this.DriveModelArrayList = DriveModelArrayList;
            this.context = context;
        }
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.job_rv_item, parent, false);
            return new ViewHolder(view);
        }
        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            DriveModel modal = DriveModelArrayList.get(position);
            holder.companyNameTV.setText(modal.getCompanyName());
            holder.RoleTV.setText(modal.getRole());
            holder.CTCTV.setText(modal.getCTC());
            holder.JDTV.setText(modal.getJD());
            holder.LinkTV.setText(modal.getLink());
        }
        @Override
        public int getItemCount() {
            return DriveModelArrayList.size();
        }
        public class ViewHolder extends RecyclerView.ViewHolder {
            private TextView companyNameTV, RoleTV, CTCTV, JDTV;
            private Button LinkTV;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                companyNameTV = itemView.findViewById(R.id.idTVCompanyName);
                RoleTV = itemView.findViewById(R.id.idTVRole);
                CTCTV = itemView.findViewById(R.id.idTVCTC);
                JDTV = itemView.findViewById(R.id.idTVJD);
                LinkTV = itemView.findViewById(R.id.idTVLink);
            }
        }
    };
