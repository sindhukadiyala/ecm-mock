package gov.nih.nci.ecm.mock.dto;

import gov.nih.nci.iso21090.Ad;
import gov.nih.nci.iso21090.Ii;
import gov.nih.nci.iso21090.Tel;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.gson.Gson;

/**
 * The Class CTEPResearchOrganizationDTO.
 *
 * @author Ramakrishna Gundala
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_EMPTY)
public class CTEPResearchOrganizationDTO {

    /**
     * Instantiates a new CTEP healthcare facility DTO.
     */
    public CTEPResearchOrganizationDTO() {
        super();
    }

    /**
     * Instantiates a new CTEP Research Organization DTO.
     *
     * @param ctepResearchOrganizationJSON
     *            the CTEP Research Organization JSON
     */
    public CTEPResearchOrganizationDTO(String ctepResearchOrganizationJSON) {
        Gson gson = new Gson();
        CTEPResearchOrganizationDTO dto = gson
                .fromJson(ctepResearchOrganizationJSON,
                        CTEPResearchOrganizationDTO.class);
        this.duplicateOf = dto.getDuplicateOf();
        this.playerIdentifier = dto.getPlayerIdentifier();
        this.identifier = dto.getIdentifier();
        this.name = dto.getName();
        this.postalAddress = dto.getPostalAddress();
        this.status = dto.getStatus();
        this.telecomAddress = dto.getTelecomAddress();
        this.fundingMechanism = dto.getFundingMechanism();
        this.typeCode = dto.getTypeCode();
    }

    /**
     * Gets the type code.
     *
     * @return the type code
     */
    public gov.nih.nci.iso21090.Cd getTypeCode() {
        return typeCode;
    }

    /**
     * Sets the type code.
     *
     * @param typeCode
     *            the new type code
     */
    public void setTypeCode(gov.nih.nci.iso21090.Cd typeCode) {
        this.typeCode = typeCode;
    }

    /**
     * Gets the funding mechanism.
     *
     * @return the funding mechanism
     */
    public gov.nih.nci.iso21090.Cd getFundingMechanism() {
        return fundingMechanism;
    }

    /**
     * Sets the funding mechanism.
     *
     * @param fundingMechanism
     *            the new funding mechanism
     */
    public void setFundingMechanism(gov.nih.nci.iso21090.Cd fundingMechanism) {
        this.fundingMechanism = fundingMechanism;
    }

    /** The duplicate of. */
    @JsonProperty("duplicateOf")
    private gov.nih.nci.iso21090.Ii duplicateOf;

    /** The player identifier. */
    @JsonProperty("playerIdentifier")
    private gov.nih.nci.iso21090.Ii playerIdentifier;

    /** The m identifier. */
    @JsonProperty("identifier")
    private gov.nih.nci.iso21090.DSet<Ii> identifier;

    /** The name. */
    @JsonProperty("name")
    private gov.nih.nci.iso21090.EnOn name;

    /** The m postal address. */
    @JsonProperty("postalAddress")
    private gov.nih.nci.iso21090.DSet<Ad> postalAddress;

    /** The m status. */
    @JsonProperty("status")
    private gov.nih.nci.iso21090.Cd status;

    /** The m telecom address. */
    @JsonProperty("telecomAddress")
    private gov.nih.nci.iso21090.DSet<Tel> telecomAddress;

    /** The type code. */
    @JsonProperty("typeCode")
    private gov.nih.nci.iso21090.Cd typeCode;

    /** The funding mechanism. */
    @JsonProperty("fundingMechanism")
    private gov.nih.nci.iso21090.Cd fundingMechanism;
    
    /**
     * Gets the duplicate of.
     *
     * @return the duplicate of
     */
    public gov.nih.nci.iso21090.Ii getDuplicateOf() {
        return duplicateOf;
    }

    /**
     * Sets the duplicate of.
     *
     * @param duplicateOf
     *            the new duplicate of
     */
    public void setDuplicateOf(gov.nih.nci.iso21090.Ii duplicateOf) {
        this.duplicateOf = duplicateOf;
    }

    /**
     * Gets the player identifier.
     *
     * @return the player identifier
     */
    public gov.nih.nci.iso21090.Ii getPlayerIdentifier() {
        return playerIdentifier;
    }

    /**
     * Sets the player identifier.
     *
     * @param playerIdentifier
     *            the new player identifier
     */
    public void setPlayerIdentifier(gov.nih.nci.iso21090.Ii playerIdentifier) {
        this.playerIdentifier = playerIdentifier;
    }


    /**
     * Sets the identifier.
     *
     * @param identifier
     *            the new identifier
     */
    public void setIdentifier(gov.nih.nci.iso21090.DSet<Ii> identifier) {
        this.identifier = identifier;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(gov.nih.nci.iso21090.EnOn name) {
        this.name = name;
    }
    
    /**
     * Gets the identifier.
     *
     * @return the identifier
     */
    public gov.nih.nci.iso21090.DSet<Ii> getIdentifier() {
        return identifier;
    }

    /**
     * Gets the postal address.
     *
     * @return the postal address
     */
    public gov.nih.nci.iso21090.DSet<Ad> getPostalAddress() {
        return postalAddress;
    }

    /**
     * Sets the postal address.
     *
     * @param postalAddress
     *            the new postal address
     */
    public void setPostalAddress(gov.nih.nci.iso21090.DSet<Ad> postalAddress) {
        this.postalAddress = postalAddress;
    }
    
    /**
     * Gets the name.
     *
     * @return the name
     */
    public gov.nih.nci.iso21090.EnOn getName() {
        return name;
    }

    /**
     * Gets the status.
     *
     * @return the status
     */
    public gov.nih.nci.iso21090.Cd getStatus() {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param status
     *            the new status
     */
    public void setStatus(gov.nih.nci.iso21090.Cd status) {
        this.status = status;
    }

    /**
     * Gets the telecom address.
     *
     * @return the telecom address
     */
    public gov.nih.nci.iso21090.DSet<Tel> getTelecomAddress() {
        return telecomAddress;
    }

    /**
     * Sets the telecom address.
     *
     * @param telecomAddress
     *            the new telecom address
     */
    public void setTelecomAddress(gov.nih.nci.iso21090.DSet<Tel> telecomAddress) {
        this.telecomAddress = telecomAddress;
    }
    
}
