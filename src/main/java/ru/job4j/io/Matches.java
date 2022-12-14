package ru.job4j.io;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + " введите число от 1 до 3:");
            try {
                int matches = Integer.parseInt(scanner.nextLine());
                if (matches >= 1 && matches <= Math.min(3, count)) {
                    count -= matches;
                    System.out.println("Спичек на столе: " + count);
                    turn = !turn;
                } else {
                    System.out.println("Введено некорректное число!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Введено некорректное число!");
            }
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}