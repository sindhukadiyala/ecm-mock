package gov.nih.nci.ecm.mock.rest.service;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

/**
 * Created by vinodh on 4/6/17.
 */

@Service("simpleJMSService")
public class JMSServiceImpl implements JMSService {

    // Set up all the default values
    private static final String DEFAULT_CONNECTION_FACTORY = "java:/ECMMockConnectionFactory";
    private static final String DEFAULT_DESTINATION = "java:/topic/ECMMockTopic";
    private static final String DEFAULT_MESSAGE_COUNT = "1";
    private static final String DEFAULT_USERNAME = "";
    private static final String DEFAULT_PASSWORD = "";
    private static final String INITIAL_CONTEXT_FACTORY = "org.jboss.naming.remote.client.InitialContextFactory";
    private static final String PROVIDER_URL = "remote://localhost:31699";
    
    String dataDir = System.getProperty("ECM_MOCK_DATA_DIR");

    private ConnectionFactory getConnectionFactory(Context context) throws NamingException {
        // Perform the JNDI lookups
        String connectionFactoryString = System.getProperty("connection.factory", DEFAULT_CONNECTION_FACTORY);
        System.out.println("Attempting to acquire connection factory \"" + connectionFactoryString + "\"");
        ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup(connectionFactoryString);
        System.out.println("Found connection factory \"" + connectionFactoryString + "\" in JNDI");

        return connectionFactory;
    }

    private Context getContext() throws NamingException {
        // Set up the context for the JNDI lookup
//        final Properties env = new Properties();
//        env.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
//        env.put(Context.PROVIDER_URL, System.getProperty(Context.PROVIDER_URL, PROVIDER_URL));
        //env.put(Context.SECURITY_PRINCIPAL, System.getProperty("username", DEFAULT_USERNAME));
        //env.put(Context.SECURITY_CREDENTIALS, System.getProperty("password", DEFAULT_PASSWORD));
        // required for jboss
//        env.put("jboss.naming.client.ejb.context", "true");
        //return new InitialContext(env);
        return new InitialContext();

        /*
        final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        final Context context = new InitialContext(jndiProperties);
        return context;*/
    }

    private Destination getDestination(Context context) throws NamingException {
        String destinationString = System.getProperty("destination", DEFAULT_DESTINATION);
        System.out.println("Attempting to acquire destination \"" + destinationString + "\"");
        Destination destination = (Destination) context.lookup(destinationString);
        System.out.println("Found destination \"" + destinationString + "\" in JNDI");

        return destination;
    }

    @Override
    public Map<String, String> createJMSMessage(List<String> ids) {
        //TODO: construct jms message based on xmls for these ids and publish in JMS topic
        Context context = null;
        Connection connection = null;
        
        Map<String, String> results = new HashMap<String, String>();
        
        try {
            context = getContext();
            ConnectionFactory connectionFactory = getConnectionFactory(context);
            Destination destination = getDestination(context);

            // Create the JMS connection, session, producer, and consumer
            connection = connectionFactory.createConnection(System.getProperty("username", DEFAULT_USERNAME), System.getProperty("password", DEFAULT_PASSWORD));
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(destination);
//            MessageConsumer consumer = session.createConsumer(destination);
            connection.start();
            
            for(String id : ids) {
                InputStream is = null;
                try {
                    is = new FileInputStream(dataDir + "/jms/" + id + ".xml");
                    String xml = IOUtils.toString(is);
                    Message message = session.createTextMessage(xml);
                    producer.send(message);
                    results.put(id, "sent " + message.getJMSMessageID());
                } catch (Exception e) {
                    results.put(id, e.toString());
                } finally {
                    IOUtils.closeQuietly(is);
                }
            }
//
//            TextMessage message2 = (TextMessage) consumer.receive(5000);
//            System.out.println("Received message with content " + message2.getText());

        } catch (Exception ex) {
            ex.printStackTrace();
            results.put("error", ex.toString());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }

            if (context != null) {
                try {
                    context.close();
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
        }

        return results;
    }
}
