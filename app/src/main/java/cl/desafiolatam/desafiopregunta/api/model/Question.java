package cl.desafiolatam.desafiopregunta.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class Question {
    private String category;
    private String type;
    private String difficulty;
    private String question;
    @SerializedName("correct_answer")
    private boolean correct_answer;
    @SerializedName("incorrect_answer")
    private boolean[] incorrect_answers;

    @Override
    public String toString() {
        return "Question{" +
                "category='" + category + '\'' +
                ", type='" + type + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", question='" + question + '\'' +
                ", correct_answer=" + correct_answer +
                ", incorrect_answers=" + Arrays.toString(incorrect_answers) +
                '}';
    }

    public String getDifficulty() {
        return this.difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getQuestion() {
        return this.question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public boolean isCorrect_answer() {
        return correct_answer;
    }

    public boolean[] getIncorrect_answers() {
        return incorrect_answers;
    }

    public void setIncorrect_answers(boolean[] incorrect_answers) {
        this.incorrect_answers = incorrect_answers;
    }

    public void setCorrect_answer(boolean correct_answer) {
        this.correct_answer = correct_answer;
    }
}
