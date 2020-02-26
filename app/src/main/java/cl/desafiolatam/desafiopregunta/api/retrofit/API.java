package cl.desafiolatam.desafiopregunta.api.retrofit;

import java.util.List;

import cl.desafiolatam.desafiopregunta.api.model.QuestionsResults;
import retrofit2.Call;
import retrofit2.http.GET;

public interface API {
    @GET("api.php?amount=1&category=18&difficulty=medium&type=boolean")
    Call<List<QuestionsResults>> listRepos();
}
