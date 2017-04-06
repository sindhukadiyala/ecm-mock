package gov.nih.nci.ecm.mock.rest.service;

import gov.nih.nci.ecm.mock.rest.dto.Build;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by vinodh on 4/6/17.
 */
@Service("simpleBuildService")
public class BuildServiceImpl implements BuildService {

    @Override
    public Build getBuildInfo() {
        Build b = new Build();
        b.setEnvironment("Development - local");
        b.setServer("localhost");
        b.setVersionNumber("1.0");
        b.setBuiltDate(new Date().toString());
        return b;
    }
}
