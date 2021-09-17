package ru.pereyma.mergesorter.parser;

import java.util.Comparator;

public class CommandLineArgumentsParser<T extends Comparable<T>> {
    private DataType dataType = DataType.INTEGER;
    private Comparator<T> comparator = new AscendingComparator<>();
    private final String[] inputFiles;
    private final String outputFile;

    public CommandLineArgumentsParser(String[] args) {
        int dataTypeModifiersAmount = 0;
        int sortingOrderModifiersAmount = 0;

        for (String e : args) {
            switch (e) {
                case "-s" -> {
                    dataType = DataType.STRING;
                    ++dataTypeModifiersAmount;
                }
                case "-i" -> ++dataTypeModifiersAmount;
                case "-a" -> ++sortingOrderModifiersAmount;
                case "-d" -> {
                    comparator = new DescendingComparator<>();
                    ++sortingOrderModifiersAmount;
                }
            }
        }

        if(dataTypeModifiersAmount < 1) {
            System.out.println("Укажите модификатор данных: \"-s\" - строки, \"-i\" - целые числа");

            System.exit(0);
        }

        int totalModifiersAmount = dataTypeModifiersAmount + sortingOrderModifiersAmount;

        outputFile = args[totalModifiersAmount];

        int inputFilesAmount = args.length - totalModifiersAmount - 1;
        inputFiles = new String[inputFilesAmount];
        System.arraycopy(args, totalModifiersAmount + 1, inputFiles, 0, inputFilesAmount);
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


