package com.example.vanhung.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void chooseWord(View v)
    {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void chooseAnswer(View v)
    {
        Intent intent=new Intent(this,ChooseAnswer.class);
        startActivity(intent);
    }

}
