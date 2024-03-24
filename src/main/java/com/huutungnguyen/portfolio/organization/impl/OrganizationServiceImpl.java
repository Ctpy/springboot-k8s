package com.huutungnguyen.portfolio.organization.impl;

import com.huutungnguyen.portfolio.organization.Organization;
import com.huutungnguyen.portfolio.organization.OrganizationService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

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

    @Override
    public Organization getOrganizationById(int id) {
        for (Organization organization : organizations) {
            if (organization.getId() == id) {
                return organization;
            }
        }
        return null;
    }

    @Override
    public Organization deleteOrganizationById(int id) {
        for (int i = 0; i < organizations.size(); i++) {
            if (organizations.get(i).getId() == id) {
                return organizations.remove(i);
            }
        }
        return null;
    }

    @Override
    public boolean updateOrganization(int id, Organization organization) {
        for (Organization curOrganization: organizations){
            if (curOrganization.getId() == id){
                curOrganization.setDescription(organization.getDescription());
                curOrganization.setLocation(organization.getLocation());
                curOrganization.setTitle(organization.getTitle());
                return true;
            }
        }
        return false;
    }
}
