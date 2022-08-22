package ru.job4j.poly;

public class Bus implements Transport, Vehicle {
    @Override
    public void drive() {
        System.out.println(getClass().getSimpleName() + " едет по городу");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Количество пассажиров " + count);
    }

    @Override
    public double fill(int count) {
        return count * 49;
    }

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " двигается по скоростным трассам");
    }
}