package com.taliaapr.wedone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdatActivity extends AppCompatActivity {

    ApiInterface apiInterface;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter bajuAdatAdapter;
    private RecyclerView.LayoutManager layoutManager;
    public static AdatActivity ma;

    ImageView imgAkunToko;
    TextView tvNamaToko, tvAlamatToko;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adat);

        recyclerView = (RecyclerView) findViewById(R.id.rvAdat);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);

//        imgAkunToko = findViewById(R.id.imgAkunToko);
//        tvNamaToko = findViewById(R.id.tvNamaToko);
//        tvAlamatToko = findViewById(R.id.tvAlamatToko);
//
//        Glide.with(AdatActivity.this)
//                .load(""+getIntent().getStringExtra("fotoToko"))
//                .apply(new RequestOptions().override(350,550))
//                .into(imgAkunToko);
//        tvNamaToko.setText(getIntent().getExtras().getString("namaToko"));
//        tvAlamatToko.setText(getIntent().getExtras().getString("alamatToko"));

//        DataBajuAdat[] dataBajuAdat = new DataBajuAdat[]{
//                new DataBajuAdat("Baju Adat Jawa", "Rp.1.000.000", R.drawable.adatjawa),
//                new DataBajuAdat("Baju Adat Jambi", "Rp.750.000", R.drawable.adatjambi),
//        };
//
//        BajuAdatAdapter bajuAdatAdapter = new BajuAdatAdapter(dataBajuAdat, AdatActivity.this);
//        recyclerView.setAdapter(bajuAdatAdapter);

        int value = getIntent().getIntExtra("IdKategori",0);

        if(value == 1){
            getSupportActionBar().setTitle("Adat");
        } else if (value == 2){
            getSupportActionBar().setTitle("Modern");
        }

        //Function
        getDataBajuAdat();
        run();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search_actionbar, menu);
        MenuItem menuItem = menu.findItem(R.id.search_actionbar);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("cari baju adat disini...");
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
        intent.putExtra("idKategori", mIntent.getIntExtra("idKategori", 0));
    }

    public void getDataBajuAdat() {
        Call<GetDataBaju> dataBajuCall = apiInterface.getDataBaju();
        dataBajuCall.enqueue(new Callback<GetDataBaju>() {
            @Override
            public void onResponse(Call<GetDataBaju> call, Response<GetDataBaju>
                    response) {
                List<DataBaju> dataBajuList = response.body().getData();
                Log.d("Retrofit Get", "Jumlah data Kontak: " +
                        String.valueOf(dataBajuList.size()));
                bajuAdatAdapter = new BajuAdatAdapter(dataBajuList);
                recyclerView.setAdapter(bajuAdatAdapter);
            }

            @Override
            public void onFailure(Call<GetDataBaju> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}