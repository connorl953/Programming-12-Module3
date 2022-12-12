package com.connor.module34;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Class that takes in an ArrayList and sorts the players by various criteria
 * using a mergesort.
 */

public class PlayerSorter {
    //The following fields are the different sort types:
    public static int GAMESPLAYED = 0;
    public static int ATBATS = 1;
    public static int RUNS = 2;
    public static int PERCENTRUNS = 3; // Calculated by: runs/atBats
    public static int PERCENTONBASE = 4; // Calculated by (hits + doubles + triples) / atBats

    /**
     * This method is an interface that allows the sorting of a player given based on
     * certain criteria.  There are 5 options to sort a player which are by Games played,
     * at bats, runs, percent runs, percent on base.
     * The sort is in descending order (Largest to smallest)
     * This method calls one of 5 private methods that will do the sort based on the chosen criteria.
     * @param list List of players containing the statistics
     * @param sortType How the user wants the players sorted.  The value should be chosed from one of
     *                 the 5 static fields from the class.
     * @return An ArrayList that is sorted according to the users specification.
     */
    public static ArrayList<PlayerBattingStats> sort(ArrayList<PlayerBattingStats> list, int sortType) {
        switch(sortType){
            case 0: {
                return sortByGamesPlayed(list);
            }
            case 1: {
                return sortByAtBats(list);
            }
            case 2: {
                return sortByRuns(list);
            }
            case 3: {
                return sortByPercentRuns(list);
            }
            case 4: {
                return sortByPercentOnBase(list);
            }
            default:{
                return null;
            }
        }

    }

    private static ArrayList<PlayerBattingStats> sortByGamesPlayed(ArrayList<PlayerBattingStats> list){
        return mergeSort(list, new CompareByGamesPlayed());
    }
    private static ArrayList<PlayerBattingStats> sortByAtBats(ArrayList<PlayerBattingStats> list){
        return mergeSort(list, new CompareByAtBats());
    }
    private static ArrayList<PlayerBattingStats> sortByRuns(ArrayList<PlayerBattingStats> list){
        return mergeSort(list, new CompareByRuns());
    }
    private static ArrayList<PlayerBattingStats> sortByPercentRuns(ArrayList<PlayerBattingStats> list){
        return mergeSort(list, new CompareByPercentRuns());
    }
    private static ArrayList<PlayerBattingStats> sortByPercentOnBase(ArrayList<PlayerBattingStats> list){
        return mergeSort(list, new CompareByPercentOnBase());
    }


    /**
     * mergeSort() is a private static method that takes an ArrayList of PlayerBattingStats objects and a Comparator object as parameters.
     * With the help of merge(), it uses the merge sort algorithm to sort the ArrayList of PlayerBattingStats objects according to the Comparator object.
     * It returns an ArrayList of PlayerBattingStats objects that is sorted according to the Comparator object.
     * @param p The list to sort
     * @param c The comparator to use for sorting
     * @return a sorted version of list p
     */
    private static ArrayList<PlayerBattingStats> mergeSort(ArrayList<PlayerBattingStats> p, Comparator<PlayerBattingStats> c) {
        ArrayList<PlayerBattingStats> result = new ArrayList<>();
        if (p.size() <= 1) {
            result.add(p.get(0));
            return result;
        }
        int mid = p.size() / 2;
        ArrayList<PlayerBattingStats> left = new ArrayList<>(p.subList(0, mid));
        ArrayList<PlayerBattingStats> right = new ArrayList<>(p.subList(mid, p.size()));
        ArrayList<PlayerBattingStats> leftList = mergeSort(left, c);
        ArrayList<PlayerBattingStats> rightList = mergeSort(right, c);
        result = merge(leftList, rightList, c);
        return result;
    }


    private static ArrayList<PlayerBattingStats> merge(ArrayList<PlayerBattingStats> left, ArrayList<PlayerBattingStats> right, Comparator<PlayerBattingStats> c) {
        ArrayList<PlayerBattingStats> result = new ArrayList<>();
        while (left.size() > 0 || right.size() > 0) {
            if (left.size() > 0 && right.size() > 0) {
                if (c.compare(left.get(0), right.get(0)) < 0) {
                    result.add(left.get(0));
                    left.remove(0);
                } else {
                    result.add(right.get(0));
                    right.remove(0);
                }
            } else if (left.size() > 0) {
                result.add(left.get(0));
                left.remove(0);
            } else {
                result.add(right.get(0));
                right.remove(0);
            }
        }

        return result;
    }
}
