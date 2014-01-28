package com.labyrinth.fantasyfootball.networking;






import android.util.Log;

import com.labyrinth.fantasyfootball.fragments.SpiceManagerFragment;
import com.octo.android.robospice.SpiceManager;


public class NetworkThreader {
	private String TAG = "NetworkThreader"; // Debug TAG
	
	private SpiceManager spiceManager;
	private SpiceManagerFragment currentContext;
	private Object mObject;
	private String mUrl;
	private GetSpiceRequest getSpiceRequest;
	
	
	public NetworkThreader(String url, SpiceManager spiceManager, SpiceManagerFragment currentContext, Object mObject){
		this.mUrl = url;
		this.mObject = mObject;
		this.spiceManager = spiceManager;
		this.currentContext = currentContext;
	}
	
	public void getObjectFromServer(String key){
		Log.d(TAG, "In Get ObjectFromServer");
		getSpiceRequest  = new GetSpiceRequest(mObject, mUrl);
		Log.d(TAG, "In Get ObjectFromServer - after GetSpiceRequest");
		spiceManager.execute(getSpiceRequest, key, NetworkingConstants.ONE_MIN_IN_MILL, new GetRoboSpiceRequestListener(currentContext));
		Log.d(TAG, "In Get ObjectFromServer - after Execute");
	}
	
}
