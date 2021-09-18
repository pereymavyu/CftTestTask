## Программа MergeSort

### Описание программы
Программа производит сортировку слиянием файлов, содержащих данные одного из двух видов: 
целые числа или строки. Данные в файлах должны быть записаны записаны в столбик (каждая строка файла – новый элемент). 
Строки могут содержать любые не пробельные символы. Считается, что файлы предварительно отсортированы.

### Инструкция по запуску:
1) Скачать исполняемый файл программы из /out/artifacts/MergeSort_jar/MergeSort.jar
в папку на компьютере;
2) Поместить в папку с исполняемым файлом файлы для сортировки;
3) В командной строке перейти в папку с исполняемым файлом;
4) Запустить программу с указанием следущих параметров (через пробел, в указанном порядке):
- режим сортировки (-a или -d), необязательный, по умолчанию сортируем по возрастанию;
- тип данных (-s или -i), обязательный;
- имя выходного файла, обязательное;
- остальные параметры – имена входных файлов, не менее одного.

Пример команды для запуска программы:
 java -jar MergeSort.jar -d -i out.txt in1.txt in2.txt in3.txt

* Для запуска jar-файлов на компьютере должна быть установлена Java (www.java.com/ru/download/manual.jsp)


### Особенности реализации:
1. Если исходные файлы не отсортированы корректно и содержат выпадающие значения (строки или цифры), 
то эти значения не записываются в итоговый отсортированный файл, сообщения об этих значениях 
выводится на консоль;
2. Если при сортировке целых чисел входные файлы содержат некорректные данные (строки не содержащие чисел, пустые строки) 
то эти строки не записываются в итоговый отсортированный файл, сообщения об этих значениях выводится на консоль; 
