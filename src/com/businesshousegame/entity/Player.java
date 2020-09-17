package com.businesshousegame.entity;

import java.util.List;
import java.util.stream.Collectors;

public class Player {

    private String name;
    private	int cash;
    private List<Hotel> hotels;
    private	int position;

    public Player(String name, int cash, List<Hotel> hotels, int position) {
        this.name = name;
        this.cash = cash;
        this.hotels = hotels;
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position % Constants.MAX_BAORD_SIZE;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if(null == obj) return false;
        if(!(obj instanceof Player)) return false;
        Player other = (Player) obj;
        return this.name.equals(other.name);
    }

    @Override
    public String toString() {
        return "Player[Name=" + name + ", Cash=" + cash + ", Position=" + position + ", Hotels={" +
                hotels.stream().map(Hotel::toString).collect(Collectors.joining(",")) +"}]";
    }
}
