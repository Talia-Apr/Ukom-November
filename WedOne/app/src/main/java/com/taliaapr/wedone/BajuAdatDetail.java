package com.taliaapr.wedone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class BajuAdatDetail extends AppCompatActivity {

    ImageView imgBajuAdat;
    TextView tvNamaBajuAdat,tvHargaSewaAdat,tvDescAdat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baju_adat_detail);

        imgBajuAdat = findViewById(R.id.adat_detail_img);
        tvNamaBajuAdat = findViewById(R.id.adat_namabaju_detail);
        tvHargaSewaAdat = findViewById(R.id.adat_hargabaju_detail);
//        tvDescAdat = findViewById(R.id.adat_descbaju_detail);

        imgBajuAdat.setImageResource(getIntent().getExtras().getInt("imgBajuAdat"));
        tvNamaBajuAdat.setText(getIntent().getExtras().getString("namaBajuAdat"));
        tvHargaSewaAdat.setText(getIntent().getExtras().getString("hargaSewaAdat"));
//      tvDesc.setText(getIntent().getExtras().getString("DeskripsiProduk"));
    }

    public void btnDetailAdatToko(View view) {
        Intent intent = new Intent(this, TokoActivity.class);
        startActivity(intent);
    }

    public void btnSewaAdat(View view) {
        Intent intent = new Intent(this, DataSewaActivity.class);
        startActivity(intent);
    }
}