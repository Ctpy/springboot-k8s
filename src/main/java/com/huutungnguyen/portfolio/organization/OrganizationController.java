package com.huutungnguyen.portfolio.organization;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrganizationController {
    private List<Organization> organizations = new ArrayList<>();

    @GetMapping("/organizations")
    public List<Organization> findAll() {
        return organizations;
    }

    @PostMapping("/organizations")
    public String createOrganization(@RequestBody Organization organization) {
        organizations.add(organization);

        return "Organization created successfully";
    }
}
