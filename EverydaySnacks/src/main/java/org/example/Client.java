package org.example;

public class Client {
    private int ClientId;
    private String name;
    private double basicDiscount;
    private double volumeDiscountAbove10000;
    private double volumeDiscountAbove30000;

    public Client(int clientId, String name, double basicDiscount, double volumeDiscountAbove10000, double volumeDiscountAbove30000) {
        ClientId = clientId;
        this.name = name;
        this.basicDiscount = basicDiscount;
        this.volumeDiscountAbove10000 = volumeDiscountAbove10000;
        this.volumeDiscountAbove30000 = volumeDiscountAbove30000;
    }

    public double clientDiscount(double totalPrice){
        totalPrice = totalPrice - (totalPrice * getBasicDiscount());
        return totalPrice;
    }
    double discountAbove(double totalPrice){
        if(totalPrice > 30000){
            totalPrice = totalPrice - (totalPrice * getVolumeDiscountAbove30000());
        } else if (totalPrice > 10000) {
            totalPrice = totalPrice - (totalPrice * getVolumeDiscountAbove10000());
        } else {
            return totalPrice;
        }
        return totalPrice;
    }
    public double allDiscount(double totalPrice){
        totalPrice = totalPrice - (totalPrice * getBasicDiscount());
        if(totalPrice > 30000){
            totalPrice = totalPrice - (totalPrice * getVolumeDiscountAbove30000());
        } else if (totalPrice > 10000) {
            totalPrice = totalPrice - (totalPrice * getVolumeDiscountAbove10000());
        } else {
            return totalPrice;
        }
        return totalPrice;

    }

    public int getClientId() {
        return ClientId;
    }

    public void setClientId(int clientId) {
        ClientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBasicDiscount() {
        return basicDiscount;
    }

    public void setBasicDiscount(double basicDiscount) {
        this.basicDiscount = basicDiscount;
    }

    public double getVolumeDiscountAbove10000() {
        return volumeDiscountAbove10000;
    }

    public void setVolumeDiscountAbove10000(double volumeDiscountAbove10000) {
        this.volumeDiscountAbove10000 = volumeDiscountAbove10000;
    }

    public double getVolumeDiscountAbove30000() {
        return volumeDiscountAbove30000;
    }

    public void setVolumeDiscountAbove30000(double volumeDiscountAbove30000) {
        this.volumeDiscountAbove30000 = volumeDiscountAbove30000;
    }
}
