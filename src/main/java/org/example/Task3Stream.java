package org.example;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Task3Stream {

    public static void run() {
        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new Employee(
                "Иванов Иван Иванович",
                25,
                "IT",
                70000.0
        ));

        employees.add(new Employee(
                "Петров Петр Петрович",
                35,
                "IT",
                95000.0
        ));

        employees.add(new Employee(
                "Сидорова Анна Сергеевна",
                42,
                "Бухгалтерия",
                80000.0
        ));

        employees.add(new Employee(
                "Ахметов Тимур Русланович",
                29,
                "Продажи",
                65000.0
        ));

        employees.add(new Employee(
                "Смирнова Елена Андреевна",
                38,
                "HR",
                75000.0
        ));

        System.out.println("Список сотрудников:");

        for (Employee employee : employees) {
            System.out.println(employee);
        }

        ArrayList<Employee> result = employees.stream()
                .filter(employee -> employee.getAge() > 30)
                .collect(Collectors.toCollection(ArrayList::new));

        System.out.println();
        System.out.println("Сотрудники старше 30 лет:");

        for (Employee employee : result) {
            System.out.println(employee);
        }
    }
}