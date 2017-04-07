package gov.nih.nci.ecm.mock.ejb.service;

import gov.nih.nci.common.exceptions.CTEPEntException;
import gov.nih.nci.coppa.domain.Organization;
import gov.nih.nci.coppa.services.*;
import gov.nih.nci.ecm.mock.util.JsonMapper;
import gov.nih.nci.iso21090.EnOn;
import gov.nih.nci.iso21090.Ii;
import gov.nih.nci.services.correlation.HealthCareFacilityDTO;
import gov.nih.nci.services.correlation.ResearchOrganizationDTO;
import gov.nih.nci.services.organization.OrganizationDTO;
import org.apache.commons.io.IOUtils;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

/**
 * Created by vinodh on 4/4/17.
 */
@Stateless(name = "OrganizationService")
@Remote(OrganizationService.class)
public class OrganizationServiceBean implements OrganizationService {

    JsonMapper mapper = new JsonMapper();

    String dataDir = System.getProperty("ECM_MOCK_DATA_DIR");

    @Override
    public OrganizationDTO getOrganizationById(Ii ii) throws CTEPEntException {
        String id = ii.getExtension();
        String json = null;
        InputStream is = null;
        try {
            is = new FileInputStream(dataDir + "/org/" + id + ".json");
            json =IOUtils.toString(is);
            OrganizationDTO dto = mapper.convertToObject(json, OrganizationDTO.class);
            EnOn name = dto.getName().clone();
            dto.setName(name);
            return dto;
        } catch (Exception e) {
            throw new CTEPEntException(1, e.getMessage());
        } finally {
            IOUtils.closeQuietly(is);
        }
    }

    @Override
    public List<OrganizationDTO> getOrganizationsByCriteria(OrganizationDTO organizationDTO) throws CTEPEntException {
        return null;
    }

    @Override
    public List<Organization> getOrganizationsByCriteria(Organization organization) throws CTEPEntException {
        return null;
    }

    @Override
    public HealthCareFacilityDTO getHealthCareFacility(Ii ii) throws CTEPEntException {
        String id = ii.getExtension();
        String json = null;
        try {
            json =IOUtils.toString(new FileInputStream(dataDir + "/hcf/" + id + ".json"));
            HealthCareFacilityDTO dto = mapper.convertToObject(json, HealthCareFacilityDTO.class);
            EnOn name = dto.getName().clone();
            dto.setName(name);
            return dto;
        } catch (Exception e) {
            throw new CTEPEntException(1, e.getMessage());
        }
    }

    @Override
    public ResearchOrganizationDTO getResearchOrganization(Ii ii) throws CTEPEntException {
        String id = ii.getExtension();
        String json = null;
        try {
            json =IOUtils.toString(new FileInputStream(dataDir + "/resorg/" + id + ".json"));
            ResearchOrganizationDTO dto = mapper.convertToObject(json, ResearchOrganizationDTO.class);
            EnOn name = dto.getName().clone();
            dto.setName(name);
            return dto;
        } catch (Exception e) {
            throw new CTEPEntException(1, e.getMessage());
        }
    }
}
