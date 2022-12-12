package com.connor.module34;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static ArrayList<PlayerBattingStats> players;

    /**
     * Takes in a comma sperated values file and parses the data.  It takes the data and
     * creates a PlayerBattingStats object and adds it to the players list.  The CSV file
     * must be in the format of:
     * Name,Team,Gamesplayed,At bats, runs, hits, doubles, triples, home runs, rbi's
     * @param file containg the data
     */
    public static void parseCSVData(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] splitter = line.split(",");
            String name = splitter[0];
            String team = splitter[1];
            int gamesPlayed = Integer.parseInt(splitter[2]);
            int atBats = Integer.parseInt(splitter[3]);
            int runs = Integer.parseInt(splitter[4]);
            int hits = Integer.parseInt(splitter[5]);
            int doubles = Integer.parseInt(splitter[6]);
            int triples = Integer.parseInt(splitter[7]);
            int homeRunes = Integer.parseInt(splitter[8]);
            int rbis = Integer.parseInt(splitter[9]);
            players.add(new PlayerBattingStats(name, team, gamesPlayed, atBats, runs, hits, doubles, triples, homeRunes, rbis));
        }

    }

    public static void main(String[] args) {
        players = new ArrayList<>();
        try {
            parseCSVData(new File("src/com/connor/module34/PlayerData.csv"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (PlayerBattingStats player : players) {
            System.out.println(player);
        }

        System.out.println("*************Sorted by Games***************");
        for (PlayerBattingStats player : PlayerSorter.sort(players, 0)) {
            System.out.println(player);
        }
        System.out.println("*************Sorted by At-Bats***************");
        for (PlayerBattingStats player : PlayerSorter.sort(players, 1)) {
            System.out.println(player);
        }
        System.out.println("*************Sorted by Runs***************");
        for (PlayerBattingStats player : PlayerSorter.sort(players, 2)) {
            System.out.println(player);
        }
        System.out.println("*************Sorted by Percent-Runs***************"); // Calculated by: runs/atBats
        for (PlayerBattingStats player : PlayerSorter.sort(players, 3)) {
            System.out.println(player);
        }
        System.out.println("*************Sorted by Percent-On-Base***************"); // Calculated by (hits + doubles + triples) / atBats
        for (PlayerBattingStats player : PlayerSorter.sort(players, 4)) {
            System.out.println(player);
        }
    }
}
