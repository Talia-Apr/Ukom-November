package com.taliaapr.wedone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProdukSayaActivity extends AppCompatActivity {

    ApiInterface apiInterface;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter produkTokoAdapter;
    private RecyclerView.LayoutManager layoutManager;
    public static ProdukSayaActivity ma;

    TextView tvNamaToko;
    ImageView imgAkunToko;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produk_saya);

//        tvNamaToko = findViewById(R.id.tvNamaTokoSaya);
//
//        tvNamaToko.setText(getIntent().getExtras().getString("namaToko"));

//        tvNamaToko = findViewById(R.id.tvNamaTokoSaya);
//        imgAkunToko = findViewById(R.id.imgAkunTokoSaya);
//        Glide.with(ProdukSayaActivity.this)
//                .load(""+getIntent().getStringExtra("imgAkunToko"))
//                .apply(new RequestOptions().override(350,550))
//                .into(imgAkunToko);
//        tvNamaToko.setText(getIntent().getExtras().getString("namaToko"));

        recyclerView = (RecyclerView) findViewById(R.id.rvProduk);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        ma=this;

//        DataProduk[] dataProduk = new DataProduk[]{
//                new DataProduk("Adat Jawa", "Rp.1.000.000", R.drawable.adatjawa, "Baju yang sangat nyaman dipakai dengan harga yang murah"),
//                new DataProduk("Adat Jambi", "Rp.750.000", R.drawable.adatjambi, "Baju yang sangat nyaman dipakai dengan harga yang murah"),
//                new DataProduk("Blue Dress", "Rp.1.300.000", R.drawable.moderndressblue, "Baju yang sangat nyaman dipakai dengan harga yang murah"),
//                new DataProduk("Long Dress", "Rp.2.350.000", R.drawable.modernlongdress, "Baju yang sangat nyaman dipakai dengan harga yang murah"),
//        };
//
//        ProdukTokoAdapter produkTokoAdapter = new ProdukTokoAdapter(dataProduk, ProdukSayaActivity.this);
//        recyclerView.setAdapter(produkTokoAdapter);

        // Function
        getDataBajuToko();
    }

    public void getDataBajuToko() {
        Call<GetDataBaju> dataBajuCall = apiInterface.getDataBaju();
        dataBajuCall.enqueue(new Callback<GetDataBaju>() {
            @Override
            public void onResponse(Call<GetDataBaju> call, Response<GetDataBaju>
                    response) {
                List<DataBaju> dataBajuList = response.body().getData();
                Log.d("Retrofit Get", "Jumlah data Kontak: " +
                        String.valueOf(dataBajuList.size()));
                produkTokoAdapter = new ProdukTokoAdapter(dataBajuList);
                recyclerView.setAdapter(produkTokoAdapter);
            }

            @Override
            public void onFailure(Call<GetDataBaju> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }

    public void btnTambahBaju(View view) {
        Intent intent = new Intent(this, TambahProdukActivity.class);
        startActivity(intent);
    }

    public void daftarPenyewa(View view) {
        Intent intent = new Intent(this, DaftarPenyewaActivity.class);
        startActivity(intent);
    }
}