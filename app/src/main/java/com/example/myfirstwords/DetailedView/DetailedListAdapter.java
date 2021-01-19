package com.example.myfirstwords.DetailedView;

import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfirstwords.R;

import java.util.ArrayList;

public class DetailedListAdapter extends RecyclerView.Adapter<DetailedListAdapter.DetailedViewHolder> {

    public ArrayList<MenuItem> items_list;

    public DetailedListAdapter(ArrayList<MenuItem> items_list) {
        this.items_list = items_list;
    }

    @NonNull
    @Override
    public DetailedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_details, parent, false);
        return new DetailedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailedViewHolder holder, int position) {
        holder.itemImage.setImageResource(items_list.get(position).getImageId());
    }

    @Override
    public int getItemCount() {
        return items_list.size();
    }

    public void setItems_list(ArrayList<MenuItem> items_list) {
        this.items_list = items_list;
    }

    public class DetailedViewHolder extends RecyclerView.ViewHolder {
        ArrayList<MenuItem> items_list;
        MediaPlayer player;
        private int imageID;
        private Button make_sound;
        private int sound_effectID;
        private Button make_say;
        private int sound = R.raw.dog_russian;
        private MenuItem menuItem;
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
        }

        public void play(View v, int id) {
            if (player != null) {
                player.release();
            }
            // player = MediaPlayer.create(getContext(), id);
            player.start();
        }

        public void stopPlayer(View v) {
            if (player != null) {
                player.release();
                player = null;
            }
        }
    }

}
