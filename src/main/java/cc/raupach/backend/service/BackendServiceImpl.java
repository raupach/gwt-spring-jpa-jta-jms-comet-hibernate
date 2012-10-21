package cc.raupach.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import cc.raupach.frontend.client.BackendService;

/**
 * @author Oliver Raupach, 21.10.2012
 */
public class BackendServiceImpl extends RemoteServiceServlet implements BackendService
{

   private static final long serialVersionUID = 182103338416964691L;
   private static final Logger logger = LoggerFactory.getLogger(BackendServiceImpl.class);
   
   
   private BackendServiceFacade getBackendServiceFacade ()
   {
       ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
       BackendServiceFacade backendServiceFacade = (BackendServiceFacade) context.getBean("BackendServiceFacade");
       
       return backendServiceFacade;
   }
   
   @Override
   public void requestNewRoundTrip(Integer number)
   {
      logger.info("----------- GWT RPC -----------> requestNewRoundTrip");
      BackendServiceFacade backendServiceFacade = getBackendServiceFacade();
      backendServiceFacade.requestNewRoundTrip(number);
   }

   
}
