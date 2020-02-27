package cl.desafiolatam.desafiopregunta.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result {
    @SerializedName("response_code")
    private int response_code;

    private List<Question> results;

    public List<Question> getResults() {
        return results;
    }

    public void setResults(List<Question> results) {
        this.results = results;
    }

    public int getResponse_code() {
        return this.response_code;
    }

    public void setResponse_code(int response_code) {
        this.response_code = response_code;
    }


}
