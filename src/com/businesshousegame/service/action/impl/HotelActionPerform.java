package com.businesshousegame.service.action.impl;

import com.businesshousegame.entity.Board;
import com.businesshousegame.entity.BoardCell;
import com.businesshousegame.entity.Hotel;
import com.businesshousegame.entity.HotelType;
import com.businesshousegame.entity.Player;
import com.businesshousegame.service.action.BaseActionPerform;

public class HotelActionPerform implements BaseActionPerform {

    @Override
    public void perform(BoardCell cell, Player player, Board board) {
        Hotel hotel = (Hotel) cell;
        System.out.println("Welcome to " + hotel.getHotelName() + ", Player " + player.getName());
        if(hotel.getOwner() == null) {
            // Available to buy && user can buy the hotel
            buyHotelAndAssignToUser(player, hotel, board);
        } else {
            // Somebody is owner of hotel
            if(!player.equals(hotel.getOwner())) {
                //Somebody other than player is the owner, pay the rent to player
                rentTheHotel(player, hotel);
            } else {
                upgradeTheHotel(hotel, player, board);
            }
        }
    }


    //Break in simple functions
    //Buying of hotel
    //Rent out a hotel
    //Upgrade the hotel

    private void upgradeTheHotel(Hotel hotel, Player player, Board board) {
        //You`re the owner, try to upgrade
        HotelType nextUpgrade = findNextUpgrade(hotel.getHotelType());
        if(null != nextUpgrade) {
            //Upgrade to next tier
            player.setCash(player.getCash() - (nextUpgrade.getBuyValue() - hotel.getBuyValue()));
            board.setBankCash(board.getBankCash() + (nextUpgrade.getBuyValue() - hotel.getBuyValue()));
            hotel.setHotelType(nextUpgrade);
        } else {
            System.out.println("Hotel is already maxed out");
        }
    }

    private void rentTheHotel(Player player, Hotel hotel) {
        player.setCash(player.getCash() - hotel.getRentValue());
        hotel.getOwner().setCash(hotel.getRentValue());
    }

    private void buyHotelAndAssignToUser(Player player, Hotel hotel, Board board) {
        if(player.getCash() > hotel.getBuyValue()) {
            //Transact the money
            player.setCash(player.getCash() - hotel.getBuyValue());
            board.setBankCash(board.getBankCash() + hotel.getBuyValue());
            //Assign hotel to user
            player.getHotels().add(hotel);
            hotel.setOwner(player);
        } else {
            System.out.println("Not enough money to buy this hotel");
        }
    }

    private HotelType findNextUpgrade(HotelType type) {
        if (type == HotelType.SILVER) {
            return HotelType.GOLD;
        } else if (type == HotelType.GOLD) {
            return HotelType.PLATINUM;
        }
        return null;
    }
}
