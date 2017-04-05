package gov.nih.nci.ecm.mock.ejb.service;

import gov.nih.nci.ecm.mock.dto.Organization;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Created by vinodh on 4/4/17.
 */
@Stateless
@Remote(SomeOrganizationService.class)
public class SomeOrganizationServiceBean implements SomeOrganizationService {

    @Override
    public Organization getOrganization(String id) {
        Organization org = new Organization(id, "someorg");
        return org;
    }
}
