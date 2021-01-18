package com.example.myfirstwords;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myfirstwords.MainView.Categorie;
import com.example.myfirstwords.MainView.CategorieList;
import com.example.myfirstwords.MainView.CategoriesClickListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView_main;

    public ArrayList<Categorie> getCategories() {
        return categories;
    }

    private ArrayList<Categorie> categories = new ArrayList<>();
    public static final String EXTRA_POSITION = "MainActivity.extra.holder.position";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView_main = findViewById(R.id.recyclerview_main);
        populateRecipeList();
        //  View.OnClickListener listener = view -> onClickViewHolderAction(view);

        CategorieList categorieList = new CategorieList(categories);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView_main.setLayoutManager(linearLayoutManager);
        recyclerView_main.setAdapter(categorieList);
        categorieList.setCategoriesClickListener(new CategoriesClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(getApplicationContext(), "Position: " + position + " clicked.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Categorie.class);
                intent.putExtra(EXTRA_POSITION, position);
                startActivity(intent);
            }
        });
    }


    public void populateRecipeList() {
        String[] categ = getResources().getStringArray(R.array.categories_en);
        String[] imageTitles = getResources().getStringArray(R.array.categories_images);

        for (int i = 0; i < categ.length; i++) {
            int imageId = getResources().getIdentifier(imageTitles[i], "drawable", getPackageName());

            categories.add(new Categorie(categ[i], imageId));
        }
    }
}