/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.a7med.inventory.frontend.helpers;

import inventory.pl.entities.User;
import inventory.pl.services.SearchService;
import inventory.pl.services.ServiceManager;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import me.a7med.inventory.frontend.helpers.qualifiers.LoggedIn;

/**
 *
 * @author A7med
 */
@Named
@SessionScoped
public class Login implements Serializable {

    @Inject
    private transient SearchService searchService;
    private User current;
    private String userName;
    private String password;
   

    public String logout() {
        System.out.println("loging out");

        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession session = (HttpSession) ec.getSession(true);

        session.invalidate();
        try {
            ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public String login() {
        System.out.println("search service status="+searchService.getClass());
        User logged = searchService.login(userName,password);

        if (logged != null) {
            current = logged;
            System.out.println("logged=" + logged.getName());
            return "index?faces-redirect=true";

        } else {
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid Login", ""));
            return null;
        }
    }

    public boolean isLoggedIn() {

        return current != null;

    }

    @Produces
    @LoggedIn
    public User getCurrent() {
        return current;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
