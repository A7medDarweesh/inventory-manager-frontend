/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.a7med.inventory.frontend.helpers.converters;

import inventory.pl.entities.Role;
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
@FacesConverter(forClass = Role.class,value = "roleConverter")
public class RoleConverter implements Converter{
    @Inject
    SearchService searchService;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
       return searchService.getObjectById(Role.class, Long.parseLong(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value instanceof Role){
            Role w=(Role) value;
            return ""+w.getId();
        }else{
            return "no Value";
        }
    }
    
    
}
