/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.a7med.inventory.frontend.controllers;

import inventory.pl.entities.ProductItem;
import inventory.pl.entities.User;
import inventory.pl.entities.Warehouse;
import inventory.pl.services.SaveService;
import inventory.pl.services.SearchService;
import inventory.pl.services.ServiceManager;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import me.a7med.inventory.frontend.helpers.qualifiers.LoggedIn;

/**
 *
 * @author ahmed_darweeesh
 */
@Named
@ViewScoped
public class WarehousesController {

    private String name;
    @Inject
    SaveService SaveService;
    @Inject
    SearchService searchService;
    @LoggedIn
    @Inject
    User user;
    private List<Warehouse>userWarehouses;
    private List<ProductItem>warehouseItems;
    private List<ProductItem>selectedItems;
    private Warehouse selectedWarehouse;
    private Warehouse toWarehouse;

    public Warehouse getToWarehouse() {
        return toWarehouse;
    }

    public void setToWarehouse(Warehouse toWarehouse) {
        this.toWarehouse = toWarehouse;
    }

    @PostConstruct
    public void init(){
        userWarehouses=getAll();
        if(!userWarehouses.isEmpty()){
            selectedWarehouse=userWarehouses.get(0);
        loadItems();
        }
    }
    public List<Warehouse> getAll() {
        return searchService.getAllWarehouses(user);
    }

   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Warehouse> getUserWarehouses() {
        return userWarehouses;
    }

    public void setUserWarehouses(List<Warehouse> userWarehouses) {
        this.userWarehouses = userWarehouses;
    }

    public List<ProductItem> getWarehouseItems() {
        return warehouseItems;
    }

    public void setWarehouseItems(List<ProductItem> warehouseItems) {
        this.warehouseItems = warehouseItems;
    }

    public Warehouse getSelectedWarehouse() {
        return selectedWarehouse;
    }

    public void setSelectedWarehouse(Warehouse selectedWarehouse) {
        this.selectedWarehouse = selectedWarehouse;
    }

    public void loadItems() {
        
        warehouseItems=searchService.findItemsInWarehouse(selectedWarehouse);
    }

    public List<ProductItem> getSelectedItems() {
        return selectedItems;
    }

    public void setSelectedItems(List<ProductItem> selectedItems) {
        this.selectedItems = selectedItems;
    }
public void transferProducts(){
    for(ProductItem item:selectedItems){
        item.setWarehouse(toWarehouse);
    }
    SaveService.transferItems(selectedItems);
    loadItems();
}
}
