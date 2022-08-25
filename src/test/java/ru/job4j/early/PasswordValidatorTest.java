package ru.job4j.early;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PasswordValidatorTest {
    @Test
    public void whenNullException() {
        String password = null;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            PasswordValidator.validate(password); });
        assertThat(exception.getMessage()).isEqualTo("Пароль не должен быть null");
    }

    @Test
    public void whenLengthOutOfRange() {
        String password = "a";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            PasswordValidator.validate(password); });
        assertThat(exception.getMessage()).isEqualTo("Длина пароля не в диапазоне [8, 32]");
    }

    @Test
    public void whenNotContainsUpperCase() {
        String password = "abcdefgh";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            PasswordValidator.validate(password); });
        assertThat(exception.getMessage()).isEqualTo("Пароль не содержит символа в верхнем регистре");
    }

    @Test
    public void whenNotContainsLowerCase() {
        String password = "A1234567";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            PasswordValidator.validate(password); });
        assertThat(exception.getMessage()).isEqualTo("Пароль не содержит символа в нижнем регистре");
    }

    @Test
    public void whenNotContainsNumbers() {
        String password = "aBcdefgh";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            PasswordValidator.validate(password); });
        assertThat(exception.getMessage()).isEqualTo("Пароль не содержит цифры");
    }

    @Test
    public void whenNotContainsSpecial() {
        String password = "aBcdefg1";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            PasswordValidator.validate(password); });
        assertThat(exception.getMessage()).isEqualTo("Пароль не содержит спец. символа");
    }

    @Test
    public void whenContainsInvalidSubstring() {
        String password = "qWerty1.";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            PasswordValidator.validate(password); });
        assertThat(exception.getMessage()).isEqualTo("Пароль содержит недопустимую подстроку: qwerty, 12345, password, admin, user");
    }

    @Test
    public void whenPasswordIsValid() {
        String password = "qWerta1.";
        String expected = "Пароль валидный";
        String result = PasswordValidator.validate(password);
        assertThat(result).isEqualTo(expected);
    }
}