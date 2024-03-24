package com.huutungnguyen.portfolio.organization;

import java.util.List;

public interface OrganizationService {
    List<Organization> findAll();
    void createOrganization(Organization organization);

    Organization getOrganizationById(int id);

    Organization deleteOrganizationById(int id);

    boolean updateOrganization(int id, Organization organization);
}
