package com.labyrinth.fantasyfootball.fragments;













import com.labyrinth.fantasyfootball.networking.GetModelList;
import com.octo.android.robospice.SpiceManager;

import android.app.Fragment;
import android.os.Bundle;




import com.octo.android.robospice.JacksonSpringAndroidSpiceService;

public abstract  class SpiceManagerFragment extends Fragment{
	
    protected SpiceManager spiceManager = new SpiceManager(JacksonSpringAndroidSpiceService.class);
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
	public void onStart() {
        spiceManager.start(getActivity());
        super.onStart();
    }

    @Override
	public void onStop() {
    	if (spiceManager.isStarted()) {
            spiceManager.shouldStop();
        }
        super.onStop();
    }
    
    protected SpiceManager getSpiceManager(){
		return spiceManager;
    }


    
    
    /** Error codes coming back from a NetworkThreader will call this method, 
     *  passing in their error codes. Pop some toast or something on the error string.
     * 
     * @param errorCode
     */

    public abstract void networkError(String errorCode);

   // protected abstract void performRequest(Object ob);

   

	


    
    /** When the NetworkThreader receives a 200 from the server for a GET it will call this method.
     *  The result is an extension of ArrayList and contains a LinkedHashMap of serialized objects 
     *  from the server. Typically we're using this to grab objects from the server, and then 
     *  deserializing them.
     * 
     * @param result
     */
	public abstract void networkGetSuccess(GetModelList result);
	
	/** The network response for a successful POST will call this method. The result is just
	 *  a generic object for now until we know what we'll be getting from the server after a 
	 *  successful POST.
	 * 
	 * @param result
	 */
	public abstract void feedbackSomeThang(Object result);



	

    

}
