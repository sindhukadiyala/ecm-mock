package gov.nih.nci.ecm.mock.util;

import gov.nih.nci.ecm.mock.dto.CTEPClincalResearchStaffDTO;
import gov.nih.nci.ecm.mock.dto.CTEPHealthCareProviderDTO;
import gov.nih.nci.ecm.mock.dto.CTEPHealthcareFacilityDTO;
import gov.nih.nci.ecm.mock.dto.CTEPOrganizationDTO;
import gov.nih.nci.ecm.mock.dto.CTEPPersonDTO;
import gov.nih.nci.ecm.mock.dto.CTEPResearchOrganizationDTO;
import gov.nih.nci.services.correlation.ClinicalResearchStaffDTO;
import gov.nih.nci.services.correlation.HealthCareFacilityDTO;
import gov.nih.nci.services.correlation.HealthCareProviderDTO;
import gov.nih.nci.services.correlation.ResearchOrganizationDTO;
import gov.nih.nci.services.organization.OrganizationDTO;
import gov.nih.nci.services.person.PersonDTO;

import org.codehaus.jackson.map.ObjectMapper;

public class DTOToDomainConverter {
	
	  /**
     * 
     * @param jsonString the jsonString
     * @param <T> the <T>
     * @param objClass the objClass
     * @return the Object for the JSONString
     */
    public static <T> T unmarshallJSON(String jsonString, Class<T> objClass) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            // JSON from String to Object
             return (mapper.readValue(jsonString, objClass));

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

	public static HealthCareProviderDTO convert(
			CTEPHealthCareProviderDTO ecmMsHCPDTO) {
		HealthCareProviderDTO localHCPDTO = new HealthCareProviderDTO();
		localHCPDTO.setDuplicateOf(ecmMsHCPDTO.getDuplicateOf());
		localHCPDTO.setIdentifier(ecmMsHCPDTO.getIdentifier());
		localHCPDTO.setPlayerIdentifier(ecmMsHCPDTO.getPlayerIdentifier());
		localHCPDTO.setPostalAddress(ecmMsHCPDTO.getPostalAddress());
		localHCPDTO.setScoperIdentifier(ecmMsHCPDTO.getScoperIdentifier());
		localHCPDTO.setStatus(ecmMsHCPDTO.getStatus());
		localHCPDTO.setTelecomAddress(ecmMsHCPDTO.getTelecomAddress());
		localHCPDTO.setCertificateLicenseText(ecmMsHCPDTO
				.getCertificateLicenseText());

		return localHCPDTO;
	}
	
	public static PersonDTO convert(
            CTEPPersonDTO ecmMsPersonDTO) {
        PersonDTO localPersonDTO = new PersonDTO();
        localPersonDTO.setIdentifier(ecmMsPersonDTO.getIdentifier());
        localPersonDTO.setBirthDate(ecmMsPersonDTO.getBirthDate());
        localPersonDTO.setEthnicGroupCode(ecmMsPersonDTO.getEthnicGroupCode());
        localPersonDTO.setName(ecmMsPersonDTO.getName());
        localPersonDTO.setPostalAddress(ecmMsPersonDTO.getPostalAddress());
        localPersonDTO.setRaceCode(ecmMsPersonDTO.getRaceCode());
        localPersonDTO.setSexCode(ecmMsPersonDTO.getSexCode());
        localPersonDTO.setStatusCode(ecmMsPersonDTO.getStatusCode());
        localPersonDTO.setTelecomAddress(ecmMsPersonDTO.getTelecomAddress());

        return localPersonDTO;
    }
	
	 public static ClinicalResearchStaffDTO convert(
	           CTEPClincalResearchStaffDTO ecmMsCRSDTO) {
	       ClinicalResearchStaffDTO localCRSDTO = new ClinicalResearchStaffDTO();
	       localCRSDTO.setDuplicateOf(ecmMsCRSDTO.getDuplicateOf());
	       localCRSDTO.setIdentifier(ecmMsCRSDTO.getIdentifier());
	       localCRSDTO.setPlayerIdentifier(ecmMsCRSDTO.getPlayerIdentifier());
	       localCRSDTO.setPostalAddress(ecmMsCRSDTO.getPostalAddress());
	       localCRSDTO.setScoperIdentifier(ecmMsCRSDTO.getScoperIdentifier());
	       localCRSDTO.setStatus(ecmMsCRSDTO.getStatus());
	       localCRSDTO.setTelecomAddress(ecmMsCRSDTO.getTelecomAddress());
	       
	       return localCRSDTO;
	 }
	 
