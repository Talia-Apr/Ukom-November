package com.taliaapr.wedone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    Button btnAdat;
    Button btnModern;
    ApiInterface apiInterface;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter bajuAdapter;
    private RecyclerView.LayoutManager layoutManager;
    public static HomeActivity ma;
    Login getLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        // Action Bar
        getSupportActionBar().hide();

        Intent intent = getIntent();
        if (intent.getExtras() != null){

            getLogin =  (Login) intent.getSerializableExtra("data");
            Log.e("TAG", "===>" + getLogin.getEmail());

        }

        // Button Kategori
        btnAdat = (Button) findViewById(R.id.btnAdat);
        btnAdat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer idKategori = 1;
                Intent intent = new Intent(v.getContext(), AdatActivity.class);
                intent.putExtra("idKategori", idKategori);
                startActivity(intent);
            }
        });

        btnModern = (Button) findViewById(R.id.btnModern);
        btnModern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Integer idKategori = 2;
                    Intent intent = new Intent(v.getContext(), AdatActivity.class);
                    intent.putExtra("idKategori", idKategori);
                    startActivity(intent);
            }
        });

        // Recycler View
        recyclerView = (RecyclerView) findViewById(R.id.rvHome);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        ma=this;

//        DataBaju[] dataBaju = new DataBaju[]{
//                new DataBaju("Baju Adat Jawa", "Rp.1.000.000", R.drawable.adatjawa),
//                new DataBaju("Baju Adat Jambi", "Rp.750.000", R.drawable.adatjambi),
//                new DataBaju("Baju Adat Riau", "Rp.800.000", R.drawable.adatriau),
//                new DataBaju("Baju Adat Betawi", "Rp.500.000", R.drawable.adatbetawi),
//                new DataBaju("Baju Modern Blue Dress", "Rp.1.300.000", R.drawable.moderndressblue),
//                new DataBaju("Baju Modern Simple White", "Rp.800.000", R.drawable.modernsimple),
//                new DataBaju("Baju Modern Gold Dress", "Rp.1.500.000", R.drawable.moderndressgold),
//                new DataBaju("Baju Modern Long Dress", "Rp.2.350.000", R.drawable.modernlongdress),
//        };
//
//        BajuAdapter bajuAdapter = new BajuAdapter(dataBaju, HomeActivity.this);
//        recyclerView.setAdapter(bajuAdapter);

        // Botton Navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.btmNav);
        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        return true;

                    case R.id.history:
                        if(intent.getExtras()==null){
                            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                            overridePendingTransition(0,0);
                        } else {
                            startActivity(new Intent(getApplicationContext(), HistoryActivity.class));
                        }
                        return true;

                    case R.id.akun:
                        if(intent.getExtras()==null){
                            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                            overridePendingTransition(0,0);
                        }else{
                            startActivity(new Intent(getApplicationContext(), AkunActivity.class));
                        }
                        return true;
                }
                return false;
            }
        });

        Intent mintent = new Intent();
        mintent.putExtra("data", intent.getExtras());

        // Function
        getDataBajuHome();

    }


    public void getDataBajuHome() {
        Call<GetDataBaju> dataBajuCall = apiInterface.getDataBaju();
        dataBajuCall.enqueue(new Callback<GetDataBaju>() {
            @Override
            public void onResponse(Call<GetDataBaju> call, Response<GetDataBaju>
                    response) {
                List<DataBaju> dataBajuList = response.body().getData();
                Log.d("Retrofit Get", "Jumlah data Kontak: " +
                        String.valueOf(dataBajuList.size()));
                bajuAdapter = new BajuAdapter(dataBajuList);
                recyclerView.setAdapter(bajuAdapter);
            }

            @Override
            public void onFailure(Call<GetDataBaju> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }

//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main_menu, menu);
//        searchView = (androidx.appcompat.widget.SearchView) menu.findItem(R.id.search).getActionView();
//        searchView.setOnQueryTextListener(new androidx.appcompat.widget.SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                if (newText.length()>1){
//                    ApiInterface apiInterface = APIClient.getClient().create(ApiInterface.class);
//                    Call<Response> call = apiInterface.getQuery(API_KEY, LANGUAGE, newText, PAGE);
//                    call.enqueue(new Callback<Response>() {
//                        @Override
//                        public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
//                            List<Result> mList = response.body().getResults();
//                            adapter = new MovieAdapter(MainActivity.this, mList);
//                            recyclerView.setAdapter(adapter);
//                        }
//
//                        @Override
//                        public void onFailure(Call<Response> call, Throwable t) {
//
//                        }
//                    });
//                }
//                return true;
//            }
//        });
//        return super.onCreateOptionsMenu(menu);
//    }
}