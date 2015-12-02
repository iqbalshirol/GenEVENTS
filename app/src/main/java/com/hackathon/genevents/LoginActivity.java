package com.hackathon.genevents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hackathon.genevents.constants.StringConstants;
import com.hackathon.genevents.utils.DRDSharedPreferences;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private DRDSharedPreferences drdSharedPreferences;
    private Button mBtnSignIn;
    private EditText mETUsername;
    private EditText mETPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.genpact_login);

        drdSharedPreferences = new DRDSharedPreferences(this);

        mBtnSignIn = (Button) findViewById(R.id.btn_login);
        mBtnSignIn.setOnClickListener(this);
        mETUsername = (EditText) findViewById(R.id.et_username);
        mETPassword = (EditText) findViewById(R.id.et_password);

       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }


    @Override
    public void onClick(View view) {

    }
}
