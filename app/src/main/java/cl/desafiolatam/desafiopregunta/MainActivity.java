package cl.desafiolatam.desafiopregunta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import java.util.List;
import cl.desafiolatam.desafiopregunta.api.model.Result;
import cl.desafiolatam.desafiopregunta.api.model.Question;
import cl.desafiolatam.desafiopregunta.api.retrofit.API;
import cl.desafiolatam.desafiopregunta.api.retrofit.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity {

    private static String TAG = "MaingActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiConfig();
    }

    private void apiConfig() {

        Log.d(TAG, "entrando a ApiConfig()");
        // Obtenemos la instancia
        Retrofit instance = RetrofitClient.getInstance();

        // Creamos el servicio
        API apiService = RetrofitClient.getInstance().create(API.class);

        // Creando la llamada
        Call<Result> call = apiService.getQuestions();

        // Encolando la llamada para que se ejecute en el futuro (próximo espero)
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                // En caso de respuesta positiva
                //Log.d(TAG, "procesando respuesta");
                // Obtenemos desde el body la lista de pregunta
               List <Question> questionList = response.body().getResults();
                // imprimir los resultados
                //String question1;
                //question1 = questionList.get(0).getQuestion();
                //Toast.makeText(MainActivity.this, questionList.get(1).getCategory(), Toast.LENGTH_SHORT).show();
                     Log.d("MainActivity","onResponse: " + response.code());
                Log.d("MainActivity","onResponse: " + response.body().getResults().get(0));

                MainFragment mainFragment = new MainFragment(questionList);
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.container, mainFragment).commit();

            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.d(TAG, "procesando falla");
                Log.getStackTraceString(t);
                // En caso de falla
                Toast.makeText(getApplicationContext(), "No se pudo conectar con el servidor", Toast.LENGTH_SHORT).show();

            }
        });
    }
}