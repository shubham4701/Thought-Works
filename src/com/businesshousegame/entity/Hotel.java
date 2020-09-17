package com.businesshousegame.entity;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class Hotel implements BoardCell {

    private HotelType hotelType;
    private Player owner;
    private String hotelName;

    public Hotel(HotelType hotelType, String hotelName) {
        this.hotelType = hotelType;
        this.hotelName = hotelName;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public Player getOwner() {
        return owner;
    }

    public HotelType getHotelType() {
        return hotelType;
    }

    public void setHotelType(HotelType hotelType) {
        this.hotelType = hotelType;
    }

    public int getBuyValue() {
        return this.hotelType.getBuyValue();
    }

    public int getRentValue() {
        return this.hotelType.getRentValue();
    }

    public String getHotelName() {
        return hotelName;
    }

    @Override
    public Integer getCost() {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if(null == obj) return false;
        if(!(obj instanceof Hotel)) return false;
        Hotel other = (Hotel) obj;
        return this.hotelName.equals(other.hotelName);
    }

    @Override
    public String toString() {
        return "Hotel[Name=" + this.hotelName + ", Type=" + this.hotelType.getType() + "]";
    }
}
