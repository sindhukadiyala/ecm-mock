package gov.nih.nci.ecm.mock.ejb.service;

import gov.nih.nci.common.exceptions.CTEPEntException;
import gov.nih.nci.coppa.services.PersonService;
import gov.nih.nci.ecm.mock.util.JsonMapper;
import gov.nih.nci.iso21090.Ii;
import gov.nih.nci.services.correlation.ClinicalResearchStaffDTO;
import gov.nih.nci.services.correlation.HealthCareProviderDTO;
import gov.nih.nci.services.correlation.IdentifiedPersonDTO;
import gov.nih.nci.services.person.PersonDTO;
import org.apache.commons.io.IOUtils;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.io.FileInputStream;
import java.util.List;

/**
 * Created by vinodh on 4/5/17.
 */
@Stateless
@Remote(PersonService.class)
public class PersonServiceBean implements PersonService {

    JsonMapper mapper = new JsonMapper();

    String dataDir = System.getProperty("ECM_MOCK_DATA_DIR");
    //    String dataDir = "/Users/vinodh/sb/projects/ctrp-modern/ejb-remote/data";

    @Override
    public PersonDTO getPersonById(Ii ii) throws CTEPEntException {
        String id = ii.getExtension();
        String json = null;
        try {
            json = IOUtils.toString(new FileInputStream(dataDir + "/person/" + id + ".json"));
            return mapper.convertToObject(json, PersonDTO.class);
        } catch (Exception e) {
            throw new CTEPEntException(1, e.getMessage());
        }
    }

    @Override
    public List getPersonByCriteria(PersonDTO ii) throws CTEPEntException {
        return null;
    }

    @Override
    public ClinicalResearchStaffDTO getClinicalResearchStaffByPlayerId(Ii ii) throws CTEPEntException {
        String id = ii.getExtension();
        String json = null;
        try {
            json = IOUtils.toString(new FileInputStream(dataDir + "/crs/" + id + ".json"));
            return mapper.convertToObject(json, ClinicalResearchStaffDTO.class);
        } catch (Exception e) {
            throw new CTEPEntException(1, e.getMessage());
        }
    }

    @Override
    public HealthCareProviderDTO getHealthCareProviderByPlayerId(Ii ii) throws CTEPEntException {
        String id = ii.getExtension();
        String json = null;
        try {
            json = IOUtils.toString(new FileInputStream(dataDir + "/hcp-player/" + id + ".json"));
            return mapper.convertToObject(json, HealthCareProviderDTO.class);
        } catch (Exception e) {
            throw new CTEPEntException(1, e.getMessage());
        }
    }

    @Override
    public HealthCareProviderDTO getHealthCareProviderByRoleId(Ii ii) throws CTEPEntException {
        String id = ii.getExtension();
        String json = null;
        try {
            json = IOUtils.toString(new FileInputStream(dataDir + "/hcp-role/" + id + ".json"));
            return mapper.convertToObject(json, HealthCareProviderDTO.class);
        } catch (Exception e) {
            throw new CTEPEntException(1, e.getMessage());
        }
    }

    @Override
    public IdentifiedPersonDTO getIdentifiedPersonById(Ii ii) throws CTEPEntException {
        String id = ii.getExtension();
        String json = null;
        try {
            json = IOUtils.toString(new FileInputStream(dataDir + "/idp/" + id + ".json"));
            return mapper.convertToObject(json, IdentifiedPersonDTO.class);
        } catch (Exception e) {
            throw new CTEPEntException(1, e.getMessage());
        }
    }
}
