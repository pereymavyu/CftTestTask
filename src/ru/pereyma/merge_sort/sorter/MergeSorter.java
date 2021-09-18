package ru.pereyma.merge_sort.sorter;

import ru.pereyma.merge_sort.parser.DataType;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class MergeSorter {
    public static <T extends Comparable<T>> void sort(String[] inputFileNames, String outputFileName, DataType dataType, Comparator<T> comparator) {
        ArrayList<BufferedReader> readers = new ArrayList<>();

        BufferedWriter writer = null;

        try {
            for (String e : inputFileNames) {
                readers.add(new BufferedReader(new FileReader(e)));
            }

            ArrayList<Object> itemsToCompare = new ArrayList<>();

            String currentLine;

            if (dataType == DataType.STRING) {
                for (int i = 0; i < readers.size(); ++i) {
                    if ((currentLine = readers.get(i).readLine()) != null) {
                        itemsToCompare.add(currentLine);
                    } else {
                        readers.get(i).close();
                        readers.remove(i);
                        --i;
                    }
                }
            }

            if (dataType == DataType.INTEGER) {
                for (int i = 0; i < readers.size(); ++i) {
                    while ((currentLine = readers.get(i).readLine()) != null) {
                        try {
                            itemsToCompare.add(Integer.parseInt(currentLine));
                            break;
                        } catch (NumberFormatException ex) {
                            System.out.println("Строка \"" + currentLine + "\" не содержит корректное числовое значение и не включена в отсортированный файл");
                        }
                    }

                    if (currentLine == null) {
                        readers.get(i).close();
                        readers.remove(i);
                        --i;
                    }
                }
            }

            Object selectedItem;
            int selectedItemIndex;

            writer = new BufferedWriter(new FileWriter(outputFileName));

            while (readers.size() > 0) {
                selectedItem = itemsToCompare.get(0);
                selectedItemIndex = 0;

                for (int i = 0; i < readers.size(); ++i) {
                    //noinspection unchecked
                    if (comparator.compare((T) itemsToCompare.get(i), (T) selectedItem) < 0) {
                        selectedItemIndex = i;
                        selectedItem = itemsToCompare.get(i);
                    }
                }

                Object previousSelectedItem = selectedItem;

                writer.write(selectedItem.toString());
                writer.newLine();

                if (dataType == DataType.STRING) {
                    while ((currentLine = readers.get(selectedItemIndex).readLine()) != null) {
                        //noinspection unchecked
                        if (comparator.compare((T) currentLine, (T) previousSelectedItem) >= 0) {
                            itemsToCompare.set(selectedItemIndex, currentLine);
                            break;
                        } else {
                            System.out.println("Входные файлы могут быть некорректно отсортированы, строка \"" + currentLine + "\" выпадает из порядка сортировки и не включена в итоговый файл");
                        }
                    }

                    if (currentLine == null) {
                        readers.get(selectedItemIndex).close();
                        itemsToCompare.remove(selectedItemIndex);
                        readers.remove(selectedItemIndex);
                    }
                }

                if (dataType == DataType.INTEGER) {
                    while ((currentLine = readers.get(selectedItemIndex).readLine()) != null) {
                        Object currentNumber;

                        try {
                            currentNumber = Integer.parseInt(currentLine);
                        } catch (NumberFormatException ex) {
                            System.out.println("Строка \"" + currentLine + "\" не содержит корректное числовое значение и не включена в отсортированный файл");
                            continue;
                        }

                        //noinspection unchecked
                        if (comparator.compare((T) currentNumber, (T) previousSelectedItem) >= 0) {
                            itemsToCompare.set(selectedItemIndex, currentNumber);
                            break;
                        } else {
                            System.out.println("Входные файлы могут быть некорректно отсортированы, значение \"" + currentNumber + "\" выпадает из порядка сортировки и не включено в итоговый файл");
                        }
                    }

                    if (currentLine == null) {
                        readers.get(selectedItemIndex).close();
                        itemsToCompare.remove(selectedItemIndex);
                        readers.remove(selectedItemIndex);
                    }
                }

                writer.flush();
            }

            System.out.println("Сортировка завершена");

        } catch (IOException ex) {
            System.out.println("Проверьте правильность указания выходного и входных файлов");
            System.out.println(ex.getMessage());
        } finally {
            try {
                for (BufferedReader e : readers) {
                    e.close();
                }

                if (writer != null) {
                    writer.close();
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}