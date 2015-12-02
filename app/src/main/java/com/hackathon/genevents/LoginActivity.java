package com.hackathon.genevents;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hackathon.genevents.constants.StringConstants;
import com.hackathon.genevents.gateway.listener.RequestCallbackListener;
import com.hackathon.genevents.gateway.request.LoginRequest;
import com.hackathon.genevents.gateway.response.LoginResponce;
import com.hackathon.genevents.modal.LoginDTO;
import com.hackathon.genevents.modal.ResponseDTO;
import com.hackathon.genevents.utils.DRDSharedPreferences;
import com.hackathon.genevents.utils.NetworkUtils;
import com.hackathon.genevents.utils.UIUtils;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private DRDSharedPreferences drdSharedPreferences;
    private Button mBtnSignIn;
    private EditText mETUsername;
    private EditText mETPassword;
    ProgressDialog progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.genpact_login);

        drdSharedPreferences = new DRDSharedPreferences(this);

        mBtnSignIn = (Button) findViewById(R.id.btn_login);
        mBtnSignIn.setOnClickListener(this);
        mETUsername = (EditText) findViewById(R.id.et_username);
        mETPassword = (EditText) findViewById(R.id.et_password);


    }


    @Override
    public void onClick(View view) {
        if (NetworkUtils.isNetworkAvailable(LoginActivity.this)) {
            showLoader();
            LoginDTO loginDTO = new LoginDTO(mETUsername.getText().toString(), mETPassword.getText().toString(), drdSharedPreferences.getString(StringConstants.PREF_GCM_REG_ID, ""));
            new LoginRequest(loginDTO, new RequestCallbackListener() {
                @Override
                public void onResponseReceived(final ResponseDTO responseData) {
                    Log.i("LoginResponce ", "   " + responseData.getResponseObj().toString());
                    LoginActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            LoginResponce responce = (LoginResponce) responseData.getResponseObj();
                            if (responce.getIsAuhthenticated().equalsIgnoreCase("True")) {
                                Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                                startActivity(i);
                                LoginActivity.this.finish();
                            } else {
                                Toast.makeText(LoginActivity.this, "Login fail", Toast.LENGTH_LONG).show();
                            }
                            hideLoader();
                        }
                    });

                }

                @Override
                public void onError(int code, String message) {
                    LoginActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            hideLoader();
                        }
                    });
                    Log.i("LoginResponce ", "   " + message);
                }
            }).execute();
        }
    }

    public void showLoader() {
        progressBar = new ProgressDialog(LoginActivity.this);
        progressBar.setCancelable(true);
        progressBar.setCanceledOnTouchOutside(false);
        progressBar.setMessage("Loading ...");
        progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressBar.show();
    }

    public void hideLoader() {
        if (progressBar != null) {
            if (progressBar.isShowing()) {
                progressBar.dismiss();
            }
        }
    }
}
