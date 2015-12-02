
package com.hackathon.genevents.gateway.helper;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Environment;
import android.util.Log;

import com.hackathon.genevents.EventsApplication;
import com.hackathon.genevents.R;
import com.hackathon.genevents.constants.ConnectionConstants;
import com.hackathon.genevents.gateway.exception.ClientTimeOutException;
import com.hackathon.genevents.gateway.exception.HttpRequestException;
import com.hackathon.genevents.gateway.helper.http.HttpClientHandler;
import com.hackathon.genevents.gateway.listener.NetworkResponseListener;
import com.hackathon.genevents.gateway.response.Response;

public class RequestResponseHandler {

	public static final int METHOD_GET = 1;
	public static final int METHOD_POST = 2;
	public static final int METHOD_GET_PDF = 4;

	private static final String TAG = "RequestResponseHandler";

	private String hostUrl;
	private String requestData;
	private int httpMethod;
	private NetworkResponseListener networkListener;
	/**
	 * Initializes request task with required parameters.
	 * 
	 * @param hostUrl
	 *            Server URL to deliver the request data
	 * @param requestData
	 *            Request data to be sent to server
	 * @param reqMethod
	 *            Method GET / POST
	 * @param networkListener
	 *            Response listener for callbacks
	 */
	public void createRequestTask(final String hostUrl, final String requestData, final int reqMethod,
			final NetworkResponseListener networkListener) {

		this.hostUrl = hostUrl;
		this.requestData = requestData;
		this.httpMethod = reqMethod;
		this.networkListener = networkListener;

	}

	/**
	 * This method process the request and send the response in callback
	 * listener
	 */
	public void processRequest() {

		final Response responseObj = new Response();
		HttpClientHandler client = null;

		try {
			HttpResponse httpResponse;

			Log.i(TAG , " Start processing the HTTP request");

			if (httpMethod == METHOD_POST) {
				client = new HttpClientHandler(hostUrl, ConnectionConstants.CONTENTTYPE_JSON);
				httpResponse = client.executePost(requestData);
			} else {
				client = new HttpClientHandler(hostUrl, ConnectionConstants.CONTENTTYPE);
				httpResponse = client.executeGet();
			}

			Log.i(TAG , " Received HTTP response: " + httpResponse.getStatusLine());

			responseObj.setResponseCode(httpResponse.getStatusLine().getStatusCode());
			responseObj.setResponseMessage(httpResponse.getStatusLine().getReasonPhrase().toString());

			if (httpResponse.getStatusLine().getStatusCode() == HttpURLConnection.HTTP_OK) {


                    handleGenericResponse(httpResponse, responseObj);

				return;
			}

		} catch (ClientTimeOutException e) {
			responseObj.setResponseCode(HttpURLConnection.HTTP_CLIENT_TIMEOUT);
			responseObj.setResponseMessage(EventsApplication.getResString(R.string.err_msg_nw_request_timeout));

		} catch (HttpRequestException e) {
			responseObj.setResponseCode(HttpURLConnection.HTTP_UNAVAILABLE);
			responseObj.setResponseMessage(EventsApplication.getResString(R.string.err_msg_nw_server_not_responding));

		} catch (IOException e) {
			responseObj.setResponseCode(HttpURLConnection.HTTP_NOT_FOUND);
			responseObj.setResponseMessage(EventsApplication.getResString(R.string.err_msg_nw_server_not_responding));

		} catch (ParseException e) {
			responseObj.setResponseCode(HttpURLConnection.HTTP_INTERNAL_ERROR);
			responseObj.setResponseMessage(EventsApplication.getResString(R.string.err_msg_nw_data_not_submitted));

		} catch (JSONException e) {
			responseObj.setResponseCode(HttpURLConnection.HTTP_INTERNAL_ERROR);
			responseObj.setResponseMessage(EventsApplication.getResString(R.string.err_msg_nw_data_not_submitted));

		} catch (Exception e) {
			responseObj.setResponseCode(HttpURLConnection.HTTP_INTERNAL_ERROR);
			responseObj.setResponseMessage(e.toString());

		} finally {
			if (client != null) {
				client.closeConnection();
			}
		}

		Log.i(TAG , " Error code: " + responseObj.getResponseCode());
		Log.i(TAG , " Error message: " + responseObj.getResponseMessage());

		networkListener.onNetworkError(responseObj);
	}

    private void handleGenericResponse(HttpResponse httpResponse, Response responseObj) throws IOException, JSONException {
        final HttpEntity entity = httpResponse.getEntity();
        Log.d(TAG, "Content length: " + entity.getContentLength());

        responseObj.setResponseObject(new JSONObject(EntityUtils.toString(entity)));
		Log.i(TAG, " Response code: " + responseObj.getResponseCode());
		Log.i(TAG, " Response message: " + responseObj.getResponseMessage());
		Log.i(TAG, " Response Object: " + responseObj.getResponseObject());
        networkListener.onNetworkResponse(responseObj);
    }
}
