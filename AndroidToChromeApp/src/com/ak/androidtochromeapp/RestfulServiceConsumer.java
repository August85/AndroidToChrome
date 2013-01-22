/*package com.ak.androidtochromeapp;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;
import android.widget.Toast;

public class RestfulServiceConsumer extends AsyncTask{
	//String URL = "http://androidtochrome.appspot.com/resources/CustomMessage/message/";
	String result = "";

	@Override
	protected String doInBackground(String... args) {
		// TODO Auto-generated method stub
		HttpClient httpclient = new DefaultHttpClient();
		//String newURL = URL.concat((String) paramArrayOfParams[0]);
		HttpGet request = new HttpGet((String) args[0]);
		ResponseHandler<String> handler = new BasicResponseHandler();
		try {
			result = httpclient.execute(request, handler);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		httpclient.getConnectionManager().shutdown();
		return result;

	}
	protected void onPostExecute(String result) {
		
    }
	

	
}
*/