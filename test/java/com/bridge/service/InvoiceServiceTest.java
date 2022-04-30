package com.bridge.service;

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



}
