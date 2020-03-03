package cl.desafiolatam.desafiopregunta;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import cl.desafiolatam.desafiopregunta.api.model.Question;
import cl.desafiolatam.desafiopregunta.api.model.Result;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private String question2;
    private List<Question> resultList;

    public MainFragment(List<Question> resultList) {
        this.resultList = resultList;
    }

    /*public MainFragment newInstance (String question) {
        MainFragment fragment = new MainFragment();
        Bundle arguments = new Bundle();
        arguments.putString("QUESTION",question);
        fragment.setArguments(arguments);
        return fragment;
        // Required empty public constructor
    }*/


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         //question2 = getArguments().getString("QUESTION");
       // Log.d("MainFragment", "onCreateView: onCreateView" + question2);
        return inflater.inflate(R.layout.activity_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView pregunta = view.findViewById(R.id.textView2);
        TextView categoria = view.findViewById(R.id.textView3);
        TextView dificultad = view.findViewById(R.id.textView4);
        pregunta.setText(resultList.get(0).getQuestion());
        categoria.setText(resultList.get(0).getCategory());
        dificultad.setText(resultList.get(0).getDifficulty());
        boolean correcta = resultList.get(0).isCorrect_answer();
        RadioGroup radioGroup = view.findViewById(R.id.radioGroup);
        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numero = radioGroup.getCheckedRadioButtonId();
                Log.d("Fragment", String.valueOf(numero));
                if (numero == R.id.radioButton){
                    Log.d("Fragment", "verdadero");
                    Log.d("Fragment", String.valueOf(correcta));
                    boolean prueba = false;
                    if (prueba == correcta){
                        Toast.makeText(getContext(), "Respuesta Incorrecta", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getContext(), "Respuesta Correcta", Toast.LENGTH_SHORT).show();

                    }
                } else if (numero == R.id.radioButton2){
                    Log.d("Fragment", "falso");
                    boolean prueba = true;
                    if (prueba == correcta){
                        Toast.makeText(getContext(), "Respuesta Incorrecta", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getContext(), "Respuesta Correcta", Toast.LENGTH_SHORT).show();

                    }

                } else {
                    Log.d("Fragment", "No encontrado");
                }

            }
        });

    }
}
