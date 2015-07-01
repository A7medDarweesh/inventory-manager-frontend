package me.a7med.inventory.frontend.controllers;

import inventory.pl.entities.NeedsRequest;
import inventory.pl.entities.Project;
import inventory.pl.services.SaveService;
import inventory.pl.services.SearchService;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

@Named
@RequestScoped
public class RequstsController {
@Inject
SaveService saveService;
@Inject
SearchService searchService;
List<NeedsRequest>userRequests;
private NeedsRequest selectedRequest;
private Project projectToAddRequestTo;

public List<NeedsRequest>getAllRequsts(){
	return searchService.getAllRequests();
}

/**
 * @return the userRequests
 */
public List<NeedsRequest> getUserRequests() {
	return userRequests;
}

/**
 * @param userRequests the userRequests to set
 */
public void setUserRequests(List<NeedsRequest> userRequests) {
	this.userRequests = userRequests;
}

/**
 * @return the selectedRequest
 */
public NeedsRequest getSelectedRequest() {
	return selectedRequest;
}

/**
 * @param selectedRequest the selectedRequest to set
 */
public void setSelectedRequest(NeedsRequest selectedRequest) {
	this.selectedRequest = selectedRequest;
}

/**
 * @return the projectToAddRequestTo
 */
public Project getProjectToAddRequestTo() {
	return projectToAddRequestTo;
}

/**
 * @param projectToAddRequestTo the projectToAddRequestTo to set
 */
public void setProjectToAddRequestTo(Project projectToAddRequestTo) {
	this.projectToAddRequestTo = projectToAddRequestTo;
}
public void addRequest(){
	saveService.addRequest(projectToAddRequestTo);
}
public void editRequest(NeedsRequest needsRequest){
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    if(session != null ){
        session.setAttribute("needsRequest", needsRequest);
    }
        
}
}
