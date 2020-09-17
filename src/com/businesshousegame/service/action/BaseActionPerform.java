package com.businesshousegame.service.action;

import com.businesshousegame.entity.Board;
import com.businesshousegame.entity.BoardCell;
import com.businesshousegame.entity.Player;

public interface BaseActionPerform {
    void perform(BoardCell cell, Player player, Board board);
}
