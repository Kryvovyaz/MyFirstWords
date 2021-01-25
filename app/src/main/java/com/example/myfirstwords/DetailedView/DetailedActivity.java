package com.example.myfirstwords.DetailedView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;

import com.example.myfirstwords.DetailedView.DetailedListAdapter;
import com.example.myfirstwords.DetailedView.MenuItem;
import com.example.myfirstwords.MainView.CategorieList;
import com.example.myfirstwords.R;

import java.util.ArrayList;
import java.util.Locale;

public class DetailedActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<MenuItem> items_list = new ArrayList<>();
    private int language;
    private int list_position;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        Intent intent1 = getIntent();
        Bundle bundle1 = intent1.getExtras();
        if (bundle1 != null) {

            language = bundle1.getInt("LANGUAGE");
            list_position = bundle1.getInt("Position");

            switch (list_position) {
                case 0:
                    //items_list.clear();
                    populateAnimalsList(language);
                    break;
                case 1:
                    //items_list.clear();
                    populateFruitsList(language);
                    break;

                case 2:
                    //  items_list.clear();
                    populateVegetablesList(language);
                    break;

                case 3:
                    //  items_list.clear();
                    populateBerriesList(language);
                    break;
                case 4:
                    //  items_list.clear();
                    populateFoodList(language);
                    break;
                case 5:
                    //  items_list.clear();
                    populateObjectsList(language);
                    break;
                case 7:
                    // items_list.clear();
                    populateVehiclesList(language);
                    break;


                case 9:
                    // items_list.clear();
                    populateMyBodyList(language);
                    break;

                case 10:
                    //  items_list.clear();
                    populateColorsList(language);
                    break;

            }

        }


        recyclerView = findViewById(R.id.recycler_detailed);


        DetailedListAdapter detailedListAdapter = new DetailedListAdapter(items_list, list_position, language);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(detailedListAdapter);


    }

    public void populateAnimalsList(int language) {
        String[] images = getResources().getStringArray(R.array.animals_pictures);
        String[] sound_effects = getResources().getStringArray(R.array.animals_sounds_effect);

        String[] aimalsName = new String[images.length];
        if (language == 2) {
            aimalsName = getResources().getStringArray(R.array.animals_pictures);

        }
        if (language == 1) {
            aimalsName = getResources().getStringArray(R.array.animals_russian);

        }

        for (int i = 0; i < images.length; i++) {
            int imageId = getResources().getIdentifier(images[i], "drawable", getPackageName());

            int sound_effectID = getResources().getIdentifier(sound_effects[i], "raw", getPackageName());

            items_list.add(new MenuItem(imageId, sound_effectID, aimalsName[i]));
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////
    public void populateFruitsList(int language) {

        String[] images = getResources().getStringArray(R.array.fruits_pictures);

        String[] names = new String[images.length];

        if (language == 2) {

            names = getResources().getStringArray(R.array.fruits_pictures);
        }
        if (language == 1) {

            names = getResources().getStringArray(R.array.fruits_names_russian);
        }

        addItemtoList(images, names);

    }

    //////////////////////////////////////////////////////////////////////////////////////////////
    public void populateBerriesList(int language) {

        String[] images = getResources().getStringArray(R.array.berries_pictures);

        String[] names = new String[images.length];

        if (language == 2) {

            names = getResources().getStringArray(R.array.berries_pictures);
        }
        if (language == 1) {

            names = getResources().getStringArray(R.array.berries_names_russian);
        }

        addItemtoList(images, names);

    }

    //////////////////////////////////////////////////////////////////////////////////////////////
    public void populateFoodList(int language) {

        String[] images = getResources().getStringArray(R.array.food_pictures);

        String[] names = new String[images.length];

        if (language == 2) {

            names = getResources().getStringArray(R.array.food_pictures);
        }
        if (language == 1) {

            names = getResources().getStringArray(R.array.food_names_russian);
        }

        addItemtoList(images, names);

    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    public void populateObjectsList(int language) {

        String[] images = getResources().getStringArray(R.array.objects_pictures);

        String[] names = new String[images.length];

        if (language == 2) {

            names = getResources().getStringArray(R.array.objects_pictures);
        }
        if (language == 1) {

            names = getResources().getStringArray(R.array.objects_names_russian);
        }

        addItemtoList(images, names);

    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    public void populateVegetablesList(int language) {

        String[] images = getResources().getStringArray(R.array.vegetables_pictures);

        String[] names = new String[images.length];

        if (language == 2) {

            names = getResources().getStringArray(R.array.vegetables_pictures);
        }
        if (language == 1) {

            names = getResources().getStringArray(R.array.vegetables_names_russian);
        }
        addItemtoList(images, names);

    }

    //////////////////////////////////////////////////////////////////////////////////////////
    public void populateVehiclesList(int language) {

        String[] images = getResources().getStringArray(R.array.vehicles_pictures);

        String[] names = new String[images.length];

        if (language == 2) {

            names = getResources().getStringArray(R.array.vehicles_pictures);
        }
        if (language == 1) {

            names = getResources().getStringArray(R.array.vehicles_names_russian);
        }
        addItemtoList(images, names);


    }
    //////////////////////////////////////////////////////////////////////////////////////////

    public void populateMyBodyList(int language) {

        String[] images = getResources().getStringArray(R.array.mybody_pictures);

        String[] names = new String[images.length];

        if (language == 2) {

            names = getResources().getStringArray(R.array.mybody_pictures);
        }
        if (language == 1) {

            names = getResources().getStringArray(R.array.mybody_names_russian);
        }
        addItemtoList(images, names);


    }

    //////////////////////////////////////////////////////////////////////////////////////////
    public void populateColorsList(int language) {

        String[] images = getResources().getStringArray(R.array.colors_pictures);

        String[] names = new String[images.length];

        if (language == 2) {

            names = getResources().getStringArray(R.array.colors_pictures);
        }
        if (language == 1) {

            names = getResources().getStringArray(R.array.colors_names_russian);
        }

        addItemtoList(images, names);


    }

    ////////////////////////////////////////////////////////////////////////////////////////
    public void addItemtoList(String[] images, String[] names) {

        for (int i = 0; i < images.length; i++) {
            int imageId = getResources().getIdentifier(images[i], "drawable", getPackageName());
            items_list.add(new MenuItem(imageId, names[i].replaceAll("_", " ").replaceAll("color", "")));

        }
    }
}