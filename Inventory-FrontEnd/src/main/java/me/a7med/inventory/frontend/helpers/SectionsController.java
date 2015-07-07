/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.a7med.inventory.frontend.helpers;

import inventory.pl.helpers.Section;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author ahmed_darweeesh
 */
@Named
@ApplicationScoped
public class SectionsController {

    private List<Section> sections;
    String[] sectionNames = {"Projects", "Suppliers","Warehouses", "Requests", "Procurements and Purchases", "Inventory-In Transactions", "Inventory-Out Transactions", "products"};
    String[][] sectionActions = {{"view", "create", "reports"}, {"view", "create", "edit", "reports"},{"view", "create", "reports"}, {"view", "add", "edit", "change status", "reports"},
    {"view", "add", "edit", "change status", "reports"}, {"view", "make transaction", "reports"}, {"view", "make transaction", "reports"},
    {"view", "create", "edit", "reports"}
    };
    String[][] sectionLinks = {{"index", "reports"}, {"index", "reports"}, {"index", "reports"}, {"index", "reports"}, {"index", "reports"}, {"index", "reports"}, {"index", "reports"}, {"index", "reports"}};
    String[] linkNames = {"projects", "suppliers", "warehouse","requests", "procurments", "inventory_in", "inventory_out", "products"};

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    @PostConstruct
    public void init() {
        sections = new ArrayList<>();
        for (int i = 0; i < sectionNames.length; i++) {
            Section s = new Section();
            s.setId(i);
            s.setName(sectionNames[i]);
            s.setActions(sectionActions[i]);
            s.setSectionLinks(sectionLinks[i]);
            s.setLinkName(linkNames[i]);
            sections.add(s);
        }
    }

}
