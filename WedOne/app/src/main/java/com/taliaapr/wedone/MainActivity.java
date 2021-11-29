package com.taliaapr.wedone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Login login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        Runnable r = new Runnable() {
            @Override
            public void run() {
                loginActivity(login);
                startActivity(new Intent(MainActivity.this, HomeActivity.class));
                finish();
            }
        };

        Handler h = new Handler();
        h.postDelayed(r,3000);
    }

    public void loginActivity(Login login){
        Call<GetLogin> loginCall = ApiClient.getApi().loginUser(login);
        loginCall.enqueue(new Callback<GetLogin>() {
            @Override
            public void onResponse(Call<GetLogin> call, Response<GetLogin> response) {
                if (response.isSuccessful()){
                    Login login = (Login) response.body().getData();
                    startActivity(new Intent(MainActivity.this, HomeActivity.class).putExtra("data", login));
                    finish();
                }else {
                    String message = "Tidak Bisa Daftar, Tolong Ulangi";
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<GetLogin> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();

            }
        });
    }
}