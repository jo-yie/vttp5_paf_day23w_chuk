package vttp.batch5.paf.day23.model;

import java.util.Date;
import java.util.List;

public class ShoppingCart {

    // {"name":"fff","address":"fff","deliveryDate":"2025-01-17","lineItems":[{"name":"fffff","quantity":1,"unitPrice":0.1},{"name":"fff","quantity":1,"unitPrice":0.1}]}

    private String name; 
    private String address; 
    private Date deliveryDate;
    private List<LineItem> lineItems;
    public ShoppingCart() {
    }
    public ShoppingCart(String name, String address, Date deliveryDate, List<LineItem> lineItems) {
        this.name = name;
        this.address = address;
        this.deliveryDate = deliveryDate;
        this.lineItems = lineItems;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Date getDeliveryDate() {
        return deliveryDate;
    }
    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
    public List<LineItem> getLineItems() {
        return lineItems;
    }
    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }
}
