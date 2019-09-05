package com.example.prova;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView campo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        campo = findViewById(R.id.produto);
        getProdutos();
    }

    private void getProdutos() {
        RetrofitService.getService().getProdutos().enqueue(new Callback<List<Produto>>() {
            @Override
            public void onResponse(Call<List<Produto>> call, Response<List<Produto>> response) {
                List<Produto> produtos = response.body();
                for (Produto produto: produtos) {
                    campo.append("\n"+produto.getDescricao() + "\nR$" + produto.getValor()+"\n\n");
                }
            }
            @Override
            public void onFailure (Call < List < Produto >> call, Throwable t){

            }
        });
    }
}
