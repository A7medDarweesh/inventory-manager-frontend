/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.a7med.inventory.frontend.controllers;

import inventory.pl.entities.FeatureValue;
import inventory.pl.entities.Features;
import inventory.pl.entities.ProductItem;
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
@Named
@SessionScoped
public class ProductItemController implements Serializable{
    @Inject
    ProductController productController;
     @Inject
    ServiceManager manager;
    private String code;
    private List<FeatureValue>values;
    
    public List<ProductItem>getAllItems(){
        values=null;
        System.out.println("getting product items for"+productController.getCurrentProduct().getId());
        List<ProductItem> items = manager.getProductService().getProductItems(productController.getCurrentProduct().getId());
        System.out.println("size="+items.size());
        return items;
    }
    private void createValues(){
        if(values!=null){
            values.clear();
        }
        List<FeatureValue>vals=new ArrayList<>();
        for(Features f:manager.getProductService().getProductFeatures(productController.getCurrentProduct().getId())){
            FeatureValue current=new FeatureValue();
            current.setFeature(f);
            vals.add(current);
        }
        values=vals;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public void saveProduct(){
        System.out.println("values size="+code);
        ProductItem item=new ProductItem();
        item.setCode(code);
        item.setCreationeDate(new Date());
        
        item.setProduct(productController.getCurrentProduct());
        manager.getProductService().saveProductItem(item);
        for(FeatureValue val:getValues()){
            val.setProductItem(item);
        }
        item.setFeaturesValues(values);
        manager.getProductService().saveProductItem(item);
        
    }
     public List<FeatureValue> getItemValue(ProductItem id){
         if(id==null){
             return new ArrayList<>();
         }
         System.out.println("getting values for id="+id.getCode());
         return manager.getProductService().getItemValues(id.getId());
     }
     public List<Features>getProductFeatures(){
         return manager.getProductService().getProductFeatures(productController.getCurrentProduct().getId());
     }

    public List<FeatureValue> getValues() {
        if(values==null)
            createValues();
        return values;
    }

    public void setValues(List<FeatureValue> values) {
        this.values = values;
    }
}
