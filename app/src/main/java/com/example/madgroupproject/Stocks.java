package com.example.madgroupproject;

import java.util.Date;

public class Stocks {

    private int serialNumber;
    private String StockOwner;
    private String WarehouseLocation;
    private String InsideStock;
    private Date DiliverDate;

    public Stocks(String s1, String stockOwner, String string, String s, String toString){

    }

    public Stocks(int serialNumber, String stockOwner, String warehouseLocation, String insideStock, Date diliverDate) {
        this.serialNumber = serialNumber;
        StockOwner = stockOwner;
        WarehouseLocation = warehouseLocation;
        InsideStock = insideStock;
        DiliverDate = diliverDate;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
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

    public Date getDiliverDate() {
        return DiliverDate;
    }

    public void setDiliverDate(Date diliverDate) {
        DiliverDate = diliverDate;
    }
}
