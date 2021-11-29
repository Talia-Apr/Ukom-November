package com.taliaapr.wedone;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("/api/menu")
    Call<GetDataBaju> getDataBaju();

    @GET("/api/order")
    Call<GetHistory> getHistory();

    @POST("/api/register")
    Call<GetDaftar> daftarUser(@Body Daftar daftar);

    @POST("/api/login")
    Call<GetLogin> loginUser(@Body Login login);


//    @FormUrlEncoded
//    @POST("kontak")
//    Call<PostPutDelKontak> postKontak(@Field("nama") String nama,
//                                      @Field("nomor") String nomor);
//    @FormUrlEncoded
//    @PUT("kontak")
//    Call<PostPutDelKontak> putKontak(@Field("id") String id,
//                                     @Field("nama") String nama,
//                                     @Field("nomor") String nomor);
//    @FormUrlEncoded
//    @HTTP(method = "DELETE", path = "kontak", hasBody = true)
//    Call<PostPutDelKontak> deleteKontak(@Field("id") String id);
}
