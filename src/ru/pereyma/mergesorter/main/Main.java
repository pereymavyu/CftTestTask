package ru.pereyma.mergesorter.main;

import ru.pereyma.mergesorter.parser.CommandLineArgumentsParser;
import ru.pereyma.mergesorter.sorter.MergeSorter;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        CommandLineArgumentsParser parser = new CommandLineArgumentsParser(args);

        MergeSorter.sort(parser.getInputFiles(), parser.getOutputFile(), parser.getDataType(), parser.getComparator());
    }
}