package gov.nih.nci.ecm.mock.dto;

import java.io.Serializable;

/**
 * Created by vinodh on 4/4/17.
 */
public class Organization implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String name;

    public Organization() {
        this(null, null);
    }

    public Organization(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
