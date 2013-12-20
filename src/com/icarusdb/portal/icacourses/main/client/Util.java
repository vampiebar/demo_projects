package com.icarusdb.portal.icacourses.main.client;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.ListBox;

public class Util {

	static public String urlBase = "http://localhost:9090/ICACoursesWS/jaxrs/genel/";

	// static public String urlBase =
	// "http://icarusway.com/ICACoursesWS/jaxrs/genel/";

	void sendRequest(String url, String successMsg, String errorMsg) {

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);

		try {
			Request request = builder.sendRequest(null, new RequestCallback() {
				public void onError(Request request, Throwable exception) {

				}

				@Override
				public void onResponseReceived(Request request,
						Response response) {

					Window.alert("SONUC: " + response.getText());

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			Window.alert(e.getMessage() + "ERROR");
		}
	}

	static int GetLBXSelectedTextIndex(ListBox lbx, String text) {

		for (int i = 0; i < lbx.getItemCount(); i++) {

			if (lbx.getItemText(i).equals(text)) {

				return i;
			}
		}

		return -1;
	}
}
