package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws Exception{
        Solution solution = new Solution();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
        BufferedReader fileReader2 = new BufferedReader(new FileReader(fileName2));
        String s;
        while ((s = fileReader.readLine()) != null){
            allLines.add(s);
        }
        String z;
        while ((z = fileReader2.readLine()) != null){
            forRemoveLines.add(z);
        }
        System.out.println(allLines);
        System.out.println(forRemoveLines);
        reader.close();
        fileReader.close();

        try {
            solution.joinData();
        }catch (Exception e){

        }

    }

    public void joinData () throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        }
        else if (!allLines.contains(forRemoveLines)){
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
