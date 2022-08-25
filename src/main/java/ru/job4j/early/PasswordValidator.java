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
            if (isUpperCase && isLowerCase && isDigit && isSpecial) {
                break;
            }
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Длина пароля не в диапазоне [8, 32]");
        }
        if (!isUpperCase) {
            throw new IllegalArgumentException("Пароль не содержит символа в верхнем регистре");
        }
        if (!isLowerCase) {
            throw new IllegalArgumentException("Пароль не содержит символа в нижнем регистре");
        }
        if (!isDigit) {
            throw new IllegalArgumentException("Пароль не содержит цифры");
        }
        if (!isSpecial) {
            throw new IllegalArgumentException("Пароль не содержит спец. символа");
        }
        if (password.toLowerCase().contains("user") || password.contains("12345") || password.toLowerCase().contains("admin")
                || password.toLowerCase().contains("password") || password.toLowerCase().contains("qwerty")) {
            throw new IllegalArgumentException("Пароль содержит недопустимую подстроку: qwerty, 12345, password, admin, user");
        }
        return "Пароль валидный";
    }
}