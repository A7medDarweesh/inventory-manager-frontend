/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.a7med.inventory.frontend.config;

import inventory.pl.services.SaveService;
import inventory.pl.services.SearchService;
import inventory.pl.services.ServiceManager;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

/**
 *
 * @author ahmed_darweeesh
 */
@Named
@ApplicationScoped
public class ConfigLoader {

    private ServiceManager manager;
    private SearchService searchService;
    private SaveService saveService;

    @PostConstruct
    public void init() {
        
    }

    public void setManager(ServiceManager manager) {
        this.manager = manager;
    }

    public void setSearchService(SearchService searchService) {
        this.searchService = searchService;
    }

    public void setSaveService(SaveService saveService) {
        this.saveService = saveService;
    }

    @Produces
    public ServiceManager getManager() {
        return manager;
    }

    @Produces
    public SearchService getSearchService() {
        System.out.println("getting manager status=" + searchService.getClass());
        return searchService;
    }

    @Produces
    public SaveService getSaveService() {
        return saveService;
    }

}
