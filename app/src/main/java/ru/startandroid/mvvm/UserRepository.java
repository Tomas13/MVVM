package ru.startandroid.mvvm;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.facebook.stetho.okhttp3.StethoInterceptor;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserRepository {
    private Webservice webservice;

    OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .addNetworkInterceptor(new StethoInterceptor())
            .build();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build();



    // ...
    public LiveData<User> getUser(String userId) {
        webservice = retrofit.create(Webservice.class);


        // This is not an optimal implementation, we'll fix it below
        final MutableLiveData<User> data = new MutableLiveData<>();
        webservice.getUser(userId).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                // error case is left out for brevity
                data.setValue(response.body());

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });

        return data;
    }
}
