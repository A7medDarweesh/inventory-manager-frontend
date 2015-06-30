/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.a7med.inventory.frontend.helpers;

import inventory.pl.entities.FeatureValue;
import inventory.pl.entities.Features;
import inventory.pl.services.SaveService;
import inventory.pl.services.SearchService;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author ahmed_darweeesh
 */
@RequestScoped
@Named
public class SearchUtils {

    @Inject
    SearchService searchService;
    @Inject
    SaveService saveService;

    public List<FeatureValue> createValues(long id) {

        List<FeatureValue> vals = new ArrayList<>();
        for (Features f : searchService.getProductFeatures(id)) {
            FeatureValue current = new FeatureValue();
            current.setFeature(f);
            vals.add(current);
        }
        return vals;
    }
}
