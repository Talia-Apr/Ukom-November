package com.taliaapr.wedone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EditProdukActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_produk);
    }

    public void btnSimpanEditProduk(View view) {
        Intent intent = new Intent(this, ProdukSayaActivity.class);
        startActivity(intent);
    }
}