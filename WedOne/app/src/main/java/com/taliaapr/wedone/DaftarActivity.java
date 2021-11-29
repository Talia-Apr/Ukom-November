package com.taliaapr.wedone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationManagerCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.safetynet.SafetyNet;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DaftarActivity extends AppCompatActivity {

    Button btnDaftar;
    EditText etNamaUser, etAlamat, etNomorTelp, etOtp, etEmail, etPassword;
    TextView tMasuk;
    String SITE_KEY = "6LevCWQdAAAAAMcG_eSl-gY4OxtjOCdsFz6nkBl9";
    String SECRET_KEY = "6LevCWQdAAAAANEX_XAJh_q1wovwZWfuoqLs0IVU";
    RequestQueue queue;
    private FirebaseAuth mAuth;
    private String verificationId;
    private Button verifyOTPBtn, generateOTPBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        getSupportActionBar().hide();

        mAuth = FirebaseAuth.getInstance();

        btnDaftar = findViewById(R.id.btnDaftar);
        generateOTPBtn = findViewById(R.id.btnOtp);
        etNamaUser = findViewById(R.id.etNamaUser);
        etNomorTelp = findViewById(R.id.etNomorTelp);
        etOtp = findViewById(R.id.etOtp);
        etAlamat = findViewById(R.id.etAlamat);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        tMasuk = findViewById(R.id.tMasuk);

        queue = Volley.newRequestQueue(getApplicationContext());
        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = etNamaUser.getText().toString();
                String alamat = etAlamat.getText().toString();
                String telp = etNomorTelp.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                if (email.isEmpty() || !email.contains("@gmail.com")) {
                    showError(etEmail, "Email tidak Valid");
                } else if (nama.isEmpty() || alamat.isEmpty() || telp.isEmpty()) {
                    Toast.makeText(DaftarActivity.this, "Data Harus terisi", Toast.LENGTH_SHORT).show();
                } else if (password.isEmpty() || password.length() < 3 || !etPassword.getText().toString().matches("[a-z,A-Z,0-9]*")) {
                    Toast.makeText(DaftarActivity.this, "Kurang dari 8", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(etOtp.getText().toString())) {
                    Toast.makeText(DaftarActivity.this, "Please enter OTP", Toast.LENGTH_SHORT).show();
                } else {
                    verifyGoogleReCAPTCHA();
                    verifyCode(etOtp.getText().toString());
                }
            }
        });

        generateOTPBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etNomorTelp.getText().toString())) {
                    Toast.makeText(DaftarActivity.this, "Please enter a valid phone number.", Toast.LENGTH_SHORT).show();
                } else {
                    String phone = "+62" + etNomorTelp.getText().toString();
                    sendVerificationCode(phone);
                }
            }
        });
    }

    private void verifyGoogleReCAPTCHA() {
        SafetyNet.getClient(this).verifyWithRecaptcha(SITE_KEY)
                .addOnSuccessListener(this, new OnSuccessListener<SafetyNetApi.RecaptchaTokenResponse>() {
                    @Override
                    public void onSuccess(SafetyNetApi.RecaptchaTokenResponse response) {
                        if (!response.getTokenResult().isEmpty()) {
                            handleVerification(response.getTokenResult());
                        }
                    }
                })
                .addOnFailureListener(this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        if (e instanceof ApiException) {
                            ApiException apiException = (ApiException) e;
                            Log.d("TAG", "Error message: " +
                                    CommonStatusCodes.getStatusCodeString(apiException.getStatusCode()));
                        } else {
                            Toast.makeText(DaftarActivity.this, "Error found is : " + e, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    protected void handleVerification(final String responseToken) {
        String url = "https://www.google.com/recaptcha/api/siteverify";
        StringRequest request = new StringRequest(Request.Method.POST, url,
                new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            if (jsonObject.getBoolean("success")) {
                                Daftar daftar = new Daftar();
                                daftar.setNama(etNamaUser.getText().toString());
                                daftar.setAlamat(etAlamat.getText().toString());
                                daftar.setTelp(etNomorTelp.getText().toString());
                                daftar.setEmail(etEmail.getText().toString());
                                daftar.setPassword(etPassword.getText().toString());

                                daftarActivity(daftar);
                                Toast.makeText(DaftarActivity.this, "User verified with reCAPTCHA", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getApplicationContext(), String.valueOf(jsonObject.getString("error-codes")), Toast.LENGTH_LONG).show();
                            }
                        } catch (Exception ex) {
                            Log.d("TAG", "JSON exception: " + ex.getMessage());
                        }
                    }
                },
                new com.android.volley.Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("TAG", "Error message: " + error.getMessage());
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("secret", SECRET_KEY);
                params.put("response", responseToken);
                return params;
            }
        };
        request.setRetryPolicy(new DefaultRetryPolicy(50000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(request);
    }

    public void tMasuk(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

//    public void btnDaftar(View view) {
//        String nama = etNamaUser.getText().toString();
//        String alamat = etAlamat.getText().toString();
//        String telp = etNomorTelp.getText().toString();
//        String email = etEmail.getText().toString();
//        String password = etPassword.getText().toString();
//
//        if(email.isEmpty()||!email.contains("@gmail.com")){
//            showError(etEmail,"Email tidak Valid");
//        }else if(nama.isEmpty() || alamat.isEmpty() || telp.isEmpty()){
//            Toast.makeText(this, "Data Harus terisi", Toast.LENGTH_SHORT).show();
//        } else if (password.isEmpty()||password.length()<8){
//            Toast.makeText(this, "Kurang dari 8", Toast.LENGTH_SHORT).show();
//        }else {
//            Daftar daftar = new Daftar();
//            daftar.setNama(etNamaUser.getText().toString());
//            daftar.setAlamat(etAlamat.getText().toString());
//            daftar.setTelp(etNomorTelp.getText().toString());
//            daftar.setEmail(etEmail.getText().toString());
//            daftar.setPassword(etPassword.getText().toString());
////            cekData();
//
//            daftarActivity(daftar);
//        }

//        Intent intent = new Intent(this, HomeActivity.class);
//        startActivity(intent);
//        finish();

//
//    private void cekData() {
//        String email = etEmail.getText().toString();
//
//        if(email.isEmpty()||!email.contains("@gmail.com")){
//            showError(etEmail,"Email tidak Valid");
//        }else{
//            startActivity(new Intent(DaftarActivity.this, LoginActivity.class));
//        }
//    }

    private void showError(EditText input, String a) {
        input.setError(a);
        input.requestFocus();
    }


    public void daftarActivity(Daftar daftar){
        Call<GetDaftar> daftarCall = ApiClient.getApi().daftarUser(daftar);
        daftarCall.enqueue(new Callback<GetDaftar>() {
            @Override
            public void onResponse(Call<GetDaftar> call, Response<GetDaftar> response) {
                if (response.isSuccessful()){
                    String message = "Daftar Berhasil";
                    Toast.makeText(DaftarActivity.this, message, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(DaftarActivity.this, LoginActivity.class));
                    finish();
                }else {
                    String message = "Tidak Bisa Daftar, Tolong Ulangi";
                    Toast.makeText(DaftarActivity.this, message, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<GetDaftar> call, Throwable t) {
                String message = t.getLocalizedMessage();
               Toast.makeText(DaftarActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void signInWithCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent i = new Intent(DaftarActivity.this, LoginActivity.class);
                            startActivity(i);
                            finish();
                        } else {
                            Toast.makeText(DaftarActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }


    private void sendVerificationCode(String number) {
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber(number)
                        .setTimeout(60L, TimeUnit.DAYS.SECONDS)
                        .setActivity(this)
                        .setCallbacks(mCallBack)
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks
            mCallBack = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            verificationId = s;
        }

        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
            final String code = phoneAuthCredential.getSmsCode();

            if (code != null) {
                etOtp.setText(code);
                verifyCode(code);
            }
        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            Toast.makeText(DaftarActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    };

    private void verifyCode(String code) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);

        signInWithCredential(credential);
    }

}