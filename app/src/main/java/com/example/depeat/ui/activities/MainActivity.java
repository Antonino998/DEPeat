package com.example.depeat.ui.activities;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.example.depeat.R;
import com.example.depeat.Utilities;

public  class MainActivity extends AppCompatActivity implements  View.OnClickListener{
        LinearLayout ln;
        Button loginBtn;
        Button register;
        EditText mail_ed;
        EditText psw_ed;
        Intent openpage1;
        Intent  opemRegister;
        Switch swBackground;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main); // quale layaut voglio mostrare
            loginBtn = findViewById(R.id.login_btn);
            register = findViewById(R.id.register_botton);

            mail_ed = findViewById(R.id.email_text);
            psw_ed = findViewById(R.id.password_text);

            swBackground=findViewById(R.id.cb_activity);
            ln = findViewById(R.id.linear_pricipale);

            if (!hasInvitationCode()){
                register.setVisibility(View.INVISIBLE);
            }

            loginBtn.setOnClickListener(this); //
            register.setOnClickListener(this);
            swBackground.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    cambiaSfondo(isChecked);
                }
            });

            Log.i("Lifecycle","Activity created");


        }
        private void cambiaSfondo(boolean isChecked){
            ln.setId(R.id.linear_pricipale);
            if(isChecked) {
                ln.setBackgroundColor(Color.GREEN);
            }else
                ln.setBackgroundColor(Color.WHITE);

        }
        void showToast(String testo){
            Toast.makeText(this,testo, Toast.LENGTH_LONG).show();
        }

        private boolean hasInvitationCode(){
            return true;
        }



        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.login_btn){
                doLogin();
                String email=mail_ed.getText().toString();
            }

            else if(v.getId() == R.id.register_botton) {
                opemRegister = new Intent(this, RgisterActivity.class);
                startActivity(opemRegister);
            }

        }

        private void doLogin() {
            String mail=mail_ed.getText().toString();

            if(Utilities.controlEmail(mail) && psw_ed.getText().toString().length()>7){

                showToast("Credenziali corrette");

            }

            else{

                showToast("Credenziali errate o incorrette");
            }}
    }


