package com.taliaapr.wedone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SewaAdapter extends RecyclerView.Adapter<SewaAdapter.ViewHolder>{

    Sewa[] sewa;
    Context context;

    public SewaAdapter(Sewa[] sewa, SewaActivity activity) {
        this.sewa = sewa;
        this.context = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = android.view.LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.sewa_list,parent,false);
        SewaAdapter.ViewHolder viewHolder = new SewaAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Sewa sewaList = sewa[position];
        holder.tvNamaBajuSewa.setText(sewaList.getNamaBajuSewa());
        holder.tvHargaPerSewa.setText(sewaList.getHargaPerSewa());
        holder.imgSewa.setImageResource(sewaList.getImgBajuSewa());
    }

    @Override
    public int getItemCount() {
        return sewa.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvNamaBajuSewa;
        TextView tvHargaPerSewa;
        ImageView imgSewa;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgSewa = itemView.findViewById(R.id.imageSewa);
            tvNamaBajuSewa = itemView.findViewById(R.id.tvNamaBajuSewa);
            tvHargaPerSewa = itemView.findViewById(R.id.tvHargaPerSewa);
        }
    }
}
