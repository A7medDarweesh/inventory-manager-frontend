/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.a7med.inventory.frontend.helpers.converters;

import inventory.pl.entities.User;
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
@FacesConverter(forClass = User.class,value = "userConverter")
public class UserConverter implements Converter{
    @Inject
    SearchService searchService;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
       return searchService.getObjectById(User.class, Integer.parseInt(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value instanceof User){
            User w=(User) value;
            return ""+w.getId();
        }else{
            return "no Value";
        }
    }
    
}
