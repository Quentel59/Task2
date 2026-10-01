package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task1Array {

    public static void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество элементов массива: ");
        int n = scanner.nextInt();

        if (n < 0) {
            System.out.println("Количество элементов не может быть отрицательным.");
            return;
        }

        int[] numbers = new int[n];
        Random random = new Random();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(101) - 50;
        }

        System.out.println("Массив:");
        System.out.println(Arrays.toString(numbers));

        if (numbers.length == 0) {
            System.out.println("Массив пустой.");
            return;
        }

        int maxAbs = Math.abs(numbers[0]);

        for (int i = 1; i < numbers.length; i++) {
            if (Math.abs(numbers[i]) > maxAbs) {
                maxAbs = Math.abs(numbers[i]);
            }
        }

        System.out.println("Максимальное значение по модулю: " + maxAbs);
    }
}