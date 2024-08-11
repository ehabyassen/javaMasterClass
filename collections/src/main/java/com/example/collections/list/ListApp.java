package com.example.collections.list;

import java.util.*;

public class ListApp {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Ehab");
        names.add("Aya");
        names.add("Eslam");

        System.out.println(names);

        names.set(1, "Mama");

        System.out.println(names);

        names.add("Ali");
        names.add("Adel");

        System.out.println(names);

        List<String> sub = names.subList(2, 4);

        System.out.println(sub);

        names.addAll(1, sub);

        System.out.println(names);

//        names.remove("Ali");
        names.removeIf(n -> n.equals("Ali"));

        System.out.println(names);

        List<String> dbl = new ArrayList<>(names);

        names.add(1, "Fareed");

        System.out.println(names);

        System.out.println(names.equals(dbl));

        swap(names, 1, 2);

        System.out.println(names);
        System.out.println("-".repeat(30));

        ListIterator<String> it = names.listIterator();
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.nextIndex());
        System.out.println(it.nextIndex());

        List<String> subn = names.subList(1, 5);
        names.subList(1, 4).clear();
        System.out.println(names);
        System.out.println(subn);

        System.out.println("-".repeat(30));



        String[] x = {"N1", "N2", "N3", "N4"};
        List<String> strings = Arrays.asList(x);

        System.out.println(strings);

        strings.set(1, "N5");
        System.out.println(strings);
        System.out.println(x[1]);

        List<String> subS = strings.subList(1, 3);

        System.out.println(subS);
        subS.set(0, "N7");
        System.out.println(subS);
        System.out.println(strings);
        System.out.println(x[1]);


    }

    private static void swap(List<String> list, int i, int j) {
        String swap = list.get(i);
        list.set(i, list.get(j));
        list.set(j, swap);
    }

    private static void shuffle(List<String> list) {
        Random random = new Random();
        int c = 0;
        for (int i = 1; i <= list.size(); i++) {
            swap(list, i - 1, random.nextInt(i));
            c++;
        }
        System.out.println(c);
    }
}
