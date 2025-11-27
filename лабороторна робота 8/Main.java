package ua.opnu;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // =====================================================
        // === ЗАВДАННЯ 1 – MyOptional (ввід користувача)
        // =====================================================
        System.out.println("=== Завдання 1: MyOptional ===");

        System.out.print("Введіть значення (або пусто): ");
        String text = sc.nextLine();

        MyOptional<String> opt = text.isBlank()
                ? new MyOptional<>()
                : new MyOptional<>(text);

        System.out.println("Ваш MyOptional: " + opt);
        System.out.println("orElse('Немає даних'): " + opt.orElse("Немає даних"));

        // =====================================================
        // === ЗАВДАННЯ 2 – Ввід 2 книг і їх порівняння
        // =====================================================
        System.out.println("\n=== Завдання 2: Порівняння BookData ===");

        System.out.println("Введіть дані ПЕРШОЇ книги:");
        BookData b1 = readBook(sc);

        System.out.println("Введіть дані ДРУГОЇ книги:");
        BookData b2 = readBook(sc);

        System.out.println("\nПорівняння b1.compareTo(b2) = " + b1.compareTo(b2));

        if (b1.compareTo(b2) < 0)
            System.out.println("Книга 1 гірше за книгу 2");
        else if (b1.compareTo(b2) > 0)
            System.out.println("Книга 1 краща за книгу 2");
        else
            System.out.println("Книги однакові за рейтингом!");

        // =====================================================
        // === Завдання 3 – printArray() (ввід)
        // =====================================================
        System.out.println("\n=== Завдання 3: Printer ===");

        System.out.print("Скільки елементів введете? ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] arrStr = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Введіть елемент [" + i + "]: ");
            arrStr[i] = sc.nextLine();
        }

        Printer printer = new Printer();
        printer.printArray(arrStr);

        // =====================================================
        // === Завдання 4 – filter() з лямбдою
        // =====================================================
        System.out.println("\n=== Завдання 4: filter() ===");

        System.out.print("Кількість чисел: ");
        int m = sc.nextInt();
        Integer[] nums = new Integer[m];

        for (int i = 0; i < m; i++) {
            System.out.print("Число [" + i + "]: ");
            nums[i] = sc.nextInt();
        }

        Integer[] filtered = new GenericFilter().filter(nums, x -> x % 2 == 0);

        System.out.println("Парні:");
        for (Integer x : filtered) System.out.print(x + " ");
        System.out.println();

        // =====================================================
        // === Завдання 5 – contains()
        // =====================================================
        System.out.println("\n=== Завдання 5: contains() ===");

        System.out.print("Введіть слово для пошуку: ");
        sc.nextLine();
        String word = sc.nextLine();

        System.out.println("Містить? " + GenericContains.contains(arrStr, word));

        // =====================================================
        // === Завдання 6 – Tuple
        // =====================================================
        System.out.println("\n=== Завдання 6: Кортежі ===");

        System.out.print("Введіть назву предмету: ");
        String subj = sc.nextLine();
        System.out.print("Оцінка: ");
        int mark = sc.nextInt();
        sc.nextLine();

        GenericTwoTuple<String, Integer> t1 =
                new GenericTwoTuple<>(subj, mark);

        System.out.println("TwoTuple: " + t1);

        GenericThreeTuple<String, Integer, String> t2 =
                new GenericThreeTuple<>(subj, mark, "OK");

        System.out.println("ThreeTuple: " + t2);

        sc.close();
    }

    // ==========================================================
    // === ДОПОМІЖНИЙ МЕТОД ДЛЯ ЧИТАННЯ КНИГИ
    // ==========================================================
    private static BookData readBook(Scanner sc) {
        System.out.print("Назва: ");
        String title = sc.nextLine();

        System.out.print("Автор: ");
        String author = sc.nextLine();

        System.out.print("Кількість оцінок: ");
        int votes = sc.nextInt();

        System.out.print("Сума оцінок: ");
        int sum = sc.nextInt();
        sc.nextLine();

        return new BookData(title, author, sum, votes);
    }
}
