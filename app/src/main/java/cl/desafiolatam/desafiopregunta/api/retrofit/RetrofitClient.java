package cl.desafiolatam.desafiopregunta.api.retrofit;

import java.net.URL;

import retrofit2.Retrofit;

public class RetrofitClient {

    private static Retrofit retrofit;
    public static Retrofit getInstance(){
            if (retrofit == null){
                retrofit = new Retrofit().Builder()
                        .baseUrl(URL)
                        .build();
            }
            return retrofit;
    }
}
