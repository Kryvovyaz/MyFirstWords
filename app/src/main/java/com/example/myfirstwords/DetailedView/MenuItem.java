package com.example.myfirstwords.DetailedView;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.TextView;

public class MenuItem {

    private int imageId;
    private int sound_effectID;
    private String name;
    private Character character;

    public Character getCharacter() {
        return character;
    }

    public MenuItem(Character character) {
        this.character = character;
    }

    public String getName() {
        return name;
    }

    public MenuItem(int imageId, int sound_effectID, String name) {
        this.imageId = imageId;
        this.sound_effectID = sound_effectID;
        this.name = name;
    }

    public MenuItem(int imageId, String name) {
        this.imageId = imageId;
        this.name = name;
    }

    public int getSound_effectID() {
        return sound_effectID;
    }

    public int getImageId() {
        return imageId;
    }
}