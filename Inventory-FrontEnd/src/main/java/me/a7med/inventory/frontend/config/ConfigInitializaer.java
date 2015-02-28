/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.a7med.inventory.frontend.config;

import inventory.pl.services.ServiceManager;
import javax.enterprise.inject.Produces;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author ahmed_darweeesh
 */
public class ConfigInitializaer implements ServletContextListener {
private ServiceManager manager;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        manager = inventory.pl.configs.ConfigLoader.getServiceManager();
         System.out.println("created manager status="+manager==null);
    }

    @Produces
    public ServiceManager getManager() {
        return manager;
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        inventory.pl.configs.ConfigLoader.closeContext();
    }
}
