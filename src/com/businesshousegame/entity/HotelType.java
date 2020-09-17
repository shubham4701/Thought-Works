package com.businesshousegame.entity;

public enum HotelType {

    GOLD(300, 150), SILVER(200, 50), PLATINUM(500, 300);

    private final int buyValue;
    private final int rentValue;

    HotelType(int buyValue, int rentValue) {
        this.buyValue = buyValue;
        this.rentValue = rentValue;
    }

    public int getBuyValue() {
        return buyValue;
    }

    public int getRentValue() {
        return rentValue;
    }

    public String getType() {
        switch (this) {
        case SILVER:
            return "Silver";
        case GOLD:
            return "Gold";
        case PLATINUM:
            return "Platinum";
        }
        return null;
    }
}

