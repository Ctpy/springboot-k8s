package com.huutungnguyen.portfolio.organization;

import java.util.List;

public interface OrganizationService {
    List<Organization> findAll();
    void createOrganization(Organization organization);
}
