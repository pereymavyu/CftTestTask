package ru.pereyma.mergesorter.comparators;

import java.util.Comparator;

public class AscendingComparator<T extends Comparable<T>> implements Comparator<T> {
    public int compare(T a, T b) {
        return a.compareTo(b);
    }
}
