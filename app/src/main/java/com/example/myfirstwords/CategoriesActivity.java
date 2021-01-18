package com.example.myfirstwords;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class CategoriesActivity extends MainActivity {
    private int position;
    TextView textView;

    public CategoriesActivity(int position) {
        this.position = position;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorie);
        Intent intent = getIntent();
        position = intent.getIntExtra(MainActivity.EXTRA_POSITION, 0);
        textView.findViewById(R.id.text);
        textView.setText(getCategories().get(position).categorie_name);

    }
}