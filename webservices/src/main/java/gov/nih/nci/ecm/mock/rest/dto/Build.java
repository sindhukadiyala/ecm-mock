package gov.nih.nci.ecm.mock.rest.dto;

/**
 * Created by vinodh on 4/6/17.
 */
public class Build {

    String versionNumber;
    String builtDate;
    String environment;
    String server;

    public String getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(String versionNumber) {
        this.versionNumber = versionNumber;
    }

    public String getBuiltDate() {
        return builtDate;
    }

    public void setBuiltDate(String builtDate) {
        this.builtDate = builtDate;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }
}
