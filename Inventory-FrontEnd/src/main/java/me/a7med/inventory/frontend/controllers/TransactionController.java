/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.a7med.inventory.frontend.controllers;

import inventory.pl.entities.FeatureValue;
import inventory.pl.entities.Product;
import inventory.pl.entities.ProductItem;
import inventory.pl.entities.User;
import inventory.pl.entities.Warehouse;
import inventory.pl.services.SaveService;
import inventory.pl.services.SearchService;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import me.a7med.inventory.frontend.helpers.SearchUtils;
import me.a7med.inventory.frontend.helpers.qualifiers.LoggedIn;

/**
 *
 * @author ahmed_darweeesh
 */
@Named
@ViewScoped
public class TransactionController {

    private Warehouse warehouse;
    private Product selectedProduct;
    @Inject
    SearchService searchService;
    @Inject
    SaveService saveService;
    @Inject
    SearchUtils utils;
    private String code;
    private List<FeatureValue> values;
    private List<Warehouse> warehouses;
    private List<Product> products;
    @Inject
    @LoggedIn
    User loggedUser;

    @PostConstruct
    public void init() {
        products = searchService.getAllProducts();
        selectedProduct = products.get(0);
        warehouses = searchService.getAllWarehouses(loggedUser);
        values = utils.createValues(selectedProduct.getId());
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<FeatureValue> getValues() {
        return values;
    }

    public void setValues(List<FeatureValue> values) {
        this.values = values;
    }

    public List<Warehouse> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(List<Warehouse> warehouses) {
        this.warehouses = warehouses;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void reload() {
        values = utils.createValues(selectedProduct.getId());
    }
     public void saveProduct(){
        System.out.println("values size="+code);
        ProductItem item=new ProductItem();
        item.setCode(code);
        item.setCreationeDate(new Date());
        item.setWarehouse(warehouse);
        
        item.setProduct(selectedProduct);
        saveService.saveProductItem(item);
        for(FeatureValue val:getValues()){
            val.setProductItem(item);
        }
        item.setFeaturesValues(values);
        saveService.saveProductItem(item);
        
    }
}
