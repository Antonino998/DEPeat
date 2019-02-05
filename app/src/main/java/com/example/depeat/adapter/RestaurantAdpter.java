package com.example.depeat.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.depeat.R;
import com.example.depeat.datamodels.Restaurant;

import java.util.ArrayList;

public class RestaurantAdpter extends RecyclerView.Adapter {

    LayoutInflater inflater;
    Context contesto;
    private ArrayList<Restaurant> ristoranti;

    public RestaurantAdpter(Context context, ArrayList<Restaurant> ristoranti) {
        contesto = context;
        inflater = LayoutInflater.from(context);
        this.ristoranti = ristoranti;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.item_ristorante, viewGroup, false);
        return new RestaurantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int posizione) {

        RestaurantViewHolder vh = (RestaurantViewHolder) viewHolder;
        vh.restaurantName.setText(ristoranti.get(posizione).getName());
        vh.indirizzo.setText(ristoranti.get(posizione).getIndirizzo());
        vh.minOrd.setText(ristoranti.get(posizione).getMinOrd());
        Glide.with(contesto).load(ristoranti.get(posizione).getImgUrl()).into(vh.immagineLogo);

    }


    @Override
    public int getItemCount() {
        return ristoranti.size();
    }


    public class RestaurantViewHolder extends RecyclerView.ViewHolder {
        public TextView restaurantName;
        public TextView indirizzo;
        public TextView minOrd;
        public ImageView immagineLogo;


        public RestaurantViewHolder(View itemView) {
            super(itemView);
            restaurantName = itemView.findViewById(R.id.name_tv);
            indirizzo = itemView.findViewById(R.id.indirizzo_tv);
            minOrd = itemView.findViewById(R.id.minOrd_tv);
            immagineLogo = itemView.findViewById(R.id.iconImageView);

        }

    }
}
