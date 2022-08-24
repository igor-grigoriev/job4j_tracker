package ru.job4j.early;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PasswordValidatorTest {
    @Test
    public void whenException() {
        String password = null;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            PasswordValidator.validate(password); });
        assertThat(exception.getMessage()).isEqualTo("Пароль не должен быть null");
    }

    @Test
    public void whenLengthOutOfRange() {
        String password = "a";
        String expected = "Длина пароля не в диапазоне [8, 32]";
        String result = PasswordValidator.validate(password);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenNotContainsUpperCase() {
        String password = "abcdefgh";
        String expected = "Пароль не содержит символа в верхнем регистре";
        String result = PasswordValidator.validate(password);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenNotContainsLowerCase() {
        String password = "A1234567";
        String expected = "Пароль не содержит символа в нижнем регистре";
        String result = PasswordValidator.validate(password);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenNotContainsNumbers() {
        String password = "aBcdefgh";
        String expected = "Пароль не содержит цифры";
        String result = PasswordValidator.validate(password);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenNotContainsSpecial() {
        String password = "aBcdefg1";
        String expected = "Пароль не содержит спец. символа";
        String result = PasswordValidator.validate(password);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenContainsInvalidSubstring() {
        String password = "qWerty1.";
        String expected = "Пароль содержит недопустимую подстроку: qwerty, 12345, password, admin, user";
        String result = PasswordValidator.validate(password);
        assertThat(result).isEqualTo(expected);
    }
}