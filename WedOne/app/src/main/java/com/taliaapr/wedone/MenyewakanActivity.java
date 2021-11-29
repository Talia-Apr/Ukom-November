package com.taliaapr.wedone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenyewakanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menyewakan);
    }

    public void btnDaftarToko(View view) {
        Intent intent = new Intent(this, DaftarTokoActivity.class);
        startActivity(intent);
    }
}