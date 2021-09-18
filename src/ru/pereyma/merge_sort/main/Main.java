package ru.pereyma.merge_sort.main;

import ru.pereyma.merge_sort.parser.CommandLineArgumentsParser;
import ru.pereyma.merge_sort.sorter.MergeSorter;

public class Main {
    public static <T extends Comparable<T>> void main(String[] args) {
        CommandLineArgumentsParser<T> parser = new CommandLineArgumentsParser<>(args);

        MergeSorter.sort(parser.getInputFiles(), parser.getOutputFile(), parser.getDataType(), parser.getComparator());
    }
}