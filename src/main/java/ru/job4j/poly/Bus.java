package ru.job4j.poly;

public class Bus implements Transport, Vehicle {
    @Override
    public void drive() {
    }

    @Override
    public void passengers(int count) {
    }

    @Override
    public double fill(int count) {
        return 0;
    }

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " двигается по скоростным трассам");
    }
}