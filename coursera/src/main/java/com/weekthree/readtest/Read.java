package com.weekthree.readtest;
import java.io.*;
import static java.lang.Integer.parseInt;


public class Read {

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 1; i++) {
            String filePath = new File("").getAbsolutePath();
            BufferedReader buffReader = new BufferedReader(new FileReader(filePath + "/sources/kargermincut.txt"));
            String line = buffReader.readLine();
            while (line != null) {
                String strNumLine = line;
                String[] verticesStrList = strNumLine.trim().split("\\s+");
                int num = parseInt(verticesStrList[0]);
                for (int j = 1; j < verticesStrList.length; j++) {
                    int number = parseInt(verticesStrList[j]);
                }
                line = buffReader.readLine();
            }
            buffReader.close();
        }
    }
}