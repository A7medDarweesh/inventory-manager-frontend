/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.a7med.inventory.frontend.controllers;

import inventory.pl.entities.User;
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
    String userName;
    String password;
    @Inject
    SearchService searchService;
    public List<User>getAllUsers(){
        System.out.println("getting users");
        return searchService.getAllusers();
    }
    
}
