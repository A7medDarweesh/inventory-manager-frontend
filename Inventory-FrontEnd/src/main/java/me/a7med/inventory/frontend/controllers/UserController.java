/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.a7med.inventory.frontend.controllers;

import inventory.pl.entities.Role;
import inventory.pl.entities.User;
import inventory.pl.services.SaveService;
import inventory.pl.services.SearchService;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author ahmed_darweeesh
 */
@Named
@RequestScoped
public class UserController {
    private String userName;
    private String password;
    @Inject
    SearchService searchService;
    @Inject
    SaveService saveService;
    private Role selectedRole;
    private List<User> selectedUsers;
    public List<User>getAllUsers(){
        return searchService.getAllusers();
    }
    public void saveUser(){
        System.out.println("saving user");
        saveService.addUser(userName,password,selectedRole);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getSelectedRole() {
        return selectedRole;
    }

    public void setSelectedRole(Role selectedRole) {
        this.selectedRole = selectedRole;
    }
    public List<Role> getUserRoles(){
        return searchService.getAvailableRoles();
    }
    public void deleteUser(User u){
        saveService.deleteUser(u);
    }

    public List<User> getSelectedUsers() {
        return selectedUsers;
    }

    public void setSelectedUsers(List<User> selectedUsers) {
        this.selectedUsers = selectedUsers;
    }
}
