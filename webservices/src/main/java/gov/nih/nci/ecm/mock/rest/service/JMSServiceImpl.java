package gov.nih.nci.ecm.mock.rest.service;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by vinodh on 4/6/17.
 */

@Service("simpleJMSService")
public class JMSServiceImpl implements JMSService {

    @Override
    public String createJMSMessage(List<String> ids) {
        System.out.println(ids);
        //TODO: construct jms message based on xmls for these ids and publish in JMS topic
        return "success";
    }
}
