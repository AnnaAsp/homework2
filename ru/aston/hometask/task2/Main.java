package aston.hometask.task2;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Мастер и Маргарита", "Михаил Булгаков", 1967, 382);
        Book book2 = new Book("Преступление и наказание", "Фёдор Достоевский", 1866, 608);
        Book book3 = new Book("1984", "Джордж Оруэлл", 1949, 328);
        Book book4 = new Book("Три товарища", "Эрих Мария Ремарк", 1936, 480);
        Book book5 = new Book("Война и мир", "Лев Толстой", 1869, 1225);
        Book book6 = new Book("Метро 2033", "Дмитрий Глуховский", 2005, 385);
        Book book7 = new Book("Лавр", "Евгений Водолазкин", 2012, 448);
        Book book8 = new Book("Авиатор", "Евгений Водолазкин", 2016, 320);
        Book book9 = new Book("Текст", "Дмитрий Глуховский", 2017, 389);
        Book book10 = new Book("Черновик", "Сергей Лукьяненко", 2005, 384);

        Student student1 = new Student("Иван Иванов", List.of(book1, book2, book3, book4, book5));
        Student student2 = new Student("Петр Петров", List.of(book2, book4, book6, book8, book10));
        Student student3 = new Student("Сергей Сергеев", List.of(book1, book3, book5, book7, book9));
        Student student4 = new Student("Анна Аннова", List.of(book4, book6, book8, book9, book10));
        Student student5 = new Student("Мария Маринова", List.of(book1, book2, book3, book5, book7));

        List<Student> students = List.of(student1, student2, student3, student4, student5);

        students.stream()
                .peek(student -> System.out.println(student))
                .flatMap(student -> student.getBooks().stream())
                .distinct()
                .sorted(Comparator.comparingInt(Book::getPages))
                .filter(book -> book.getYear() > 2000)
                .limit(3)
                .map(Book::getYear)
                .findAny()
                .ifPresentOrElse(
                        year -> System.out.println("Год выпуска найденной книги: " + year),
                        () -> System.out.println("Такая книга отсутствует")
                );

    }
}

