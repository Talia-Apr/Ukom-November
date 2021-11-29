package com.taliaapr.wedone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PembayaranDaftarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembayaran_daftar);
    }

    public void pmbDana(View view) {
        Intent intent = new Intent(this, VerifPembayaranActivity.class);
        startActivity(intent);
    }
}