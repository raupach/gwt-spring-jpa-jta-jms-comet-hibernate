package cc.raupach.frontend.client;

import com.google.gwt.core.client.JavaScriptObject;

public class NumberDtoOverlay extends JavaScriptObject
{
   protected NumberDtoOverlay()
   {
   }
   
   public final native int getNumber() /*-{ return this.number; }-*/;
   
}
