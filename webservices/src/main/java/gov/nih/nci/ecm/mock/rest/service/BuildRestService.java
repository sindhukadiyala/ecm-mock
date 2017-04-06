package gov.nih.nci.ecm.mock.rest.service;

import org.apache.cxf.jaxrs.ext.MessageContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

/**
 * Created by vinodh on 4/6/17.
 */
@Service("buildServiceSimpleRestEndpoint")
public class BuildRestService {


    private static final String APPLICATION_JSON = "application/json";

    @Autowired
    @Qualifier("buildServiceProxy")
    private gov.nih.nci.ecm.mock.rest.service.BuildService buildServiceImpl;

    @Context
    private MessageContext context;

    @GET
    @Path("/build")
    @Produces({ APPLICATION_JSON })
    @Consumes({ APPLICATION_JSON })
    public Response getBuildInfo() {
        return Response.ok(buildServiceImpl.getBuildInfo()).build();
    }
}
