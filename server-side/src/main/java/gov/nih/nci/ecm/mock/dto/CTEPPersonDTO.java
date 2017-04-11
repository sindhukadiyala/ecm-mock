package gov.nih.nci.ecm.mock.dto;

import gov.nih.nci.iso21090.Tel;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import com.google.gson.Gson;

/**
 * The Class CTEPPersonDTO.
 *
 * @author Ramakrishna Gundala
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CTEPPersonDTO {
    /**
     * Instantiates a new CTEP Person DTO.
     */
    public CTEPPersonDTO() {
        super();
    }

    /**
     * Instantiates a new CTEP Person DTO.
     *
     * @param ctepPersonJSON
     *            the CTEP Person JSON
     */
    public CTEPPersonDTO(String ctepPersonJSON) {
        Gson gson = new Gson();
        CTEPPersonDTO dto = gson.fromJson(ctepPersonJSON, CTEPPersonDTO.class);
        this.statusDate = dto.getStatusDate();
        this.birthDate = dto.getBirthDate();
        this.ethnicGroupCode = dto.getEthnicGroupCode();
        this.identifier = dto.getIdentifier();
        this.name = dto.getName();
        this.postalAddress = dto.getPostalAddress();
        this.statusCode = dto.getStatusCode();
        this.sexCode = dto.getSexCode();
        this.telecomAddress = dto.getTelecomAddress();
    }

    /** The birth date. */
    @JsonProperty("birthDate")
    private gov.nih.nci.iso21090.Ts birthDate;

    /** The ethnic group code. */
    @JsonProperty("ethnicGroupCode")
    private gov.nih.nci.iso21090.DSet ethnicGroupCode;

    /** The identifier. */
    @JsonProperty("identifier")
    private gov.nih.nci.iso21090.Ii identifier;

    /** The name. */
    @JsonProperty("name")
    private gov.nih.nci.iso21090.EnPn name;

    /** The postal address. */
    @JsonProperty("postalAddress")
    private gov.nih.nci.iso21090.Ad postalAddress;

    /** The race code. */
    @JsonProperty("raceCode")
    private gov.nih.nci.iso21090.DSet raceCode;

    /** The sex code. */
    @JsonProperty("sexCode")
    private gov.nih.nci.iso21090.Cd sexCode;

    /** The status code. */
    @JsonProperty("statusCode")
    private gov.nih.nci.iso21090.Cd statusCode;

    /** The status date. */
    @JsonProperty("statusDate")
    private gov.nih.nci.iso21090.Ts statusDate;

    /** The telecom address. */
    @JsonProperty("telecomAddress")
    private gov.nih.nci.iso21090.DSet<Tel> telecomAddress;

    /**
     * Gets the birth date.
     *
     * @return the birth date
     */
    public gov.nih.nci.iso21090.Ts getBirthDate() {
        return birthDate;
    }

    /**
     * Sets the birth date.
     *
     * @param birthDate
     *            the new birth date
     */
    public void setBirthDate(gov.nih.nci.iso21090.Ts birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Gets the ethnic group code.
     *
     * @return the ethnic group code
     */
    public gov.nih.nci.iso21090.DSet getEthnicGroupCode() {
        return ethnicGroupCode;
    }

    /**
     * Sets the ethnic group code.
     *
     * @param ethnicGroupCode
     *            the new ethnic group code
     */
    public void setEthnicGroupCode(gov.nih.nci.iso21090.DSet ethnicGroupCode) {
        this.ethnicGroupCode = ethnicGroupCode;
    }

    /**
     * Gets the identifier.
     *
     * @return the identifier
     */
    public gov.nih.nci.iso21090.Ii getIdentifier() {
        return identifier;
    }

    /**
     * Sets the identifier.
     *
     * @param identifier
     *            the new identifier
     */
    public void setIdentifier(gov.nih.nci.iso21090.Ii identifier) {
        this.identifier = identifier;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public gov.nih.nci.iso21090.EnPn getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name
     *            the new name
     */
    public void setName(gov.nih.nci.iso21090.EnPn name) {
        this.name = name;
    }

    /**
     * Gets the postal address.
     *
     * @return the postal address
     */
    public gov.nih.nci.iso21090.Ad getPostalAddress() {
        return postalAddress;
    }

    /**
     * Sets the postal address.
     *
     * @param postalAddress
     *            the new postal address
     */
    public void setPostalAddress(gov.nih.nci.iso21090.Ad postalAddress) {
        this.postalAddress = postalAddress;
    }

    /**
     * Gets the race code.
     *
     * @return the race code
     */
    public gov.nih.nci.iso21090.DSet getRaceCode() {
        return raceCode;
    }

    /**
     * Sets the race code.
     *
     * @param raceCode
     *            the new race code
     */
    public void setRaceCode(gov.nih.nci.iso21090.DSet raceCode) {
        this.raceCode = raceCode;
    }

    /**
     * Gets the sex code.
     *
     * @return the sex code
     */
    public gov.nih.nci.iso21090.Cd getSexCode() {
        return sexCode;
    }

    /**
     * Sets the sex code.
     *
     * @param sexCode
     *            the new sex code
     */
    public void setSexCode(gov.nih.nci.iso21090.Cd sexCode) {
        this.sexCode = sexCode;
    }

    /**
     * Gets the status code.
     *
     * @return the status code
     */
    public gov.nih.nci.iso21090.Cd getStatusCode() {
        return statusCode;
    }

    /**
     * Sets the status code.
     *
     * @param statusCode
     *            the new status code
     */
    public void setStatusCode(gov.nih.nci.iso21090.Cd statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * Gets the status date.
     *
     * @return the status date
     */
    public gov.nih.nci.iso21090.Ts getStatusDate() {
        return statusDate;
    }

    /**
     * Sets the status date.
     *
     * @param statusDate
     *            the new status date
     */
    public void setStatusDate(gov.nih.nci.iso21090.Ts statusDate) {
        this.statusDate = statusDate;
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
