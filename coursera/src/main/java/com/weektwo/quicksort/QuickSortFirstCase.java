package com.weektwo.quicksort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Integer.parseInt;

/**
Results:
case 1: 162085
case 2: 164123
case 3: 138382
 */
public class QuickSortFirstCase {

    private static long counter = 0;
    private static int NUMBERS = 10000;

    public static void main(String[] args) throws IOException {
        /** taskCase can be 1 or 2 or 3 */
        int taskCase = 1;
        int[] fullList = new int[NUMBERS];
        fillUpListFromFile(fullList);
        quicksort(fullList, 0, fullList.length, taskCase);
        printResult();
    }

    static int[] fillUpListFromFile(int[] fullList) throws IOException {
        String filePath = new File("").getAbsolutePath();
        BufferedReader buffReader = new BufferedReader(new FileReader(filePath + "/sources/QuickSort.txt"));
        String line = buffReader.readLine();
        for (int i = 0; i < NUMBERS; i++) {
            String strNumLine = line;
            int num = parseInt(strNumLine);
            fullList[i] = num;
            line = buffReader.readLine();
        }
        buffReader.close();
        return fullList;
    }

    static void quicksort(int[] myList, int l, int r, int taskCase) {
        if (l < r) {
            counter += r - l - 1;
            int pivot = 0;
            if(taskCase == 1) {
                /** Usage for first task */
                pivot = chooseFirstElement(myList, l);
            } else if(taskCase == 2) {
                /** Usage for second task */
                pivot = chooseLastElement(myList, l, r);
            } else if(taskCase == 3) {
                /** Usage for third task */
                pivot = choosingMedian(myList, l, r);

            }

            int i = l + 1;
            for (int j = l + 1; j < r; j++) {
                if (myList[j] < pivot) {
                    swap(myList, j, i);
                    i = i + 1;
                }
            }
            swap(myList, i - 1, l);
            quicksort(myList, l, i - 1, taskCase);
            quicksort(myList, i, r, taskCase);
        }
    }

    private static int chooseFirstElement(int[] myList, int l) {
        return myList[l];
    }

    private static int chooseLastElement(int[] myList, int l, int r) {
        swap(myList, r - 1, l);
        return myList[l];
    }

    private static int choosingMedian(int[] myList, int l, int r) {
        int index = (r - 1) - ((r - l) / 2);
        int first = myList[l];
        int middle = myList[index];
        int last = myList[r - 1];
        int median;

        if (middle < first && first < last || last < first && first < middle) median = l;
        else if (first < middle && middle < last || last < middle && middle < first) median = index;
        else median = r - 1;

        swap(myList, median, l);
        return myList[l];
    }

    private static void swap(int[] myList, int j, int i) {
        int temp = myList[j];
        myList[j] = myList[i];
        myList[i] = temp;
    }

    private static void printResult() {
        System.out.println(counter);
    }
}