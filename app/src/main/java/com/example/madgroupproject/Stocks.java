package com.example.madgroupproject;

public class Stocks {
    private String serialNumber;
    private String StockOwner;
    private String WarehouseLocation;
    private String InsideStock;
    private String Price;
    private String Quantity;



    public Stocks(String serialNumber, String stockOwner, String warehouseLocation, String insideStock, String price, String quantity) {
        this.serialNumber = serialNumber;
        StockOwner = stockOwner;
        WarehouseLocation = warehouseLocation;
        InsideStock = insideStock;
        Price = price;
        Quantity = quantity;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getStockOwner() {
        return StockOwner;
    }

    public void setStockOwner(String stockOwner) {
        StockOwner = stockOwner;
    }

    public String getWarehouseLocation() {
        return WarehouseLocation;
    }

    public void setWarehouseLocation(String warehouseLocation) {
        WarehouseLocation = warehouseLocation;
    }

    public String getInsideStock() {
        return InsideStock;
    }

    public void setInsideStock(String insideStock) {
        InsideStock = insideStock;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }
}
