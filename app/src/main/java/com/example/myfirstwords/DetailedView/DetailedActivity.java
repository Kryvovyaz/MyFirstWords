package com.example.myfirstwords.DetailedView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myfirstwords.DetailedView.DetailedListAdapter;
import com.example.myfirstwords.DetailedView.MenuItem;
import com.example.myfirstwords.MainView.CategorieList;
import com.example.myfirstwords.R;

import java.util.ArrayList;

public class DetailedActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<MenuItem> items_list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);
        populateRusAnimalsList();
        recyclerView = findViewById(R.id.recycler_detailed);


        DetailedListAdapter detailedListAdapter = new DetailedListAdapter(items_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(detailedListAdapter);


    }

    public void populateRusAnimalsList() {
        String[] animals = getResources().getStringArray(R.array.animals_russian);
        String[] images = getResources().getStringArray(R.array.animals_pictures);
        String[] sound_effects = getResources().getStringArray(R.array.animals_sounds_effect);
        String[] sounds = getResources().getStringArray(R.array.animals_sounds_russian);
        for (int i = 0; i < animals.length; i++) {
            int imageId = getResources().getIdentifier(images[i], "drawable", getPackageName());

            int sound_effectID = getResources().getIdentifier(sound_effects[i], "raw", getPackageName());
            int sound_englishID = getResources().getIdentifier(sounds[i], "raw", getPackageName());
            items_list.add(new MenuItem(animals[i], imageId, sound_effectID, sound_englishID));
        }
    }
//    public void populateEnAnimalsList() {
//        String[] animals = getResources().getStringArray(R.array.animals_english);
//        String[] images = getResources().getStringArray(R.array.animals_pictures);
//        String[] sound_effects = getResources().getStringArray(R.array.animals_sounds_effect);
//        String[] sounds = getResources().getStringArray(R.array.animals_sounds_english);
//        for (int i = 0; i < animals.length; i++) {
//            int imageId = getResources().getIdentifier(images[i], "drawable", getPackageName());
//
//            int sound_effectID = getResources().getIdentifier(sound_effects[i], "raw", getPackageName());
//            int sound_englishID = getResources().getIdentifier(sounds[i], "raw", getPackageName());
//           items_list.add(new Animal(animals[i], imageId, sound_effectID, sound_englishID));
//        }
}