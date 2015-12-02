
package com.hackathon.genevents.gateway.exception;

import com.hackathon.genevents.EventsApplication;
import com.hackathon.genevents.R;

public class HttpRequestException extends Exception {

	private static final long serialVersionUID = -2413629666163901633L;


	public HttpRequestException(final Exception exception) {
		super(exception);
	}

	@Override
	public String getMessage() {

		return EventsApplication.getResString(R.string.err_msg_nw_server_not_responding);
	}
}