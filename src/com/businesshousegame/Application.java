package com.businesshousegame;

import com.businesshousegame.entity.Board;
import com.businesshousegame.entity.BoardCell;
import com.businesshousegame.entity.Hotel;
import com.businesshousegame.entity.HotelType;
import com.businesshousegame.entity.Jail;
import com.businesshousegame.entity.Lottery;
import com.businesshousegame.entity.NormalCell;
import com.businesshousegame.entity.Player;
import com.businesshousegame.service.GamePlayService;
import com.businesshousegame.service.action.impl.HotelActionPerform;
import com.businesshousegame.service.action.impl.JailActionPerform;
import com.businesshousegame.service.action.impl.LotteryActionPerform;
import com.businesshousegame.service.action.impl.NormalActionPerform;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        GamePlayService gamePlayService = getGameplayService();
        List<Player> players = new ArrayList<>();
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please enter player details, enter quit to end game and done for playing after players are entered!");
            String input = scanner.nextLine().trim();
            while (!input.equals("quit")) {
                while(!input.equals("done")) {
                    System.out.print("Enter Player Name : ");
                    input = scanner.nextLine().trim();
                    if("done".equals(input)) break;
                    players.add(new Player(input, 1000, new ArrayList<>(), -1));
                }
                players.forEach(player -> {
                    System.out.print("Enter Move for " + player.getName() + " : ");
                    try{
                        gamePlayService.performMove(Integer.parseInt(scanner.nextLine().trim()), player);
                    } catch (NumberFormatException ex) {
                        System.exit(0);
                    }
                    System.out.println(player.toString());
                    System.out.println(gamePlayService.getBoard().toString());
                });
            }
        }
    }

    private static GamePlayService getGameplayService() {
        Board board = new Board(getSampleBoardCellList(), 5000);
        HotelActionPerform hotelActionPerform = new HotelActionPerform();
        JailActionPerform jailActionPerform = new JailActionPerform();
        LotteryActionPerform lotteryActionPerform = new LotteryActionPerform();
        NormalActionPerform normalActionPerform = new NormalActionPerform();
        return new GamePlayService(board, hotelActionPerform, jailActionPerform, lotteryActionPerform, normalActionPerform);
    }

    private static List<BoardCell> getSampleBoardCellList() {
        List<BoardCell> cells = new LinkedList<>();
        cells.add(new NormalCell());
        cells.add(new Hotel(HotelType.GOLD, "First Hotel"));
        cells.add(new Lottery());
        cells.add(new NormalCell());
        cells.add(new NormalCell());
        cells.add(new Jail());
        cells.add(new NormalCell());
        cells.add(new NormalCell());
        cells.add(new Hotel(HotelType.SILVER, "Second Hotel"));
        cells.add(new NormalCell());
        cells.add(new NormalCell());
        cells.add(new NormalCell());
        cells.add(new Lottery());
        cells.add(new NormalCell());
        cells.add(new NormalCell());
        cells.add(new NormalCell());
        cells.add(new Jail());
        cells.add(new NormalCell());
        cells.add(new Hotel(HotelType.PLATINUM, "Third Hotel"));
        cells.add(new NormalCell());
        cells.add(new NormalCell());
        cells.add(new Lottery());
        cells.add(new NormalCell());
        cells.add(new NormalCell());
        cells.add(new NormalCell());
        cells.add(new Jail());
        cells.add(new NormalCell());
        cells.add(new NormalCell());
        cells.add(new NormalCell());
        cells.add(new Hotel(HotelType.PLATINUM, "Fourth Hotel"));
        cells.add(new Lottery());
        cells.add(new NormalCell());
        cells.add(new Jail());
        cells.add(new NormalCell());
        cells.add(new NormalCell());
        cells.add(new NormalCell());
        return cells;
    }
}
