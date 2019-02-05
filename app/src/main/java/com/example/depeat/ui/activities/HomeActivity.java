package com.example.depeat.ui.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.example.depeat.R;
import com.example.depeat.adapter.RestaurantAdpter;
import com.example.depeat.datamodels.Restaurant;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout ln;
    EditText mail_ed;
    EditText psw_ed;
    FloatingActionButton grid;

    ArrayList<Restaurant> lista;

    RecyclerView restaurantRV;
    RecyclerView.LayoutManager layoutManager;
    RestaurantAdpter adapter;


    SharedPreferences preferences;
    private static final String SharedPrefs = "com.example.depeat.general_pref";
    private static final String  VIEW_MODE = "VIEW_MODE";
    private boolean isGridLayout= false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home); // quale layaut voglio mostrare

        grid = findViewById(R.id.grid_button);
        restaurantRV = findViewById(R.id.places_rv);
        layoutManager = getLayoutManager(getSavedLayoutManager());
        adapter=new RestaurantAdpter(this,getData());
        grid.setOnClickListener(this);

        restaurantRV.setLayoutManager(layoutManager);
        restaurantRV.setAdapter(adapter);

    }

    private  RecyclerView.LayoutManager getLayoutManager(boolean isGridLayout){
       this.isGridLayout=false;
        if (isGridLayout){

            layoutManager = new LinearLayoutManager(this);
                grid.setImageResource(R.drawable.ic_action_grid);
            return layoutManager;
        }
        else{

            this.isGridLayout= true;
            layoutManager = new GridLayoutManager(this,2);
            grid.setImageResource(R.mipmap.is_lista_png);


            return  layoutManager;
        }

    }

    private ArrayList<Restaurant> getData(){
        lista = new ArrayList<>();
        lista.add(new Restaurant("mc donals","via roma 10","  10€","http://pngimg.com/uploads/mcdonalds/mcdonalds_PNG9.png"));
        lista.add(new Restaurant("Kfc","via sandro sandri 10"," 5€","https://upload.wikimedia.org/wikipedia/it/5/57/300px-KFC_logo_svg.png"));
        lista.add(new Restaurant("Rosso peperone","via tiburtina 8","12€","https://gorgeouslygf.files.wordpress.com/2014/05/logo-rossopomodoro-june-2013.png?w=560"));
        lista.add(new Restaurant("Burger King","via sandri 18","  3€","https://upload.wikimedia.org/wikipedia/it/thumb/3/3a/Burger_King_Logo.svg/1013px-Burger_King_Logo.svg.png"));

        return lista;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        if (item.getItemId() == R.id.login_menu) {
            startActivity(new Intent(this, RgisterActivity.class));
            return true;
        }else if(item.getItemId() == R.id.checkout_menu){
            startActivity(new Intent(this,CheckoutActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    void showToast(String testo) {
        Toast.makeText(this, testo, Toast.LENGTH_LONG).show();
    }

        public void onClick (View v)
        {
            if (grid.getId() == R.id.grid_button) {

               getLayoutManager(isGridLayout);
                restaurantRV.setLayoutManager(layoutManager);
                restaurantRV.setAdapter(adapter);
                saveLayoutManager(isGridLayout);
            }
    }

    void saveLayoutManager(boolean isGridLayout){
        preferences = getSharedPreferences(SharedPrefs,MODE_PRIVATE);
        SharedPreferences.Editor  editor = preferences.edit();
        editor.putBoolean(VIEW_MODE,isGridLayout);
        editor.apply();
    }
    public boolean getSavedLayoutManager(){
        preferences = getSharedPreferences(SharedPrefs,MODE_PRIVATE);

        return preferences.getBoolean(VIEW_MODE,false);
    }



}


