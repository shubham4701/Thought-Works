package com.businesshousegame.service;

import com.businesshousegame.entity.Board;
import com.businesshousegame.entity.BoardCell;
import com.businesshousegame.entity.Hotel;
import com.businesshousegame.entity.Jail;
import com.businesshousegame.entity.Lottery;
import com.businesshousegame.entity.Player;
import com.businesshousegame.service.action.BaseActionPerform;
import com.businesshousegame.service.action.impl.HotelActionPerform;
import com.businesshousegame.service.action.impl.JailActionPerform;
import com.businesshousegame.service.action.impl.LotteryActionPerform;
import com.businesshousegame.service.action.impl.NormalActionPerform;

public class GamePlayService {

    private Board board;
    private HotelActionPerform hotelActionPerform;
    private JailActionPerform jailActionPerform;
    private LotteryActionPerform lotteryActionPerform;
    private NormalActionPerform normalActionPerform;
    private BaseActionPerform finalAction;

    public GamePlayService(Board board, HotelActionPerform hotelActionPerform, JailActionPerform jailActionPerform,
            LotteryActionPerform lotteryActionPerform, NormalActionPerform normalActionPerform) {
        this.board = board;
        this.hotelActionPerform = hotelActionPerform;
        this.jailActionPerform = jailActionPerform;
        this.lotteryActionPerform = lotteryActionPerform;
        this.normalActionPerform = normalActionPerform;
    }

    public void performMove(int nextTurn, Player player) {
        BoardCell cell = board.getNextCell(player.getPosition() + nextTurn);
        if(cell instanceof Hotel) {
            finalAction = hotelActionPerform;
        } else if (cell instanceof Jail) {
            finalAction = jailActionPerform;
        } else if (cell instanceof Lottery) {
            finalAction = lotteryActionPerform;
        } else {
            finalAction = normalActionPerform;
        }
        finalAction.perform(cell, player, board);
        player.setPosition(player.getPosition() + nextTurn);
    }

    public Board getBoard() {
        return board;
    }
}
