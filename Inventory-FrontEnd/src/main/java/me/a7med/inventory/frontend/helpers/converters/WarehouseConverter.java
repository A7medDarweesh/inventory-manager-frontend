/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.a7med.inventory.frontend.helpers.converters;

import inventory.pl.entities.Warehouse;
import inventory.pl.services.SearchService;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

/**
 *
 * @author ahmed_darweeesh
 */
@FacesConverter(forClass = Warehouse.class,value = "warehouseConverter")
public class WarehouseConverter implements Converter{
    @Inject
    SearchService searchService;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return searchService.getObjectById(Warehouse.class,value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
