package com.example.depeat.ui.activities;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.example.depeat.R;
import com.example.depeat.Utilities;
import com.example.depeat.adapter.RestaurantAdpter;
import com.example.depeat.datamodels.Restaurant;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout ln;
    EditText mail_ed;
    EditText psw_ed;

    Intent opemRegister;
    Switch swBackground;
    ArrayList<Restaurant> lista;

RecyclerView restaurantRV;
RecyclerView.LayoutManager layoutManager;
RestaurantAdpter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // quale layaut voglio mostrare

        restaurantRV = findViewById(R.id.places_rv);
        layoutManager = new LinearLayoutManager(this);
        adapter=new RestaurantAdpter(this,getData());


        restaurantRV.setLayoutManager(layoutManager);
        restaurantRV.setAdapter(adapter);




        Log.i("Lifecycle", "Activity created");


    }

    private ArrayList<Restaurant> getData(){
        lista = new ArrayList<>();
        lista.add(new Restaurant("mc donals","via roma 10","10"));
        lista.add(new Restaurant("Kfc","via sandro sandri 10","5"));
        lista.add(new Restaurant("Rosso peperone","via tiburtina 8","12"));

        return lista;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

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

    private boolean hasInvitationCode() {
        return true;
    }

    @Override
    public void onClick(View v) {

    }

    private void doLogin() {
        String mail = mail_ed.getText().toString();

        if (Utilities.controlEmail(mail) && psw_ed.getText().toString().length() > 7) {

            showToast("Credenziali corrette");



        } else {

            showToast("Credenziali errate o incorrette");
        }
    }
}


