package gov.nih.nci.ecm.mock.dto;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import com.google.gson.Gson;

/**
 * The Class CTEPJMSMessageDTO.
 *
 * @author Ramakrishna Gundala
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CTEPJMSMessageDTO {

    /**
     * Instantiates a new CTEPJMS message DTO.
     *
     * @param jMSMessageID the j MS message ID
     * @param text  the text
     */
    public CTEPJMSMessageDTO(String jMSMessageID, String text) {
        super();
        this.jMSMessageID = jMSMessageID;
        this.text = text;
    }

    /**
     * Instantiates a new CTEPJMS message DTO.
     *
     * @param jmsMessageJSON the JMS message JSON
     */
    public CTEPJMSMessageDTO(String jmsMessageJSON) {
        Gson gson = new Gson();
        CTEPJMSMessageDTO grupoAplicacao = gson.fromJson(jmsMessageJSON,
                CTEPJMSMessageDTO.class);
        this.jMSMessageID = grupoAplicacao.getjMSMessageID();
        this.text = grupoAplicacao.getText();
    }

    /** The JMS message ID. */
    @JsonProperty("jMSMessageID")
    private String jMSMessageID;

    /** The text. */
    @JsonProperty("text")
    private String text;

    /**
     * Gets the j MS message ID.
     *
     * @return jMSMessageID
     */
    public String getjMSMessageID() {
        return jMSMessageID;
    }

    /**
     * Sets the jMS message ID.
     *
     * @param jmsMessageID the jMSMessageID
     */
    public void setjMSMessageID(String jmsMessageID) {
        this.jMSMessageID = jmsMessageID;
    }

    /**
     * Gets the text.
     *
     * @return text
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the text.
     *
     * @param text the text
     */
    public void setText(String text) {
        this.text = text;
    }

}
