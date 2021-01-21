package com.example.myfirstwords.DetailedView;

import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfirstwords.R;

import java.util.ArrayList;
import java.util.Locale;

public class DetailedListAdapter extends RecyclerView.Adapter<DetailedListAdapter.DetailedViewHolder> {

    public ArrayList<MenuItem> items_list;
    public MediaPlayer player;
    public int listposition;
    public TextToSpeech t1;
    public int language;

    public DetailedListAdapter(ArrayList<MenuItem> items_list, int listposition, int language) {
        this.items_list = items_list;
        this.listposition = listposition;
        this.language = language;
    }

    @NonNull
    @Override
    public DetailedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_details, parent, false);
        t1 = new TextToSpeech(parent.getContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    if (language == 2) {
                        t1.setLanguage(Locale.ENGLISH);
                    }
                    if (language == 1) {
                        t1.setLanguage(new Locale("ru"));
                    }

                }
            }
        });

        return new DetailedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailedViewHolder holder, int position) {
        holder.itemImage.setImageResource(items_list.get(position).getImageId());

        if (listposition == 0) {
            holder.make_sound.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    play(v, items_list.get(position).getSound_effectID());
                }
            });


        } else {
            holder.make_sound.setVisibility(View.INVISIBLE);
        }

        holder.make_say.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
//                if (player.isPlaying()) {
//                    stopPlayer(v);
//                }
                // play(v, items_list.get(position).getMake_sound());
                String toSpeak = items_list.get(position).getName();

                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);

            }
        });

    }

    @Override
    public int getItemCount() {
        return items_list.size();
    }


    //    }
    public void play(View v, int id) {
        if (player != null) {
            player.release();
        }
        player = MediaPlayer.create(v.getContext(), id);
        player.start();
    }

    public void stopPlayer(View v) {
        if (player != null) {
            player.release();
            player = null;
        }
    }

    public static class DetailedViewHolder extends RecyclerView.ViewHolder {


        public ArrayList<MenuItem> items_list;
        public Button make_sound;
        public Button make_say;

        private ImageView itemImage;

        public DetailedViewHolder(@NonNull View itemView, ArrayList<MenuItem> animals) {
            super(itemView);
            this.items_list = animals;

        }

        public DetailedViewHolder(@NonNull View itemView) {

            super(itemView);

            make_say = itemView.findViewById(R.id.make_say);
            make_sound = itemView.findViewById(R.id.make_sound);
            itemImage = itemView.findViewById(R.id.details_image);
            make_sound.setSoundEffectsEnabled(false);
            make_say.setSoundEffectsEnabled(false);


        }
    }

}