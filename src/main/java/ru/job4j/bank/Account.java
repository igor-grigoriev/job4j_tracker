package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс, реализующий модель банковского счета
 * @author Igor Grigoriev
 * @version 1.0
 */
public class Account {
    /**
     * Реквизиты банковского счета в переменной типа String
     */
    private String requisite;
    /**
     * Баланс банковского счета в переменной типа double
     */
    private double balance;

    /**
     * Конструктор класса принимает и записывает реквизиты и баланс банковского счета
     * @param requisite реквизиты банковского счета
     * @param balance баланс банковского счета
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Геттер для реквизитов банковского счета
     * @return реквизиты банковского счета
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Сеттер для реквизитов банковского счета
     * Принимает и записывает реквизиты банковского счета
     * @param requisite реквизиты банковского счета
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Геттер для баланса банковского счета
     * @return баланс банковского счета
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Сеттер для баланса банковского счета
     * Принимает и записывает баланс банковского счета
     * @param balance баланс банковского счета
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Метод для сравнения текущего объекта с принмаемым
     * @param o сравниваемый объект
     * @return true если объекты идентичны, иначе false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Метод определения хэш-кода объекта по паспорту пользователя
     * @return значение хэш-кода объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}