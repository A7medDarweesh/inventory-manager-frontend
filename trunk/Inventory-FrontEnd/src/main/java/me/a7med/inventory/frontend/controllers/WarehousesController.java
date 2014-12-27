/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.a7med.inventory.frontend.controllers;

import inventory.pl.entities.Warehouse;
import inventory.pl.services.ServiceManager;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author ahmed_darweeesh
 */
@Named
@SessionScoped
public class WarehousesController implements Serializable{
    private String name;
    @Inject
    ServiceManager manager;
    public List<Warehouse>getAll(){
        return manager.getwWarehousesService().findAll();
    }
    public void addWarehouse(){
        Warehouse warehouse=new Warehouse();
        warehouse.setName(name);
        manager.getwWarehousesService().saveWarehouse(warehouse);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
