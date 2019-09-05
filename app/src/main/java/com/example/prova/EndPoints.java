package com.example.prova;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EndPoints {

    @GET("droidcafe")
    Call<List<Produto>> getProdutos();
}
