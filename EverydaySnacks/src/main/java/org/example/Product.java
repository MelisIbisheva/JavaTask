package org.example;

public class Product {
    private int productId;
    private String productName;
    private double unitCost;
    private double markup;
    private String promotion;

    public Product(int productId, String productName, double unitCost, double markup, String promotion) {
        this.productId = productId;
        this.productName = productName;
        this.unitCost = unitCost;
        this.markup = markup;
        this.promotion = promotion;
    }

    public double calculateStandardUnitPrice(){
        double calculatePrice = 0 ;
        if(this.productId==1 || this.productId==2){
            calculatePrice = this.unitCost + (this.unitCost * this.markup);
        }else {
            calculatePrice = this.unitCost + this.markup;
        }
        return roundToTwoDecimals(calculatePrice);
    }
    public double calculatePromotionalUnitPrice(){
        double calculatePrice = 0;
        if (this.promotion.equals("30% off")) {
           calculatePrice = calculateStandardUnitPrice()  - (calculateStandardUnitPrice() * 0.30);
        }
        return roundToFiveDecimals(calculatePrice);
    }
    public double calculatePromotionalUnitPrice(int quantity){
        double promotionalPrice = 0;
        if(this.promotion.equals("Buy 2, get 3rd free") && quantity>2) {
            int paidItems = quantity - (quantity / 3);
            double totalPrice = paidItems * calculateStandardUnitPrice();
            promotionalPrice = totalPrice / quantity;
        }
        return roundToFiveDecimals(promotionalPrice);
    }
    private  double roundToFiveDecimals(double value) {
        return Math.round(value * 100000.0) / 100000.0;
    }
    private  double roundToTwoDecimals(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    public double getMarkup() {
        return markup;
    }

    public void setMarkup(double markup) {
        this.markup = markup;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }
}
