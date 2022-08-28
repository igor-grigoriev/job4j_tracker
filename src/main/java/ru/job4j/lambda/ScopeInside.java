package ru.job4j.lambda;

public class ScopeInside {
    public static void main(String[] args) {
        int[] number = {1, 2, 3};
        int total = 0;
        for (int num : number) {
            total += num;
        }
        System.out.println(total);
    }
}