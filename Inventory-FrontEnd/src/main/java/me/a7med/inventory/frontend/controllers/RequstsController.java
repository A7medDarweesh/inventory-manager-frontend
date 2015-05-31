package me.a7med.inventory.frontend.controllers;

import java.net.Authenticator.RequestorType;
import java.util.List;

import inventory.pl.dao.OrderRepository;
import inventory.pl.entities.NeedsRequest;
import inventory.pl.services.SaveService;
import inventory.pl.services.SearchService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class RequstsController {
@Inject
SaveService saveService;
@Inject
SearchService searchService;
List<NeedsRequest>userRequests;
}
