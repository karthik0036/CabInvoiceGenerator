package com.bridge.service;

import com.bridge.model.InvoiceSummary;
import com.bridge.model.Ride;
import org.junit.Test;
import org.junit.Assert;


public class InvoiceServiceTest {

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




}
