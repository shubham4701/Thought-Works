package com.businesshousegame.entity;

import java.util.List;

public class Board {

    private List<BoardCell> cells;
    private int bankCash;

    public Board(List<BoardCell> cells, int cashToStart) {
        this.cells = cells;
        this.bankCash = cashToStart;
    }

    public BoardCell getNextCell(int diceValue) {
        return cells.get(diceValue % Constants.MAX_BAORD_SIZE);
    }

    public int getBankCash() {
        return bankCash;
    }

    public void setBankCash(int bankCash) {
        this.bankCash = bankCash;
    }

    @Override public String toString() {
        return "Board[BankCash=" + bankCash + "]";
    }
}
