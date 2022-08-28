package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] left = o1.split("/");
        String[] right = o2.split("/");
        int res = right[0].compareTo(left[0]);
        if (res == 0) {
            for (int i = 1; i < Math.min(left.length, right.length); i++) {
                res = left[i].compareTo(right[i]);
                if (res != 0) {
                    break;
                }
            }
        }
        return (res != 0) ? res : Integer.compare(left.length, right.length);
    }
}