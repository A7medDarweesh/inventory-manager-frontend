/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.a7med.inventory.frontend.controllers;

import inventory.pl.entities.FeatureValue;
import inventory.pl.entities.NeedsRequest;
import inventory.pl.entities.Product;
import inventory.pl.entities.ProductItemSpecs;
import inventory.pl.entities.RequestDetails;
import inventory.pl.services.SaveService;
import inventory.pl.services.SearchService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Min;
import me.a7med.inventory.frontend.helpers.SearchUtils;

/**
 *
 * @author ahmed_darweeesh
 */
@ViewScoped
@Named
public class RequestDetailsController implements Serializable{

    @Inject
    SearchService searchService;
    @Inject
    SaveService saveService;
    @Inject
    SearchUtils utils;
    private Product selectedProduct;
    private NeedsRequest request;
    private List<FeatureValue> values;
    private List<Product>products;
    private boolean showAddPanle;
    @Min(1)
    private int quantity;
    @PostConstruct
    public void init(){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if(session != null && session.getAttribute("needsRequest") != null){
           request =  (NeedsRequest)session.getAttribute("needsRequest") ;
        }
        
        products=searchService.getAllProducts();
    }
    public List<FeatureValue> getItemValue(RequestDetails specs){
         if(specs==null){
             return new ArrayList<>();
         }
         return searchService.getItemValues(specs.getId());
     }
  public List<RequestDetails>getAllItems(){
        List<RequestDetails> items = searchService.getAllRequestDetails(request.getId());
        System.out.println("size="+items.size());
        return items;
    }
  public void reloadValues(boolean checkForNull){
      showAddPanle=true;
     
          createValues();
      
      
  }
    private void createValues() {
        if (values != null) {
            values.clear();
        }
       showAddPanle=true;
       
        values = utils.createValues(selectedProduct.getId());
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public NeedsRequest getRequest() {
        return request;
    }

    public void setRequest(NeedsRequest request) {
        this.request = request;
    }

    public List<FeatureValue> getValues() {
        return values;
    }

    public void setValues(List<FeatureValue> values) {
        this.values = values;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    public void saveRequestDetails(){
        RequestDetails requestDetails=new RequestDetails();
        requestDetails.setRequest(request);
        requestDetails.setQuantity(""+quantity);
        ProductItemSpecs specs=new ProductItemSpecs();
        specs.setFeaturesValues(values);
        for(FeatureValue fet:values){
            fet.setProductItemspecs(specs);
        }
        specs.setProduct(selectedProduct);
        specs.setRequest(requestDetails);
        requestDetails.setRequest(request);
        requestDetails.setRequestItems(specs);
        List<RequestDetails>details=new ArrayList<>();
        details.add(requestDetails);
       // request.getProductList().add(requestDetails);
        saveService.addRequest(request, details);
        
    }

    public boolean isShowAddPanle() {
        return showAddPanle;
    }

    public void setShowAddPanle(boolean showAddPanle) {
        this.showAddPanle = showAddPanle;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
