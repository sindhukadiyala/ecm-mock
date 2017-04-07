package gov.nih.nci.ecm.mock.rest.service;

import java.util.List;
import java.util.Map;

/**
 * Created by vinodh on 4/6/17.
 */
public interface JMSService {

    Map<String, String> createJMSMessage(List<String> ids);
}
