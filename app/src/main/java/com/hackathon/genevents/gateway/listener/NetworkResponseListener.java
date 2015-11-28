/**
 * ============================================================================================================
 * File Name       	: NetworkResponseListener.java
 * Author          	: Apex Team @ Endeavour Software Technologies pvt. ltd., Bangalore.
 * Version         	: 1.0.0
 * Copyright       	: Apex
 * Description     	:This is the Parent interface which receive the response callback from gateway layer.
 * History         	:
 * ============================================================================================================
 *  Sr. No.	    Date		          Name				 Description
 * ============================================================================================================
 *  1.	   	    15.10.2014            Apex Team            Initial Version.
 *  2.                                Apex Team            Check SVN.
 * ============================================================================================================
 */

package com.hackathon.genevents.gateway.listener;


import com.hackathon.genevents.gateway.response.Response;

public interface NetworkResponseListener {

	/**
	 * Process the response once response is received from the Connection
	 * handler.
	 */
	void onNetworkResponse(Response responseData);

	/**
	 * Process the response once errror occurred from the Connection handler.
	 */
	void onNetworkError(Response responseData);

}
