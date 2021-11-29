package com.taliaapr.wedone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistoryActivity extends AppCompatActivity {

    Button btnDataSewa;
    ApiInterface apiInterface;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter historyAdapter;
    private RecyclerView.LayoutManager layoutManager;
    public static HistoryActivity ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        recyclerView = (RecyclerView) findViewById(R.id.rvHistory);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        ma=this;

//        History[] history = new History[]{
//                new History("Moon Wedding","Perum.Mentari Bumi Sejahtera Kalipecabean - Sidoarjo, Jawa Timur",
//                        "Baju Pernikahan Adat Jawa", "07-11-2021",
//                        "10-11-2021", "Rp. 1.000.000")
//        };
//
//        HistoryAdapter historyAdapter = new HistoryAdapter(history, HistoryActivity.this);
//        recyclerView.setAdapter(historyAdapter);

        BottomNavigationView bottomNavigationView = findViewById(R.id.btmNav);
        bottomNavigationView.setSelectedItemId(R.id.history);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.history:
                        return true;

                    case R.id.akun:
                        startActivity(new Intent(getApplicationContext(), AkunActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
        getDataHistory();
    }

    public void getDataHistory() {
        Call<GetHistory> historyCall = apiInterface.getHistory();
        historyCall.enqueue(new Callback<GetHistory>() {
            @Override
            public void onResponse(Call<GetHistory> call, Response<GetHistory>
                    response) {
                List<History> historyList = response.body().getData();
                Log.d("Retrofit Get", "Jumlah data Kontak: " +
                        String.valueOf(historyList.size()));
                historyAdapter = new HistoryAdapter(historyList);
                recyclerView.setAdapter(historyAdapter);
            }

            @Override
            public void onFailure(Call<GetHistory> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}