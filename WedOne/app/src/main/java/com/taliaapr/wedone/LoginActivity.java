package com.taliaapr.wedone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    EditText etEmail, etPassword;
    TextView daftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

        btnLogin = findViewById(R.id.btnLogin);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        daftar = findViewById(R.id.tDaftar);

        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, DaftarActivity.class));
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String etemail = etEmail.getText().toString();
                String etpassword = etPassword.getText().toString();

                if (etemail.isEmpty() || etpassword.isEmpty()){
                    String message = "Semua Kolom Harus Diisi";
                    Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
                }else {
                    Login login = new Login();
                    login.setEmail(etEmail.getText().toString());
                    login.setPassword(etPassword.getText().toString());

                    loginActivity(login);
                }
            }
        });

    }

    public void loginActivity(Login login){
        Call<GetLogin> loginCall = ApiClient.getApi().loginUser(login);
        loginCall.enqueue(new Callback<GetLogin>() {
            @Override
            public void onResponse(Call<GetLogin> call, Response<GetLogin> response) {
                if (response.isSuccessful()){
                    Login login = (Login) response.body().getData();
                    startActivity(new Intent(LoginActivity.this, HomeActivity.class).putExtra("data", login));
                    finish();
                }else {
                    String message = "Tidak Bisa Daftar, Tolong Ulangi";
                    Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<GetLogin> call, Throwable t) {

                String message = t.getLocalizedMessage();
                Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();

            }
        });
    }


}