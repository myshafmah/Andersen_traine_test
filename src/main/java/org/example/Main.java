package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final int NUM = 7;
    private static final String NAME = "Вячеслав";

    public static void main(String[] args) {
        menu();
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("--------------MENU---------------");
        System.out.println("1. Task #1");
        System.out.println("2. Task #2");
        System.out.println("3. Task #3");
        System.out.println("0. Для выхода\n");
    }

    private static boolean menu() throws InputMismatchException {
        printMenu();
        try {
            switch (getStrFromConsole("номер задания: ").nextInt()) {
                case 0:
                    break;
                case 1:
                    task1(getStrFromConsole("число: "));
                    menu();
                    break;
                case 2:
                    task2(getStrFromConsole("имя: "));
                    menu();
                    break;
                case 3:
                    task3(getStrFromConsole("количество элементов массива: "));
                    break;
                default:
                    return menu();
            }
        } catch (InputMismatchException e) {
            System.out.println("\ninvalid input");
            menu();
        }
        return false;
    }

    private static Scanner getStrFromConsole(String str) {
        System.out.print("Введите " + str);
        return new Scanner(System.in);
    }

    private static void task1(Scanner sc) {
        if (sc.nextInt() > NUM) {
            System.out.println("\nПривет");
        }
        menu();
    }

    private static void task2(Scanner sc) {
        String str = sc.next();
        if (str.contentEquals(NAME)) {
            System.out.println("Привет, " + NAME);
        } else {
            System.out.println("Нет такого имени");
        }
    }

    private static void task3(Scanner sc) {
        int[] array = new int[sc.nextInt()];
        System.out.println("Введите элементы массива: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println("Элементы массива кратные 3: ");
        for (int j : array) {
            if (j % 3 == 0) {
                System.out.println(j);
            }
        }
        menu();
    }
}