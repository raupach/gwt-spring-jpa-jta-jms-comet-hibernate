package cc.raupach.frontend.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * @author Oliver Raupach, 20.10.2012
 */
public class Frontend implements EntryPoint
{

   @Override
   public void onModuleLoad()
   {
      
      Button sendButton = new Button("Start");
      Label nameField = new Label();
      nameField.setText("0");
      
      
      RootPanel.get("nameFieldContainer").add(nameField);
      RootPanel.get("sendButtonContainer").add(sendButton);
   }

}
