package com.test.Models;

/**
 * Created by Mike on 3/12/2017.
 */
public class Items {

    private String ProductName;
    private String Description;
    private String Quantity;
    private String Price;
    private String Itemid;
    private String Types;

    public Items(String productName, String description, String quantity, String price, String itemid, String types) {
        ProductName = productName;
        Description = description;
        Quantity = quantity;
        Price = price;
        Itemid = itemid;
        Types = types;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getItemid() {
        return Itemid;
    }

    public void setItemid(String itemid) {
        Itemid = itemid;
    }

    public String getTypes() {
        return Types;
    }

    public void setTypes(String types) {
        Types = types;
    }
}

