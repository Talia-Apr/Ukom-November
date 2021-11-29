package com.taliaapr.wedone;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.GenericLifecycleObserver;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class BajuAdapter extends RecyclerView.Adapter<BajuAdapter.ViewHolder>{

    List<DataBaju> dataBajuList;
    Context context;

    public BajuAdapter(List<DataBaju> dataBajuList) {
        this.dataBajuList = dataBajuList;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BajuAdapter.ViewHolder holder, final int position) {
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


//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, dataBajuList.getKategori(), Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return dataBajuList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgBaju;
        TextView tvNamaBaju;
        TextView tvHargaSewa;
        TextView tvDeskripsi;
        TextView tvAlamat;
        TextView tvNamaToko;
        ImageView imgFotoToko;
        Button btnProduk;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgBaju = itemView.findViewById(R.id.imageHome);
            tvNamaBaju = itemView.findViewById(R.id.tvNamaBaju);
            tvHargaSewa = itemView.findViewById(R.id.tvHargaSewa);
            tvDeskripsi = itemView.findViewById(R.id.home_descbaju_detail);
            tvAlamat = itemView.findViewById(R.id.tvAlamat);
            tvNamaToko = itemView.findViewById(R.id.namaToko);
            imgFotoToko = itemView.findViewById(R.id.imgAkunTokoDetail);
            btnProduk = itemView.findViewById(R.id.btnProduk);
        }
    }
}
