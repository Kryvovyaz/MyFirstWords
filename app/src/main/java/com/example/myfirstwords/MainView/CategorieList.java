package com.example.myfirstwords.MainView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfirstwords.R;

import java.util.ArrayList;

public class CategorieList extends RecyclerView.Adapter<CategorieList.CategorieHolder> {
    private CategoriesClickListener categoriesClickListener;

    public void setCategoriesClickListener(CategoriesClickListener categoriesClickListener) {
        this.categoriesClickListener = categoriesClickListener;
    }

    private ArrayList<Categorie> categories_list;

    public CategorieList(ArrayList<Categorie> categories) {
        this.categories_list = categories;
    }

    @NonNull
    @Override
    public CategorieList.CategorieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_menu, parent, false);
        return new CategorieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategorieList.CategorieHolder holder, int position) {
        holder.categorie_name.setText(categories_list.get(position).categorie_name);
        holder.imageView.setImageResource(categories_list.get(position).categorie_imageId);
    }

    @Override
    public int getItemCount() {
        return categories_list.size();
    }

    public class CategorieHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView categorie_name;

        public CategorieHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.main_recycler_image);
            categorie_name = itemView.findViewById(R.id.main_recycler_text);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    categoriesClickListener.onClick(getAdapterPosition());
                }
            });
        }
    }

}
