/**
 * ============================================================================================================
 * File Name       	: LoginRequest.java
 * Author          	: Apex Team @ Endeavour Software Technologies pvt. ltd., Bangalore.
 * Version         	: 1.0.0
 * Copyright       	: Apex
 * Description     	: This is the class which takes the Login request from UI and sends it to connection handler. 
 * 						On receiving the response from connection handler it parse the response sends the DTO 
 * 						object back to UI callback listener. 
 * History         	:
 * ============================================================================================================
 *  Sr. No.	    Date		          Name				 Description
 * ============================================================================================================
 *  1.	   	    16.10.2014           Apex Team            Initial Version.
 *  2.                               Apex Team            Check SVN.
 * ============================================================================================================
 */

package com.hackathon.genevents.gateway.request;

import android.os.AsyncTask;
import android.util.Log;

import com.hackathon.genevents.EventsApplication;
import com.hackathon.genevents.R;
import com.hackathon.genevents.constants.ConnectionConstants;
import com.hackathon.genevents.gateway.helper.RequestResponseHandler;
import com.hackathon.genevents.gateway.listener.NetworkResponseListener;
import com.hackathon.genevents.gateway.listener.RequestCallbackListener;
import com.hackathon.genevents.gateway.request.requestbuilder.QueryRequestBuilder;
import com.hackathon.genevents.gateway.response.Response;
import com.hackathon.genevents.gateway.response.reponseparser.JsonResponseParser;
import com.hackathon.genevents.modal.LoginResponseDTO;

public class LoginRequest extends AsyncTask<Object, Void, Void> implements NetworkResponseListener {

	private static final String TAG = "LoginRequest";

	private final String loginUserName;

	private final String loginPassword;

	private final String versionNumber;

	private final boolean pinLogin;

	private final RequestCallbackListener uiListener;

	public LoginRequest(String userName, String password, boolean isPinLogin, String version,
			RequestCallbackListener uiListener) {
		this.loginUserName = userName;
		this.loginPassword = password;
		this.pinLogin = isPinLogin;
		this.versionNumber = version;
		this.uiListener = uiListener;
	}

	@Override
	protected Void doInBackground(Object... params) {

		// Form the Login query
		/*String reqQuery = QueryRequestBuilder.formLoginQuery(loginUserName, loginPassword, pinLogin, versionNumber);
		Log.d(TAG,"Login Request URL: "+reqQuery);

		// Start processing the request
		RequestResponseHandler reqHanlder = new RequestResponseHandler();
		reqHanlder.createRequestTask(ConnectionConstants.SERVER_URL + reqQuery, null,
				RequestResponseHandler.METHOD_GET, this);
		reqHanlder.processRequest();*/
		return null;
	}

	@Override
	public void onNetworkResponse(Response responseData) {

		Log.i(TAG, "onNetworkResponse");

		// Parse the response and send to UI Listener
		try {
			uiListener.onResponseReceived(JsonResponseParser.parseResponse(responseData, LoginResponseDTO.class));

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

}
