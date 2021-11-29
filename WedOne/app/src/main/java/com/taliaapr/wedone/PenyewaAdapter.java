package com.taliaapr.wedone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PenyewaAdapter extends RecyclerView.Adapter<PenyewaAdapter.ViewHolder>{

    Penyewa[] penyewa;
    Context context;

    public PenyewaAdapter(Penyewa[] penyewa, DaftarPenyewaActivity activity) {
        this.penyewa = penyewa;
        this.context = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.penyewa_list,parent,false);
        PenyewaAdapter.ViewHolder viewHolder = new PenyewaAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PenyewaAdapter.ViewHolder holder, int position) {
        final Penyewa penyewaList = penyewa[position];
        holder.tvNamaPenyewa.setText(penyewaList.getNamaPenyewa());
        holder.tvBajuPenyewa.setText(penyewaList.getBajuPenyewa());
        holder.tvAlamatPenyewa.setText(penyewaList.getAlamatPenyewa());
        holder.tvHargaSewaBaju.setText(penyewaList.getHargaSewaBaju());
        holder.tvTanggalSewaPenyewa.setText(penyewaList.getTanggalSewaPenyewa());
        holder.tvTanggalAkhirPenyewa.setText(penyewaList.getTanggalAkhirPenyewa());
    }

    @Override
    public int getItemCount() {
        return penyewa.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvNamaPenyewa;
        TextView tvBajuPenyewa;
        TextView tvAlamatPenyewa;
        TextView tvHargaSewaBaju;
        TextView tvTanggalSewaPenyewa;
        TextView tvTanggalAkhirPenyewa;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaPenyewa = itemView.findViewById(R.id.tvNamaPenyewa);
            tvBajuPenyewa = itemView.findViewById(R.id.tvNamaBajuPenyewa);
            tvAlamatPenyewa = itemView.findViewById(R.id.tvAlamatPenyewa);
            tvHargaSewaBaju = itemView.findViewById(R.id.tvHargaSewaBaju);
            tvTanggalSewaPenyewa = itemView.findViewById(R.id.tvTanggalSewaPenyewa);
            tvTanggalAkhirPenyewa = itemView.findViewById(R.id.tvTanggalAkhirPenyewa);
        }
    }
}
