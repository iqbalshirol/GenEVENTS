package com.hackathon.genevents.gateway.exception;


import com.hackathon.genevents.EventsApplication;
import com.hackathon.genevents.R;

public class ResponseParseException extends Exception {

	private static final long serialVersionUID = 2L;

	public ResponseParseException(){
		super(EventsApplication.getResString(R.string.err_msg_internal_error));
	}
	
	public ResponseParseException(final String msg){
		super(msg);
	}
	
	public ResponseParseException(final Exception e){
		super(e);
	}

}
