package com.company;

import java.util.Comparator;

public class NameComparator implements Comparator<Enrollee> {
    @Override
    public int compare(Enrollee o1, Enrollee o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
