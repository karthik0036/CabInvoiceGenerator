package com.bridge.service;

import com.bridge.model.InvoiceSummary;
import com.bridge.model.Ride;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;


public class InvoiceServiceTest {

    InvoiceService invoiceService;

    @Before
    public void before() {
        invoiceService = new InvoiceService();

    }

    @Test
    public void given_DistanceAndTime_ShouldReturn_TotalFare(){

        InvoiceService invoiceService = new InvoiceService();
        double distance = 3.0;
        int time = 3;
        double totalFare = invoiceService.calculateFare(distance, time);
        Assert.assertEquals(33,totalFare,0);

    }

    @Test
    public void given_LessDistanceAndTime_ShouldReturn_MinFare(){

        InvoiceService invoiceService = new InvoiceService();
        double distance = 0.1;
        int time = 1;
        double totalFare = invoiceService.calculateFare(distance, time);
        Assert.assertEquals(5.0,totalFare,0);
    }

    @Test
    public void givenMultipleRides_ShouldReturn_TotalOfTotalRides(){
        Ride[] rides ={
                new Ride(2.0,3),
                new Ride(3.0,4),
                new Ride(4.0,5),
                new Ride(0.1,1),

        };
        InvoiceService invoiceService = new InvoiceService();
        double totalFare = invoiceService.calculateTotalFare(rides);

        Assert.assertEquals(5,totalFare,0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1),
        };
        InvoiceService invoiceService = new InvoiceService();
        InvoiceSummary invoiceSummary = invoiceService.calculateFare(rides);
        InvoiceSummary expectedInvoices = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoices.getInvoiceSummary(), invoiceSummary.getInvoiceSummary());
    }

    @Test
    public void givenUserId_ShouldReturnInvoiceSummary() {
        InvoiceService invoiceService = new InvoiceService();
        InvoiceSummary invoiceSummary = invoiceService.getInvoice(1);
        InvoiceSummary expectedInvoices = new InvoiceSummary(2, 30);
        Assert.assertEquals(expectedInvoices.getInvoiceSummary(), invoiceSummary.getInvoiceSummary());
    }

    //UC-5
    @Test
    public void givenDistanceAndTime_WhenNormal_ShouldReturnTotalFare() {

        double distance = 2.0;
        int time = 5;
        String type = "normal";
        double fare = invoiceService.calculateFare(distance, time, type);
        Assert.assertEquals(25, fare, 0.0);

    }

    @Test
    public void givenLessDistanceAndTime_WhenNormal_ShouldReturnMinFare() {

        double distance = 0.1;
        int time = 1;
        String type = "normal";
        double fare = invoiceService.calculateFare(distance, time, type);
        Assert.assertEquals(5, fare, 0.0);
    }

    @Test
    public void givenMultipleRides_WhenNormal_ShouldReturnTotalFare() {

        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)};
        String type = "normal";
        double totalFare = invoiceService.calculateFare(rides, type);
        Assert.assertEquals(30.0, totalFare, 0.0);
    }


    @Test
    public void givenDistanceAndTime_WhenPremium_ShouldReturnTotalFare() {

        double distance = 2.0;
        int time = 5;
        String type = "premium";
        double fare = invoiceService.calculateFare(distance, time, type);
        Assert.assertEquals(40, fare, 0.0);

    }

    @Test
    public void givenLessDistanceAndTime_WhenPremium_ShouldReturnMinFare() {

        double distance = 0.1;
        int time = 1;
        String type = "premium";
        double fare = invoiceService.calculateFare(distance, time, type);
        Assert.assertEquals(20, fare, 0.0);
    }

    @Test
    public void givenMultipleRides_WhenPremium_ShouldReturnTotalFare() {

        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)};
        String type = "premium";
        double totalFare = invoiceService.calculateFare(rides, type);
        Assert.assertEquals(60, totalFare, 0.0);
    }

    @Test
    public void givenMultipleRides_WhenNormal_ShouldReturnInvoiceSummary() {
        String type = "Normal";
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1),
        };
        InvoiceSummary invoiceSummary = invoiceService.calculateTotalFare(rides, type);
        InvoiceSummary expectedInvoices = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoices.getInvoiceSummary(), invoiceSummary.getInvoiceSummary());
    }

    @Test
    public void givenMultipleRides_WhenPremium_ShouldReturnInvoiceSummary() {
        String type = "Premium";
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1),
        };
        InvoiceSummary invoiceSummary = invoiceService.calculateTotalFare(rides, type);
        InvoiceSummary expectedInvoices = new InvoiceSummary(2, 60.0);
        Assert.assertEquals(expectedInvoices.getInvoiceSummary(), invoiceSummary.getInvoiceSummary());
    }






}
