package com.businesshousegame.service.action.impl;

import com.businesshousegame.entity.Board;
import com.businesshousegame.entity.BoardCell;
import com.businesshousegame.entity.Player;
import com.businesshousegame.service.action.BaseActionPerform;

public class NormalActionPerform implements BaseActionPerform {
    @Override
    public void perform(BoardCell cell, Player player, Board board) {
        //Do nothing
        System.out.println("Normal cell");
    }
}
