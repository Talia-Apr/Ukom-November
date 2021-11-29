package com.taliaapr.wedone;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class BajuAdatAdapter extends RecyclerView.Adapter<BajuAdatAdapter.ViewHolder>{

    List<DataBaju> dataBajuList;
    Context context;

    public BajuAdatAdapter(List<DataBaju> dataBajuList) {
        this.dataBajuList = dataBajuList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adat_item_list,parent,false);
        BajuAdatAdapter.ViewHolder viewHolder = new BajuAdatAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BajuAdatAdapter.ViewHolder holder, final int position) {
        Intent intent = (AdatActivity.ma.getIntent());
        int value = intent.getIntExtra("idKategori", 0);

        if (dataBajuList.get(position).getIdkategori() == value) {
            holder.tvNamaBaju.setText(dataBajuList.get(position).getMenu());
            holder.tvHargaSewa.setText(String.valueOf(dataBajuList.get(position).getHarga()));
            holder.tvAlamat.setText(dataBajuList.get(position).getAlamattoko());
            Glide.with(holder.itemView.getContext())
                    .load(""+dataBajuList.get(position).getGambar())
                    .into(holder.imgBaju);
            holder.btnProduk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), BajuDetail.class);
                    intent.putExtra("imgBaju", dataBajuList.get(position).getGambar());
                    intent.putExtra("namaBaju", dataBajuList.get(position).getMenu());
                    intent.putExtra("hargaSewa", dataBajuList.get(position).getHarga());
                    intent.putExtra("deskripsiBaju", dataBajuList.get(position).getDeskripsi());
                    intent.putExtra("fotoToko", dataBajuList.get(position).getFototoko());
                    intent.putExtra("alamatToko", dataBajuList.get(position).getAlamattoko());
                    intent.putExtra("namaToko", dataBajuList.get(position).getNamatoko());
                    intent.putExtra("idToko", dataBajuList.get(position).getIdtoko());

                    v.getContext().startActivity(intent);
                }
            });
        } else {
            holder.itemView.setVisibility(View.GONE);
            holder.itemView.setLayoutParams(new RecyclerView.LayoutParams(0, 0));
        }
    }


    @Override
    public int getItemCount() {
        return dataBajuList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgBaju;
        TextView tvNamaBaju;
        TextView tvHargaSewa;
        TextView tvAlamat;
        Button btnProduk;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgBaju = itemView.findViewById(R.id.imageAdat);
            tvNamaBaju = itemView.findViewById(R.id.tvNamaBajuAdat);
            tvHargaSewa = itemView.findViewById(R.id.tvHargaSewaAdat);
            tvAlamat = itemView.findViewById(R.id.tvAlamat);
            btnProduk = itemView.findViewById(R.id.btnProdukAdat);
        }
    }
}
