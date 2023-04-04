package com.example.newsapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class entertainmentfragment extends Fragment {
    String api = "5ecf88e5e00040a08ce628c22be5dd8d";
    ArrayList<model_class> modelClassArrayList;
    RecyclerView.Adapter adapter;
    String country = "in";
    private RecyclerView recyclerViewofentertainment;
    private String category = "entertainment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.entertainmentfragment,null);

        recyclerViewofentertainment = view.findViewById(R.id.recylerviewofentertainment);
        modelClassArrayList = new ArrayList<>();
        recyclerViewofentertainment.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new recyclerView_adapter(getContext(),modelClassArrayList);
        recyclerViewofentertainment.setAdapter(adapter);

        findNews();

        return view;
    }

    private void findNews() {
        apiUtilities.getApiInterface().getCategoryNews(country,category,100,api).enqueue(new Callback<main_news>() {
            @Override
            public void onResponse(Call<main_news> call, Response<main_news> response) {
                if(response.isSuccessful()){
                    modelClassArrayList.addAll(response.body().getArticles());
                    Log.e("response ",""+modelClassArrayList.get(0).getUrlTOImage());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<main_news> call, Throwable t) {

            }
        });
    }
}
