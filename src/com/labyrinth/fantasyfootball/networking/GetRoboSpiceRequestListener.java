package com.labyrinth.fantasyfootball.networking;





import org.springframework.web.client.HttpServerErrorException;





import android.widget.Toast;


import com.labyrinth.fantasyfootball.fragments.SpiceManagerFragment;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;

public class GetRoboSpiceRequestListener implements RequestListener<GetModelList> {
	private SpiceManagerFragment currentContext;
	public GetRoboSpiceRequestListener(SpiceManagerFragment currentContext){
		this.currentContext = currentContext;
	}

	  @Override
	  public void onRequestFailure(SpiceException spiceException){
		  if(spiceException.getCause() instanceof HttpServerErrorException){
			  HttpServerErrorException exception = (HttpServerErrorException)spiceException.getCause();
			  String errorCode = exception.getResponseBodyAsString();
			  currentContext.networkError(errorCode);
		  }
		  else {
			  Toast.makeText( currentContext.getActivity(), spiceException.getCause().toString(), Toast.LENGTH_SHORT ).show();
		  }
	  }
	
	  @Override
	  public void onRequestSuccess(GetModelList result){
		  Toast.makeText( currentContext.getActivity(), "Network success", Toast.LENGTH_SHORT ).show();
		  currentContext.networkGetSuccess(result);
	  }




}
