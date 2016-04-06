package com.company;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Card> sets = new ArrayList<Card>();

    public void addSet(final Card a, final Card b, final Card c) {
        sets.add(a);
        sets.add(b);
        sets.add(c);
    }

    public int countSets() {
        return sets.size();
    }
}
