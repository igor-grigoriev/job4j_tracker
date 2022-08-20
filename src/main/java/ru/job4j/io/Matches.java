package ru.job4j.io;

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
            String input = scanner.nextLine();
            while ((!input.equals("1") && !input.equals("2") && !input.equals("3")) || Integer.parseInt(input) > count) {
                System.out.println("Введено некорректное число!");
                input = scanner.nextLine();
            }
            count -= Integer.parseInt(input);
            System.out.println("Спичек на столе: " + count);
            turn = !turn;
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}