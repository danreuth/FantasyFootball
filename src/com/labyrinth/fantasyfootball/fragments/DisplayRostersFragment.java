package com.labyrinth.fantasyfootball.fragments;

import android.os.Bundle;
import android.util.Log;

import com.labyrinth.fantasyfootball.networking.GetModelList;
import com.labyrinth.fantasyfootball.networking.NetworkThreader;
import com.labyrinth.fantasyfootball.networking.NetworkingConstants;

public class DisplayRostersFragment extends SpiceManagerFragment {
	private String TAG = "DisplayRostersFragment";  // Debug TAG
	private NetworkThreader networkThread;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "In onCreate");
		networkThread = new NetworkThreader(NetworkingConstants.GET_ROSTERS_URI, spiceManager, DisplayRostersFragment.this, null);
		networkThread.getObjectFromServer("Get Rosters");
		Log.d(TAG, "In onCreate - after Network Threader Call");
	}

	@Override
	public void networkError(String errorCode) {
		Log.d(TAG, "Network Failure");

	}

	@Override
	public void networkGetSuccess(GetModelList result) {
		Log.d(TAG, "Network Success");

	}

	@Override
	public void feedbackSomeThang(Object result) {
		// TODO Auto-generated method stub

	}

}
