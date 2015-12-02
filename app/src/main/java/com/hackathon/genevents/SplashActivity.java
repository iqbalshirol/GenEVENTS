package com.hackathon.genevents;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.hackathon.genevents.constants.StringConstants;
import com.hackathon.genevents.gateway.listener.RequestCallbackListener;
import com.hackathon.genevents.gateway.request.GetEventsRequest;
import com.hackathon.genevents.modal.GetEventResDTO;
import com.hackathon.genevents.modal.GetEventsDTO;
import com.hackathon.genevents.modal.ResponseDTO;
import com.hackathon.genevents.resuable.gcm.GCMManager;
import com.hackathon.genevents.utils.DRDSharedPreferences;

import java.util.ArrayList;
import java.util.Arrays;

public class SplashActivity extends AppCompatActivity {

    private GCMManager mGcmManager;
    private DRDSharedPreferences mDrdSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        messageHandler.sendEmptyMessageDelayed(0, 2000);
        mGcmManager = new GCMManager();
        mDrdSharedPreferences = new DRDSharedPreferences(this);
        if (mDrdSharedPreferences.getString(StringConstants.PREF_GCM_REG_ID, "").equals(""))
            mGcmManager.registerToGCM(this);
//use this for get events
        GetEventsDTO getEventsDTO = new GetEventsDTO();
        getEventsDTO.setEventName("");
        getEventsDTO.setEventType("1");
        getEventsDTO.setUserID("2");
        new GetEventsRequest(getEventsDTO, new RequestCallbackListener() {
            @Override
            public void onResponseReceived(ResponseDTO responseData) {
                ArrayList<GetEventResDTO> eventResDTOs = new ArrayList<GetEventResDTO>();
                eventResDTOs.addAll(Arrays.asList((GetEventResDTO[]) responseData
                        .getResponseObj()));
            }

            @Override
            public void onError(int code, String message) {

            }
        }).execute();
    }

    private Handler messageHandler = new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            startActivity(new Intent(SplashActivity.this, LoginActivity.class));
            SplashActivity.this.finish();
        }
    };

}
