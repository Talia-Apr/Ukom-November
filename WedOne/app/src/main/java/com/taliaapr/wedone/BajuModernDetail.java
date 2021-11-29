package com.taliaapr.wedone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class BajuModernDetail extends AppCompatActivity {

    ImageView imgBajuModern;
    TextView tvNamaBajuModern,tvHargaSewaModern,tvDescModern;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baju_modern_detail);

        imgBajuModern = findViewById(R.id.modern_detail_img);
        tvNamaBajuModern = findViewById(R.id.modern_namabaju_detail);
        tvHargaSewaModern = findViewById(R.id.modern_hargabaju_detail);
//        tvDescModern = findViewById(R.id.modern_descbaju_detail);

        imgBajuModern.setImageResource(getIntent().getExtras().getInt("imgBajuModern"));
        tvNamaBajuModern.setText(getIntent().getExtras().getString("namaBajuModern"));
        tvHargaSewaModern.setText(getIntent().getExtras().getString("hargaSewaModern"));
//      tvDescModern.setText(getIntent().getExtras().getString("DeskripsiProduk"));
    }

    public void btnDetailModernToko(View view) {
        Intent intent = new Intent(this, TokoActivity.class);
        startActivity(intent);
    }

    public void btnSewaModern(View view) {
        Intent intent = new Intent(this, DataSewaActivity.class);
        startActivity(intent);
    }
}