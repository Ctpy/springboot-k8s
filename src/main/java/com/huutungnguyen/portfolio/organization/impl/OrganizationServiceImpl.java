package com.huutungnguyen.portfolio.organization.impl;

import com.huutungnguyen.portfolio.organization.Organization;
import com.huutungnguyen.portfolio.organization.OrganizationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class OrganizationServiceImpl implements OrganizationService {
    private List<Organization> organizations = new ArrayList<>();
    private int id;

    @Override
    public List<Organization> findAll() {
        return organizations;
    }

    @Override
    public void createOrganization(Organization organization) {
        organization.setId(id++);
        organizations.add(organization);
    }
}
