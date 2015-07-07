package me.a7med.inventory.frontend.controllers;

import inventory.pl.entities.NeedsRequest;
import inventory.pl.entities.Procurement;
import inventory.pl.entities.Project;
import inventory.pl.services.SaveService;
import inventory.pl.services.SearchService;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class ProcurmentController implements Serializable {
	Project selectedProject;
	@Inject
	SaveService saveService;
	@Inject
	SearchService searchService;
	Procurement selectedProcurement;
	List<Procurement> userProcurments;
	List<NeedsRequest> userRequests;
	boolean showRequestsPanel;
        
        @PostConstruct
        public void init(){
            
        }
	/**
	 * @return the selectedProject
	 */
	public Project getSelectedProject() {
		return selectedProject;
	}
	/**
	 * @param selectedProject the selectedProject to set
	 */
	public void setSelectedProject(Project selectedProject) {
		this.selectedProject = selectedProject;
	}
	/**
	 * @return the selectedProcurement
	 */
	public Procurement getSelectedProcurement() {
		return selectedProcurement;
	}
	/**
	 * @param selectedProcurement the selectedProcurement to set
	 */
	public void setSelectedProcurement(Procurement selectedProcurement) {
		this.selectedProcurement = selectedProcurement;
	}
	/**
	 * @return the userProcurments
	 */
	public List<Procurement> getUserProcurments() {
		return userProcurments;
	}
	/**
	 * @param userProcurments the userProcurments to set
	 */
	public void setUserProcurments(List<Procurement> userProcurments) {
		this.userProcurments = userProcurments;
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
	

}
