package gov.nih.nci.ecm.mock.rest.service;

import org.apache.cxf.jaxrs.ext.MessageContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by vinodh on 4/6/17.
 */
@Service("jmsServiceSimpleRestEndpoint")
public class JMSRestService {

        private static final String APPLICATION_JSON = "application/json";

        @Autowired
        @Qualifier("jmsServiceProxy")
        private gov.nih.nci.ecm.mock.rest.service.JMSService jmsServiceImpl;

        @Context
        private MessageContext context;

        @POST
        @Path("/createmsg")
        @Produces({ APPLICATION_JSON })
        @Consumes({ APPLICATION_JSON })
        public Response createJMSMessage(List<String> ids) {
            return Response.ok(jmsServiceImpl.createJMSMessage(ids)).build();
        }
        
        @GET
        @Path("/createmsgs")
        @Produces({ APPLICATION_JSON })
        public Response createJMSMessages(@QueryParam("id") List<String> ids) {
            return Response.ok(jmsServiceImpl.createJMSMessage(ids)).build();
        }

}
