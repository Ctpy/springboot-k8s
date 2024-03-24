package com.huutungnguyen.portfolio.organization;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrganizationController {
    private OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping("/organizations")
    public List<Organization> findAll() {
        return organizationService.findAll();
    }

    @PostMapping("/organizations")
    public String createOrganization(@RequestBody Organization organization) {
        organizationService.createOrganization(organization);
        return "Organization created successfully";
    }
}
