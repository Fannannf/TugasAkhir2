package com.example.tugasakhir2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {
    private Context context;
    private ArrayList<ModelLaundry> mylist;
    FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
    private AdapterView.OnItemClickListener item;

    public OrderAdapter(Context context, ArrayList<ModelLaundry> mylist) {
        this.context = context;
        this.mylist = mylist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_riwayat, parent, false);
        ViewHolder evh = new ViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ModelLaundry data = mylist.get(position);
        holder.riwayatNama.setText(firebaseUser.getDisplayName());
        holder.riwayatHasil.setText("Rp "+ data.getTotal());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,Detail_Activity.class);
                intent.putExtra("nama",data.getNama());
                intent.putExtra("kaos",data.getKaos());
                intent.putExtra("jeans",data.getJeans());
                intent.putExtra("jaket",data.getJaket());
                intent.putExtra("bedcover",data.getBedcover());
                intent.putExtra("total",data.getTotal());
                intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView riwayatNama,riwayatHasil;
        CardView riwayat;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            riwayatNama = itemView.findViewById(R.id.riwayatNama);
            riwayatHasil = itemView.findViewById(R.id.riwayatHasil);
            riwayat = itemView.findViewById(R.id.itemRiwayat);
        }
    }
}
