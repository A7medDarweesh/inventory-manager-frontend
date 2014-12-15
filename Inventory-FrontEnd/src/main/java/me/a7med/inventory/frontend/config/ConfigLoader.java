/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.a7med.inventory.frontend.config;

import inventory.pl.services.ServiceManager;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 *
 * @author ahmed_darweeesh
 */
@ApplicationScoped
@Named
public class ConfigLoader {
  
    private ServiceManager manager;
   
    @PostConstruct
    public void init(){
         manager = inventory.pl.configs.ConfigLoader.getServiceManager();
         System.out.println("created manager status="+manager==null);
    }

    @Produces
    public ServiceManager getManager() {
        return manager;
    }
 
    
    
}
