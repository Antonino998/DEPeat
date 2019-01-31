package com.example.depeat;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RgisterActivity extends Activity implements View.OnClickListener, TextWatcher {

        EditText insEmail;
        EditText password;
        EditText numTel;
        Button register;

    private boolean controlPhone(String phone){
        return Patterns.PHONE.matcher(phone).matches();
    }
    private boolean controlEmail(String mail){
        return Patterns.EMAIL_ADDRESS.matcher(mail).matches();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.register_activity);

        insEmail = findViewById(R.id.ed_nome);
        password = findViewById(R.id.passwordR);
        numTel = findViewById(R.id.ed_num_tel);
        register = findViewById(R.id.conf_registBotton);

        insEmail.addTextChangedListener(this);
        password.addTextChangedListener(this);
        numTel.addTextChangedListener(this);

        register.setOnClickListener(this);

    }

    private boolean VerificaControlli(){
       if(controlEmail(insEmail.getText().toString()) && password.getText().toString().length() >6
               && controlPhone(numTel.getText().toString())){
           return true ;
        }
        return false;
    }
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        register.setEnabled(VerificaControlli());
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.conf_registBotton){
            showToast("Utente registrato");
        }

    }
    void showToast(String testo){
        Toast.makeText(this,testo, Toast.LENGTH_LONG).show();
    }
}
