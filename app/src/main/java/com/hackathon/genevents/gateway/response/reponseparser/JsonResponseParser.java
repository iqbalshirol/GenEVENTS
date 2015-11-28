package com.hackathon.genevents.gateway.response.reponseparser;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.hackathon.genevents.gateway.exception.ResponseParseException;
import com.hackathon.genevents.gateway.response.Response;
import com.hackathon.genevents.gateway.util.ResponseConstants;
import com.hackathon.genevents.modal.ResponseDTO;

import java.lang.reflect.Type;

public class JsonResponseParser {

	private static final String TAG = "ResponseParser";

	public static ResponseDTO parseGenericResponse(
			Response responseData) throws ResponseParseException {
		
		ResponseDTO responseDTO;
		try {
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson gson = gsonBuilder.create();
			JSONObject obj = responseData.getResponseObject();

			responseDTO = new ResponseDTO();
			if (obj.has(ResponseConstants.KEY_ACTION_ERRORS)) {
				responseDTO = gson.fromJson(obj.toString(), ResponseDTO.class);
			} else {
				responseDTO.setSuccess(true);
			}

			Log.d(TAG, "ResponseDTO: " + responseDTO);
		} catch (JsonSyntaxException e) {
			throw new ResponseParseException(e);
		}
		return responseDTO;
	}

	public static ResponseDTO parseResponse(Response responseData,
			Class<?> dtoClass) throws ResponseParseException {
		
		ResponseDTO responseDTO;
		try {
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson gson = gsonBuilder.create();
			JSONObject obj = responseData.getResponseObject();

			responseDTO = new ResponseDTO();
			if (obj.has(ResponseConstants.KEY_ACTION_ERRORS)) {
				responseDTO = gson.fromJson(obj.toString(), ResponseDTO.class);
			} else {
				responseDTO.setResponseObj(gson.fromJson(obj.toString(), dtoClass));
			}

			Log.d(TAG, "ResponseDTO: " + responseDTO);
			
		} catch (JsonSyntaxException e) {
			throw new ResponseParseException(e);
		}
		return responseDTO;
	}

	public static ResponseDTO parseResponse(Response responseData,
			Class<?> dtoClass, String jsonKey) throws ResponseParseException {
		
		ResponseDTO responseDTO;
		try {
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson gson = gsonBuilder.create();
			JSONObject obj = responseData.getResponseObject();

			responseDTO = new ResponseDTO();
			if (obj.has(ResponseConstants.KEY_ACTION_ERRORS)) {
				responseDTO = gson.fromJson(obj.toString(), ResponseDTO.class);
			} else {
				responseDTO.setResponseObj(gson.fromJson(obj.getJSONObject(jsonKey)
						.toString(), dtoClass));
			}

			Log.d(TAG, "ResponseDTO: " + responseDTO);
		} catch (JsonSyntaxException e) {
			throw new ResponseParseException(e);
		} catch (JSONException e) {
			throw new ResponseParseException(e);
		}
		return responseDTO;
	}

	public static ResponseDTO parseListResponse(
			Response responseData, Class<?> dtoArray, String jsonKey) throws ResponseParseException {
		
		ResponseDTO responseDTO;
		try {
			GsonBuilder gsonBuilder = new GsonBuilder();
			final Gson gson = gsonBuilder.create();
			final JSONObject obj = responseData.getResponseObject();

			responseDTO = new ResponseDTO();
			if (obj.has(ResponseConstants.KEY_ACTION_ERRORS)) {
				responseDTO = gson.fromJson(obj.toString(), ResponseDTO.class);
			} else {
				responseDTO.setResponseObj(gson.fromJson(obj.getJSONArray(jsonKey)
						.toString(), dtoArray));
			}
			Log.d(TAG, "ResponseDTO: " + responseDTO.getResponseObj());
		} catch (JsonSyntaxException e) {
			throw new ResponseParseException(e);
		} catch (JSONException e) {
			throw new ResponseParseException(e);
		}
		return responseDTO;
	}

}
