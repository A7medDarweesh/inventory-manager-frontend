/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.a7med.inventory.frontend.config;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author ahmed_darweeesh
 */
@Named
public class ConfigInitializaer implements ServletContextListener {
    @Inject
    private ConfigLoader manager;
   
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("init context"+manager.getClass());
    }

   
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        inventory.pl.configs.ConfigLoader.closeContext();
    }
}
