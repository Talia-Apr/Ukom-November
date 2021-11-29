package com.taliaapr.wedone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class DaftarPenyewaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_penyewa);

        RecyclerView recyclerView = findViewById(R.id.rvPenyewa);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Penyewa[] penyewa = new Penyewa[]{
                new Penyewa("Rini Wulandari","Perum.Taman Delta Pecabean - Sidoarjo, Jawa Timur",
                        "Baju Pernikahan Adat Jawa", "07-11-2021",
                        "10-11-2021", "Rp. 1.000.000")
        };

        PenyewaAdapter penyewaAdapter = new PenyewaAdapter(penyewa, DaftarPenyewaActivity.this);
        recyclerView.setAdapter(penyewaAdapter);
    }

}