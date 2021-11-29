package com.taliaapr.wedone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TokoMenyewaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toko_menyewa);
    }

    public void btnTambahProduk(View view) {
        Intent intent = new Intent(this, TambahProdukActivity.class);
        startActivity(intent);
    }
}