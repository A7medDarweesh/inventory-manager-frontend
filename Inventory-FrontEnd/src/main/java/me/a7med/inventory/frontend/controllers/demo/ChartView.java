/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.a7med.inventory.frontend.controllers.demo;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author ahmed_darweeesh
 */
@Named
public class ChartView {
    private BarChartModel barModel;
    private PieChartModel pieModel1;
 
    @PostConstruct
    public void init() {
        createBarModels();
        createPieModels();
    }
 
    public BarChartModel getBarModel() {
        return barModel;
    }
     
    public PieChartModel getPieModel1() {
        return pieModel1;
    }
 
    private void createBarModels() {
        createBarModel();
    }
     
    private void createBarModel() {
        barModel = initBarModel();
         
        barModel.setTitle("Bar Chart");
        barModel.setLegendPosition("ne");
         barModel.setAnimate(true);
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Warehouses Movements");
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Number of Transactions");
        yAxis.setMin(0);
        yAxis.setMax(200);
    }
     
    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
 
        ChartSeries ins = new ChartSeries();
        ins.setLabel("To Warehouse Transactions");
        ins.set("WH 1", 120);
        ins.set("WH 2", 100);
        ins.set("WH 3", 44);
        ins.set("WH 4", 150);
        ins.set("WH 5", 25);
 
        ChartSeries outs = new ChartSeries();
        outs.setLabel("From Warehouse Transaction");
        outs.set("WH 1", 52);
        outs.set("WH 2", 60);
        outs.set("WH 3", 110);
        outs.set("WH 4", 135);
        outs.set("WH 5", 120);
 
        model.addSeries(ins);
        model.addSeries(outs);
         
        return model;
    }
 
    private void createPieModels() {
        createPieModel1();
    }
     
    private void createPieModel1() {
        pieModel1 = new PieChartModel();
         
        pieModel1.set("warehouse 1", 540);
        pieModel1.set("warehouse 2", 325);
        pieModel1.set("warehouse 3", 702);
        pieModel1.set("warehouse 4", 421);
        pieModel1.set("warehouse 5", 421);
         
        pieModel1.setTitle("Products Distribution on Warehouses");
        pieModel1.setLegendPosition("w");
    }
 
    public void itemSelect(ItemSelectEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
                        "Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());
         
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
