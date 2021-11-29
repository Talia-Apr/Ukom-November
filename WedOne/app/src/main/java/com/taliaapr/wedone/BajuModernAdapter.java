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

public class BajuModernAdapter extends RecyclerView.Adapter<BajuModernAdapter.ViewHolder>{

    List<DataBaju> dataBajuList;
    Context context;

    public BajuModernAdapter(List<DataBaju> dataBajuList) {
        this.dataBajuList = dataBajuList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.modern_item_list,parent,false);
        BajuModernAdapter.ViewHolder viewHolder = new BajuModernAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BajuModernAdapter.ViewHolder holder, final int position) {
        holder.tvNamaBajuModern.setText(dataBajuList.get(position).getMenu());
        holder.tvHargaSewaModern.setText(String.valueOf(dataBajuList.get(position).getHarga()));
        holder.tvAlamatToko.setText(dataBajuList.get(position).getAlamattoko());
        Glide.with(holder.itemView.getContext())
                .load(""+dataBajuList.get(position).getGambar())
                .into(holder.imgBajuModern);
//        holder.imgBaju.setImageResource(dataBajuList.getImgBaju());
        holder.btnProdukModern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), BajuDetail.class);
                intent.putExtra("imgBaju", dataBajuList.get(position).getGambar());
//                intent.putExtra("imgBaju", dataBajuList.getKategori());
                intent.putExtra("namaBaju", dataBajuList.get(position).getMenu());
                intent.putExtra("hargaSewa", dataBajuList.get(position).getHarga());
                intent.putExtra("deskripsiBaju", dataBajuList.get(position).getDeskripsi());
                intent.putExtra("fotoToko", dataBajuList.get(position).getFototoko());
                intent.putExtra("alamatToko", dataBajuList.get(position).getAlamattoko());
                intent.putExtra("namaToko", dataBajuList.get(position).getNamatoko());

                v.getContext().startActivity(intent);
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataBajuList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgBajuModern;
        TextView tvNamaBajuModern;
        TextView tvHargaSewaModern;
        TextView tvAlamatToko;
        Button btnProdukModern;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgBajuModern = itemView.findViewById(R.id.imageModern);
            tvNamaBajuModern = itemView.findViewById(R.id.tvNamaBajuModern);
            tvHargaSewaModern = itemView.findViewById(R.id.tvHargaSewaModern);
            tvAlamatToko = itemView.findViewById(R.id.tvAlamatModern);
            btnProdukModern = itemView.findViewById(R.id.btnProdukModern);
        }
    }
}
