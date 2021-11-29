package com.taliaapr.wedone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class BajuTokoDetail extends AppCompatActivity {

    ImageView imgBajuToko;
    TextView tvNamaBajuToko,tvHargaSewaToko,tvDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baju_toko_detail);

        imgBajuToko = findViewById(R.id.home_detail_img);
        tvNamaBajuToko = findViewById(R.id.home_namabaju_detail);
        tvHargaSewaToko = findViewById(R.id.home_hargabaju_detail);
//        tvDesc = findViewById(R.id.home_descbaju_detail);

        imgBajuToko.setImageResource(getIntent().getExtras().getInt("imgBajuToko"));
        tvNamaBajuToko.setText(getIntent().getExtras().getString("namaBajuToko"));
        tvHargaSewaToko.setText(getIntent().getExtras().getString("hargaSewaToko"));
//        tvDesc.setText(getIntent().getExtras().getString("DeskripsiProduk"));
    }

    public void btnDetailToko(View view) {
        Intent intent = new Intent(this, TokoActivity.class);
        startActivity(intent);
    }

    public void btnSewaToko(View view) {
        Intent intent = new Intent(this, SewaActivity.class);
        startActivity(intent);
    }

}