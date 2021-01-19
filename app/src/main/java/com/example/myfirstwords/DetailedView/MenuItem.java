package com.example.myfirstwords.DetailedView;

import android.os.Parcel;
import android.os.Parcelable;

public class MenuItem {
    private String name;
    private int imageId;
    private int sound_effectID;
    private int make_sound;


    public MenuItem(String name, int imageId, int sound_effecrID, int sound) {
        this.name = name;
        this.imageId = imageId;
        this.sound_effectID = sound_effecrID;
        this.make_sound = sound;
    }

    public MenuItem(String name, int imageId, int sound_effecrID) {
        this.name = name;
        this.imageId = imageId;
        this.sound_effectID = sound_effecrID;

    }

    public int getSound_effectID() {
        return sound_effectID;
    }

    public int getMake_sound() {
        return make_sound;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }


}
