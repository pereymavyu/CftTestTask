import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        boolean isOrderAscending = true;
        boolean isStringData;
        int optionalArgumentsCount = 0;

        for (String e : args) {
            switch (e) {
                case "-s" -> {
                    isStringData = true;
                    ++optionalArgumentsCount;
                }
                case "-i" -> ++optionalArgumentsCount;
                case "-a" -> ++optionalArgumentsCount;
                case "-d" -> {
                    isOrderAscending = false;
                    ++optionalArgumentsCount;
                }
            }
        }

        int inputFilesAmount = args.length - optionalArgumentsCount - 1;
        String[] inputFileNames = new String[inputFilesAmount];
        System.arraycopy(args, optionalArgumentsCount + 1, inputFileNames, 0, inputFilesAmount);


        System.out.println(Arrays.toString(args));

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(args[optionalArgumentsCount]))) {
            BufferedReader[] ins = new BufferedReader[inputFilesAmount];

            for (int i = 0; i < inputFilesAmount; ++i) {
                ins[i] = new BufferedReader(new FileReader(inputFileNames[i]));
            }




            /*

            int[] numbers = new int[inputFilesAmount];
            String currentLine;
            int endedListCounter = 0;
            boolean[] isEnded = new boolean[inputFilesAmount];


            for (int i = 0; i < ins.length; ++i) {
                if ((currentLine = ins[i].readLine()) != null) {
                    numbers[i] = Integer.parseInt(currentLine);
                } else {
                    isEnded[i] = true;
                    ++endedListCounter;
                }
            }

            int min = numbers[0];
            int minIndex = 0;

            while (endedListCounter < ins.length) {
                for (int i = 0; i < numbers.length; ++i) {
                    if (!isEnded[i]) {
                        minIndex = i;
                        min = numbers[i];
                        break;
                    }
                }

                for (int i = 0; i < numbers.length; ++i) {
                    if (isEnded[i]) {
                        continue;
                    }

                    if (numbers[i] < min) {
                        minIndex = i;
                        min = numbers[i];
                    }
                }

                bw.write(String.valueOf(min));
                bw.newLine();

                String temp;

                if ((temp = ins[minIndex].readLine()) != null) {
                    numbers[minIndex] = Integer.parseInt(temp);
                } else {
                    isEnded[minIndex] = true;
                    ++endedListCounter;
                }
            }*/
        }
    }


    public static void sort(String[] inputFileNames, String outputFileName, DataType dataType, SortingOrder sortingOrder) throws IOException {
        int inputFilesAmount = inputFileNames.length;

        BufferedReader[] input = new BufferedReader[inputFilesAmount];
        for (int i = 0; i < inputFilesAmount; ++i) {
            input[i] = new BufferedReader(new FileReader(inputFileNames[i]));
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName));

        if (dataType == DataType.INTEGER) {
            int[] numbers = new int[inputFilesAmount];
            String currentLine;
            int endedListCounter = 0;
            boolean[] isEnded = new boolean[inputFilesAmount];


            for (int i = 0; i < input.length; ++i) {
                if ((currentLine = input[i].readLine()) != null) {
                    numbers[i] = Integer.parseInt(currentLine);
                } else {
                    isEnded[i] = true;
                    ++endedListCounter;
                }
            }

            int min = numbers[0];
            int minIndex = 0;

            while (endedListCounter < input.length) {
                for (int i = 0; i < numbers.length; ++i) {
                    if (!isEnded[i]) {
                        minIndex = i;
                        min = numbers[i];
                        break;
                    }
                }

                for (int i = 0; i < numbers.length; ++i) {
                    if (isEnded[i]) {
                        continue;
                    }

                    if (numbers[i] < min) {
                        minIndex = i;
                        min = numbers[i];
                    }
                }

                bw.write(String.valueOf(min));
                bw.newLine();

                String temp;

                if ((temp = input[minIndex].readLine()) != null) {
                    numbers[minIndex] = Integer.parseInt(temp);
                } else {
                    isEnded[minIndex] = true;
                    ++endedListCounter;
                }


            }


        }
    }
}
