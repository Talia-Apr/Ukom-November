package com.taliaapr.wedone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class BajuDetail extends AppCompatActivity {

    ImageView imgBaju, imgFotoToko;
    TextView tvNamaBaju,tvHargaSewa,tvDeskripsi, tvAlamat, tvNamaToko;
    Button btnDetailToko;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baju_detail);

        imgBaju = findViewById(R.id.home_detail_img);
        tvNamaBaju = findViewById(R.id.home_namabaju_detail);
        tvHargaSewa = findViewById(R.id.home_hargabaju_detail);
        tvDeskripsi = findViewById(R.id.home_descbaju_detail);
        tvAlamat = findViewById(R.id.tvAlamat);
        tvNamaToko = findViewById(R.id.namaToko);
        imgFotoToko = findViewById(R.id.imgAkunTokoDetail);
        btnDetailToko = findViewById(R.id.btnDetailToko);

//        imgBaju.setImageResource(getIntent().getExtras().getInt("imgBaju"));
        Glide.with(BajuDetail.this)
                .load(""+getIntent().getStringExtra("imgBaju"))
                .apply(new RequestOptions().override(350,550))
                .into(imgBaju);
        tvNamaBaju.setText(getIntent().getExtras().getString("namaBaju"));
        tvHargaSewa.setText(Integer.toString(getIntent().getIntExtra("hargaSewa",0)));
        tvDeskripsi.setText(getIntent().getExtras().getString("deskripsiBaju"));
        tvAlamat.setText(getIntent().getExtras().getString("alamatToko"));
        tvNamaToko.setText(getIntent().getExtras().getString("namaToko"));
        Glide.with(BajuDetail.this)
                .load(""+getIntent().getStringExtra("fotoToko"))
                .apply(new RequestOptions().override(350,550))
                .into(imgFotoToko);

        btnDetailToko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), TokoActivity.class);
                intent.putExtra("fotoToko", getIntent().getStringExtra("fotoToko"));
                intent.putExtra("namaToko", getIntent().getStringExtra("namaToko"));
                intent.putExtra("alamatToko", getIntent().getStringExtra("alamatToko"));
                intent.putExtra("idToko", getIntent().getIntExtra("idToko",0));
                startActivity(intent);
            }
        });
    }

    public void btnSewa(View view) {

        Intent nwIntent = (HomeActivity.ma.getIntent());

        if(nwIntent.getExtras()==null){
            startActivity(new Intent(view.getContext(),LoginActivity.class));
        }else {
            Intent intent = new Intent(this, DataSewaActivity.class);
            startActivity(intent);
        }
//
//        Intent intent = new Intent(this, LoginActivity.class);
//        startActivity(intent);
    }
}