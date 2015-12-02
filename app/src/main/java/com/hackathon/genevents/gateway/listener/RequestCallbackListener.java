
package com.hackathon.genevents.gateway.listener;


import com.hackathon.genevents.modal.ResponseDTO;

public interface RequestCallbackListener {

	/**
	 * Process the response once response is received from the Connection
	 * handler.
	 */
	void onResponseReceived(ResponseDTO responseData);

	/**
	 * Process the response once errror occurred from the Connection handler.
	 */
	void onError(int code, String message);
}
