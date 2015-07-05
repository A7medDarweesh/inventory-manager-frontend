package me.a7med.inventory.frontend.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import inventory.pl.entities.Role;
import inventory.pl.helpers.Section;
import inventory.pl.services.SaveService;
import inventory.pl.services.SearchService;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import me.a7med.inventory.frontend.helpers.SectionsController;

import org.primefaces.model.CheckboxTreeNode;
import org.primefaces.model.TreeNode;

@Named
@ViewScoped
public class RoleController {
	String roleName;
	private TreeNode permissions;
	StringBuilder builder = new StringBuilder();
	private TreeNode[] selectedNodes;
	@Inject
	SectionsController sectionsController;
	@Inject
	SaveService saveService;
	@Inject
	SearchService searchService;
	List<Role>allRoles;
	@PostConstruct
	public void init() {
		permissions = createCheckboxDocuments();
		allRoles=getAllRoles();
	}

	private List<Role> getAllRoles() {
		return searchService.getAllRoles();
	}

	private TreeNode createCheckboxDocuments() {
		TreeNode root = new CheckboxTreeNode(new Section(), null);
		for (Section s : sectionsController.getSections()) {
			TreeNode sectionNode = new CheckboxTreeNode(s, root);

			for (String action : s.getActions()) {
				TreeNode actionNode = new CheckboxTreeNode(action, sectionNode);
			}
		}

		return root;
	}

	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName
	 *            the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return the permissions
	 */
	public TreeNode getPermissions() {
		return permissions;
	}

	/**
	 * @param permissions
	 *            the permissions to set
	 */
	public void setPermissions(TreeNode permissions) {
		this.permissions = permissions;
	}

	/**
	 * @return the selectedNodes
	 */
	public TreeNode[] getSelectedNodes() {
		return selectedNodes;
	}

	/**
	 * @param selectedNodes
	 *            the selectedNodes to set
	 */
	public void setSelectedNodes(TreeNode[] selectedNodes) {
		this.selectedNodes = selectedNodes;
	}

	public void saveRole() {
		builder.setLength(0);
		for (TreeNode node : selectedNodes) {
			Object data = node.getData();
			if (data instanceof String) {
				String action = node.getData().toString();
				Section section = (Section) node.getParent().getData();
				builder.append(section.getName()).append("_").append(action).append(";");
			}
			builder.deleteCharAt(builder.length() - 1);
			Role r = new Role();
			r.setRoleName(roleName);
			r.setPermissions(builder.toString());
			saveService.saveRole(r);
			System.out.println(node.getData().toString());
		}
	}

	/**
	 * @param allRoles the allRoles to set
	 */
	public void setAllRoles(List<Role> allRoles) {
		this.allRoles = allRoles;
	}
}
