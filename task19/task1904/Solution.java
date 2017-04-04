package com.javarush.task.task19.task1904;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner  {
        private Scanner fileScanner;
        @Override
        public Person read() throws IOException {
            String str = fileScanner.nextLine();
            String[] split = str.split(" ");

            Calendar calendar = new GregorianCalendar(Integer.parseInt(split[5]), Integer.parseInt(split[4]) - 1, Integer.parseInt(split[3]));
            Date date = calendar.getTime();
            return new Person(split[1], split[2], split[0], date);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }

        public PersonScannerAdapter(Scanner scanner){
            this.fileScanner = scanner;

        }
    }
}
