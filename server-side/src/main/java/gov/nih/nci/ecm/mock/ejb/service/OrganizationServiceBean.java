package gov.nih.nci.ecm.mock.ejb.service;

import gov.nih.nci.common.exceptions.CTEPEntException;
import gov.nih.nci.coppa.domain.Organization;
import gov.nih.nci.coppa.services.*;
import gov.nih.nci.ecm.mock.dto.CTEPHealthcareFacilityDTO;
import gov.nih.nci.ecm.mock.dto.CTEPOrganizationDTO;
import gov.nih.nci.ecm.mock.dto.CTEPResearchOrganizationDTO;
import gov.nih.nci.ecm.mock.util.DTOToDomainConverter;
import gov.nih.nci.iso21090.DSet;
import gov.nih.nci.iso21090.EnOn;
import gov.nih.nci.iso21090.Ii;
import gov.nih.nci.services.correlation.HealthCareFacilityDTO;
import gov.nih.nci.services.correlation.ResearchOrganizationDTO;
import gov.nih.nci.services.organization.OrganizationDTO;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import static java.lang.String.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

/**
 * Created by vinodh on 4/4/17.
 */
@Stateless(name = "OrganizationService")
@Remote(OrganizationService.class)
public class OrganizationServiceBean implements OrganizationService {

    private static final Logger LOG = Logger.getLogger(PersonServiceBean.class);

    String dataDir = System.getProperty("ECM_MOCK_DATA_DIR");

    @Override
    public OrganizationDTO getOrganizationById(Ii ii) throws CTEPEntException {
        String id = ii.getExtension();
        String json = null;
        InputStream is = null;
        try {
            is = new FileInputStream(dataDir + "/org/" + id + ".json");
            json = IOUtils.toString(is);
            
            CTEPOrganizationDTO dto1 = DTOToDomainConverter.unmarshallJSON(json, CTEPOrganizationDTO.class);
            OrganizationDTO dto = DTOToDomainConverter.convert(dto1);
            
            EnOn name = dto.getName().clone();
            dto.setName(name);
            return dto;
        } catch (Exception e) {
            LOG.warn(format("getOrganizationById failed for %s:", id), e);
            throw new CTEPEntException(1, e.getMessage());
        } finally {
            IOUtils.closeQuietly(is);
        }
    }

    @Override
    public List<OrganizationDTO> getOrganizationsByCriteria(OrganizationDTO organizationDTO) throws CTEPEntException {
        throw new UnsupportedOperationException("getOrganizationsByCriteria");
    }

    @Override
    public List<Organization> getOrganizationsByCriteria(Organization organization) throws CTEPEntException {
        throw new UnsupportedOperationException("getOrganizationsByCriteria");
    }

    @Override
    public HealthCareFacilityDTO getHealthCareFacility(Ii ii) throws CTEPEntException {
        String id = ii.getExtension();
        String json = null;
        InputStream is = null;
        try {
            is = new FileInputStream(dataDir + "/hcf/" + id + ".json");
            json = IOUtils.toString(is);
            
            CTEPHealthcareFacilityDTO dto1 = DTOToDomainConverter.unmarshallJSON(json, CTEPHealthcareFacilityDTO.class);
            HealthCareFacilityDTO dto = DTOToDomainConverter.convert(dto1);
            
            EnOn name = dto.getName().clone();
            dto.setName(name);
            DSet pa = dto.getPostalAddress().clone();
            dto.setPostalAddress(pa);
            return dto;
        } catch (Exception e) {
            LOG.warn(format("getHealthCareFacility failed for %s:", id), e);
            throw new CTEPEntException(1, e.getMessage());
        } finally {
            IOUtils.closeQuietly(is);
        }
    }

    @Override
    public ResearchOrganizationDTO getResearchOrganization(Ii ii) throws CTEPEntException {
        String id = ii.getExtension();
        String json = null;
        InputStream is = null;
        try {
            is = new FileInputStream(dataDir + "/resorg/" + id + ".json");
            json = IOUtils.toString(is);
            
            CTEPResearchOrganizationDTO dto1 = DTOToDomainConverter.unmarshallJSON(json, CTEPResearchOrganizationDTO.class);
            ResearchOrganizationDTO dto = DTOToDomainConverter.convert(dto1);
            
            EnOn name = dto.getName().clone();
            dto.setName(name);
            return dto;
        } catch (Exception e) {
            LOG.warn(format("getResearchOrganization failed for %s:", id), e);
            throw new CTEPEntException(1, e.getMessage());
        } finally {
            IOUtils.closeQuietly(is);
        }
    }
}
