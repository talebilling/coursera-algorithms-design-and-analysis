package com.weekone.inversioncount;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import static java.lang.Integer.parseInt;


public class IntArrayMergeSort {

    public static void main(String[] args) throws IOException {
        List<Integer> myList = new ArrayList<>();
        String filePath = new File("").getAbsolutePath();
        System.out.println(filePath);
        BufferedReader buffReader = new BufferedReader(new FileReader(filePath + "/sources/integerArray.txt"));
        String line = buffReader.readLine();
        while (line != null) {
            String strNumLine = line;
            int num = parseInt(strNumLine);
            myList.add(num);
            line = buffReader.readLine();
        }
        buffReader.close();

        System.out.println();
        long counter = mergeSort(myList);
        System.out.println(counter);
    }

    private static long mergeSort(List<Integer> myList) {
        if(myList.size() == 1) return 0;
        long counter = 0;

        List<Integer> leftArray = new ArrayList<>(myList.subList(0, myList.size()/2));
        List<Integer> rightArray = new ArrayList<>(myList.subList(myList.size()/2, myList.size()));
        counter = mergeSort(leftArray) + mergeSort(rightArray) + merge(myList, leftArray, rightArray);
        return counter;
    }

    private static long merge(List<Integer> myList, List<Integer> leftArray, List<Integer> rightArray) {
        long counter = 0;
        int i = 0; // leftArray index
        int j = 0; // rightArray index
        int size = leftArray.size() + rightArray.size();
        for (int k = 0; k < size; k++) {
            if (i == leftArray.size()) {
                myList.set(k, rightArray.get(j));
                j++;
            }
            else if (j == rightArray.size()) {
                myList.set(k, leftArray.get(i));
                i++;
            }
            else {
                if (rightArray.get(j) < leftArray.get(i)) {
                    myList.set(k, rightArray.get(j));
                    j++;
                    counter = counter + leftArray.size() - i;
                } else {
                    myList.set(k, leftArray.get(i));
                    i++;
                }
            }
        }
        return counter;
    }
}