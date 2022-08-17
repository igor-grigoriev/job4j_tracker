package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String messag;

    public Error() {
    }

    public Error(boolean active, int status, String messag) {
        this.active = active;
        this.status = status;
        this.messag = messag;
    }

    public void printInfo() {
        System.out.println("Актив: " + active);
        System.out.println("Статус: " + status);
        System.out.println("Сообщение: " + messag);
    }

    public static void main(String[] args) {
        new Error().printInfo();
        new Error(false, -1, "false-1").printInfo();
        new Error(true, 1, "true1").printInfo();
    }
}