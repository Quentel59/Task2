package org.example;

import java.util.Scanner;

public class Task5Timer implements Task {

    private int seconds;
    private volatile boolean running;
    private Thread timerThread;

    public Task5Timer(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public void start() {
        if (running) {
            System.out.println("Таймер уже запущен.");
            return;
        }

        running = true;

        timerThread = new Thread(() -> {
            int currentSeconds = seconds;

            while (running && currentSeconds >= 0) {
                System.out.println("Осталось секунд: " + currentSeconds);

                if (currentSeconds == 0) {
                    break;
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }

                currentSeconds--;
            }

            running = false;
            System.out.println("Таймер остановлен.");
        });

        timerThread.start();
    }

    @Override
    public void stop() {
        running = false;

        if (timerThread != null) {
            timerThread.interrupt();
        }
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите время таймера в секундах: ");
        int seconds = scanner.nextInt();

        if (seconds < 0) {
            System.out.println("Время не может быть отрицательным.");
            return;
        }

        Task5Timer timer = new Task5Timer(seconds);

        timer.start();

        System.out.println("Для остановки таймера нажмите Enter.");

        scanner.nextLine();
        scanner.nextLine();

        timer.stop();
    }
}