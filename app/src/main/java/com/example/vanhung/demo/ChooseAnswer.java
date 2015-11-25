package com.example.vanhung.demo;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.wefika.flowlayout.FlowLayout;

public class ChooseAnswer extends AppCompatActivity {
    FlowLayout my_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_answer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        my_layout = (FlowLayout) findViewById(R.id.my_control);
        FlowLayout.LayoutParams params = new FlowLayout.LayoutParams(FlowLayout.LayoutParams.WRAP_CONTENT, FlowLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 0, 0, 0);

        FlowLayout.LayoutParams layoutParams = new FlowLayout.LayoutParams(FlowLayout.LayoutParams.MATCH_PARENT, FlowLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, 10, 0, 10);
        //question
        String question=getResources().getString(R.string.question_1);
        TextView textview_delimiter = new TextView(ChooseAnswer.this);
        textview_delimiter.setLayoutParams(params);
        textview_delimiter.setText(question);
        textview_delimiter.setTextSize(20);
        textview_delimiter.setPadding(5, 5, 5, 5);
        textview_delimiter.setTextColor(Color.BLUE);
        my_layout.addView(textview_delimiter);

        //answer1
        String answer_1=getResources().getString(R.string.answer_1);
        FontView txt_anwser_1 = new FontView(ChooseAnswer.this);
        txt_anwser_1.setLayoutParams(layoutParams);
        txt_anwser_1.setText(answer_1);
        txt_anwser_1.setTextSize(20);
        txt_anwser_1.setPadding(10,20,10,20);
        txt_anwser_1.setTextColor(Color.BLUE);
        my_layout.addView(txt_anwser_1);

        //answer1
        String answer_2=getResources().getString(R.string.answer_2);
        FontView txt_anwser_2 = new FontView(ChooseAnswer.this);
        txt_anwser_2.setLayoutParams(layoutParams);
        txt_anwser_2.setText(answer_2);
        txt_anwser_2.setTextSize(20);
        txt_anwser_2.setPadding(10,20,10,20);
        txt_anwser_2.setTextColor(Color.BLUE);
        my_layout.addView(txt_anwser_2);
    }

}
