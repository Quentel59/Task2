package org.example;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Task2MergeSort {

    public static void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество элементов списка: ");
        int n = scanner.nextInt();

        if (n < 0) {
            System.out.println("Количество элементов не может быть отрицательным.");
            return;
        }

        ArrayList<Double> numbers = new ArrayList<>(n);
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            double number = -50 + random.nextDouble() * 100;
            numbers.add(number);
        }

        System.out.println("Исходный список:");
        System.out.println(numbers);

        mergeSort(numbers);

        System.out.println("Отсортированный список:");
        System.out.println(numbers);
    }

    public static void mergeSort(ArrayList<Double> list) {
        if (list.size() <= 1) {
            return;
        }

        int middle = list.size() / 2;

        ArrayList<Double> left = new ArrayList<>();
        ArrayList<Double> right = new ArrayList<>();

        for (int i = 0; i < middle; i++) {
            left.add(list.get(i));
        }

        for (int i = middle; i < list.size(); i++) {
            right.add(list.get(i));
        }

        mergeSort(left);
        mergeSort(right);

        merge(list, left, right);
    }

    private static void merge(
            ArrayList<Double> list,
            ArrayList<Double> left,
            ArrayList<Double> right) {

        int leftIndex = 0;
        int rightIndex = 0;
        int listIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex) <= right.get(rightIndex)) {
                list.set(listIndex, left.get(leftIndex));
                leftIndex++;
            } else {
                list.set(listIndex, right.get(rightIndex));
                rightIndex++;
            }

            listIndex++;
        }

        while (leftIndex < left.size()) {
            list.set(listIndex, left.get(leftIndex));
            leftIndex++;
            listIndex++;
        }

        while (rightIndex < right.size()) {
            list.set(listIndex, right.get(rightIndex));
            rightIndex++;
            listIndex++;
        }
    }
}