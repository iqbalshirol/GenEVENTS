package com.hackathon.genevents;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.hackathon.genevents.constants.StringConstants;
import com.hackathon.genevents.gateway.listener.RequestCallbackListener;
import com.hackathon.genevents.gateway.request.GetEventsRequest;
import com.hackathon.genevents.modal.GetEventResDTO;
import com.hackathon.genevents.modal.GetEventResponce;
import com.hackathon.genevents.modal.GetEventsDTO;
import com.hackathon.genevents.modal.ResponseDTO;
import com.hackathon.genevents.utils.NetworkUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllEventsActivity extends Activity {

    List<GetEventResponce> eventResDTOs = new ArrayList<GetEventResponce>();
    ListView listView;
    EventsAdapter mVanHouseAdapter;
    ProgressDialog progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_events);
        listView=(ListView)findViewById(R.id.listView);
        mVanHouseAdapter = new EventsAdapter(this, R.layout.item_details, eventResDTOs,"");
        listView.setAdapter(mVanHouseAdapter);

        GetEventsDTO getEventsDTO = new GetEventsDTO();
        getEventsDTO.setEventName("");
        getEventsDTO.setEventType("1");
        getEventsDTO.setUserID("2");
        if(NetworkUtils.isNetworkAvailable(AllEventsActivity.this)) {
            showLoader();
            new GetEventsRequest(getEventsDTO, new RequestCallbackListener() {
                @Override
                public void onResponseReceived(ResponseDTO responseData) {

                    eventResDTOs.addAll(Arrays.asList((GetEventResponce[]) responseData
                            .getResponseObj()));
                    AllEventsActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            hideLoader();
                            mVanHouseAdapter.notifyDataSetChanged();
                            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    Intent intent = new Intent(AllEventsActivity.this, DescriptionActivity.class);
                                    intent.putExtra(StringConstants.NAME, eventResDTOs.get(position).getEventName());
                                    intent.putExtra(StringConstants.DESC, eventResDTOs.get(position).getEventDesc());
                                    startActivity(intent);
                                }
                            });
                        }
                    });
                }

                @Override
                public void onError(int code, String message) {
                    AllEventsActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            hideLoader();
                            Toast.makeText(AllEventsActivity.this,"Error while getting data",Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }).execute();
        }
    }
    public void showLoader() {
        progressBar = new ProgressDialog(AllEventsActivity.this);
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
