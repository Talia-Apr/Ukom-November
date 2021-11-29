package com.taliaapr.wedone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class TambahProdukActivity extends AppCompatActivity {

    ImageView imgTambahProduk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_produk);

        imgTambahProduk = findViewById(R.id.imgTambahProduk);
        imgTambahProduk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pilihGambarProduk();
            }
        });
    }

    public void pilihGambarProduk(){
//        AlertDialog.Builder builder = new AlertDialog.Builder(VerifPembayaranActivity.this);
//        LayoutInflater inflater = getLayoutInflater();
//        View DialogView = inflater.inflate( alert_dialog_verif, null);
        Toast.makeText(this, "Memasukkan Gambar Baju", Toast.LENGTH_SHORT).show();
    };

    public void btnSimpanProduk(View view) {
        Intent intent = new Intent(this, ProdukSayaActivity.class);
        startActivity(intent);
    }
}