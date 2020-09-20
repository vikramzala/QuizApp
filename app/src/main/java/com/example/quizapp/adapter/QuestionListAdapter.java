package com.example.quizapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.quizapp.R;
import com.example.quizapp.activity.MainActivity;
import com.example.quizapp.model.ResponseData;

import java.util.List;

public class QuestionListAdapter extends RecyclerView.Adapter<QuestionListAdapter.ViewHolder> {

    private View view;
    private ViewHolder viewHolder;
    private Context context;
    private List<ResponseData.ResultsBean> data;
    private boolean isClear;

    public QuestionListAdapter(Context context, List<ResponseData.ResultsBean> data, boolean isClear) {
        this.context = context;
        this.data = data;
        this.isClear = isClear;
    }

    @Override
    public QuestionListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.style_item_data, parent, false);
        viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final QuestionListAdapter.ViewHolder holder, final int position) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            holder.tvQuestion.setText((position + 1) + ". " + Html.fromHtml(data.get(position).getQuestion(),Html.FROM_HTML_MODE_COMPACT));
            holder.tvOption1.setText("(1) " + Html.fromHtml(data.get(position).getIncorrect_answers().get(0), Html.FROM_HTML_MODE_COMPACT));
            holder.tvOption2.setText("(2) " + Html.fromHtml(data.get(position).getIncorrect_answers().get(1), Html.FROM_HTML_MODE_COMPACT));
            holder.tvOption3.setText("(3) " + Html.fromHtml(data.get(position).getIncorrect_answers().get(2), Html.FROM_HTML_MODE_COMPACT));
            holder.tvOption4.setText("(4) " + Html.fromHtml(data.get(position).getIncorrect_answers().get(3), Html.FROM_HTML_MODE_COMPACT));
        } else {
            holder.tvQuestion.setText((position + 1) + ". " + Html.fromHtml(data.get(position).getQuestion()));
            holder.tvOption1.setText("(1) " + Html.fromHtml(data.get(position).getIncorrect_answers().get(0)));
            holder.tvOption2.setText("(2) " + Html.fromHtml(data.get(position).getIncorrect_answers().get(1)));
            holder.tvOption3.setText("(3) " + Html.fromHtml(data.get(position).getIncorrect_answers().get(2)));
            holder.tvOption4.setText("(4) " + Html.fromHtml(data.get(position).getIncorrect_answers().get(3)));
        }
        if (isClear) {
            holder.tvOption2.setBackgroundColor(context.getResources().getColor(R.color.colorWhite));
            holder.tvOption3.setBackgroundColor(context.getResources().getColor(R.color.colorWhite));
            holder.tvOption1.setBackgroundColor(context.getResources().getColor(R.color.colorWhite));
            holder.tvOption4.setBackgroundColor(context.getResources().getColor(R.color.colorWhite));
            isClear = false;
        }
        holder.tvOption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("option 1 << ", "" + holder.tvOption1.getText().toString() + "==" + data.get(position).getCorrect_answer());

                holder.tvOption1.setBackgroundColor(context.getResources().getColor(R.color.colorGrey));
                holder.tvOption2.setBackgroundColor(context.getResources().getColor(R.color.colorWhite));
                holder.tvOption3.setBackgroundColor(context.getResources().getColor(R.color.colorWhite));
                holder.tvOption4.setBackgroundColor(context.getResources().getColor(R.color.colorWhite));
                if (holder.tvOption1.getText().toString().contains(data.get(position).getCorrect_answer())) {
                    data.get(position).setCorrect(true);
                    data.get(position).setNotAttempt("1");
                    Log.e("Ans 1 <<", "" + data.get(position).getCorrect_answer());
                }else {
                    data.get(position).setCorrect(false);
                    data.get(position).setNotAttempt("0");
                }
//                }
            }
        });
        holder.tvOption2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("option 2 << ", "" + holder.tvOption2.getText().toString() + "==" + data.get(position).getCorrect_answer());

                holder.tvOption2.setBackgroundColor(context.getResources().getColor(R.color.colorGrey));
                holder.tvOption1.setBackgroundColor(context.getResources().getColor(R.color.colorWhite));
                holder.tvOption3.setBackgroundColor(context.getResources().getColor(R.color.colorWhite));
                holder.tvOption4.setBackgroundColor(context.getResources().getColor(R.color.colorWhite));
                if (holder.tvOption2.getText().toString().contains(data.get(position).getCorrect_answer())) {
                    data.get(position).setCorrect(true);
                    data.get(position).setNotAttempt("1");
                    Log.e("Ans 2 <<", "" + data.get(position).getCorrect_answer());
                }else {
                    data.get(position).setCorrect(false);
                    data.get(position).setNotAttempt("0");
                }
//                }
            }
        });
        holder.tvOption3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("option 3 << ", "" + holder.tvOption3.getText().toString() + "==" + data.get(position).getCorrect_answer());

                holder.tvOption3.setBackgroundColor(context.getResources().getColor(R.color.colorGrey));
                holder.tvOption2.setBackgroundColor(context.getResources().getColor(R.color.colorWhite));
                holder.tvOption1.setBackgroundColor(context.getResources().getColor(R.color.colorWhite));
                holder.tvOption4.setBackgroundColor(context.getResources().getColor(R.color.colorWhite));
                if (holder.tvOption3.getText().toString().contains(data.get(position).getCorrect_answer())) {
                    data.get(position).setCorrect(true);
                    data.get(position).setNotAttempt("1");
                    Log.e("Ans 3 <<", "" + data.get(position).getCorrect_answer());
                }else {
                    data.get(position).setCorrect(false);
                    data.get(position).setNotAttempt("0");
                }
//                }
            }
        });
        holder.tvOption4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("option 4 << ", "" + holder.tvOption4.getText().toString() + "==" + data.get(position).getCorrect_answer());

                holder.tvOption4.setBackgroundColor(context.getResources().getColor(R.color.colorGrey));
                holder.tvOption2.setBackgroundColor(context.getResources().getColor(R.color.colorWhite));
                holder.tvOption3.setBackgroundColor(context.getResources().getColor(R.color.colorWhite));
                holder.tvOption1.setBackgroundColor(context.getResources().getColor(R.color.colorWhite));
                if (holder.tvOption4.getText().toString().contains(data.get(position).getCorrect_answer())) {
                    data.get(position).setCorrect(true);
                    data.get(position).setNotAttempt("1");
                    Log.e("Ans 4 <<", "" + data.get(position).getCorrect_answer());
                }else {
                    data.get(position).setCorrect(false);
                    data.get(position).setNotAttempt("0");
                }

//                }
            }
        });
    }

    public List<ResponseData.ResultsBean> getAdapterData() {
        return data;
    }

    public void setAdapterData(List<ResponseData.ResultsBean> mData) {
        data = mData;
        notifyDataSetChanged();

    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        if (data != null && data.size() > 0)
            return data.size();
        else
            return 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvQuestion;
        private TextView tvOption1, tvOption2, tvOption3, tvOption4;

        public ViewHolder(View itemView) {
            super(itemView);
            tvQuestion = itemView.findViewById(R.id.tvQuestion);
            tvOption1 = itemView.findViewById(R.id.tvOption1);
            tvOption2 = itemView.findViewById(R.id.tvOption2);
            tvOption3 = itemView.findViewById(R.id.tvOption3);
            tvOption4 = itemView.findViewById(R.id.tvOption4);

        }
    }
}
