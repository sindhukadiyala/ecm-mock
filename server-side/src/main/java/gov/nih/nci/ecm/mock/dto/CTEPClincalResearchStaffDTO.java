package gov.nih.nci.ecm.mock.dto;

import gov.nih.nci.iso21090.Ad;
import gov.nih.nci.iso21090.Ii;
import gov.nih.nci.iso21090.Tel;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import com.google.gson.Gson;

/**
 * The Class CTEPClincalResearchStaffDTO.
 *
 * @author Ramakrishna Gundala
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CTEPClincalResearchStaffDTO {
    /**
     * Instantiates a new CTEP Clinical Research Staff DTO.
     */
    public CTEPClincalResearchStaffDTO() {
        super();
    }

    /**
     * Instantiates a new CTEP Clinical Research Staff DTO.
     *
     * @param ctepCRSJSON
     *            the ctep CRSJSON
     */
    public CTEPClincalResearchStaffDTO(String ctepCRSJSON) {
        Gson gson = new Gson();
        CTEPClincalResearchStaffDTO dto = gson.fromJson(ctepCRSJSON,
                CTEPClincalResearchStaffDTO.class);
        this.duplicateOf = dto.getDuplicateOf();
        this.playerIdentifier = dto.getPlayerIdentifier();
        this.scoperIdentifier = dto.getScoperIdentifier();
        this.identifier = dto.getIdentifier();
        this.postalAddress = dto.getPostalAddress();
        this.status = dto.getStatus();
        this.telecomAddress = dto.getTelecomAddress();
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
     * Sets the identifier.
     *
     * @param identifier
     *            the new identifier
     */
    public void setIdentifier(gov.nih.nci.iso21090.DSet<Ii> identifier) {
        this.identifier = identifier;
    }

    /**
     * Gets the scoper identifier.
     *
     * @return the scoper identifier
     */
    public gov.nih.nci.iso21090.Ii getScoperIdentifier() {
        return scoperIdentifier;
    }

    /**
     * Sets the scoper identifier.
     *
     * @param scoperIdentifier
     *            the new scoper identifier
     */
    public void setScoperIdentifier(gov.nih.nci.iso21090.Ii scoperIdentifier) {
        this.scoperIdentifier = scoperIdentifier;
    }
    
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
     * Gets the postal address.
     *
     * @return the postal address
     */
    public gov.nih.nci.iso21090.DSet<Ad> getPostalAddress() {
        return postalAddress;
    }
    
    /** The duplicate of. */
    @JsonProperty("duplicateOf")
    private gov.nih.nci.iso21090.Ii duplicateOf;

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
     * Sets the player identifier.
     *
     * @param playerIdentifier
     *            the new player identifier
     */
    public void setPlayerIdentifier(gov.nih.nci.iso21090.Ii playerIdentifier) {
        this.playerIdentifier = playerIdentifier;
    }

    /** The identifier. */
    @JsonProperty("identifier")
    private gov.nih.nci.iso21090.DSet<Ii> identifier;

    /** The scoper identifier. */
    @JsonProperty("scoperIdentifier")
    private gov.nih.nci.iso21090.Ii scoperIdentifier;

    /** The player identifier. */
    @JsonProperty("playerIdentifier")
    private gov.nih.nci.iso21090.Ii playerIdentifier;

    /** The postal address. */
    @JsonProperty("postalAddress")
    private gov.nih.nci.iso21090.DSet<Ad> postalAddress;

    /** The status. */
    @JsonProperty("status")
    private gov.nih.nci.iso21090.Cd status;

    /** The telecom address. */
    @JsonProperty("telecomAddress")
    private gov.nih.nci.iso21090.DSet<Tel> telecomAddress;

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
