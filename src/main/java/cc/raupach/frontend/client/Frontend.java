package cc.raupach.frontend.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * @author Oliver Raupach, 20.10.2012
 */
public class Frontend implements EntryPoint
{

   private final BackendServiceAsync backendService = GWT.create(BackendService.class);
   
   private Timer timer;
   private boolean running = false;
   private Button startButton;
   private Integer currentSeries = Integer.valueOf(0);

   @Override
   public void onModuleLoad()
   {
      ExternalNativeScriptService.exportStaticMethod();
   
      
      startButton = new Button("Start");
      startButton.addClickHandler(new ClickHandler()
      {
         
         @Override
         public void onClick(ClickEvent event)
         {
            if (!running)
            {
               Double random = new Double ( Math.random() *500000);
               currentSeries = random.intValue();
               timer.scheduleRepeating(3000);
               startButton.setText("Stop");
               running = true;
            }
            else
            {
               timer.cancel();
               running = false;
               startButton.setText("Start");
            }
         }
      });
      
      
      Label counterField = new Label();
      counterField.setText("0");
      
      
      RootPanel.get("nameFieldContainer").add(counterField);
      RootPanel.get("sendButtonContainer").add(startButton);
      
      timer = new Timer()
      {
         
         @Override
         public void run()
         {
            backendService.requestNewRoundTrip(currentSeries, new AsyncCallback<Void>()
            {
               
               @Override
               public void onSuccess(Void result)
               {
               }
               
               @Override
               public void onFailure(Throwable caught)
               {
               }
            });
         }
      };
   }

}
