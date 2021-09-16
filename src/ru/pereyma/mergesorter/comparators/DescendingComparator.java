package ru.pereyma.mergesorter.comparators;

import java.util.Comparator;

public class DescendingComparator<T extends Comparable<T>> implements Comparator<T> {
    public int compare(T a, T b) {
        return b.compareTo(a);
    }
}
