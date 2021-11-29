package com.taliaapr.wedone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AkunActivity extends AppCompatActivity {

    ImageView imgAkun;
    TextView tvNamaUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akun);

        imgAkun = findViewById(R.id.imgAkun);
        tvNamaUser = findViewById(R.id.tvNama);

        Glide.with(AkunActivity.this)
                .load(""+getIntent().getStringExtra("gambar"))
                .apply(new RequestOptions().override(60,60))
                .into(imgAkun);
        tvNamaUser.setText(getIntent().getStringExtra("nama"));

        BottomNavigationView bottomNavigationView = findViewById(R.id.btmNav);
        bottomNavigationView.setSelectedItemId(R.id.akun);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.history:
                        startActivity(new Intent(getApplicationContext(), HistoryActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.akun:
                        return true;
                }
                return false;
            }
        });
    }

    public void akunSet(View view) {
        Intent intent = new Intent(this, PengaturanAkunActivity.class);
        startActivity(intent);
    }

    public void mulaiMenyewakan(View view) {
        Intent intent = new Intent(this, MenyewakanActivity.class);
        startActivity(intent);
    }

    public void tokoSet(View view) {
        Intent intent = new Intent(this, ProdukSayaActivity.class);
        startActivity(intent);
    }
}