package com.example.quizapp.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.quizapp.db.dao.QuestionDao;
import com.example.quizapp.db.model.Question;

@Database(entities = {Question.class}, version = 2, exportSchema = false)
public abstract class QuestionDatabase extends RoomDatabase {

    public abstract QuestionDao questionDao();

}
