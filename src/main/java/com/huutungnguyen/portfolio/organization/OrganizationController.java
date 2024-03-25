package com.huutungnguyen.portfolio.organization;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/organizations")
public class OrganizationController {
    private OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping
    public ResponseEntity<List<Organization>> findAll() {
        return ResponseEntity.ok(organizationService.findAll());
    }

    @PostMapping
    public ResponseEntity<String> createOrganization(@RequestBody Organization organization) {
        organizationService.createOrganization(organization);
        return new ResponseEntity<>("Organization created successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Organization> getOrganizationById(@PathVariable int id) {
        Organization organization = organizationService.getOrganizationById(id);
        if (organization != null) {
            return new ResponseEntity<>(organization, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrganizationById(@PathVariable int id){
        boolean found = organizationService.deleteOrganizationById(id);
        if (!found){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Organization deleted", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateOrganization(@PathVariable int id, @RequestBody Organization organization){
        boolean updated = organizationService.updateOrganization(id, organization);
        if (!updated){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
