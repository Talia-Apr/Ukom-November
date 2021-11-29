package com.taliaapr.wedone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TokoActivity extends AppCompatActivity {

    ApiInterface apiInterface;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter bajuTokoAdapter;
    private RecyclerView.LayoutManager layoutManager;
    public static TokoActivity ma;
    ImageView imgAkunToko;
    TextView tvNamaToko, tvAlamatToko;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toko);

        recyclerView = (RecyclerView) findViewById(R.id.rvToko);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        ma=this;

        imgAkunToko = findViewById(R.id.imgAkunToko);
        tvNamaToko = findViewById(R.id.tvNamaToko);
        tvAlamatToko = findViewById(R.id.tvAlamatToko);


        Glide.with(TokoActivity.this)
                .load(""+getIntent().getStringExtra("fotoToko"))
                .apply(new RequestOptions().override(350,550))
                .into(imgAkunToko);
        tvNamaToko.setText(getIntent().getExtras().getString("namaToko"));
        tvAlamatToko.setText(getIntent().getExtras().getString("alamatToko"));

//        DataBajuToko[] dataBajuToko = new DataBajuToko[]{
//                new DataBajuToko("Baju Adat Jawa", "Rp.1.000.000", R.drawable.adatjawa),
//                new DataBajuToko("Baju Adat Jambi", "Rp.750.000", R.drawable.adatjambi),
//                new DataBajuToko("Baju Modern Blue Dress", "Rp.1.300.000", R.drawable.moderndressblue),
//                new DataBajuToko("Baju Modern Long Dress", "Rp.2.350.000", R.drawable.modernlongdress),
//        };
//
//        BajuTokoAdapter bajuTokoAdapter = new BajuTokoAdapter(dataBajuToko, TokoActivity.this);
//        recyclerView.setAdapter(bajuTokoAdapter);

        //Function
        run();
        getDataBajuToko();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_search_actionbar, menu);
        MenuItem menuItem = menu.findItem(R.id.search_actionbar);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("cari baju ditoko ini...");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    public void run(){
        ma=this;
        Intent mIntent = getIntent();
        Intent intent = new Intent();
        intent.putExtra("idToko", mIntent.getIntExtra("idToko", 0));
    }

        public void getDataBajuToko() {
            Call<GetDataBaju> dataBajuCall = apiInterface.getDataBaju();
            dataBajuCall.enqueue(new Callback<GetDataBaju>() {
                @Override
                public void onResponse(Call<GetDataBaju> call, Response<GetDataBaju>
                        response) {
                    List<DataBaju> dataBajuList = response.body().getData();
                    Log.d("Retrofit Get", "Jumlah data Kontak: " +
                            String.valueOf(dataBajuList.size()));
                    bajuTokoAdapter = new BajuTokoAdapter(dataBajuList);
                    recyclerView.setAdapter(bajuTokoAdapter);
                }

                @Override
                public void onFailure(Call<GetDataBaju> call, Throwable t) {
                    Log.e("Retrofit Get", t.toString());
                }
            });
        }
}