package com.ftn.agent.dto;

public class ItemDTO {

    private String startPeriodDate;

    private String endPeriodDate;

    private int capacity;

    private double price;

    public ItemDTO() {}

    public String getStartPeriodDate() {
        return startPeriodDate;
    }

    public void setStartPeriodDate(String startPeriodDate) {
        this.startPeriodDate = startPeriodDate;
    }

    public String getEndPeriodDate() {
        return endPeriodDate;
    }

    public void setEndPeriodDate(String endPeriodDate) {
        this.endPeriodDate = endPeriodDate;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
