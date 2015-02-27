package com.syngenta.rhoffman.syngenta;

/**
 *
 */
public class BulkSite {

    public String[] productList = {};
    public String location;
    public int open;
    public int close;

    public BulkSite(String locationCityState, int openTime, int closeTime, String[] productListArray){

        location = locationCityState;
        open = openTime;
        close = closeTime;
        productList = productListArray;

    }

    private String[] getProductList(){

        return productList;

    }



}
