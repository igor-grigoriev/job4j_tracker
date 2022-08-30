package ru.job4j.bank;

import java.util.*;

/**
 * Класс, реализующий интсрумент банковского сервиса
 * @author Igor Grigoriev
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение пользователей банка в коллекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод для добавления нового пользователя банка в карту пользователей
     * @param user пользователь банка
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод для добавления нового банковского счета в список счетов пользователя банка
     * @param passport паспорт пользователя банка
     * @param account банковский счет пользователя банка
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод, осуществляющий поиск пользователя банка по его паспорту
     * @param passport паспорт пользователя банка
     * @return пользователь банка
     */
    public User findByPassport(String passport) {
        return users.keySet().stream()
                .filter(user -> passport.equals(user.getPassport()))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод, осуществляющий поиск банковского счета пользователя по его паспорту и реквизитам счета
     * @param passport паспорт пользователя банка
     * @param requisite реквизиты банковского счета
     * @return банковский счет
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return getAccounts(user).stream()
                    .filter(account -> requisite.equals(account.getRequisite()))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод, осуществляющий перевод денежных средств с одного банковского счета на другой
     * @param srcPassport паспорт пользователя-отправителя
     * @param srcRequisite реквизиты банковского счета-отправителя
     * @param destPassport паспорт пользователя-получателя
     * @param destRequisite реквизиты банковского счета-получателя
     * @param amount объем переводимых денежных средств
     * @return true если перевод выполнен успешно, иначе false
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() - amount > -0.001) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            return true;
        }
        return false;
    }

    /**
     * Метод принимает пользователя банка и получает список его банковских счетов
     * @param user пользователь банка
     * @return список банковских счетов
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }

    public static void main(String[] args) {
        Account ac = new BankService().findByRequisite("df", "d");
    }
}