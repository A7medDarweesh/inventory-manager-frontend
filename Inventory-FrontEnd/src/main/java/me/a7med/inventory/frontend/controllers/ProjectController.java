/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.a7med.inventory.frontend.controllers;

import inventory.pl.entities.Project;
import inventory.pl.entities.User;
import inventory.pl.entities.Warehouse;
import inventory.pl.services.SaveService;
import inventory.pl.services.SearchService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import me.a7med.inventory.frontend.helpers.qualifiers.LoggedIn;

/**
 *
 * @author ahmed_darweeesh
 */
@Named
@RequestScoped
public class ProjectController {

    private Project slectedProject;
    private String newProjectName;
    private String newProjectDesc;
    private List<User> projectMembers;
    private Warehouse newProjectWarehouse;
    @Inject
    SearchService searchService;
    @Inject
    SaveService saveService;
    @Inject
    @LoggedIn
    User currentUser;
    private List<Project> userProjectList;

    @PostConstruct
    public void init() {
        userProjectList = searchService.getUserProjects(currentUser);
    }

    public Project getSlectedProject() {
        return slectedProject;
    }

    public void setSlectedProject(Project slectedProject) {
        this.slectedProject = slectedProject;
    }

    public String getNewProjectName() {
        return newProjectName;
    }

    public void setNewProjectName(String newProjectName) {
        this.newProjectName = newProjectName;
    }

    public String getNewProjectDesc() {
        return newProjectDesc;
    }

    public void setNewProjectDesc(String newProjectDesc) {
        this.newProjectDesc = newProjectDesc;
    }

    public List<User> getProjectMembers() {
        return projectMembers;
    }

    public void setProjectMembers(List<User> projectMembers) {
        this.projectMembers = projectMembers;
    }

    public Warehouse getNewProjectWarehouse() {
        return newProjectWarehouse;
    }

    public void setNewProjectWarehouse(Warehouse newProjectWarehouse) {
        this.newProjectWarehouse = newProjectWarehouse;
    }

    public List<Project> getProjectlList() {
        return searchService.getUserProjects(currentUser);
    }

    public void createProject() {
        System.out.println("no of users in project=" + projectMembers.size() + " and warehouse is=" + newProjectWarehouse.getName());
        Project p=new Project();
        p.setDescription(newProjectName);
        p.setName(newProjectName);
        
        saveService.createProject(p, projectMembers,newProjectWarehouse);
    }

    public List<Project> getUserProjectList() {
        return searchService.getUserProjects(currentUser);
    }

    public void setUserProjectList(List<Project> userProjectList) {
        this.userProjectList = userProjectList;
    }
}
