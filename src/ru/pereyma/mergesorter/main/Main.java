package ru.pereyma.mergesorter.main;

import ru.pereyma.mergesorter.parser.CommandLineArgumentsParser;
import ru.pereyma.mergesorter.sorter.MergeSorter;

public class Main {
    public static <T extends Comparable<T>> void main(String[] args) {
        CommandLineArgumentsParser<T> parser = new CommandLineArgumentsParser<>(args);

        MergeSorter.sort(parser.getInputFiles(), parser.getOutputFile(), parser.getDataType(), parser.getComparator());
    }
}