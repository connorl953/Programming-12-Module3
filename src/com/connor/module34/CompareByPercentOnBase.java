package com.connor.module34;

import java.util.Comparator;

public class CompareByPercentOnBase implements Comparator<PlayerBattingStats> {

    // Calculated by (hits + doubles + triples) / atBats
    @Override
    public int compare(PlayerBattingStats o1, PlayerBattingStats o2) {
        double o1P = ((double)o1.getHits() + o1.getDoubles() + o1.getTriples()) / o1.getAtBats();
        double o2P = ((double)o2.getHits() + o2.getDoubles() + o2.getTriples()) / o2.getAtBats();
        return (int) ((o2P - o1P) * 100);
    }
}
