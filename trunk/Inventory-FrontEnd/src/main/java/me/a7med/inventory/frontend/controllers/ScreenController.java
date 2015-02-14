/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.a7med.inventory.frontend.controllers;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author ahmed_darweeesh
 */
@SessionScoped
@Named
public class ScreenController implements Serializable {
    private String screen="dashboard";
    private String page="index";

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }
    
    public void switchScreen(String newScreen,String newPage){
        screen=newScreen;
        page=newPage;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
    public void testAction(String source){
        System.out.println("Action recieved from "+source);
    }
}
