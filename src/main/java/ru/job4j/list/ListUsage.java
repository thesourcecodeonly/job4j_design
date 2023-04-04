package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class ListUsage {
    public static void main(String[] args) {
        List<String> rsl = new ArrayList<>();
        rsl.add("one");
        rsl.add("two");
        rsl.add("three");
        List<String> list = new ArrayList<>();
        list.add("four");
        list.add("five");
        rsl.set(1, "two and second");
        rsl.remove(1);
        for (String s : rsl) {
            System.out.println("Текущий элемент: " + s);
        }
    }
}
