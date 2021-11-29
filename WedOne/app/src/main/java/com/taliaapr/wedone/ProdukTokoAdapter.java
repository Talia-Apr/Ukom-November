package com.taliaapr.wedone;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ProdukTokoAdapter extends RecyclerView.Adapter<ProdukTokoAdapter.ViewHolder>{

    List<DataBaju> dataBajuList;
    Context context;

    public ProdukTokoAdapter(List<DataBaju> dataBajuList) {
        this.dataBajuList = dataBajuList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.produk_list,parent,false);
        ProdukTokoAdapter.ViewHolder viewHolder = new ProdukTokoAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProdukTokoAdapter.ViewHolder holder, final int position) {
        holder.tvNamaProduk.setText(dataBajuList.get(position).getMenu());
        holder.tvHargaSewaProduk.setText(String.valueOf(dataBajuList.get(position).getHarga()));
//        holder.tvNamaToko.setText(dataBajuList.get(position).getNamatoko());
//        holder.tvAlamatToko.setText(dataBajuList.get(position).getAlamattoko());
        holder.tvDeskripsiProduk.setText(dataBajuList.get(position).getDeskripsi());
//        Glide.with(holder.itemView.getContext())
//                .load(""+dataBajuList.get(position).getFototoko())
//                .into(holder.imgAkunToko);
        Glide.with(holder.itemView.getContext())
                .load(""+dataBajuList.get(position).getGambar())
                .into(holder.imageProduk);
        holder.popMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(v.getContext(), holder.popMenu);
                popupMenu.inflate(R.menu.popup_menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()){
                                case R.id.editProduk:
                                    Intent intent = new Intent(v.getContext(), EditProdukActivity.class);
                                    v.getContext().startActivity(intent);
                                    intent.putExtra("namaBaju", dataBajuList.get(position).getMenu());
                                    intent.putExtra("hargaSewa", dataBajuList.get(position).getHarga());
                                    intent.putExtra("deskripsiBaju", dataBajuList.get(position).getDeskripsi());
                                    intent.putExtra("alamatToko", dataBajuList.get(position).getAlamattoko());
                                    return true;

                                case R.id.hapusProduk:
                                    Toast.makeText(v.getContext(), "Hapus Produk", Toast.LENGTH_SHORT).show();
                                    return true;

                                default:
                                    return false;
                            }
                        }
                });
                popupMenu.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataBajuList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvNamaProduk;
        TextView tvHargaSewaProduk;
        ImageView imgAkunToko;
        TextView tvNamaToko;
        TextView tvAlamatToko;
        TextView tvDeskripsiProduk;
        ImageView imageProduk;
        TextView popMenu;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaProduk = itemView.findViewById(R.id.tvNamaProduk);
            tvHargaSewaProduk = itemView.findViewById(R.id.tvHargaSewaProduk);
            imgAkunToko = itemView.findViewById(R.id.imgAkunTokoSaya);
//            tvNamaToko = itemView.findViewById(R.id.tvNamaTokoSaya);
//            tvAlamatToko = itemView.findViewById(R.id.tvAlamatToko);
            tvDeskripsiProduk = itemView.findViewById(R.id.tvDeskripsiProduk);
            imageProduk = itemView.findViewById(R.id.imageProduk);
            popMenu = itemView.findViewById(R.id.popMenu);
        }

    }
}
