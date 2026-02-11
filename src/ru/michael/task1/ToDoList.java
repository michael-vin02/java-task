package ru.michael.task1;

import java.util.Scanner;

public class ToDoList {

    private static final String[] tasks = new String[10];


    public static void main(String[] args) {
        menu();
        program();
    }


    private static void menu() {
        System.out.println(">>> Меню:");
        System.out.println("1. Добавить задачу");
        System.out.println("2. Показать все задачи");
        System.out.println("3. Удалить задачу (по номеру)");
        System.out.println("4. Отметить задачу как выполненную");
        System.out.println("0. Выход");
        System.out.println("\nВыберите пункт меню:");
    }


    private static void program() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int userNumber = scanner.nextInt();
            if (userNumber == 1) {
                addTask();
            } else if (userNumber == 2) {
                viewTask();
            } else if (userNumber == 3) {
                deleteTask();
            } else if (userNumber == 0) {
                break;
            } else {
                break;
            }
        }
    }


    private static void addTask() {
        System.out.println("Введите описание задачи:");
        Scanner scanner = new Scanner(System.in);
        String userTask = scanner.nextLine();
        for (int i = 0; true; i++) {
            if (tasks[i] == null) {
                tasks[i] = userTask;
                break;
            }
        }
        System.out.println("Задача добавлена!\n\n");
        menu();
    }


    private static void viewTask() {
        System.out.println("Список задач:");
        for (int i = 0; i < tasks.length; i++) {
            System.out.println(i + 1 + ". [ ] " + tasks[i]);
        }
        menu();
    }


    private static void deleteTask() {
        System.out.println("Введите номер задачи для удаления:");
        Scanner scanner = new Scanner(System.in);
        int deleteTask = scanner.nextInt();
        System.out.println("Задача \"" + tasks[deleteTask - 1] + "\" удалена!");
        for (int i = 0; i < tasks.length; i++) {
            if ((deleteTask - 1) == i) {
                for (; i < tasks.length - 1; i++) {
                    tasks[i] = tasks[i + 1];
                }
                break;
            }
        }
        menu();
    }
}
