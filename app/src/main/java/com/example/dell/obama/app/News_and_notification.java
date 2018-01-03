package com.example.dell.obama.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.dell.obama.R;
import com.example.dell.obama.adapter.CardsAdapter;
import com.example.dell.obama.model.Model;

public class News_and_notification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_and_notification);
        ListView lvCards = (ListView) findViewById(R.id.list_cards);
        CardsAdapter adapter = new CardsAdapter(this);
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Navigation_drawer.class));
            }
        });


        lvCards.setAdapter((ListAdapter) adapter);
        adapter.addAll(new Model(R.drawable.obama, R.string.obama, R.string.obama_sub),
                new Model(R.drawable.obama, R.string.obama, R.string.obama_sub),
                new Model(R.drawable.obama, R.string.obama, R.string.obama_sub),
                new Model(R.drawable.obama, R.string.obama, R.string.obama_sub),
                new Model(R.drawable.obama, R.string.obama, R.string.obama_sub),
                new Model(R.drawable.obama, R.string.obama, R.string.obama_sub),
                new Model(R.drawable.obama, R.string.obama, R.string.obama_sub),
                new Model(R.drawable.obama, R.string.obama, R.string.obama_sub),
                new Model(R.drawable.obama, R.string.obama, R.string.obama_sub));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
