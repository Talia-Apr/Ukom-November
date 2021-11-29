package com.taliaapr.wedone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModernActivity extends AppCompatActivity {

    ApiInterface apiInterface;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter bajuModernAdapter;
    private RecyclerView.LayoutManager layoutManager;
    public static ModernActivity ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modern);

        RecyclerView recyclerView = findViewById(R.id.rvModern);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        DataBajuModern[] dataBajuModern = new DataBajuModern[]{
//                new DataBajuModern("Baju Modern Blue Dress", "Rp.1.300.000", R.drawable.moderndressblue),
//                new DataBajuModern("Baju Modern Long Dress", "Rp.2.350.000", R.drawable.modernlongdress),
//        };
//
//        BajuModernAdapter bajuModernAdapter = new BajuModernAdapter(dataBajuModern, ModernActivity.this);
//        recyclerView.setAdapter(bajuModernAdapter);

        //Function
        getDataBajuModern();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_search_actionbar, menu);
        MenuItem menuItem = menu.findItem(R.id.search_actionbar);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("cari baju modern disini...");
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

    public void getDataBajuModern() {
        Call<GetDataBaju> dataBajuCall = apiInterface.getDataBaju();
        dataBajuCall.enqueue(new Callback<GetDataBaju>() {
            @Override
            public void onResponse(Call<GetDataBaju> call, Response<GetDataBaju>
                    response) {
                List<DataBaju> dataBajuList = response.body().getData();
                Log.d("Retrofit Get", "Jumlah data Kontak: " +
                        String.valueOf(dataBajuList.size()));
                bajuModernAdapter = new BajuModernAdapter(dataBajuList);
                recyclerView.setAdapter(bajuModernAdapter);
            }

            @Override
            public void onFailure(Call<GetDataBaju> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}