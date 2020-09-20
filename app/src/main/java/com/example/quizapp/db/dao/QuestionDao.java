package com.example.quizapp.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.quizapp.db.model.Question;

import java.util.List;

@Dao
public interface QuestionDao {

    @Insert
    Long insertQuestion(Question question);


    @Query("SELECT * FROM Question")
    LiveData<List<Question>> fetchAllQuestions();


//    @Query("SELECT * FROM Question WHERE id =:taskId")
//    LiveData<Question> getTask(int taskId);


    @Update
    void updateTQuestion(Question question);


    @Delete
    void deleteQuestion(Question question);

}
