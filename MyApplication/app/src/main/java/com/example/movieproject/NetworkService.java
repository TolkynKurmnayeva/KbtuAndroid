package com.example.movieproject;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class NetworkService {
    private static NetworkService mInstance;
    private static final String BASE_URL = "https://api.themoviedb.org";
    private Retrofit mRetrofit;
    private static final String API_KEY="f8f3f8768f44254639d90e0d453c3c2e";

    private NetworkService() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public static NetworkService getInstance() {
        if (mInstance == null) {
            mInstance = new NetworkService();
        }
        return mInstance;
    }

    public MovieDBApi getApi (){
        return mRetrofit.create(MovieDBApi.class);
    }

    public static String getApiKey() {
        return API_KEY;
    }
}
