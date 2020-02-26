package cl.desafiolatam.desafiopregunta.api.model;

public class Questions {
    private int response_code;
    private QuestionsResults[] results;


    public int getResponse_code() {
        return this.response_code;
    }

    public void setResponse_code(int response_code) {
        this.response_code = response_code;
    }

    public QuestionsResults[] getResults() {
        return this.results;
    }

    public void setResults(QuestionsResults[] results) {
        this.results = results;
    }
}
