package gov.nih.nci.ecm.mock.ejb.service;

import static java.lang.String.format;
import gov.nih.nci.common.exceptions.CTEPEntException;
import gov.nih.nci.coppa.services.PersonService;
import gov.nih.nci.ecm.mock.dto.CTEPClincalResearchStaffDTO;
import gov.nih.nci.ecm.mock.dto.CTEPHealthCareProviderDTO;
import gov.nih.nci.ecm.mock.dto.CTEPPersonDTO;
import gov.nih.nci.ecm.mock.util.DTOToDomainConverter;
import gov.nih.nci.iso21090.EnPn;
import gov.nih.nci.iso21090.Ii;
import gov.nih.nci.services.correlation.ClinicalResearchStaffDTO;
import gov.nih.nci.services.correlation.HealthCareProviderDTO;
import gov.nih.nci.services.correlation.IdentifiedPersonDTO;
import gov.nih.nci.services.person.PersonDTO;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

/**
 * Created by vinodh on 4/5/17.
 */
@Stateless(name = "PersonService")
@Remote(PersonService.class)
public class PersonServiceBean implements PersonService {
    
    private static final Logger LOG = Logger.getLogger(PersonServiceBean.class);

    String dataDir = System.getProperty("ECM_MOCK_DATA_DIR");

    @Override
    public PersonDTO getPersonById(Ii ii) throws CTEPEntException {
        String id = ii.getExtension();
        String json = null;
        InputStream is = null;
        try {
            is = new FileInputStream(dataDir + "/person/" + id + ".json");
            json = IOUtils.toString(is);
            
            CTEPPersonDTO dto1 = DTOToDomainConverter.unmarshallJSON(json, CTEPPersonDTO.class);
            PersonDTO dto = DTOToDomainConverter.convert(dto1);
            
            EnPn name = dto.getName().clone();
            dto.setName(name);
            return dto;
        } catch (Exception e) {
            LOG.warn(format("getPersonById failed for %s:", id), e); 
            throw new CTEPEntException(1, e.getMessage());
        } finally {
            IOUtils.closeQuietly(is);
        }
    }

    @Override
    public List getPersonByCriteria(PersonDTO ii) throws CTEPEntException {
        throw new UnsupportedOperationException("getPersonByCriteria");
    }

    @Override
    public ClinicalResearchStaffDTO getClinicalResearchStaffByPlayerId(Ii ii) throws CTEPEntException {
        String id = ii.getExtension();
        String json = null;
        InputStream is = null;
        try {
            is = new FileInputStream(dataDir + "/crs/" + id + ".json");
            json = IOUtils.toString(is);

            CTEPClincalResearchStaffDTO dto1 = DTOToDomainConverter.unmarshallJSON(json, CTEPClincalResearchStaffDTO.class);
            ClinicalResearchStaffDTO dto = DTOToDomainConverter.convert(dto1);
            
            return dto;
        } catch (Exception e) {
            LOG.warn(format("getClinicalResearchStaffByPlayerId failed for %s:", id), e);
            throw new CTEPEntException(1, e.getMessage());
        } finally {
            IOUtils.closeQuietly(is);
        }
    }

    @Override
    public HealthCareProviderDTO getHealthCareProviderByPlayerId(Ii ii) throws CTEPEntException {
        String id = ii.getExtension();
        String json = null;
        InputStream is = null;
        try {
            is = new FileInputStream(dataDir + "/hcp-player/" + id + ".json");
            json = IOUtils.toString(is);
           
            CTEPHealthCareProviderDTO dto1 = DTOToDomainConverter.unmarshallJSON(json, CTEPHealthCareProviderDTO.class);
            HealthCareProviderDTO dto = DTOToDomainConverter.convert(dto1);
                    
            return dto;
        } catch (Exception e) {
            LOG.warn(format("getHealthCareProviderByPlayerId failed for %s:", id), e);
            throw new CTEPEntException(1, e.getMessage());
        } finally {
            IOUtils.closeQuietly(is);
        }
    }

    @Override
    public HealthCareProviderDTO getHealthCareProviderByRoleId(Ii ii) throws CTEPEntException {
        String id = ii.getExtension();
        String json = null;
        InputStream is = null;
        try {
            is = new FileInputStream(dataDir + "/hcp-role/" + id + ".json");
            json = IOUtils.toString(is);
            
            CTEPHealthCareProviderDTO dto1 = DTOToDomainConverter.unmarshallJSON(json, CTEPHealthCareProviderDTO.class);
            HealthCareProviderDTO dto = DTOToDomainConverter.convert(dto1);
            
            return dto;
        } catch (Exception e) {
            LOG.warn(format("getHealthCareProviderByRoleId failed for %s:", id), e);
            throw new CTEPEntException(1, e.getMessage());
        } finally {
            IOUtils.closeQuietly(is);
        }
    }

    @Override
    public IdentifiedPersonDTO getIdentifiedPersonById(Ii ii) throws CTEPEntException {
        String id = ii.getExtension();
        String json = null;
        InputStream is = null;
        try {
            is = new FileInputStream(dataDir + "/idp/" + id + ".json");
            json = IOUtils.toString(is);
            return DTOToDomainConverter.unmarshallJSON(json, IdentifiedPersonDTO.class);
        } catch (Exception e) {
            LOG.warn(format("getIdentifiedPersonById failed for %s:", id), e);
            throw new CTEPEntException(1, e.getMessage());
        } finally {
            IOUtils.closeQuietly(is);
        }
    }
}