	 public static OrganizationDTO convert(
             CTEPOrganizationDTO ecmMsOrganizationDTO) {
         OrganizationDTO localOrganizationDTO = new OrganizationDTO();
         localOrganizationDTO.setIdentifier(ecmMsOrganizationDTO.getIdentifier());
         localOrganizationDTO.setName(ecmMsOrganizationDTO.getName());
         localOrganizationDTO.setStatusDate(ecmMsOrganizationDTO
                 .getStatusDate());
         localOrganizationDTO.setStatusCode(ecmMsOrganizationDTO
                 .getStatusCode());
         localOrganizationDTO.setPostalAddress(ecmMsOrganizationDTO
                 .getPostalAddress());
         localOrganizationDTO.setTelecomAddress(ecmMsOrganizationDTO
                 .getTelecomAddress());
         localOrganizationDTO
                 .setFamilyOrganizationRelationships(ecmMsOrganizationDTO
                         .getFamilyOrganizationRelationships());

         return localOrganizationDTO;
     }
	 
	 public static HealthCareFacilityDTO convert(
             CTEPHealthcareFacilityDTO ecmMsHealthcareFacilityDTO) {
         HealthCareFacilityDTO localHealthcareFacilityDTO = new HealthCareFacilityDTO();
         localHealthcareFacilityDTO.setIdentifier(ecmMsHealthcareFacilityDTO
                 .getIdentifier());
         localHealthcareFacilityDTO
                 .setName(ecmMsHealthcareFacilityDTO.getName());
         localHealthcareFacilityDTO.setStatus(ecmMsHealthcareFacilityDTO
                 .getStatus());
         localHealthcareFacilityDTO.setPostalAddress(ecmMsHealthcareFacilityDTO
                 .getPostalAddress());
         localHealthcareFacilityDTO.setTelecomAddress(ecmMsHealthcareFacilityDTO
                 .getTelecomAddress());
         localHealthcareFacilityDTO.setDuplicateOf(ecmMsHealthcareFacilityDTO
                 .getDuplicateOf());
         localHealthcareFacilityDTO
                 .setPlayerIdentifier(ecmMsHealthcareFacilityDTO
                         .getPlayerIdentifier());

         return localHealthcareFacilityDTO;
     }
	 
	 public static ResearchOrganizationDTO convert(
             CTEPResearchOrganizationDTO ecmMsRearchOrganizationDTO) {
         ResearchOrganizationDTO researchOrganizationDTO = new ResearchOrganizationDTO();
         researchOrganizationDTO.setIdentifier(ecmMsRearchOrganizationDTO
                 .getIdentifier());
         researchOrganizationDTO.setName(ecmMsRearchOrganizationDTO.getName());
         researchOrganizationDTO.setStatus(ecmMsRearchOrganizationDTO
                 .getStatus());
         researchOrganizationDTO.setPostalAddress(ecmMsRearchOrganizationDTO
                 .getPostalAddress());
         researchOrganizationDTO.setTelecomAddress(ecmMsRearchOrganizationDTO
                 .getTelecomAddress());
         researchOrganizationDTO.setDuplicateOf(ecmMsRearchOrganizationDTO
                 .getDuplicateOf());
         researchOrganizationDTO.setPlayerIdentifier(ecmMsRearchOrganizationDTO
                 .getPlayerIdentifier());
         researchOrganizationDTO.setTypeCode(ecmMsRearchOrganizationDTO
                 .getTypeCode());
         researchOrganizationDTO.setFundingMechanism(ecmMsRearchOrganizationDTO
                 .getFundingMechanism());

         return researchOrganizationDTO;
     }

}
