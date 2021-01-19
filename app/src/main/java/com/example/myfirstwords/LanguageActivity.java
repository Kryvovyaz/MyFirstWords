package com.example.myfirstwords;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myfirstwords.DetailedView.DetailedActivity;
import com.example.myfirstwords.MainView.Categorie;
import com.example.myfirstwords.MainView.CategorieList;
import com.example.myfirstwords.MainView.CategoriesClickListener;

import java.util.ArrayList;

public class LanguageActivity extends AppCompatActivity {
    private RecyclerView recyclerView_main;

    private ArrayList<Categorie> menu = new ArrayList<>();
    public static final String EXTRA_POSITION = "MainActivity.extra.holder.position";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
        recyclerView_main = findViewById(R.id.recyclerview_main);

        Intent intent1 = getIntent();
        Bundle bundle1 = intent1.getExtras();
        if (bundle1 != null) {

            int language = bundle1.getInt("LANGUAGE");
            populateMenuList(language);
        }
        CategorieList categorieList = new CategorieList(menu);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView_main.setLayoutManager(linearLayoutManager);
        recyclerView_main.setAdapter(categorieList);
        categorieList.setCategoriesClickListener(new CategoriesClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(getApplicationContext(), "Position: " + position + " clicked.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), DetailedActivity.class);
                intent.putExtra(EXTRA_POSITION, position);
                startActivity(intent);


            }
        });
    }


    public void populateMenuList(int language) {
        String[] imageTitles = getResources().getStringArray(R.array.categories_images);
        String[] categ = new String[imageTitles.length];
        if (language == 2) {
            categ = getResources().getStringArray(R.array.categories_en);
        }
        if (language == 1) {
            categ = getResources().getStringArray(R.array.categories_ru);
        }
        for (int i = 0; i < imageTitles.length; i++) {
            int imageId = getResources().getIdentifier(imageTitles[i], "drawable", getPackageName());
            menu.add(new Categorie(categ[i], imageId));
        }
    }


    // }

}
