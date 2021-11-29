package com.taliaapr.wedone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SewaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sewa);

        RecyclerView recyclerView = findViewById(R.id.rvSewa);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Sewa[] sewa = new Sewa[]{
                new Sewa("Nama Baju", "Harga Sewa", R.drawable.empty)
        };

        SewaAdapter sewaAdapter = new SewaAdapter(sewa, SewaActivity.this);
        recyclerView.setAdapter(sewaAdapter);
    }

    public void btnPerSewa(View view) {
        Intent intent = new Intent(this, DataSewaActivity.class);
        startActivity(intent);
    }
}