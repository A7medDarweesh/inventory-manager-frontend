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
import java.util.Set;
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
    private Set<User> projectMembers;
    private String newProjectWarehouse;
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

    public Set<User> getProjectMembers() {
        return projectMembers;
    }

    public void setProjectMembers(Set<User> projectMembers) {
        this.projectMembers = projectMembers;
    }

    public String getNewProjectWarehouse() {
        return newProjectWarehouse;
    }

    public void setNewProjectWarehouse(String newProjectWarehouse) {
        this.newProjectWarehouse = newProjectWarehouse;
    }

    public List<Project> getProjectlList() {
        return searchService.getUserProjects(currentUser);
    }

    public void createProject() {        
        Project p=new Project();
        p.setDescription(newProjectName);
        p.setName(newProjectName);
        
        saveService.createProject(p, new ArrayList<User>(projectMembers),newProjectWarehouse);
    }

    public List<Project> getUserProjectList() {
        return searchService.getUserProjects(currentUser);
    }

    public void setUserProjectList(List<Project> userProjectList) {
        this.userProjectList = userProjectList;
    }
    public String getWarehouseName(Project p){
        if(p.getWarehouses()!=null){
            return p.getWarehouses().getName();
        }
        return "No Warehouse Yet";
    }
}
