package cl.desafiolatam.desafiopregunta.api.retrofit;

import java.net.URL;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit = null;
    private static final String URL = "https://opentdb.com";
    public static Retrofit getInstance(){
            if (retrofit == null){
                retrofit = new retrofit2.Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();
            }
        return retrofit;
    }
}
