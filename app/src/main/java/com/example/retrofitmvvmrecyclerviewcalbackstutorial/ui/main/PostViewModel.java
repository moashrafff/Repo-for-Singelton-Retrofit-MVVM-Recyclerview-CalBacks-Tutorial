package com.example.retrofitmvvmrecyclerviewcalbackstutorial.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.retrofitmvvmrecyclerviewcalbackstutorial.data.PostClient;
import com.example.retrofitmvvmrecyclerviewcalbackstutorial.pojo.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostViewModel extends ViewModel {

    MutableLiveData<List<PostModel>> posts = new MutableLiveData<>();

    public void getPosts(){
    PostClient.getINSTANCE().getPosts().enqueue(new Callback<List<PostModel>>() {
        @Override
        public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
            posts.setValue(response.body());
        }

        @Override
        public void onFailure(Call<List<PostModel>> call, Throwable t) {

        }
    });
    }

}
