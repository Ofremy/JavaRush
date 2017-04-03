package com.javarush.task.task17.task1711;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws Exception {
        //start here - начни тут
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
         switch (args[0]) {
             case"-c":
                     for (int i = 1; i < args.length; i += 3) {
                         if (args[1 + i].equals("м")) {
                             allPeople.add(Person.createMale(args[i], simpleDateFormat.parse(args[2 + i])));
                             System.out.println(allPeople.size() - 1);
                         } else if (args[1 + i].equals("ж")) {
                             allPeople.add(Person.createFemale(args[i], simpleDateFormat.parse(args[2 + i])));
                             System.out.println(allPeople.size() - 1);
                         }
                     }
                     break;
            case "-u":
                    for (int i = 1; i < args.length; i += 4) {
                        if (args[2 + i].equals("м")) {
                            allPeople.set(Integer.parseInt(args[i]), Person.createMale(args[1 + i], simpleDateFormat.parse(args[3 + i])));
                        } else if (args[2 + i].equals("ж")) {
                            allPeople.set(Integer.parseInt(args[i]), Person.createFemale(args[1 + i], simpleDateFormat.parse(args[3 + i])));
                        }
                    }
                    break;
           case "-d":
                    for (int i = 1; i < args.length; i++) {
                        int index = Integer.parseInt(args[i]);
                        allPeople.get(index).setName(null);
                        allPeople.get(index).setBirthDay(null);
                        allPeople.get(index).setSex(null);
                    }
                    break;
            case "-i":
                    for (int i = 1; i < args.length; i++) {
                        int index = Integer.parseInt(args[i]);
                        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                        if (allPeople.get(index).getSex().equals(Sex.MALE)) {
                            System.out.println(allPeople.get(index).getName() + " м " + simpleDateFormat1.format(allPeople.get(index).getBirthDay()));
                        } else if (allPeople.get(index).getSex().equals(Sex.FEMALE)) {
                            System.out.println(allPeople.get(index).getName() + " ж " + simpleDateFormat1.format(allPeople.get(index).getBirthDay()));
                        }
                    }
                    break;
            default: break;


        }
    }
}
