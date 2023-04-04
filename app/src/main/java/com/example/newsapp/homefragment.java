package com.example.newsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.helper.widget.Carousel;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class homefragment extends Fragment {

    String api = "5ecf88e5e00040a08ce628c22be5dd8d";
    ArrayList<model_class> modelClassArrayList;
    RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewOfHome;
    String country = "in";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.homefragment,null);
        recyclerViewOfHome = view.findViewById(R.id.recylerviewofhome);
        modelClassArrayList = new ArrayList<>();
        recyclerViewOfHome.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new recyclerView_adapter(getContext(),modelClassArrayList);
        recyclerViewOfHome.setAdapter(adapter);

        findNews();

        return view;
    }

    private void findNews() {
        apiUtilities.getApiInterface().getNews(country,100,api).enqueue(new Callback<main_news>() {
            @Override
            public void onResponse(Call<main_news> call, Response<main_news> response) {
                if(response.isSuccessful()){
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<main_news> call, Throwable t) {

            }
        });
    }
}
