package com.taliaapr.wedone;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder>{

    List<History> historyList;
    Context context;

    public HistoryAdapter(List<History> historyList) {
        this.historyList = historyList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_list,parent,false);
        ViewHolder viewHolder = new HistoryAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.ViewHolder holder, final int position) {
        holder.tvNamaTokoHistory.setText(historyList.get(position).getNamatoko());
        holder.tvNamaBajuHistory.setText(historyList.get(position).getNamabaju());
        holder.tvAlamatTokoHistory.setText(historyList.get(position).getAlamattoko());
        holder.tvHargaSewaHistory.setText(String.valueOf(historyList.get(position).getTotal()));
        holder.tvTanggalSewaHistory.setText(historyList.get(position).getTglorder());
        holder.tvTanggalAkhirHistory.setText(historyList.get(position).getTglkembali());
        holder.btnDataSewa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DataSewaActivity.class);
                intent.putExtra("namaToko", historyList.get(position).getNamatoko());
                intent.putExtra("namaBaju", historyList.get(position).getNamabaju());
                intent.putExtra("hargaTotal", historyList.get(position).getTotal());
                intent.putExtra("tglOrder", historyList.get(position).getTglorder());
                intent.putExtra("tglKembali", historyList.get(position).getTglkembali());

                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return historyList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvNamaTokoHistory;
        TextView tvNamaBajuHistory;
        TextView tvAlamatTokoHistory;
        TextView tvHargaSewaHistory;
        TextView tvTanggalSewaHistory;
        TextView tvTanggalAkhirHistory;
        Button btnDataSewa;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaTokoHistory = itemView.findViewById(R.id.tvNamaTokoHistory);
            tvNamaBajuHistory = itemView.findViewById(R.id.tvNamaBajuHistory);
            tvAlamatTokoHistory = itemView.findViewById(R.id.tvAlamatTokoHistory);
            tvHargaSewaHistory = itemView.findViewById(R.id.tvHargaSewaHistory);
            tvTanggalSewaHistory = itemView.findViewById(R.id.tvTanggalSewaHistory);
            tvTanggalAkhirHistory = itemView.findViewById(R.id.tvTanggalAkhirHistory);
            btnDataSewa = itemView.findViewById(R.id.btnDataSewa);
        }
    }
}
