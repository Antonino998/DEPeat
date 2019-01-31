package com.example.depeat.ui.activities;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.depeat.R;
import com.example.depeat.Utilities;

public class RgisterActivity extends Activity implements View.OnClickListener, TextWatcher {

    EditText insEmail;
    EditText password;
    EditText numTel;
    Button register;


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

    private boolean VerificaControlli() {
        if (Utilities.controlEmail(insEmail.getText().toString()) &&
                Utilities.controlPassword(password.getText().toString())
                && Utilities.controlPhone(numTel.getText().toString())) {
            return true;
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

        if (v.getId() == R.id.conf_registBotton) {
            showToast("Utente registrato");
        }

    }

    void showToast(String testo) {
        Toast.makeText(this, testo, Toast.LENGTH_LONG).show();
    }
}
