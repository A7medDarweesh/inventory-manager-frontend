/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.a7med.inventory.frontend.controllers;

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
    public List<User>getAllUsers(){
        System.out.println("getting users");
        return searchService.getAllusers();
    }
    public void saveUser(){
        saveService.addUser(userName,password);
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
    
}
