package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String s = reader.readLine();
            if(s.equals("exit")) break;
            Thread thread = new ReadThread(s);
            thread.start();
        }
        System.out.println(resultMap);
        reader.close();
    }

    public static class ReadThread extends Thread {
        String fileName;
        Map<Integer,Integer> map = new HashMap<>();
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            try {
                FileInputStream inputStream = new FileInputStream(fileName);
                while (inputStream.available() > 0){
                    int data = inputStream.read();
                    if(!(map.containsKey(data))) map.put(data,1);
                    else map.put(data,map.get(data) + 1);
                }

                int max = 0;
                int byte_value = 0;

                for (Map.Entry<Integer,Integer> pair : map.entrySet()) {
                    if (pair.getValue() > max) {
                        max = pair.getValue();
                        byte_value = pair.getKey();
                    }
                }
                resultMap.put(fileName,byte_value);
                inputStream.close();
        }catch (Exception e){}
        }
    }
}
