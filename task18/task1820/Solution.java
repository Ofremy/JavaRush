package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(file1));
        BufferedWriter outputStream = new BufferedWriter(new FileWriter(file2));
        ArrayList<Integer> list = new ArrayList<>();

        String s;
        while (((s = fileReader.readLine()) != null)){
            String[] parse = s.split(" ");

            for (int i = 0; i < parse.length; i++) {
                list.add(Math.round(Float.parseFloat(parse[i])));
            }
        }

        outputStream.write(Math.round(list.get(0))+"");
        for (int i = 1; i < list.size(); i++) {
            outputStream.write(" " + list.get(i));
        }
        reader.close();
        fileReader.close();
        outputStream.close();
    }
}
