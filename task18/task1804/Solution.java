package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        HashMap<Byte, Integer> map = new HashMap<>();
        List<Byte> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;

        while (inputStream.available() > 0) {
            int data = inputStream.read();
            if (!map.containsKey((byte) data)) {
                map.put((byte) data, 1);
            } else {
                int count = map.get((byte) data);
                map.put((byte) data, count + 1);
                if (min > count) {
                    min = count;
                }
            }
        }

        for (Map.Entry<Byte, Integer> pair : map.entrySet()) {
            if (pair.getValue() == min) {
                list.add(pair.getKey());
            }
        }

        System.out.print(list.get(0));

        for (int i = 1; i < list.size(); i++) {
            System.out.print(" " + list.get(i));
        }
        reader.close();
        inputStream.close();
    }
}
