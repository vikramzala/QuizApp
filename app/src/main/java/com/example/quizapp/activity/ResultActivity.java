package com.example.quizapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.quizapp.R;
import com.example.quizapp.model.ResponseData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class ResultActivity extends AppCompatActivity {

    private TextView tvTotalQue, tvAttemptedQue, tvNotAttemptedQue, tvRightAns, tvWrongAns, tvProgress;
    List<ResponseData.ResultsBean> arrayList;
    int count = 0;
    int wrong = 0;
    int notAttempt = 0;
    int attempt = 0;
    private Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        Gson gson = new Gson();
        String strJson = intent.getStringExtra("data");
        Type type = new TypeToken<List<ResponseData.ResultsBean>>() {
        }.getType();
        arrayList = gson.fromJson(strJson, type);

        Log.e("list", "" + arrayList.size());
        initUI();
    }

    private void initUI() {
        tvTotalQue = findViewById(R.id.tvTotalQue);
        tvAttemptedQue = findViewById(R.id.tvAttemptedQue);
        tvNotAttemptedQue = findViewById(R.id.tvNotAttemptedQue);
        tvRightAns = findViewById(R.id.tvRightAns);
        tvWrongAns = findViewById(R.id.tvWrongAns);
        tvProgress = findViewById(R.id.tvProgress);
        btnOk = findViewById(R.id.btnOk);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

//        for (int i = 0; i < data.size(); i++) {
//                    if (data.get(i).isCorrect()) {
//                        count++;
//                    }
//                }
//                Log.e("Count",""+count);
//
//                tvResult.setText(""+count);

        tvTotalQue.setText("" + arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).isCorrect()) {
                count++;
            }

            if (arrayList.get(i).getNotAttempt().contains("0")) {
                notAttempt++;
            }
            if (arrayList.get(i).getNotAttempt().contains("1")) {
                attempt++;
            }

            if (arrayList.get(i).getNotAttempt().contains("1") && (!arrayList.get(i).isCorrect())) {
                wrong++;
            }

        }
        tvRightAns.setText("" + count);
        tvNotAttemptedQue.setText("" + notAttempt);
        tvWrongAns.setText("" + wrong);
        tvAttemptedQue.setText(""+attempt);
    }
}