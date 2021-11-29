package com.taliaapr.wedone;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class VerifPembayaranActivity extends AppCompatActivity {

    ImageView imgVerif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verif_pembayaran);

        imgVerif = findViewById(R.id.imgVerif);
        imgVerif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pilihGambar();
            }
        });
    }

    public void pilihGambar(){
//        AlertDialog.Builder builder = new AlertDialog.Builder(VerifPembayaranActivity.this);
//        LayoutInflater inflater = getLayoutInflater();
//        View DialogView = inflater.inflate( alert_dialog_verif, null);
        Toast.makeText(this, "Memasukkan Gambar Bukti Pembayaran", Toast.LENGTH_SHORT).show();
    };

    public void btnSelesaiVerif(View view) {
        Intent intent = new Intent(this, SelesaiPembayaranActivity.class);
        startActivity(intent);
    }
}