package ru.pereyma.mergesorter;

import ru.pereyma.mergesorter.comparators.AscendingComparator;
import ru.pereyma.mergesorter.comparators.DescendingComparator;

import java.util.Comparator;

public class CommandLineArgumentsParser<T extends Comparable<T>> {
    private DataType dataType = DataType.INTEGER;
    private Comparator<T> comparator = new AscendingComparator<>();
    private final String[] inputFiles;
    private final String outputFile;

    public CommandLineArgumentsParser(String[] args) {
        int modifiersAmount = 0;

        for (String e : args) {
            switch (e) {
                case "-s" -> {
                    dataType = DataType.STRING;
                    ++modifiersAmount;
                }
                case "-i", "-a" -> ++modifiersAmount;
                case "-d" -> {
                    comparator = new DescendingComparator<>();
                    ++modifiersAmount;
                }
            }
        }

        outputFile = args[modifiersAmount];

        int inputFilesAmount = args.length - modifiersAmount - 1;
        inputFiles = new String[inputFilesAmount];
        System.arraycopy(args, modifiersAmount + 1, inputFiles, 0, inputFilesAmount);
    }

    public DataType getDataType() {
        return dataType;
    }

    public Comparator<T> getComparator() {
        return comparator;
    }

    public String[] getInputFiles() {
        return inputFiles;
    }

    public String getOutputFile() {
        return outputFile;
    }
}


