package cc.raupach.frontend.client;

import java.util.logging.Logger;

/**
 * 
 * @author Oliver Raupach, 30.03.2012
 */
public class ExternalNativeScriptService
{
    private static Logger logger = Logger.getLogger(ExternalNativeScriptService.class.getName());

    /**
     * Die Methode macht interne GWT-Methoden im native-Javascript bekannt.
     * 
     */
    public static native void exportStaticMethod()
    /*-{
          $wnd.numberChangedExternal = $entry(@cc.raupach.frontend.client.ExternalNativeScriptService::numberChangedExternal(Ljava/lang/String;));
    }-*/;
    
    
    public static native void setup()
    /*-{
         $wnd.addCometListener();
     }-*/;
    
    /**
     * Methode wird vom native-JavaScript (cometPush.js) aufgerufen, wenn ueber ActiveMQ eine Meldung kommt.
     * 
     * @param jsonTask
     */
    public static void numberChangedExternal(String jsonTask)
    {
       
    }
}
