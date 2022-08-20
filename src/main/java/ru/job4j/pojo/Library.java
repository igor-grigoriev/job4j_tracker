package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Колобок", 10);
        Book book2 = new Book("Теремок", 20);
        Book book3 = new Book("Курочка Ряба", 30);
        Book book4 = new Book("Clean code", 40);
        Book[] books = new Book[]{book1, book2, book3, book4};
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + ", " + books[i].getCount());
        }
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (Book book : books) {
            System.out.println(book.getName() + ", " + book.getCount());
        }
        for (Book book : books) {
            if (book.getName().equals("Clean code")) {
                System.out.println(book.getName() + ", " + book.getCount());
            }
        }
    }
}