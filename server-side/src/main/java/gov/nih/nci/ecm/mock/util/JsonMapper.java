package gov.nih.nci.ecm.mock.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import gov.nih.nci.common.exceptions.CTEPEntException;
import gov.nih.nci.services.organization.OrganizationDTO;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by vinodh on 4/5/17.
 */
public class JsonMapper {

    ObjectMapper mapper = new ObjectMapper();

    public <T> T convertToObject(String json, Class<T> clazz) throws IOException {
        ObjectReader reader = mapper.reader(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
        T dto = reader.forType(clazz).readValue(json);
        System.out.println(dto);

        return dto;
    }

    public static void main(String[] args) throws Exception {
        JsonMapper jm = new JsonMapper();
        String json = null;
        OrganizationDTO dto = null;
        try {
            json = IOUtils.toString(new FileInputStream("/Users/vinodh/sb/projects/ctrp-modern/ejb-remote/data/org/"
                    + "123.json"));
            dto = jm.convertToObject(json, OrganizationDTO.class);
        } catch (Exception e) {
            throw new CTEPEntException(1, e.getMessage());
        }
        System.out.println(dto.getName().getPart().get(0).getValue());
        System.out.println(dto.getIdentifier().getExtension());
    }
}
