package com.businesshousegame.service.action.impl;

import com.businesshousegame.entity.Board;
import com.businesshousegame.entity.BoardCell;
import com.businesshousegame.entity.Player;
import com.businesshousegame.service.action.BaseActionPerform;

public class LotteryActionPerform implements BaseActionPerform {
    @Override
    public void perform(BoardCell cell, Player player, Board board) {
        System.out.println(player.getName() + " Won a lottery!!");
        player.setCash(player.getCash() + cell.getCost());
        board.setBankCash(board.getBankCash() - cell.getCost());
    }
}
