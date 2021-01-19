package com.example.myfirstwords;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myfirstwords.MainView.Categorie;
import com.example.myfirstwords.MainView.CategorieList;
import com.example.myfirstwords.MainView.CategoriesClickListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ImageView button_ru;
    private ImageView button_en;

    Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Reference your views
        button_ru = findViewById(R.id.button_russian);
        button_en = findViewById(R.id.button_english);

        button_ru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), LanguageActivity.class);
                bundle.putInt("LANGUAGE", 1);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


        button_en.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), LanguageActivity.class);
                bundle.putInt("LANGUAGE", 2);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

}