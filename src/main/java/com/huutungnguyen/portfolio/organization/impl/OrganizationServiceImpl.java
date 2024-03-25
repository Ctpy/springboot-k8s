package com.huutungnguyen.portfolio.organization.impl;

import com.huutungnguyen.portfolio.organization.Organization;
import com.huutungnguyen.portfolio.organization.OrganizationRepository;
import com.huutungnguyen.portfolio.organization.OrganizationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class OrganizationServiceImpl implements OrganizationService {
    OrganizationRepository organizationRepository;

    public OrganizationServiceImpl(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    private int id;

    @Override
    public List<Organization> findAll() {
        return organizationRepository.findAll();
    }

    @Override
    public void createOrganization(Organization organization) {
        organization.setId(id++);
        organizationRepository.save(organization);
    }

    @Override
    public Organization getOrganizationById(int id) {
        return organizationRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteOrganizationById(int id) {
        try {
            organizationRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateOrganization(int id, Organization organization) {
        Optional<Organization> organizationOptional = organizationRepository.findById(id);
        if (organizationOptional.isPresent()) {
            Organization curOrganization = organizationOptional.get();
            curOrganization.setDescription(organization.getDescription());
            curOrganization.setLocation(organization.getLocation());
            curOrganization.setTitle(organization.getTitle());
            organizationRepository.save(curOrganization);
            return true;
        }
        return false;
    }
}
