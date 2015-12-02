package com.hackathon.genevents.gateway.exception;

import com.hackathon.genevents.EventsApplication;
import com.hackathon.genevents.R;

public class ClientTimeOutException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs the exception with
	 * @param exception
	 */
	public ClientTimeOutException(final Exception exception) {
		super(exception);
	}

	@Override
	public String getMessage() {

		return EventsApplication.getResString(R.string.err_msg_nw_request_timeout);
	}

}
