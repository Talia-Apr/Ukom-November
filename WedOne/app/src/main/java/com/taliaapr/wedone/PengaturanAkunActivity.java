package com.taliaapr.wedone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class PengaturanAkunActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengaturan_akun);

        imageView = findViewById(R.id.jenisKl);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new JenisKelaminDialog().show(getSupportFragmentManager(),"FragmentDialog");
            }
        });
    }

    public void btnLogout(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    public void btnSimpan(View view) {
        Intent intent = new Intent(this, AkunActivity.class);
        startActivity(intent);
    }
}