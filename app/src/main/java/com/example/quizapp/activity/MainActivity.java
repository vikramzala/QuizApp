package com.example.quizapp.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.quizapp.R;
import com.example.quizapp.adapter.QuestionListAdapter;
import com.example.quizapp.db.model.Question;
import com.example.quizapp.db.repository.QuestionRepository;
import com.example.quizapp.global.ApiClient;
import com.example.quizapp.global.RestApi;
import com.example.quizapp.model.ResponseData;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private QuestionListAdapter questionListAdapter;
    private Button btnSubmit, btnClear;
    private TextView tvResult;
    private boolean isClear = false;
    List<ResponseData.ResultsBean> data;
    private QuestionRepository questionRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionRepository = new QuestionRepository(getApplicationContext());
        initUI();
        getData();
//        getQuestions();
    }

    private void getQuestions() {
        questionRepository.getTasks().observe(this, new Observer<List<Question>>() {
            @Override
            public void onChanged(@Nullable List<Question> questions) {
                if(questions.size() > 0) {
                    if (questionListAdapter == null) {
                        questionListAdapter = new QuestionListAdapter(MainActivity.this, data, isClear);
                        recyclerView.setAdapter(questionListAdapter);

                    }
                }
            }
        });
    }


    private void initUI() {

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        tvResult = findViewById(R.id.tvResult);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnClear = findViewById(R.id.btnClear);
        btnSubmit.setOnClickListener(this);
        btnClear.setOnClickListener(this);


    }

    private void getData() {
        final ProgressDialog Dialog = new ProgressDialog(MainActivity.this);
        Dialog.setMessage("Please wait..");
        Dialog.show();
        RestApi apiInterface = ApiClient.getRetrofitInstance().create(RestApi.class);

        HashMap<String, String> map = new HashMap();
        map.put("amount", "20");
        map.put("category", "9");
        map.put("difficulty", "easy");
        map.put("type", "multiple");

        Call<ResponseData> call = apiInterface.getQuestionData(map);
        call.enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                Dialog.dismiss();
                ResponseData result;
                Random r = new Random();
                if (response.isSuccessful()) {
                    result = response.body();
                    Log.e("response", "" + result.getResults().size());
                    List<ResponseData.ResultsBean> data = new ArrayList<>();
                    data.addAll(result.getResults());
                    for (ResponseData.ResultsBean datum : data) {

                        List<String> answers = datum.getIncorrect_answers();

                        int pos = r.nextInt(4);
                        answers.add(pos, datum.getCorrect_answer());

                        datum.setIncorrect_answers(answers);

//                        Log.e("DDDDDD Question >> ",datum.getQuestion());
//                        Log.e("DDDDDD Correct Ans >> ",datum.getCorrect_answer());
//                        for (String incorrect_answer : datum.getIncorrect_answers()) {
//                            Log.e("DDDDDD Options >> ",incorrect_answer);
//                        }
                    }

                /*    for (int i = 0; i < data.size(); i++) {
                        ResponseData.ResultsBean resultsBean = new ResponseData.ResultsBean();
//                        for (int j = 0; j < resultsBean.getIncorrect_answers().size(); j++) {

                            Question question = new Question(resultsBean.getQuestion(),resultsBean.getCorrect_answer(), resultsBean.getIncorrect_answers().get(0),resultsBean.getIncorrect_answers().get(1),resultsBean.getIncorrect_answers().get(2), resultsBean.getIncorrect_answers().get(3));
//                        }
                        Log.e("question.. >>",""+resultsBean.getQuestion());
                        questionRepository.insertQuestion(question);
                        Log.e("answer.. >>",""+resultsBean.getCorrect_answer());

                    }*/

                    questionListAdapter = new QuestionListAdapter(MainActivity.this, data, isClear);
                    recyclerView.setAdapter(questionListAdapter);

               /*     for (int i = 0; i < data.size(); i++) {
                        Log.e("DDDDDD Question >> ",data.get(i).getQuestion());
                        Log.e("DDDDDD Correct Ans >> ",data.get(i).getCorrect_answer());
                        for (String incorrect_answer : data.get(i).getIncorrect_answers()) {
                            Log.e("DDDDDD Options >> ",incorrect_answer);
                        }
                    }*/

                }
            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {
                Dialog.dismiss();
//                Toast.makeText(MyCartActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSubmit:
//                int count = 0;
                data = questionListAdapter.getAdapterData();
//                for (int i = 0; i < data.size(); i++) {
//                    if (data.get(i).isCorrect()) {
//                        count++;
//                    }
//                }
//                Log.e("Count",""+count);
//
//                tvResult.setText(""+count);
                Intent intent1 = new Intent(MainActivity.this, ResultActivity.class);
                Gson gson = new Gson();
                String json = gson.toJson(data);
                intent1.putExtra("data",""+json);
                startActivity(intent1);
                break;
            case R.id.btnClear:
//                tvResult.setText("score");
//                isClear = true;
//                questionListAdapter.setAdapterData(data);
//                questionListAdapter = new QuestionListAdapter(MainActivity.this, data, isClear);
//                recyclerView.setAdapter(questionListAdapter);
                break;

        }
    }
}