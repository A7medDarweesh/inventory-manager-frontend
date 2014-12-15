/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.a7med.inventory.frontend.controllers;

import inventory.pl.entities.BuyOrder;
import inventory.pl.services.BuyOrderService;
import inventory.pl.services.ServiceManager;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author ahmed_darweeesh
 */
@RequestScoped
@Named("productCon")
public class ProductController {
    @Inject
    ServiceManager manager;
    public void test(){
        System.out.println("testing");
        BuyOrderService buyService = manager.getBuyOrderSrervice();
        BuyOrder order=new BuyOrder();
        order.setDescription("fron end test");
        order.setName("name 1");
        buyService.save(order);
    }
}
