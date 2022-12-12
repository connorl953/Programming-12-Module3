package com.connor.module34;

import java.util.Comparator;

public class CompareByRuns implements Comparator<PlayerBattingStats> {
    @Override
    public int compare(PlayerBattingStats o1, PlayerBattingStats o2) {
        return o2.getRuns() - o1.getRuns();
    }
}
