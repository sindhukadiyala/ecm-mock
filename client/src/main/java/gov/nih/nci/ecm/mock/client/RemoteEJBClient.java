package gov.nih.nci.ecm.mock.client;

import gov.nih.nci.coppa.services.OrganizationService;
import gov.nih.nci.ecm.mock.dto.Organization;
import gov.nih.nci.ecm.mock.ejb.service.SomeOrganizationService;
import gov.nih.nci.iso21090.Ii;
import gov.nih.nci.services.organization.OrganizationDTO;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

/**
 *
 *
 * @author Vinodh
 */
public class RemoteEJBClient {

    public static final String MODULE_NM = "ecm-mock-server";

    public static void main(String[] args) throws Exception {

        // Invoke a some Organization bean
        invokeSomeOrganizationService();

        // Invoke a Organization bean
        invokeOrganizationService();
    }

    /**
     * Looks up a stateless bean and invokes on it
     *
     * @throws NamingException
     */
    private static void invokeSomeOrganizationService() throws NamingException {
        // Let's lookup the remote stateless calculator
        final SomeOrganizationService orgSvc = lookupRemoteSomeOrganizationService();
        System.out.println("Obtained a remote stateless SomeOrganizationService for invocation");

        Organization org = orgSvc.getOrganization("123");
        System.out.println(org.getId() + " " + org.getName());
    }


    /**
     * Looks up and returns the proxy to remote SomeOrganizationService bean
     *
     * @return
     * @throws NamingException
     */
    private static SomeOrganizationService lookupRemoteSomeOrganizationService() throws NamingException {
        final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        final Context context = new InitialContext(jndiProperties);

        // The JNDI lookup name for a stateless session bean has the syntax of:
        // ejb:<appName>/<moduleName>/<distinctName>/<beanName>!<viewClassName>
        //
        // <appName> The application name is the name of the EAR that the EJB is deployed in
        //           (without the .ear).  If the EJB JAR is not deployed in an EAR then this is
        //           blank.  The app name can also be specified in the EAR's application.xml
        //
        // <moduleName> By the default the module name is the name of the EJB JAR file (without the
        //              .jar suffix).  The module name might be overridden in the ejb-jar.xml
        //
        // <distinctName> : AS7 allows each deployment to have an (optional) distinct name.
        //                  This example does not use this so leave it blank.
        //
        // <beanName>     : The name of the session been to be invoked.
        //
        // <viewClassName>: The fully qualified classname of the remote interface.  Must include
        //                  the whole package name.

        // let's do the lookup
        return (SomeOrganizationService) context.lookup(
                "ejb:ecm-mock/" + MODULE_NM + "/SomeOrganizationServiceBean!" + SomeOrganizationService.class.getName()
        );
    }

    /**
     * Looks up a stateless bean and invokes on it
     *
     * @throws NamingException
     */
    private static void invokeOrganizationService() throws Exception {
        // Let's lookup the remote stateless calculator
        final OrganizationService orgSvc = lookupRemoteOrganizationService();
        System.out.println("Obtained a remote stateless OrganizationService for invocation");

        Ii ii = new Ii();
        ii.setExtension("FL388");
        OrganizationDTO org = orgSvc.getOrganizationById(ii);
        System.out.println(org.getIdentifier() + " " + org.getName());
    }


    /**
     * Looks up and returns the proxy to remote SomeOrganizationService bean
     *
     * @return
     * @throws NamingException
     */
    private static OrganizationService lookupRemoteOrganizationService() throws NamingException {
        final Hashtable jndiProperties = new Hashtable();

        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");

        /*
        jndiProperties.put(InitialContext.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        jndiProperties.put(InitialContext.PROVIDER_URL, "remote://localhost:4447");
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        */
        final Context context = new InitialContext(jndiProperties);

        // The JNDI lookup name for a stateless session bean has the syntax of:
        // ejb:<appName>/<moduleName>/<distinctName>/<beanName>!<viewClassName>
        //
        // <appName> The application name is the name of the EAR that the EJB is deployed in
        //           (without the .ear).  If the EJB JAR is not deployed in an EAR then this is
        //           blank.  The app name can also be specified in the EAR's application.xml
        //
        // <moduleName> By the default the module name is the name of the EJB JAR file (without the
        //              .jar suffix).  The module name might be overridden in the ejb-jar.xml
        //
        // <distinctName> : AS7 allows each deployment to have an (optional) distinct name.
        //                  This example does not use this so leave it blank.
        //
        // <beanName>     : The name of the session been to be invoked.
        //
        // <viewClassName>: The fully qualified classname of the remote interface.  Must include
        //                  the whole package name.

        // let's do the lookup
        return (OrganizationService) context.lookup(
                "ejb:ecm-mock/" + MODULE_NM + "/OrganizationServiceBean!" + OrganizationService.class.getName()
        );
    }
}
