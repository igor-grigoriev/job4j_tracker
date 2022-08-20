package ru.job4j.pojo;

import java.time.LocalDate;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Иванов Сергей Васильевич");
        student.setGroup("ИВТ-1");
        student.setDate(LocalDate.of(2001, 10, 14));
        System.out.println(student.getFio() + ", " + student.getGroup() + ", " + student.getDate());
    }
}