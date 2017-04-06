package gov.nih.nci.ecm.mock.rest.service;

import java.util.List;

/**
 * Created by vinodh on 4/6/17.
 */
public interface JMSService {

    String createJMSMessage(List<String> ids);
}
