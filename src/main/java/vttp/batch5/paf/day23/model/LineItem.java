package vttp.batch5.paf.day23.model;

public class LineItem {

    // {"name":"fff","address":"fff","deliveryDate":"2025-01-17","lineItems":[{"name":"fffff","quantity":1,"unitPrice":0.1},{"name":"fff","quantity":1,"unitPrice":0.1}]}

    private String name; 
    private int quantity; 
    private float unitPrice;
    public LineItem() {
    }
    public LineItem(String name, int quantity, float unitPrice) {
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public float getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    } 
}
