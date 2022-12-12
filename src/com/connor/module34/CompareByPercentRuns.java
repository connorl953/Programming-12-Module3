package com.connor.module34;

import java.util.Comparator;

public class CompareByPercentRuns implements Comparator<PlayerBattingStats> {
    // Calculated by: runs/atBats
    @Override
    public int compare(PlayerBattingStats o1, PlayerBattingStats o2) {
        double o1P = (double)o1.getRuns()/o1.getAtBats();
        double o2P = (double)o2.getRuns()/o2.getAtBats();
        return (int) ((o2P - o1P) * 100);
    }
}
