package com.taliaapr.wedone;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class BajuTokoAdapter extends RecyclerView.Adapter<BajuTokoAdapter.ViewHolder>{

    List<DataBaju> dataBajuList;
    Context context;

    public BajuTokoAdapter(List<DataBaju> dataBajuList) {
        this.dataBajuList = dataBajuList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.toko_item_list,parent,false);
        BajuTokoAdapter.ViewHolder viewHolder = new BajuTokoAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BajuTokoAdapter.ViewHolder holder, final int position) {
        Intent intent = (TokoActivity.ma.getIntent());
        int value = intent.getIntExtra("idToko",0);

        if(dataBajuList.get(position).getIdtoko() == value){
        holder.tvNamaBajuToko.setText(dataBajuList.get(position).getMenu());
        holder.tvHargaSewaToko.setText(String.valueOf(dataBajuList.get(position).getHarga()));
        Glide.with(holder.itemView.getContext())
                .load("" + dataBajuList.get(position).getGambar())
                .into(holder.imgBajuToko);
        holder.btnProdukToko.setOnClickListener(new View.OnClickListener() {
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
    }else {
            holder.itemView.setVisibility(View.GONE);
            holder.itemView.setLayoutParams(new RecyclerView.LayoutParams(0,0));
        }
    }

    @Override
    public int getItemCount() {
        return dataBajuList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgBajuToko;
        TextView tvNamaBajuToko;
        TextView tvHargaSewaToko;
        Button btnProdukToko;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgBajuToko = itemView.findViewById(R.id.imageToko);
            tvNamaBajuToko = itemView.findViewById(R.id.tvNamaBajuToko);
            tvHargaSewaToko = itemView.findViewById(R.id.tvHargaSewaToko);
            btnProdukToko = itemView.findViewById(R.id.btnProdukToko);
        }
    }
}
