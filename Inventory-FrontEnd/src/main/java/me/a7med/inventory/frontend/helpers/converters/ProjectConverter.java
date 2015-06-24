package me.a7med.inventory.frontend.helpers.converters;

import inventory.pl.entities.Project;
import inventory.pl.entities.User;
import inventory.pl.services.SearchService;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
@FacesConverter(forClass = Project.class,value = "projectConverter")
public class ProjectConverter implements Converter{
    @Inject
    SearchService searchService;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
       return searchService.getObjectById(Project.class, Integer.parseInt(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value instanceof Project){
            Project w=(Project) value;
            return ""+w.getId();
        }else{
            return "no Value";
        }
    }

}
