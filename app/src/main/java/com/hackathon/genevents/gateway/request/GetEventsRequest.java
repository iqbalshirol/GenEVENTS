
package com.hackathon.genevents.gateway.request;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.hackathon.genevents.EventsApplication;
import com.hackathon.genevents.R;
import com.hackathon.genevents.constants.ConnectionConstants;
import com.hackathon.genevents.gateway.helper.RequestResponseHandler;
import com.hackathon.genevents.gateway.listener.NetworkResponseListener;
import com.hackathon.genevents.gateway.listener.RequestCallbackListener;
import com.hackathon.genevents.gateway.response.LoginResponce;
import com.hackathon.genevents.gateway.response.Response;
import com.hackathon.genevents.gateway.response.reponseparser.JsonResponseParser;
import com.hackathon.genevents.modal.GetEventResDTO;
import com.hackathon.genevents.modal.GetEventResponce;
import com.hackathon.genevents.modal.GetEventsDTO;
import com.hackathon.genevents.modal.LoginDTO;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


public class GetEventsRequest extends AsyncTask<Object, Void, Void> implements NetworkResponseListener {

    private static final String TAG = "GetEventsRequest";


    private final GetEventsDTO getEventsDTO;

    private final RequestCallbackListener uiListener;

    public GetEventsRequest(GetEventsDTO getEventsDTO,
                            RequestCallbackListener uiListener) {
        this.getEventsDTO = getEventsDTO;
        this.uiListener = uiListener;
    }

    @Override
    protected Void doInBackground(Object... params) {

        // Form the Login query

        RequestResponseHandler reqHanlder = new RequestResponseHandler();
        Gson gson = new Gson();
        String jsonObj = gson.toJson(getEventsDTO);
        reqHanlder.createRequestTask(
                ConnectionConstants.SERVER_URL + "/Events/GetEvents", jsonObj,
                RequestResponseHandler.METHOD_POST, this);

        reqHanlder.processRequest();
        return null;
    }

    @Override
    public void onNetworkResponse(Response responseData) {

        Log.i(TAG, "onNetworkResponse");

        // Parse the response and send to UI Listener
        try {
            uiListener.onResponseReceived(JsonResponseParser.parseListResponse(responseData, GetEventResponce[].class, "eventsInformation"));

        } catch (Exception e) {
            Log.e(TAG, "Exception: " + e.getMessage());
            uiListener.onError(0, EventsApplication.getResString(R.string.err_msg_internal_error));
        }
    }

    @Override
    public void onNetworkError(Response responseData) {
        Log.e(TAG, "onNetworkError");

        try {
            uiListener.onError(responseData.getResponseCode(), responseData.getResponseMessage());

        } catch (Exception e) {
            Log.e(TAG, "Exception: " + e.getMessage());
        }
    }

    public static String formLoginQuery(String user, String password) {
        String passwordURL;
        String userName;
        try {
            userName = URLEncoder.encode(user, ConnectionConstants.ENCODEINGFORMAT);
            passwordURL = URLEncoder.encode(password, ConnectionConstants.ENCODEINGFORMAT);
        } catch (UnsupportedEncodingException e) {
            passwordURL = "";
            userName = "";
        }
        return String.format("%s?%s=%s&%s=%s", "login", "UserNmae", userName, "Password", passwordURL);
    }
}
