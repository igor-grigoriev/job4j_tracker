package ru.job4j.early;

public class PasswordValidator {
    public static String validate(String password) {
        boolean isUpperCase = false;
        boolean isLowerCase = false;
        boolean isDigit = false;
        boolean isSpecial = false;
        if (password == null) {
            throw new IllegalArgumentException("Пароль не должен быть null");
        }
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                isUpperCase = true;
            }
            if (Character.isLowerCase(ch)) {
                isLowerCase = true;
            }
            if (Character.isDigit(ch)) {
                isDigit = true;
            }
            if (!Character.isUpperCase(ch) && !Character.isLowerCase(ch) && !Character.isDigit(ch)) {
                isSpecial = true;
            }
        }
        if (password.length() < 8 || password.length() > 32) {
            return "Длина пароля не в диапазоне [8, 32]";
        }
        if (!isUpperCase) {
            return "Пароль не содержит символа в верхнем регистре";
        }
        if (!isLowerCase) {
            return "Пароль не содержит символа в нижнем регистре";
        }
        if (!isDigit) {
            return "Пароль не содержит цифры";
        }
        if (!isSpecial) {
            return "Пароль не содержит спец. символа";
        }
        if (password.toLowerCase().contains("user") || password.contains("12345") || password.toLowerCase().contains("admin")
                || password.toLowerCase().contains("password") || password.toLowerCase().contains("qwerty")) {
            return "Пароль содержит недопустимую подстроку: qwerty, 12345, password, admin, user";
        }
        return password;
    }
}