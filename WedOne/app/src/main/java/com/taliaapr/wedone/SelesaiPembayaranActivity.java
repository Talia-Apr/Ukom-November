package com.taliaapr.wedone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SelesaiPembayaranActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selesai_pembayaran);
    }

    public void btnSelesaiPemb(View view) {
        Intent intent = new Intent(this, TokoMenyewaActivity.class);
        startActivity(intent);
    }
}