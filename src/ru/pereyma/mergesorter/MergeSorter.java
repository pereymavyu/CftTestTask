package ru.pereyma.mergesorter;

import ru.pereyma.mergesorter.DataType;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class MergeSorter {
    public static void sort(String[] inputFileNames, String outputFileName, DataType dataType, Comparator comparator) throws IOException {
        ArrayList<BufferedReader> input = new ArrayList<>();

        for (String e : inputFileNames) {
            input.add(new BufferedReader(new FileReader(e)));
        }

        ArrayList<Comparable> itemsToCompare = new ArrayList<>();

        String currentLine;

        if (dataType == DataType.STRING) {
            for (int i = 0; i < input.size(); ++i) {
                if ((currentLine = input.get(i).readLine()) != null) {
                    itemsToCompare.add(currentLine);
                } else {
                    input.get(i).close();
                    input.remove(i);
                    --i;
                }
            }
        }

        if (dataType == DataType.INTEGER) {
            for (int i = 0; i < input.size(); ++i) {
                while ((currentLine = input.get(i).readLine()) != null) {
                    try {
                        itemsToCompare.add(Integer.parseInt(currentLine.trim()));
                        break;
                    } catch (NumberFormatException ex) {
                        System.out.println("String \"" + currentLine + "\" was not processed");
                    }
                }

                if (currentLine == null) {
                    input.get(i).close();
                    input.remove(i);
                    --i;
                }
            }
        }

        Comparable selectedItem;
        int selectedItemIndex;

        BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName));

        while (input.size() > 0) {
            selectedItem = itemsToCompare.get(0);
            selectedItemIndex = 0;

            for (int i = 0; i < input.size(); ++i) {
                if (comparator.compare(itemsToCompare.get(i), selectedItem) < 0) {
                    selectedItemIndex = i;
                    selectedItem = itemsToCompare.get(i);
                }
            }

            bw.write(selectedItem.toString());
            bw.newLine();

            if (dataType == DataType.STRING) {
                if ((currentLine = input.get(selectedItemIndex).readLine()) != null) {
                    itemsToCompare.set(selectedItemIndex, currentLine);
                } else {
                    input.get(selectedItemIndex).close();
                    itemsToCompare.remove(selectedItemIndex);
                    input.remove(selectedItemIndex);
                }
            }

            if (dataType == DataType.INTEGER) {
                while ((currentLine = input.get(selectedItemIndex).readLine()) != null) {
                    try {
                        itemsToCompare.set(selectedItemIndex, Integer.parseInt(currentLine.trim()));
                        break;
                    } catch (NumberFormatException ex) {
                        System.out.println("String \"" + currentLine + "\" was not processed");
                    }
                }

                if (currentLine == null) {
                    input.get(selectedItemIndex).close();
                    itemsToCompare.remove(selectedItemIndex);
                    input.remove(selectedItemIndex);
                }
            }
        }

        bw.close();
    }
}