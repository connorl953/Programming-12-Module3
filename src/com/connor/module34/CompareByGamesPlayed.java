package com.connor.module34;

import java.util.Comparator;

public class CompareByGamesPlayed implements Comparator<PlayerBattingStats> {

    /**
     *
     * @param o1 left element
     * @param o2 right element
     * @return Negative if left is more than right, positive otherwise.
     */
    @Override
    public int compare(PlayerBattingStats o1, PlayerBattingStats o2) {
        return o2.getGames() - o1.getGames();
    }
}
