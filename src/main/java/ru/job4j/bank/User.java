package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс, реализующий модель пользователя банка
 * @author Igor Grigoriev
 * @version 1.0
 */
public class User {
    /**
     * Паспорт пользователя в переменной типа String
     */
    private String passport;
    /**
     * Имя пользователя в переменной типа String
     */
    private String username;

    /**
     * Конструктор класса принимает и записывает паспорт и имя пользователя
     * @param passport паспорт пользователя
     * @param username имя пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Геттер для паспорта пользователя
     * @return паспорт пользователя
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Сеттер для паспорта пользователя
     * Принимает и записывает паспорт пользователя
     * @param passport паспорт пользователя
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Геттер для имени пользователя
     * @return имя пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Сеттер для имени пользователя
     * Принимает и записывает имя пользователя
     * @param username имя пользователя
     */
    public void setUsername(String username) {
        this.username = username;
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
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Метод определения хэш-кода объекта по паспорту пользователя
     * @return значение хэш-кода объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}