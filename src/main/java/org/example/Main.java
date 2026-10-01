package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("Практическая работа №2");
            System.out.println("Вариант 1");
            System.out.println("1 - Работа с массивом");
            System.out.println("2 - Сортировка слиянием");
            System.out.println("3 - Stream API");
            System.out.println("4 - HTTP клиент и JSON");
            System.out.println("5 - Таймер");
            System.out.println("0 - Выход");
            System.out.print("Выберите задание: ");

            int choice = scanner.nextInt();

            System.out.println();

            switch (choice) {
                case 1:
                    Task1Array.run();
                    break;

                case 2:
                    Task2MergeSort.run();
                    break;

                case 3:
                    Task3Stream.run();
                    break;

                case 4:
                    Task4HttpJson.run();
                    break;

                case 5:
                    Task5Timer.run();
                    break;

                case 0:
                    System.out.println("Программа завершена.");
                    return;

                default:
                    System.out.println("Такого пункта нет.");
            }
        }
    }
}