package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        FileOutputStream outputStream = new FileOutputStream(file1);
        FileInputStream inputStream1 = new FileInputStream(file2);
        FileInputStream inputStream2 = new FileInputStream(file3);


        while (inputStream1.available() > 0){
            int data = inputStream1.read();
            outputStream.write(data);
        }

        outputStream = new FileOutputStream(file1,true);

        while (inputStream2.available() > 0){
            int data = inputStream2.read();
            outputStream.write(data);
        }

        reader.close();
        inputStream1.close();
        inputStream2.close();
        outputStream.close();
    }
}
