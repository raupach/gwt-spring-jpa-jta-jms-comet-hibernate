package cc.raupach.frontend.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>BackendService</code>.
 */
public interface BackendServiceAsync
{

   void requestNewRoundTrip(Integer series, AsyncCallback<Void> callback);
  
}
