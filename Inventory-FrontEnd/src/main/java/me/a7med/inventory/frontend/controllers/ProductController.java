/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.a7med.inventory.frontend.controllers;

import inventory.pl.entities.Features;
import inventory.pl.entities.Product;
import inventory.pl.helpers.FeatureType;
import inventory.pl.services.ServiceManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author ahmed_darweeesh
 */
@SessionScoped
@Named("productCon")
public class ProductController implements Serializable{
    @Inject
    ServiceManager manager;
    private String productName;
    private String productDescription;
    private String productquantityType;
    private Product currentProduct;
    private List<Features>features=new ArrayList<>();
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Product getCurrentProduct() {
        return currentProduct;
    }

    public void setCurrentProduct(Product currentProduct) {
        this.currentProduct = currentProduct;
    }
    public List<Product>getAllProducts(){
        return manager.getProductService().getAll();
    }

    public List<Features> getFeatureses() {
        return features;
    }

    public void setFeatureses(List<Features> featureses) {
        this.features = featureses;
    }
    public void addFeature(){
        System.out.println(features);
        features.add(new Features());
    }
    public FeatureType[]getFeatureTypes(){
        return FeatureType.values();
    }
    public void saveProduct(){
        Product p=new Product();
        p.setDescription(productDescription);
        p.setName(productName);
        p.setCreateDate(new Date());
        manager.getProductService().saveProduct(p);
        for(int i=0;i<features.size();i++){
            features.get(i).setOrder(i);
            features.get(i).setProduct(p);
        }
        p.setProductFeatures(features);
        manager.getProductService().saveProduct(p);
    }
    public void viewDetails(Product p){
        System.out.println("going to details for product "+p.getName());
        currentProduct=p;
    }

    public String getProductquantityType() {
        return productquantityType;
    }

    public void setProductquantityType(String productquantityType) {
        this.productquantityType = productquantityType;
    }
}
