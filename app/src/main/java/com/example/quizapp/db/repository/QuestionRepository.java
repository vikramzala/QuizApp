package com.example.quizapp.db.repository;


import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

import com.example.quizapp.db.QuestionDatabase;
import com.example.quizapp.db.model.Question;

import java.util.List;

public class QuestionRepository {

    private String DB_NAME = "db_question";

    private QuestionDatabase questionDatabase;

    public QuestionRepository(Context context) {
        questionDatabase = Room.databaseBuilder(context, QuestionDatabase.class, DB_NAME).build();
    }

    public void insertQuestionData(String question, String answer, String option1, String option2, String option3, String option4) {

        Question question1 = new Question(question, answer, option1, option2, option3, option4);
        question1.setQuestion(question);
        question1.setAnswer(answer);
        question1.setOption1(option1);
        question1.setOption2(option2);
        question1.setOption3(option3);
        question1.setOption4(option4);

        insertQuestion(question1);

    }


    public void insertQuestion(final Question question) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                questionDatabase.questionDao().insertQuestion(question);
                return null;
            }
        }.execute();
    }

    public void deleteTask(final Question question) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                questionDatabase.questionDao().deleteQuestion(question);
                return null;
            }
        }.execute();
    }

    public LiveData<List<Question>> getTasks() {
        return questionDatabase.questionDao().fetchAllQuestions();
    }
}
